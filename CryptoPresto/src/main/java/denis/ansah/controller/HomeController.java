package denis.ansah.controller;

import java.awt.Checkbox;
//import java.awt.List;
import java.util.List;
import java.io.IOException;
import java.net.http.HttpRequest;
//import java.sql.Date;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.bind.v2.runtime.output.UTF8XmlOutput;

import java.util.concurrent.ThreadLocalRandom;

import denis.ansah.DAO.DAOUtils;
import denis.ansah.POJO.Bank;
import denis.ansah.POJO.POJOUtils;
import denis.ansah.POJO.User;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView entry(HttpServletResponse response, HttpServletRequest request) throws IOException{
		User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
        	System.out.println("account - " + user.getUsername());
			return new ModelAndView("account", "user", user);
		}
		return new ModelAndView("account");
	}
	
	@RequestMapping(value="/user")
	public ModelAndView showSignUpSignInPage(HttpServletResponse response, HttpServletRequest request, String errorMessageString) throws IOException{
        String action = request.getParameter("action");
    	System.out.println(action);
		return new ModelAndView(action);
	}
	@RequestMapping(value="/SignOut")
	public ModelAndView signOut(HttpServletResponse response, HttpServletRequest request, String errorMessageString) throws IOException{
		System.out.println("Signing out");
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
		return new ModelAndView("account");
	}
	@RequestMapping(value="/SignIn")
	public ModelAndView signIn(HttpServletResponse response, HttpServletRequest request, String errorMessageString) throws IOException{
    	System.out.println("signing in");
    	errorMessageString = "User/password does not exist. Please double-check.";
		//Filter request fields
		if(request.getAttribute("unsafe_request") == "true"){
			errorMessageString = "Unsafe or special string characters are not allowed.";
        	System.out.println(errorMessageString);
            return new ModelAndView("signInError", "errorMessageString", errorMessageString);
        }
//		Check for empty fields
		Enumeration<String> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()) {
            String key = (String) paramNames.nextElement();
            String val = request.getParameter(key);
            if (val.isBlank()) {
            	errorMessageString = key + " field cannot be blank";
                System.out.println(errorMessageString);
        		return new ModelAndView("signInError", "errorMessageString", errorMessageString);
            }
        }
		
        DAOUtils hibernateUtils = new DAOUtils();
        String username = request.getParameter("username").toLowerCase();
      	String password = request.getParameter("password");
//      	User user = util.getUser(username, password);
      	//get all users and and find the username entered and compare password with entered password
      	List<User> existingUsers = hibernateUtils.getUsers();
      	for (User existingUser : existingUsers) {	//for each existing user, 
			if (username.equalsIgnoreCase(existingUser.getUsername())) { //if a username match is found,
				if (password.equals(existingUser.getPassword())) {	//and a password match is found for the same user,
					//then save user in session and show account view
					HttpSession session = request.getSession();
					session.setAttribute("user", existingUser);
		        	// get associated banks and add to session
			        POJOUtils util = new POJOUtils();
			      	List<Bank> banks = util.getBanks(existingUser.getId());
					session.setAttribute("banks", banks);
		    		return new ModelAndView("account");
				}
				//username is a match but password is wrong
				errorMessageString = "The PASSWORD is wrong for the entered username. Please try again.";
				return new ModelAndView("signInError", "errorMessageString", errorMessageString);
			}
		}
    	errorMessageString = "The USERNAME you entered does not exist. Please try again.";
		return new ModelAndView("signInError", "errorMessageString", errorMessageString);
	}
	
	@RequestMapping(value="/SignUp")
	public ModelAndView signUp(HttpServletResponse response, HttpServletRequest request, String errorMessageString) throws IOException{
    	System.out.println("signing up");
    	errorMessageString = "An unknown error has occurred.";
		//		Filter request fields
		if(request.getAttribute("unsafe_request") == "true"){
			errorMessageString = "Unsafe or special string characters are not allowed.";
        	System.out.println(errorMessageString);
            return new ModelAndView("signUpError", "errorMessageString", errorMessageString);
        }
		
//		Check for empty fields
		Enumeration<String> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()) {
            String key = (String) paramNames.nextElement();
            String val = request.getParameter(key);
            if (val.isBlank()) {
            	errorMessageString = key + " field cannot be blank";
                System.out.println(errorMessageString);
        		return new ModelAndView("signUpError", "errorMessageString", errorMessageString);
            }
        }
        // validate email and password
        
        
       
        //get user fields
        int id = ThreadLocalRandom.current().nextInt(); 
        id = Math.abs(id);
      	String firstname = request.getParameter("firstname");
      	String lastname = request.getParameter("lastname");
      	String username = request.getParameter("username").toLowerCase();
      	String password = request.getParameter("password");
      	String dateCreated = new java.util.Date().toString();

      	//check for existing usernames
        DAOUtils hibernateUtil = new DAOUtils();
        List<User> existingUsers = hibernateUtil.getUsers();
        for (User existingUser : existingUsers) {
			if (username.equals(existingUser.getUsername())) {
				errorMessageString = "A user already exists with the same username. Please choose a different username.";
		 		return new ModelAndView("signUpError", "errorMessageString", errorMessageString);
			}
		}
        
        // add user to database
        int resultInt = 0;
        //POJOUtils util = new POJOUtils();
      	User user = new User();
      	user.setId(id);
      	user.setFirstname(firstname);
      	user.setLastname(lastname);
      	user.setPassword(password);
      	user.setUsername(username);
      	user.setDateCreated(dateCreated);
      	resultInt = hibernateUtil.addUser(user);
      	//resultInt = util.addUser(id, firstname, lastname, username, password, dateCreated);

        // display user account page
        if (resultInt != 0) {
        	System.out.println(resultInt + "user added");
          	//User user = util.getUser(username, password);
      		HttpSession session = request.getSession();
			session.setAttribute("user", user);
      		return new ModelAndView("account");
        }
		errorMessageString = "A database error has occured. Please try again";
 		return new ModelAndView("signUpError", "errorMessageString", errorMessageString);
	}
}

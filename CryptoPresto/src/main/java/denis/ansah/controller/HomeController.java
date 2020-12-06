package denis.ansah.controller;

import java.awt.Checkbox;
//import java.awt.List;
import java.util.List;
import java.io.IOException;
import java.net.http.HttpRequest;
//import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.concurrent.ThreadLocalRandom; 



import denis.ansah.POJO.POJOUtils;
import denis.ansah.POJO.User;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView entry(HttpServletResponse response, HttpServletRequest request) throws IOException{
		String username =  (String) request.getSession().getAttribute("username");
        System.out.println("index - " + username);
        if (username != null) {
			return new ModelAndView("index", "username", username);
		}
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/user*")
	public ModelAndView signUpSignIn(HttpServletResponse response, HttpServletRequest request) throws IOException{
        String action = request.getParameter("action");
        System.out.println(action);
		return new ModelAndView(action);
	}
	
	@RequestMapping(value="/SignUp")
	public ModelAndView signUp(HttpServletResponse response, HttpServletRequest request, String errorMessageString) throws IOException{
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
        
        
        // add user to database
        int resultInt = 0;
        POJOUtils util = new POJOUtils();
        int id = ThreadLocalRandom.current().nextInt(); 
        id = Math.abs(id);
      	String firstname = request.getParameter("firstname");
      	String lastname = request.getParameter("lastname");
      	String username = request.getParameter("username");
      	String password = request.getParameter("password");
      	String passwordConf = request.getParameter("passwordConf");
      	String dateCreated = new java.util.Date().toString();
      	resultInt = util.addUser(id, firstname, lastname, username, password, passwordConf, dateCreated);

        // display user account page
        if (resultInt != 0) {
        	System.out.println(resultInt + "user added");
         	request.setAttribute("username", username);
      		return new ModelAndView("account", "username", username);
        }
		errorMessageString = "A database error has occured. Please try again";
 		return new ModelAndView("signUpError", "errorMessageString", errorMessageString);
	}
	
	@RequestMapping(value="/SignIn")
	public ModelAndView signIn(HttpServletResponse response, HttpServletRequest request, String errorMessageString) throws IOException{
        System.out.println("signIn");
		errorMessageString = "User/password does not exist. Please double-check.";
        POJOUtils util = new POJOUtils();
        String username = request.getParameter("username");
      	String password = request.getParameter("password");
      	User user = util.getUser(username, password);
      	if (user != null) {
//      		save username and password in session
      		HttpSession session = request.getSession();
			session.setAttribute("username", username);
			Cookie usernameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);
			usernameCookie.setMaxAge(300); //5min session
			passwordCookie.setMaxAge(300);
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
    		return new ModelAndView("account", "username", username);
		}
		return new ModelAndView("signInError", "errorMessageString", errorMessageString);
	}
}
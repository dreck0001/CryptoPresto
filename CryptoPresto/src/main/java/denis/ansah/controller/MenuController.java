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

import denis.ansah.POJO.Bank;
import denis.ansah.POJO.POJOUtils;
import denis.ansah.POJO.User;

@Controller
public class MenuController {
	
	@RequestMapping(value="/account")
	public ModelAndView menu(HttpServletResponse response, HttpServletRequest request) throws IOException{
		User user =  (User) request.getSession().getAttribute("user");
		if (user != null) {
      		HttpSession session = request.getSession();
			String menu = request.getParameter("menu");
			System.out.println("menu = " + menu);
			if (menu.equals("portfolio")) {
				//get list of assets items using Hibernate
//				session.setAttribute("portfolio", portfolio);
			}
			else if (menu.equals("tansactions")) {
				//get list of transactions using Hibernate
//				session.setAttribute("transactions", transactions);
			}
			else if (menu.equals("account")) {
				//get user details using Hibernate
//				session.setAttribute("transactions", transactions);
			}
			else if (menu.equals("account_addBank")) {
				//do add bank account stuff

				session.setAttribute("addingBank", "true");;
			}
			if (menu.equals("account_addBank_cancel")) {
				//do add bank account stuff

				session.removeAttribute("addingBank");
			}
			return new ModelAndView("account");
		}
		System.out.println("User is not logged in");
		return new ModelAndView("account");
	}
	
	@RequestMapping(value="/bank.htm")
	public ModelAndView addBankAccount(HttpServletResponse response, HttpServletRequest request, String addBankStatusMessageString) throws IOException{
		User user =  (User) request.getSession().getAttribute("user");
    	addBankStatusMessageString = "An unknown error has occurred.";
		if (user != null) {
      		HttpSession session = request.getSession();
      		int id = ThreadLocalRandom.current().nextInt(); 
            id = Math.abs(id);
			String bankName = request.getParameter("bankName");
			int routingNumber = Integer.parseInt(request.getParameter("routingNumber")) ;
			int accountNumber = Integer.parseInt(request.getParameter("accountNumber")) ;
			String accountType = request.getParameter("accountType");
			
			//use interceptor to validate
			
			// add to database
	        int resultInt = 0;
	        POJOUtils util = new POJOUtils();
			System.out.println("Details entered: " + bankName + " - " + routingNumber + " - " + accountNumber + " - " + accountType);
	      	resultInt = util.addBank(id, user.getId(), bankName, accountType, routingNumber, accountNumber);
	      	
	     // display addBank success page
	        if (resultInt != 0) {
	        	System.out.println(resultInt + " bank account added");
	        	addBankStatusMessageString = "Success. Your bank was added.";
	        	// add banks to session
	        	List<Bank> banks = util.getBanks(user.getId());
				session.setAttribute("banks", banks);
				//remove addingBank from session
				session.removeAttribute("addingBank");
				
//	        	List<Bank> theBanks = new POJOUtils().getBanks(user.getId());
//	        	Bank theBank = theBanks.get(0);
//				System.out.println("From database: " + theBank.getBankName());

	      		return new ModelAndView("account", "status", addBankStatusMessageString);
	        } else {
	        	addBankStatusMessageString = "Add database error has occurred. Please try again.";
	      		return new ModelAndView("account", "status", addBankStatusMessageString);
	        }
		}
		System.out.println("User is not logged in");
  		return new ModelAndView("account", "status", addBankStatusMessageString);
	}

}

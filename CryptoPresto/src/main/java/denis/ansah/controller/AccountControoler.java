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
public class AccountControoler {
	
	@RequestMapping(value="/account")
	public ModelAndView entry(HttpServletResponse response, HttpServletRequest request) throws IOException{
//		String username =  (String) request.getSession().getAttribute("username");
        System.out.println("account");
//        if (username != null) {
//			return new ModelAndView("index", "username", username);
//		}
		return new ModelAndView("index");
	}

}

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
public class MenuController {
	
	@RequestMapping(value="/menu")
	public ModelAndView menu(HttpServletResponse response, HttpServletRequest request) throws IOException{
		String sessionUsername =  (String) request.getSession().getAttribute("username");
		if (sessionUsername != null) {
			String menu = request.getParameter("menu");
			System.out.println(menu);
			if (menu.equals("Portfolio")) {
				//get list of assets items using Hibernate
				return new ModelAndView("portfolio");
			}
			
		}
		return new ModelAndView("index");
	}

}

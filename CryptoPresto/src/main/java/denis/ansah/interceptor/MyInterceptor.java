package denis.ansah.interceptor;

import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyInterceptor
 */
@WebServlet("/MyInterceptor")
public class MyInterceptor implements HandlerInterceptor {
//	private static final long serialVersionUID = 1L;
       
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	       System.out.println("MyInterceptor.preHandle");
        //Write Code here 
        try {
//            get parameter values
            Enumeration<String> paramNames = request.getParameterNames();
            while(paramNames.hasMoreElements()) {
                String key = (String) paramNames.nextElement();
                String val = request.getParameter(key);
                
                if (xssCheck(val)) {
                    request.setAttribute("unsafe_request", "true");
                    System.out.println("MyInterceptor found suspicious characters in the user input");
                    break;
                }
            }
        } catch(Exception e) {  System.out.print(e); }
        return true;
    }
    
    private boolean xssCheck(String value) {
        if (value != null) {
        	return (value.contains("<script>") || value.contains("</script>") || value.contains("<") || value.contains(">") ||
            		value.contains("/") || value.contains("\\") || value.contains("?") || value.contains("~") ||
            		value.contains("!") || value.contains("@") || value.contains("#") || value.contains("$") ||
            		value.contains("%") || value.contains("^") || value.contains("%") || value.contains("&") ||
            		value.contains("*") || value.contains("`") || value.contains("_") || value.contains("+") 
        	);
        }
        return false;
    }

	
}

package bobbyrne01.automation.wu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * Servlet implementation class GenerateEmailAddresses
 */
@WebServlet("/GenerateEmailAddresses")
public class GenerateEmailAddresses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log;
	
	
	public void init(){
		
		BasicConfigurator.configure();
		log = Logger.getLogger(GenerateEmailAddresses.class.getName());
		log.info("log4j initialized");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String text = "";
		
		if (EmailValidator.getInstance().isValid(request.getParameter("localPart") + String.valueOf(1) + "@" + request.getParameter("domain"))){
			log.info("Address will be valid.");
			
			for (int i = 0; i < Integer.valueOf(request.getParameter("numOfAddresses")); i++){
				text += 
						request.getParameter("localPart") + 
						String.valueOf(i + 1) + 
						"@" + 
						request.getParameter("domain") + "\n";
			}
			
			log.info("Generated email addresses:\n" + text);
		
		} else {
			log.error("Addresses will not be valid.");
			
			text = "Error: Addresses will not be valid. Please validate input.";
		}
		
		response.getWriter().write(text);
	}
}
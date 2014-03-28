package bobbyrne01.automation.wu;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class RandomNumber
 */
@WebServlet("/RandomNumber")
public class RandomNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log;
	
	
	public void init(){
		
		BasicConfigurator.configure();
		log = Logger.getLogger(RandomNumber.class.getName());
		log.info("log4j initialized");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		int num = new Random().nextInt();
		response.getWriter().write(String.valueOf(num));
		log.info("Random number: " + num);
	}
}
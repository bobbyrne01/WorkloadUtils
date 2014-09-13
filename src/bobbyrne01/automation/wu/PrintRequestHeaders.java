package bobbyrne01.automation.wu;

import java.io.IOException;
import java.util.Enumeration;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class Execute
 */
@WebServlet("/PrintRequestHeaders")
public class PrintRequestHeaders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log;

	public void init(){
		
		BasicConfigurator.configure();
		log = Logger.getLogger(PrintRequestHeaders.class.getName());
		log.info("log4j initialized");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration enames = request.getHeaderNames();
		TreeMap map = new TreeMap();
		
		while (enames.hasMoreElements()) {
			String name = (String) enames.nextElement();
		    String value = request.getHeader(name);
		    map.put(name, value);
		}
		   
		log.info(map.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}

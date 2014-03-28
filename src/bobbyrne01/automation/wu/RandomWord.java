package bobbyrne01.automation.wu;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class RandomWord
 */
@WebServlet("/RandomWord")
public class RandomWord extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Vector<String> words = new Vector<String>();
	private Logger log;
	
	
	public void init(){
		
		BasicConfigurator.configure();
		log = Logger.getLogger(RandomWord.class.getName());
		log.info("log4j initialized");
		
		words = Utils.getFileContents(this.getServletContext().getRealPath("/") + "/resources/words");
		log.info("RandomWord.words size is " + words.size());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String responseText = "";
		
		if (words.isEmpty()){
			
			responseText = "Error: RandomWord.words not initialized";
			log.error("RandomWord.words not initialized");
		
		}else{
			
			if (request.getParameter("numberOfWords") != null){
				
				responseText = getMultipleWords(Integer.valueOf(request.getParameter("numberOfWords")));
				
			} else {
			
				responseText = getSingleWord();
			}
		}
		
		response.getWriter().write(responseText);
		log.info("Random word(s): " + responseText);
	}
	
	
	
	private String getSingleWord(){
		
		return words.get(new Random().nextInt(words.size()));
	}
	
	private String getMultipleWords(int numberOfWords){
		
		String tempResponse = "";
		
		log.info("Number of words requested: " + numberOfWords);
		
		for (int i = 0; i < numberOfWords; i++){
			tempResponse += 
					words.get(
							new Random().nextInt(words.size())) + " ";
		}
		
		return tempResponse;
	}
}
package bobbyrne01.automation.wu;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class Utils{
	
	static Vector<String> getFileContents(String path) {
		
		Vector<String> words = new Vector<String>();
	    
	    try{
	    	FileInputStream fstream = new FileInputStream(path);

	    	DataInputStream in = new DataInputStream(fstream);
	    	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    	String strLine;
	      
	    	while ((strLine = br.readLine()) != null){
	    		words.add(strLine);
	    	}

	    	in.close();
	    
	    } catch (Exception e) {
	    	System.err.println("Error: " + e.getMessage());
	    	
	    	return new Vector<String>();
	    }

		return(words);
	}
}
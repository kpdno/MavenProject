package lesson29logging;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingDemo {

	private static final Logger log = LogManager.getLogger(LoggingWithLog4j2.class);
	
	public static void main(String[] args) {
		log.debug("Starting the application"); 
		
		log.info("Running the for loop");
		for (int i=0; i<10; i++) {
			log.info("Iteration: " + i);
			
		}
		
		log.debug("Finished for loop");
		int [] arr = new int[3];
		try {
			int a = arr[4];
//			int a = 1/0;
			log.trace("Try block execute secussefully");
		} catch (Exception e) {
			log.error("Exception is thrown", e);
//			log.error(e.getMessage());
//			log.error(e.printStackTrace());
		}
		
		log.debug("Closing the application seccessfully");
	}

}

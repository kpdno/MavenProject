package lesson29logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingWithLog4j2 {

	private static final Logger log = LogManager.getLogger(LoggingWithLog4j2.class);
	
	public static void main(String[] args) {
		//Log levels: Trace < Debug < Info < Warn < Error < Fatal
		
		log.trace("Trace message!");
		log.debug("Debug message!");
		log.info("Info message!");
		log.warn("Warn message!");
		log.error("Error message!");
		log.fatal("Fatal message!");

	}

}

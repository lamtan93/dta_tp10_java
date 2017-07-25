package dev.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalException extends RuntimeException{

	private static final Logger LOG = LoggerFactory.getLogger(GlobalException.class);
	
	public static final int ERR_SERVER = 10;
	
	public GlobalException(String message, int codeErreur){
		
		super(message);
		LOG.info("Code d'erreur: " + codeErreur);
		
	}

	public GlobalException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public GlobalException(Throwable cause) {
		super(cause);
		
	}
	
	
	
}
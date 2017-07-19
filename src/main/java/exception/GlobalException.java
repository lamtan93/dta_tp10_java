package exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalException extends Exception{

	private static final Logger LOG = LoggerFactory.getLogger(GlobalException.class);
	
	public static final int ERR_SERVER = 10;
	
	public GlobalException(String message, int codeErreur){
		
		super(message);
		LOG.info("Code d'erreur: " + codeErreur);
		
	}
	
}
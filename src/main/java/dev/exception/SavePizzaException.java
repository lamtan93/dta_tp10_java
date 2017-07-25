package dev.exception;

public class SavePizzaException extends GlobalException{
	
	public static final int ERROR_SAVE = 10;
	public static final String ERROR_SAVE_MESSAGE  = "Probleme d'insertion de data";
	
	
	
	public SavePizzaException(String errMess,int typeError ) {
		super(errMess, typeError);		
	}



	public SavePizzaException(String message, Throwable cause) {
		super(message, cause);
		
	}



	public SavePizzaException(Throwable cause) {
		super(cause);
		
	}

	
}

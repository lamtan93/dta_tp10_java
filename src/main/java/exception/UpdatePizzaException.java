package exception;

public class UpdatePizzaException extends GlobalException{
	
	public static final int ERRTYPE_UPDATE_PIZZA = 20;

	public static final String UPDATEPIZZA_INDEX_NOT_CORRECT  = "Index non trouvé";	
	public static final String UPDATEPIZZA_DATA_NOT_CORRECT  = "Erreur de saisie de données";	

	
	
	public UpdatePizzaException(String errMess,int typeError ) {
		super(errMess, typeError);		
	}



	public UpdatePizzaException(String message, Throwable cause) {
		super(message, cause);
		
	}



	public UpdatePizzaException(Throwable cause) {
		super(cause);
		
	}

	
}

package Exception;

public class SavePizzaException extends StockageException{
	
	public static final int ERROR_SAVE = 10;
	public static final String ERROR_SAVE_MESSAGE  = "Probleme d'insertion de data";
	
	
	
	public SavePizzaException(int errNum, String errMess) {
		super(errNum, errMess);		
	}

	
}

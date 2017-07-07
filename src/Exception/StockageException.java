package Exception;

public class StockageException extends Exception{

	
	public static final int ERROR_IO = 10;
	public static final int ERROR_SERVEUR = 20;
	
	private int errNum;
	private String errMess;
	
	public StockageException(String message){
		super(message);
	}
	
	public StockageException(int errNum, String errMess){
		this.errNum = errNum;
		this.errMess = errMess;
	}

	public int getErrNum() {
		return errNum;
	}

	public void setErrNum(int errNum) {
		this.errNum = errNum;
	}

	public String getErrMess() {
		return errMess;
	}

	public void setErrMess(String errMess) {
		this.errMess = errMess;
	}
}

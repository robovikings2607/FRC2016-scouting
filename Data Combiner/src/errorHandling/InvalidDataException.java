package errorHandling;

public class InvalidDataException extends Throwable{

	private static final long serialVersionUID = 1L;
	
	private String message;
	private boolean isCritical;
	
	public InvalidDataException(String message, boolean isCritical){
		this.message = message;
		this.isCritical = isCritical;
	}
	
	public String getMessage(){
		return message;
	}
	
	public boolean getIsCritical(){
		return isCritical;
	}
}

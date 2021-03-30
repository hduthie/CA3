package socialmedia;

/**
 * Exception: If the new handle already exists in the platform.
 */
public class IllegalHandleException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalHandleException(String message) {
        super(message);
    }

}

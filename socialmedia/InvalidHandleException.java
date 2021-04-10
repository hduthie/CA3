package socialmedia;
/**
 * Exception: if the handle is empty, has more than 30 characters, or has white spaces.
 */
public class InvalidHandleException 
  extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidHandleException(String errorMessage) {
        super(errorMessage);
    }
}


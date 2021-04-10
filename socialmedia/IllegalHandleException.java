package socialmedia;

/**
 * Exception: If the new handle already exists in the platform.
 */
public class IllegalHandleException 
  extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public IllegalHandleException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}

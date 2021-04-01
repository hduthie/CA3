package socialmedia;
/**
 * Exception: if the handle is empty, has more than 30 characters, or has white spaces.
 */
public class InvalidHandleException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidHandleException(String message) {
        super(message);
    }
    // handle is empty, handle contais whitespace, handle lonegr than 30 characters


}

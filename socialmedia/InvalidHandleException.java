package socialmedia;

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

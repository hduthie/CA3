package socialmedia;

/**
 * Exception: if the Post ID is not on the system.
 */
public class PostIDNotRecognisedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PostIDNotRecognisedException(String errorMessage) {
        super(errorMessage);
    }
}

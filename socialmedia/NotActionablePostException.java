package socialmedia;

/**
 * Exception: if trying to endorse or comment on an endorsement post
 */
public class NotActionablePostException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotActionablePostException(String errorMessage) {
        super(errorMessage);
    }
}

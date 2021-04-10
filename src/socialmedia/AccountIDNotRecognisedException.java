package socialmedia;

/**
 * Exception: if the Account ID is not in the system
 */
public class AccountIDNotRecognisedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccountIDNotRecognisedException(String errorMessage) {
        super(errorMessage);
    }
}
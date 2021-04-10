package socialmedia;


public class AccountIDNotRecognisedException 
  extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public AccountIDNotRecognisedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
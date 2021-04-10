package socialmedia;

public class InvalidPostException 
  extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidPostException(String errorMessage) {
        super(errorMessage);
    }
}

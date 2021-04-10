package socialmedia;

public class NotActionablePostException 
  extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NotActionablePostException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}

package socialmedia;


public class HandleNotRecognisedException 
  extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public HandleNotRecognisedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
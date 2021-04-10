package socialmedia;


public class PostIDNotRecognisedException 
  extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PostIDNotRecognisedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}


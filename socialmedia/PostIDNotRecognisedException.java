package socialmedia;

public class PostIDNotRecognisedException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PostIDNotRecognisedException(String message) {
        super(message);
    }

}

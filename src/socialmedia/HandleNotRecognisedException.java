package socialmedia;

/**
 * Exception: if the handle is not in the system
 */
public class HandleNotRecognisedException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public HandleNotRecognisedException(String errorMessage) {
    super(errorMessage);
  }
}
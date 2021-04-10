package socialmedia;

/**
 * Exception: if the Post message is empty, has more than 100 characters.
 */
public class InvalidPostException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public InvalidPostException(String errorMessage) {
    super(errorMessage);
  }
}

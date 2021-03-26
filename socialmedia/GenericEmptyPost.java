package socialmedia;

public class GenericEmptyPost extends Post{
    private static int postID = 0;
    private static String message = "The original content was removed from the system and is no longer available.";

    public GenericEmptyPost() {
        super(null, null);
    }

    public int getPostID() {
        return postID;
    }

    public String getMessage() {
        return message;
    }

    
    
}
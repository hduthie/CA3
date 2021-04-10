package socialmedia;

/**
 * Comment class creates a comment object
 */
public class Comment extends Post {
    private static final long serialVersionUID = 1L;
    private Post replyingTo;

    /**
     * Creates a Comment object extending a Post object
     * 
     * @param author     the author of the comment
     * @param message    the message body of the comment
     * @param replyingTo the post being commented on
     */
    public Comment(Account author, String message, Post replyingTo) {
        super(author, message);
        this.replyingTo = replyingTo;
    }

    public Post getReplyingTo() {
        return replyingTo;
    }

    public void setReplyingTo(Post replyingTo) {
        this.replyingTo = replyingTo;
    }

}
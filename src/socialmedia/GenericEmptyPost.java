package socialmedia;

/**
 * Generic Empty Post class creates a placeholder post
 */
public class GenericEmptyPost extends Post {

    private static final long serialVersionUID = 1L;
    private Post replyingTo = null;

    /**
     * Creates a GenericEmptyPost object extending a Post object as a placeholder
     * 
     * @param originalPost the post being replaced
     */
    public GenericEmptyPost(Post originalPost) {
        super(null, "The original content was removed from the system and is no longer available.");
        if (originalPost instanceof Comment) {
            replyingTo = ((Comment) originalPost).getReplyingTo();
        }
        this.replies = originalPost.getReplies();
    }

    public int getPostID() {
        return postID;
    }

    public String getMessage() {
        return message;
    }

    public Post getReplyingTo() {
        return replyingTo;
    }

}
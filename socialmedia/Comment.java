
// comment extends Post
public class Comment extends Post{
    // inherits ID from post
    // inherits message
    // inherits author ( an account type)
    Post replyingTo; // the comment or original post this comment is replying to

    public Post getReplyingTo() {
        return replyingTo;
    }

    public void setReplyingTo(Post replyingTo) {
        this.replyingTo = replyingTo;
    }


    
}
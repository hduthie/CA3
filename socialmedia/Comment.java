package socialmedia;

import java.util.ArrayList;

// comment extends Post
public class Comment extends Post {
    private Post replyingTo; 


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
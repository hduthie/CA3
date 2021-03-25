package socialmedia;

import java.util.ArrayList;

// comment extends Post
public class Comment extends Post {
    public Comment(int postID, String author, ArrayList<Post> records) {
        super(postID, author, records);
        // TODO Auto-generated constructor stub
    }

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
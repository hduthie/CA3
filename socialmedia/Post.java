package socialmedia;

import java.util.ArrayList;

public class Post {

    private int postID; 
    private Account author;
    private String message;
    private ArrayList<Post> replies = new ArrayList<Post>();


    public Post(Account author, String message) {
        //assign a unique chronological ID usin a static attribute
        this.author = author;
        this.message = message;
    }

    public int getPostID() {
        return postID;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Post> getReplies() {
        return replies;
    }

    public void setReplies(ArrayList<Post> replies) {
        this.replies = replies;
    }



  

}
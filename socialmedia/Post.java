package socialmedia;

import java.util.ArrayList;

public class Post {

    protected int postID; 
    protected Account author;
    protected String message;
    protected int numberOfEndorsements = 0;
    protected int numberOfComments = 0;
    protected ArrayList<Post> replies = new ArrayList<Post>();
    private static int chronologicalId = 0;


    public Post(Account author, String message) {
        // Are we checking for errors - need to do 
        this.author = author;
        this.message = message;
        postID = chronologicalId;
        incrementId();
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

    private static void incrementId(){
        chronologicalId += 1;
    }

    public void addReply(Post post) {
        replies.add(post);
    }

    public void removeReply(Post post){
        replies.remove(post);
    }

    public void incrementEndorsements(){
        numberOfEndorsements +=1;
    }
    public void decrementEndorsements(){
        numberOfEndorsements -=1;
    }


    public void incrementComments(){
        numberOfComments +=1;
    }

    public void decrementComments(){
        numberOfComments -=1;
    }


    public int getNumberOfEndorsements() {
        return numberOfEndorsements;
    }


    public int getNumberOfComments() {
        return numberOfComments;
    }

    public static int getChronologicalId() {
        return chronologicalId;
    }

    public static void setChronologicalId(int chronologicalId) {
        Post.chronologicalId = chronologicalId;
    }

  

}
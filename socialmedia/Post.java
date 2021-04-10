package socialmedia;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Post class cretes a social media post
 */
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    protected int postID;
    protected Account author;
    protected String message;
    protected int numberOfEndorsements = 0;
    protected int numberOfComments = 0;
    protected ArrayList<Post> replies = new ArrayList<Post>();
    private static int chronologicalId = 0;

    /**
     * Creates a Post Object with a unique ID
     * 
     * @param author  the author of the post
     * @param message the post message body
     */
    public Post(Account author, String message) {
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

    /**
     * Increments the static ID for the Post class so that post has a unique,
     * chronolgical ID
     */
    private static void incrementId() {
        chronologicalId += 1;
    }

    public void addReply(Post post) {
        replies.add(post);
    }

    public void removeReply(Post post) {
        replies.remove(post);
    }

    /**
     * Increments the number of endorsements associated with this Post by 1
     */
    public void incrementEndorsements() {
        numberOfEndorsements += 1;
    }

    /**
     * Decrements the number of endorsements associated with this Post by 1
     */
    public void decrementEndorsements() {
        numberOfEndorsements -= 1;
    }

    /**
     * Increments the number of Comments associated with this Post by 1
     */
    public void incrementComments() {
        numberOfComments += 1;
    }

    /**
     * Decrements the number of Comments associated with this Post by 1
     */
    public void decrementComments() {
        numberOfComments -= 1;
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
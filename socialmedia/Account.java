package socialmedia;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Account class creates a social media account with a unique ID and saves it to
 * the system
 */
public class Account implements Serializable {
    private int id;
    private String handle;
    private String description;
    private int numberOfEndorsements = 0;
    private int numberOfComments = 0;
    private ArrayList<Post> posts = new ArrayList<Post>();
    private static ArrayList<String> handles = new ArrayList<String>();
    private static int idCount = 10000000;
    private static final long serialVersionUID = 1L;

    /**
     * Creates a social media account object with a specified handle and a unique ID
     * 
     * @param handle the social media handle, already checked for uniqueness
     */
    public Account(String handle) {

        this.handle = handle;
        handles.add(handle);
        id = idCount;
        idCount += 1;

    }

    public int getId() {
        return id;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Checks if the handle is already in the system
     */
    public static Boolean isHandleUnique(String handle) {
        return !(handles.contains(handle));
    }

    /**
     * Checks the handle is not empty, longer than 30 characters or contains
     * whitespace
     * 
     * @param handle the handle being checked
     * @return true if the handle is valid, false otherwise
     */
    public static Boolean isHandleValid(String handle) {
        if (handle.equals("")) {
            return false;
        }
        if (handle.length() > 30) {
            return false;
        }
        if (handle.contains(" ")) {
            return false;
        }

        return true;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void addPostToAccount(Post p) {
        posts.add(p);
    }

    /**
     * Removes a post from the account
     * 
     * @param p the post being removed
     */
    public void removePostFromAccount(Post p) {
        if (posts.contains(p)) {
            posts.remove(p);
        }

    }

    /**
     * Increments the number of endorsements associated with this account by 1
     */
    public void incrementEndorsements() {
        numberOfEndorsements += 1;
    }

    /**
     * Decrements the number of endorsements associated with this account by 1
     */
    public void decrementEndorsements() {
        numberOfEndorsements -= 1;
    }

    /**
     * Increments the number of comments associated with this account by 1
     */
    public void incrementComments() {
        numberOfComments += 1;
    }

    /**
     * Decrements the number of endorsements associated with this account by 1
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

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Account.idCount = idCount;
    }

}
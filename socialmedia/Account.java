package socialmedia;

import java.util.ArrayList;

public class Account {
    private int id; // numerical identifier
    private String handle; // unique
    private String description; // can be empty
    private int numberOfEndorsements = 0;
    private int numberOfComments = 0;
    private ArrayList<Post> posts = new ArrayList<Post>();
    private static ArrayList<String> handles = new ArrayList<String>();
    private static int idCount = 10000000;

    public Account(String handle) throws IllegalHandleException, InvalidHandleException {
        if (isHandleValid(handle)) {
            if (isHandleUnique(handle)) {
                this.handle = handle;
                id = idCount;
                idCount += 1;
            } else {
                throw new IllegalHandleException("Handle already exists: " + handle);
            }
        } else {
            throw new InvalidHandleException("Handle is invalid: " + handle);
        }

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

    public static Boolean isHandleUnique(String handle) {
        return handles.contains(handle);
    }

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

    public void removePostFromAccount(Post p) {
        if (posts.contains(p)) {
            posts.remove(p);
        }

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

}
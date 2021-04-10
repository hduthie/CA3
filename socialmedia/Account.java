package socialmedia;

import java.util.ArrayList;
import java.io.Serializable;


public class Account implements Serializable{
    private int id; 
    private String handle; 
    private String description; 
    private int numberOfEndorsements = 0;
    private int numberOfComments = 0;
    private ArrayList<Post> posts = new ArrayList<Post>();
    private static ArrayList<String> handles = new ArrayList<String>();
    private static int idCount = 10000000;
    private static final long serialVersionUID = 1L;

    public Account(String handle){

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

    public static Boolean isHandleUnique(String handle) {
        return !(handles.contains(handle));
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

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Account.idCount = idCount;
    }

    

}
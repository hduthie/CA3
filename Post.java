public class Post {

    private int postID; 
    private String author;
    private ArrayList<postRecord> records = new ArrayList<postRecord>();

    public Post(int postID, String author, ArrayList<postRecord> records) {
        this.postID = postID;
        this.author = author;
        this.records = records;
    }
    
    public int getPostID() {
        return postID;
    }
    public void setPostID(int postID) {
        this.postID = postID;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public ArrayList<postRecord> getRecords() {
        return records;
    }
    public void setRecords(ArrayList<postRecord> records) {
        this.records = records;
    }
  

}
public class Endorsement extends Post {

    // inherits message from post class

    Post refersTo = new Post();

    public Post getRefersTo() {
        return refersTo;
    }

    public void setRefersTo(Post refersTo) {
        this.refersTo = refersTo;
    }

    public Endorsement(int postID, String author, ArrayList<postRecord> records, Post refersTo) {
        super(postID, author, records);
        this.refersTo = refersTo;
    }
}
package socialmedia;

/**
 * Endorsement class to create an Endorsement object
 */
public class Endorsement extends Post {
    private static final long serialVersionUID = 1L;
    Post refersTo;

    /**
     * Creates an Endorsement object extending a Post object with a predefined
     * message
     * 
     * @param author   the author of the endorsement
     * @param refersTo the post being endorsed
     */
    public Endorsement(Account author, Post refersTo) {
        super(author, "EP@" + author.getHandle() + ": " + refersTo.getMessage());
        this.refersTo = refersTo;
    }

    public Post getRefersTo() {
        return refersTo;
    }

    public void setRefersTo(Post refersTo) {
        this.refersTo = refersTo;
    }

}
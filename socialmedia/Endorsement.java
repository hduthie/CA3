package socialmedia;

//import java.util.ArrayList;

public class Endorsement extends Post {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Post refersTo;

    public Endorsement(Account author, Post refersTo) {

        // add this endorsement to the repleis of the OG post 
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
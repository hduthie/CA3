package socialmedia;

import java.util.ArrayList;

public class Endorsement extends Post {

    // inherits message from post class

    Post refersTo;

    public Post getRefersTo() {
        return refersTo;
    }

    public void setRefersTo(Post refersTo) {
        this.refersTo = refersTo;
    }

    public Endorsement( Account author, Post refersTo) {
        super(author, "EP@" + author.getHandle() + ": " + refersTo.getMessage());
        this.refersTo = refersTo;
    }
}
import java.util.ArrayList;

public class Account {
    private int id; // numerical identifier
    private String handle; // unique
    private String description; // can be empty
    private static ArrayList<String> handles = new ArrayList<String>();
    private static int idCount = 10000000;

    public Account(String handle) {
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

    public void setId(int id) {
        this.id = id;
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

    public Boolean isHandleUnique(String handle) {
        return handles.contains(handle);
    }

    public Boolean isHandleValid(String handle) {
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

}
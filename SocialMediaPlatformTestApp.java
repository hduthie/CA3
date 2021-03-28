import socialmedia.SocialMedia;
import socialmedia.IllegalHandleException;
import socialmedia.InvalidHandleException;
import socialmedia.InvalidPostException;
import socialmedia.SocialMediaPlatform;
import socialmedia.AccountIDNotRecognisedException;
import socialmedia.HandleNotRecognisedException;

/**
 * A short program to illustrate an app testing some minimal functionality of a
 * concrete implementation of the SocialMediaPlatform interface -- note you will
 * want to increase these checks, and run it on your SocialMedia class (not the
 * BadSocialMedia class).
 *
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class SocialMediaPlatformTestApp {

    /**
     * Test method.
     * 
     * @param args not used
     * @throws AccountIDNotRecognisedException
     */
    public static void main(String[] args) {
        System.out.println("The system compiled and started the execution...");

        SocialMediaPlatform platform = new SocialMedia();

        assert (platform.getNumberOfAccounts() == 0) : "Initial SocialMediaPlatform not empty as required.";
        assert (platform.getTotalOriginalPosts() == 0) : "Initial SocialMediaPlatform not empty as required.";
        assert (platform.getTotalCommentPosts() == 0) : "Initial SocialMediaPlatform not empty as required.";
        assert (platform.getTotalEndorsmentPosts() == 0) : "Initial SocialMediaPlatform not empty as required.";

        Integer id1;
        Integer id2;
        Integer id3;

        // int createAccount(String handle);
        // int createAccount(String handle, String description);
        // void removeAccount(int id);
        // void removeAccount(String handle);
        // void changeAccountHandle(String oldHandle, String newHandle);
        // String showAccount(String handle);
        // void updateAccountDescription(String handle, String description);
        // int createPost(String handle, String message);
        // int endorsePost(String handle, int id)
        // int commentPost(String handle, int id, String message)
        // void deletePost(int id) ISSUES
        // String showIndividualPost(int id);
        // StringBuilder showPostChildrenDetails(int id); ISSUES
        // int getNumberOfAccounts();
        // int getTotalOriginalPosts();
        // int getTotalEndorsmentPosts()
        // int getTotalCommentPosts();
        // int getMostEndorsedPost();
        // int getMostEndorsedAccount();
        // void erasePlatform();
        // void savePlatform(String filename);
        // void loadPlatform(String filename)

        // How should the errors be thrown?? Do we need to make them throwable
        // how to prevent the errors from changing the system??

        // Need to finish deletion method and stringbuilder method
        // need to do platform methods

        try {

            id1 = platform.createAccount("my_handle1");
            id2 = platform.createAccount("my_handle2",
                    "This account description tests the second create account method");
            id3 = platform.createAccount("my_handle1");
            System.out.println(platform.showAccount("my_handle1"));
            // String a = platform.showAccount("my_handle1");
            assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";

            platform.removeAccount(id1);
            assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";

        } catch (IllegalHandleException e) {
            System.out.println(e.getMessage());
            assert (false) : "IllegalHandleException thrown incorrectly";
        } catch (InvalidHandleException e) {
            System.out.println(e.getMessage());
            assert (false) : "InvalidHandleException thrown incorrectly";
        } catch (AccountIDNotRecognisedException e) {
            assert (false) : "AccountIDNotRecognisedException thrown incorrectly";
        } catch (HandleNotRecognisedException e) {

            e.printStackTrace();
        }

        try {
            System.out.println(platform.showAccount("my_handle1"));
            int post1Id = platform.createPost("my_handle1", "My First Post teehehe");
            System.out.println(platform.showAccount("my_handle1"));
            assert (platform.getTotalOriginalPosts() == 1) : "number of original posts registered in the system does not match";
        } catch (HandleNotRecognisedException e) {

            e.printStackTrace();
        } catch (InvalidPostException e) {

            e.printStackTrace();
        }
       

	}

}
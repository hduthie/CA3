import socialmedia.SocialMediaPlatform;
import socialmedia.SocialMedia;
import socialmedia.IllegalHandleException;
import socialmedia.InvalidHandleException;
import socialmedia.InvalidPostException;
import socialmedia.NotActionablePostException;
import socialmedia.PostIDNotRecognisedException;
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
        Integer id4;
        Integer id5;

        int post1 = 0;
        int post2 = 0;
        int post3 = 0;
        int post4 = 0;
        int post5 = 0;
        int post6 = 0;
        int post7 = 0;

        int like1 = 0;
        int like2 = 0;
        int like3 = 0;
        int like4 = 0;
        int like5 = 0;
        int like6 = 0;
        int like7 = 0;
        int like8 = 0;
        int like9 = 0;
        int like10 = 0;

        int comment1 = 0;
        int comment2 = 0;
        int comment3 = 0;
        int comment4 = 0;
        int comment5 = 0;
        int comment6 = 0;

        int post1Id = 0;
        int post2Id = 0;
        int post3Id = 0;
        int post4Id = 0;
        StringBuilder str;

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
        // void deletePost(int id)
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

        // IllegalHandleException
        // InvalidHandleException
        // InvalidPostException
        // PostIDNotRecognisedException
        // AccountIDNotRecognisedException
        // HandleNotRecognisedException

        // How should the errors be thrown?? Do we need to make them throwable
        // how to prevent the errors from changing the system??

        // Need to finish deletion method and stringbuilder method
        // need to do platform methods

        // Testing both createAccount() methods, and both removeAccount() methods.
        // Checking illegalHandleException is thrown properly

        try {

            // Creating Accounts ------------------
            // Testing createAccount(String handle) , createAccount(String handle, String
            // description)

            id1 = platform.createAccount("my_handle1");
            id2 = platform.createAccount("my_handle2",
                    "This account description tests the second create account method");
            id3 = platform.createAccount("my_handle3", "This is the third account.");

            assert (platform.getNumberOfAccounts() == 3) : "number of accounts registered in the system does not match";

            // Checking illegalHandleException (handle already exists)

            id4 = platform.createAccount("my_handle1", "This account's handle is illegal");
            assert (platform.getNumberOfAccounts() == 3) : "illegalHandleException has not thrown";
            id4 = platform.createAccount("my_handle4", "This account's handle is not illegal");
            assert (platform.getNumberOfAccounts() == 4) : "number of accounts registered in the system does not match";

            // Checking invalidHandleException (handle is empty, has more than 30
            // characters, or has white spaces.)

            id5 = platform.createAccount("");
            assert (platform.getNumberOfAccounts() == 4) : "invalidHandleException has not thrown";
            id5 = platform.createAccount("ThisIsMoreThanThirtyCharacters!");
            assert (platform.getNumberOfAccounts() == 4) : "invalidHandleException has not thrown";
            id5 = platform.createAccount("my handle 5");
            assert (platform.getNumberOfAccounts() == 4) : "invalidHandleException has not thrown";

            id5 = platform.createAccount("my_handle5");
            assert (platform.getNumberOfAccounts() == 5) : "number of accounts registered in the system does not match";

            // Removing Accounts -----------------
            // Testing removeAccount(String handle) , removeAccount(int id)

            // Checking HandleNotRecognisedException
            platform.removeAccount("my_handle");
            assert (platform.getNumberOfAccounts() == 4) : "HandleNotRecognisedException has not thrown";
            platform.removeAccount("my_handle4");
            assert (platform.getNumberOfAccounts() == 4) : "number of accounts registered in the system does not match";

            // Checking AccountIDNotRecognisedException

            platform.removeAccount(27);
            assert (platform.getNumberOfAccounts() == 3) : "AccountIDNotRecognisedException has not thrown";
            platform.removeAccount(id5);
            assert (platform.getNumberOfAccounts() == 3) : "number of accounts registered in the system does not match";

            // Changing Account Handle ------------------
            // Testing changeAccountHandle(String oldHandle, String newHandle)

            // Checking HandleNotRecognisedException (old handle doesn't exist)
            platform.changeAccountHandle("my_account", "my_new_account"); // should throw HandleNotRecognisedException

            // Checking illegalHandleException (new handle already exists)
            platform.changeAccountHandle("my_handle3", "my_handle2"); // should throw illegalHandleException

            // Checking invalidHandleException (handle is empty, has more than 30
            // characters, or has white spaces.)
            platform.changeAccountHandle("my_handle3", ""); // should throw invalidHandleException
            platform.changeAccountHandle("my_handle3", "ThisIsMoreThanThirtyCharacters!"); // should throw
                                                                                           // invalidHandleException
            platform.changeAccountHandle("my_handle3", "my handle 3"); // should throw invalidHandleException

            platform.changeAccountHandle("my_handle3", "my_handle");

            // Showing Account ----------------
            // Testing showAccount(String handle)

            // Checking HandleNotRecognisedException
            platform.showAccount("new_account"); // should throw a HandleNotRecognisedException

            System.out.println(platform.showAccount("my_handle"));
            String accountDetails = platform.showAccount("my_handle");
            assert (accountDetails.length() != 0) : "show account method is not functioning correctly";

            // Updating Account Description ---------------
            // Testing updateAccountDescription(String handle, String description)
            System.out.println(platform.showAccount("my_handle1"));

            // Checking HandleNotRecognisedException
            platform.updateAccountDescription("my_handle7", "This is the best account.");

            platform.updateAccountDescription("my_handle1", "This is the best account.");
            System.out.println(platform.showAccount("my_handle1"));

            // Creating Original Posts ---------------
            // Testing createPost(String handle, String message)

            post1 = platform.createPost("my_handle1", "My favourite fruit is strawberries!");
            post2 = platform.createPost("my_handle2", " My favourite sport is Tennis. ");
            post3 = platform.createPost("my_handle", "I'm a Pisces");
            post4 = platform.createPost("my_handle1", "I'm vegan now :) ");

            assert (platform.getTotalOriginalPosts() == 4) : "number of Posts registered in the system does not match";

            // Checking HandleNotRecognisedException

            post5 = platform.createPost("my_handle7", "My favourite fruit isn't strawberries!");
            assert (platform.getTotalOriginalPosts() == 4) : "HandleNotRecognisedException has not thrown";

            // Checking InvalidPostException (message is empty or has more than 100
            // characters.)
            post6 = platform.createPost("my_handle1", "");
            assert (platform.getTotalOriginalPosts() == 4) : "InvalidPostException has not thrown";

            post7 = platform.createPost("my_handle1",
                    "Humpty Dumpty sat on a wall, Humpty Dumpty had a great fall, All the king's horses and all the king's men, Couldn't put Humpty together again, Humpty Dumpty sat on a wall, Humpty Dumpty had a great fall");
            assert (platform.getTotalOriginalPosts() == 4) : "InvalidPostException has not thrown";

            // Creating Endorsement Posts ------------
            // Testing endorsePost(String handle, int id)

            like1 = platform.endorsePost("my_handle1", post1);
            like2 = platform.endorsePost("my_handle1", post3);
            like3 = platform.endorsePost("my_handle1", post4);
            like4 = platform.endorsePost("my_handle2", post1);
            like5 = platform.endorsePost("my_handle2", post3);
            like6 = platform.endorsePost("my_handle", post2);
            like7 = platform.endorsePost("my_handle", post3);
            assert (platform
                    .getTotalEndorsmentPosts() == 7) : "number of Endorsement Posts registered in the system does not match";

            // Checking HandleNotRecognisedException
            like8 = platform.endorsePost("my_handle7", post3);
            assert (platform.getTotalEndorsmentPosts() == 7) : "HandleNotRecognisedException has not thrown";

            // Checking PostIDNotRecognisedException
            like9 = platform.endorsePost("my_handle2", 74);
            assert (platform.getTotalEndorsmentPosts() == 7) : "PostIDNotRecognisedException has not thrown";

            // Checking NotActionablePostException (if the ID refers to a endorsement post)
            like9 = platform.endorsePost("my_handle2", like1);
            assert (platform.getTotalEndorsmentPosts() == 7) : "NotActionablePostException has not thrown";

            // Creating Comment Posts ------------------
            // Testing commentPost(String handle, int id, String message)

            comment1 = platform.commentPost("my_handle2", post1, "I actually hate strawberries, they're disgusting. ");
            comment2 = platform.commentPost("my_handle2", post3, "I'm a Leo!!!");
            comment3 = platform.commentPost("my_handle1", comment1, "No need to be rude!");
            comment4 = platform.commentPost("my_handle", comment1, "wow ok but who asked ");
            comment5 = platform.commentPost("my_handle", comment2, "I agree.");
            comment6 = platform.commentPost("my_handle1", post3, "I'm a Gemini xxx");
            assert (platform
                    .getTotalCommentPosts() == 6) : "number of Comment Posts registered in the system does not match";

            // Checking HandleNotRecognisedException
            int comment7 = platform.commentPost("my_handle7", post3, "I'm a Virgo btw");
            assert (platform.getTotalCommentPosts() == 6) : "HandleNotRecognisedException has not thrown";

            // Checking PostIDNotRecognisedException
            int comment8 = platform.commentPost("my_handle1", 465, "I'm a Cancer.");
            assert (platform.getTotalCommentPosts() == 6) : "PostIDNotRecognisedException has not thrown";

            // Checking NotActionablePostException (if the ID refers to a endorsement post)
            int comment9 = platform.commentPost("my_handle1", like1, "I'm an Aquarius");
            assert (platform.getTotalCommentPosts() == 6) : "NotActionablePostException has not thrown";

            // CheckingInvalidPostException (message is empty or has more than 100
            // characters.)
            int comment10 = platform.commentPost("my_handle1", post3, "");
            assert (platform.getTotalCommentPosts() == 6) : "CheckingInvalidPostException has not thrown";
            int comment11 = platform.commentPost("my_handle7", like1,
                    "Humpty Dumpty sat on a wall, Humpty Dumpty had a great fall, All the king's horses and all the king's men, Couldn't put Humpty together again, Humpty Dumpty sat on a wall, Humpty Dumpty had a great fall");
            assert (platform.getTotalCommentPosts() == 6) : "CheckingInvalidPostException has not thrown";

            // Deleting Posts -------------
            // Testing deletePost(int id)

            platform.deletePost(like1);
            assert (platform.getTotalEndorsmentPosts() == 6) : "Endorsement did not delete";
            platform.deletePost(comment6);
            assert (platform.getTotalCommentPosts() == 5) : "Comment did not delete";
            platform.deletePost(post2); // has no comments
            assert (platform.getTotalOriginalPosts() == 3) : "Post did not delete";
            platform.deletePost(post3); // has a comment
            assert (platform.getTotalOriginalPosts() == 2) : "Post did not delete";

            // Checking PostIDNotRecognisedException
            platform.deletePost(756);
            assert ((platform.getTotalOriginalPosts() == 2) && (platform.getTotalEndorsmentPosts() == 6)
                    && (platform.getTotalCommentPosts() == 5)) : "PostIDNotRecognisedException was not thrown";


            // Showing Individual Post ----------------
            // Testing showIndividualPost(int id)

            String postDetails = platform.showIndividualPost(post1);
            System.out.println(postDetails);
            assert(postDetails.length() != 0 ): "show individual post is not functioning correctly";

            // Checking PostIDNotRecognisedException
            String postDetails2 = "";
            postDetails2 = platform.showIndividualPost(735);
            assert(postDetails2.length() == 0 ): "PostIDNotRecognisedException has not thrown";


            










            // 

            // System.out.println(platform.showAccount("my_handle1"));
            // String a = platform.showAccount("my_handle1");
            assert (platform.getNumberOfAccounts() == 2) : "number of accounts registered in the system does not match";

            // platform.removeAccount(id1);
            // platform.removeAccount("my_handle2");
            assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";

            post1Id = platform.createPost("my_handle1", "My First Post teehehe");
            System.out.println();

            // System.out.println(platform.showIndividualPost(post1Id));
            // System.out.println("post created");
            // System.out.println(platform.showAccount("my_handle1"));
            // System.out.println();
            System.out.println();
            post2Id = platform.commentPost("my_handle1", post1Id, "My First comment");
            post3Id = platform.commentPost("my_handle2", post2Id, "Replying to your comment");
            post4Id = platform.endorsePost("my_handle1", post1Id);
            System.out.println(post4Id);
            // System.out.println("next up individual posts");
            // System.out.println(platform.showIndividualPost(post1Id));
            // System.out.println(platform.showIndividualPost(post2Id));
            str = platform.showPostChildrenDetails(post1Id);
            System.out.println(str.toString());
            // System.out.println(" done");

            assert (platform
                    .getTotalOriginalPosts() == 1) : "number of original posts registered in the system does not match";
            // platform.deletePost(post1Id);
            assert (platform
                    .getTotalOriginalPosts() == 0) : "number of original posts registered in the system does not match";

            platform.removeAccount(id1);

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
        } catch (InvalidPostException e) {
            assert (false) : "InvalidPostException thrown incorrectly";

        } catch (PostIDNotRecognisedException e) {
            e.printStackTrace();
            assert (false) : "PostIDNotRecognisedException thrown incorrectly";

        } catch (NotActionablePostException e) {
            e.printStackTrace();
        }

    }

}

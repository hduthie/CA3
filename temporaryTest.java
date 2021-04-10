import socialmedia.SocialMediaPlatform;
import socialmedia.SocialMedia;
import socialmedia.IllegalHandleException;
import socialmedia.InvalidHandleException;
import socialmedia.InvalidPostException;
import socialmedia.NotActionablePostException;
import socialmedia.PostIDNotRecognisedException;

import java.io.IOException;

import socialmedia.AccountIDNotRecognisedException;
import socialmedia.HandleNotRecognisedException;

public class temporaryTest {
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

            id5 = platform.createAccount("my_handle5");
            assert (platform.getNumberOfAccounts() == 5) : "number of accounts registered in the system does not match";

            // Creating Original Posts ---------------
            // Testing createPost(String handle, String message)

            post1 = platform.createPost("my_handle1", "My favourite fruit is strawberries!");
            post2 = platform.createPost("my_handle2", "My favourite sport is Tennis. ");
            post3 = platform.createPost("my_handle3", "I'm a Pisces");
            post4 = platform.createPost("my_handle1", "I'm vegan now :) ");

            assert (platform.getTotalOriginalPosts() == 4) : "number of Posts registered in the system does not match";

            // Creating Endorsement Posts ------------
            // Testing endorsePost(String handle, int id)

            like1 = platform.endorsePost("my_handle1", post1);
            like2 = platform.endorsePost("my_handle1", post3);
            like3 = platform.endorsePost("my_handle1", post4);
            like4 = platform.endorsePost("my_handle2", post1);
            like5 = platform.endorsePost("my_handle2", post3);
            like6 = platform.endorsePost("my_handle3", post2);
            like7 = platform.endorsePost("my_handle3", post3);
            assert (platform
                    .getTotalEndorsmentPosts() == 7) : "number of Endorsement Posts registered in the system does not match";

            // Creating Comment Posts ------------------
            // Testing commentPost(String handle, int id, String message)

            comment1 = platform.commentPost("my_handle2", post1, "I actually hate strawberries, they're disgusting. ");
            comment2 = platform.commentPost("my_handle2", post3, "I'm a Leo!!!");
            comment3 = platform.commentPost("my_handle1", comment1, "No need to be rude!");
            comment4 = platform.commentPost("my_handle3", post1, "wow ok but who asked ");
            comment5 = platform.commentPost("my_handle3", comment3, "I agree.");
            comment6 = platform.commentPost("my_handle1", post3, "I'm a Gemini xxx");
            assert (platform
                    .getTotalCommentPosts() == 6) : "number of Comment Posts registered in the system does not match";

            // Showing Individual Post ----------------
            // Testing showIndividualPost(int id)

            String postDetails = platform.showIndividualPost(post1);
            System.out.println(postDetails);
            assert (postDetails.length() != 0) : "show individual post is not functioning correctly";

            // ShowPostChildrenDetails()
            System.out.println(platform.showIndividualPost(post2));
            System.out.println(platform.showIndividualPost(post3));
            System.out.println(platform.showIndividualPost(post4));

            System.out.println("-------------------------------------------------------------");
            System.out.print(platform.showPostChildrenDetails(post1));

            // System.out.println("-------------------------------------------------------------");
            // System.out.print(platform.showPostChildrenDetails(post2));

            // System.out.println("-------------------------------------------------------------");
            // System.out.print(platform.showPostChildrenDetails(post3));

            // System.out.println("-------------------------------------------------------------");
            // System.out.print(platform.showPostChildrenDetails(post4));

            // System.out.println("-------------------------------------------------------------");
            // System.out.print(platform.showPostChildrenDetails(comment1));

            // System.out.println("-------------------------------------------------------------");
            // System.out.print(platform.showPostChildrenDetails(comment2));

            System.out.println("-------------------------------------------------------------");
            System.out.print(platform.showPostChildrenDetails(comment3));

            // System.out.println("-------------------------------------------------------------");
            // System.out.print(platform.showPostChildrenDetails(comment4));

            platform.deletePost(comment1);

            System.out.println("-------------------------------------------------------------");
            System.out.print(platform.showPostChildrenDetails(post1));

            System.out.println("-------------------------------------------------------------");
            System.out.print(platform.showPostChildrenDetails(comment3));

            platform.savePlatform("platform");
            platform.erasePlatform();
            platform.loadPlatform("platform.ser");

            System.out.println("-------------------------------------------------------------");
            System.out.print(platform.showPostChildrenDetails(post1));

        } catch (IllegalHandleException e) {
            System.out.println(e.getMessage());
            assert (false) : "IllegalHandleException thrown incorrectly";
        } catch (InvalidHandleException e) {
            System.out.println(e.getMessage());
            assert (false) : "InvalidHandleException thrown incorrectly";
        } catch (HandleNotRecognisedException e) {

            e.printStackTrace();
        } catch (InvalidPostException e) {
            assert (false) : "InvalidPostException thrown incorrectly";

        } catch (PostIDNotRecognisedException e) {
            e.printStackTrace();
            assert (false) : "PostIDNotRecognisedException thrown incorrectly";

        } catch (NotActionablePostException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
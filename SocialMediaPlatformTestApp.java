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
        // StringBuilder showPostChildrenDetails(int id);
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
            try {
                id4 = platform.createAccount("my_handle1", "This account's handle is illegal");
                assert (platform.getNumberOfAccounts() == 3) : "illegalHandleException has not thrown";
            } catch (IllegalHandleException e) {
                System.out.println(e.getMessage());
            }

            id4 = platform.createAccount("my_handle4", "This account's handle is not illegal");
            assert (platform.getNumberOfAccounts() == 4) : "number of accounts registered in the system does not match";

            // Checking invalidHandleException (handle is empty, has more than 30
            // characters, or has white spaces.)
            try {
                id5 = platform.createAccount("");
                assert (platform.getNumberOfAccounts() == 4) : "invalidHandleException has not thrown";
            } catch (InvalidHandleException e) {
                System.out.println(e.getMessage());
            }
            try {
                id5 = platform.createAccount("ThisIsMoreThanThirtyCharacters!");
                assert (platform.getNumberOfAccounts() == 4) : "invalidHandleException has not thrown";
            } catch (InvalidHandleException e) {
                System.out.println(e.getMessage());
            }
            try {
                id5 = platform.createAccount("my handle 5");
                assert (platform.getNumberOfAccounts() == 4) : "invalidHandleException has not thrown";
            } catch (InvalidHandleException e) {
                System.out.println(e.getMessage());
            }

            id5 = platform.createAccount("my_handle5");
            assert (platform.getNumberOfAccounts() == 5) : "number of accounts registered in the system does not match";

            // Removing Accounts -----------------
            // Testing removeAccount(String handle) , removeAccount(int id)

            // Checking HandleNotRecognisedException
            try {
                platform.removeAccount("my_handle");
                assert (platform.getNumberOfAccounts() == 4) : "HandleNotRecognisedException has not thrown";
            } catch (HandleNotRecognisedException e) {
                System.out.println(e.getMessage());
            }

            platform.removeAccount("my_handle4");
            assert (platform.getNumberOfAccounts() == 4) : "number of accounts registered in the system does not match";

            // Checking AccountIDNotRecognisedException
            try {
                platform.removeAccount(27);
                assert (platform.getNumberOfAccounts() == 3) : "AccountIDNotRecognisedException has not thrown";
            } catch (AccountIDNotRecognisedException e) {
                System.out.println(e.getMessage());
            }

            platform.removeAccount(id5);
            assert (platform.getNumberOfAccounts() == 3) : "number of accounts registered in the system does not match";

            // Changing Account Handle ------------------
            // Testing changeAccountHandle(String oldHandle, String newHandle)

            // Checking HandleNotRecognisedException (old handle doesn't exist)
            try {
                platform.changeAccountHandle("my_account", "my_new_account"); // should throw
                                                                              // HandleNotRecognisedException
            } catch (HandleNotRecognisedException e) {
                System.out.println(e.getMessage());
            }
            // Checking illegalHandleException (new handle already exists)
            try {
                platform.changeAccountHandle("my_handle3", "my_handle2"); // should throw illegalHandleException
            } catch (IllegalHandleException e) {
                System.out.println(e.getMessage());
            }

            // Checking invalidHandleException (handle is empty, has more than 30
            // characters, or has white spaces.)
            try {
                platform.changeAccountHandle("my_handle3", "");
            } catch (InvalidHandleException e) {
                System.out.println(e.getMessage());
            }
            try {
                platform.changeAccountHandle("my_handle3", "ThisIsMoreThanThirtyCharacters!");
            } catch (InvalidHandleException e) {
                System.out.println(e.getMessage());
            }
            try {
                platform.changeAccountHandle("my_handle3", "my handle 3");
            } catch (InvalidHandleException e) {
                System.out.println(e.getMessage());
            }

            platform.changeAccountHandle("my_handle3", "my_handle");

            // Showing Account ----------------
            // Testing showAccount(String handle)

            // Checking HandleNotRecognisedException
            try {
                platform.showAccount("new_account");
            } catch (HandleNotRecognisedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(platform.showAccount("my_handle"));
            String accountDetails = platform.showAccount("my_handle");
            assert (accountDetails.length() != 0) : "show account method is not functioning correctly";

            // Updating Account Description ---------------
            // Testing updateAccountDescription(String handle, String description)
            System.out.println(platform.showAccount("my_handle1"));

            // Checking HandleNotRecognisedException
            try {
                platform.updateAccountDescription("my_handle7", "This is the best account.");
            } catch (HandleNotRecognisedException e) {
                System.out.println(e.getMessage());
            }

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
            try {
                post5 = platform.createPost("my_handle7", "My favourite fruit isn't strawberries!");
            } catch (HandleNotRecognisedException e) {
                System.out.println(e.getMessage());
            }
            assert (platform.getTotalOriginalPosts() == 4) : "HandleNotRecognisedException has not thrown";

            // Checking InvalidPostException (message is empty or has more than 100
            // characters.)
            try {
                post6 = platform.createPost("my_handle1", "");
            } catch (InvalidPostException e) {
                System.out.println(e.getMessage());
            }
            assert (platform.getTotalOriginalPosts() == 4) : "InvalidPostException has not thrown";

            try {
                post7 = platform.createPost("my_handle1",
                        "Humpty Dumpty sat on a wall, Humpty Dumpty had a great fall, All the king's horses and all the king's men, Couldn't put Humpty together again, Humpty Dumpty sat on a wall, Humpty Dumpty had a great fall");
            } catch (InvalidPostException e) {
                System.out.println(e.getMessage());
            }
            assert (platform.getTotalOriginalPosts() == 4) : "InvalidPostException has not thrown";

            // Creating Endorsement Posts ------------
            // Testing endorsePost(String handle, int id)

            like1 = platform.endorsePost("my_handle1", post1);
            like2 = platform.endorsePost("my_handle1", post3);
            like3 = platform.endorsePost("my_handle1", post4);
            like4 = platform.endorsePost("my_handle2", post4);
            like5 = platform.endorsePost("my_handle2", post3);
            like6 = platform.endorsePost("my_handle", post2);
            like7 = platform.endorsePost("my_handle", post3);
            like8 = platform.endorsePost("my_handle", post1);
            assert (platform
                    .getTotalEndorsmentPosts() == 8) : "number of Endorsement Posts registered in the system does not match";

            // Checking HandleNotRecognisedException
            try {
                like8 = platform.endorsePost("my_handle7", post3);
            } catch (HandleNotRecognisedException e) {
                System.out.println(e.getMessage());
            }
            assert (platform.getTotalEndorsmentPosts() == 8) : "HandleNotRecognisedException has not thrown";

            // Checking PostIDNotRecognisedException
            try {
                like9 = platform.endorsePost("my_handle2", 74);
            } catch (PostIDNotRecognisedException e) {
                System.out.println(e.getMessage());
            }
            assert (platform.getTotalEndorsmentPosts() == 8) : "PostIDNotRecognisedException has not thrown";

            // Checking NotActionablePostException (if the ID refers to a endorsement post)
            try {
                like9 = platform.endorsePost("my_handle2", like1);
            } catch (NotActionablePostException e) {
                System.out.println(e.getMessage());
            }
            assert (platform.getTotalEndorsmentPosts() == 8) : "NotActionablePostException has not thrown";

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
            try {
                int comment7 = platform.commentPost("my_handle7", post3, "I'm a Virgo btw");
            } catch (HandleNotRecognisedException e) {
                System.out.println(e.getMessage());
            }
            assert (platform.getTotalCommentPosts() == 6) : "HandleNotRecognisedException has not thrown";

            // Checking PostIDNotRecognisedException
            try {
                int comment8 = platform.commentPost("my_handle1", 465, "I'm a Cancer.");
                assert (platform.getTotalCommentPosts() == 6) : "PostIDNotRecognisedException has not thrown";
            } catch (PostIDNotRecognisedException e) {
                System.out.println(e.getMessage());
            }

            // Checking NotActionablePostException (if the ID refers to a endorsement post)
            try {
                int comment9 = platform.commentPost("my_handle1", like1, "I'm an Aquarius");
            } catch (NotActionablePostException e) {
                System.out.println(e.getMessage());
            }
            assert (platform.getTotalCommentPosts() == 6) : "NotActionablePostException has not thrown";

            // CheckingInvalidPostException (message is empty or has more than 100
            // characters.)
            try {
                int comment10 = platform.commentPost("my_handle1", post3, "");
            } catch (InvalidPostException e) {
                System.out.println(e.getMessage());
            }
            assert (platform.getTotalCommentPosts() == 6) : "CheckingInvalidPostException has not thrown";
            try {
                int comment11 = platform.commentPost("my_handle1", post3,
                        "Humpty Dumpty sat on a wall, Humpty Dumpty had a great fall, All the king's horses and all the king's men, Couldn't put Humpty together again, Humpty Dumpty sat on a wall, Humpty Dumpty had a great fall");
            } catch (InvalidPostException e) {
                System.out.println(e.getMessage());
            }
            assert (platform.getTotalCommentPosts() == 6) : "CheckingInvalidPostException has not thrown";

            // Deleting Posts -------------
            // Testing deletePost(int id)
            
            platform.deletePost(like1);
            assert (platform.getTotalEndorsmentPosts() == 7) : "Endorsement did not delete";
            platform.deletePost(comment6);
            assert (platform.getTotalCommentPosts() == 5) : "Comment did not delete";
            platform.deletePost(post2); // has no comments
            assert (platform.getTotalOriginalPosts() == 3) : "Post did not delete";
            platform.deletePost(post1); // has a comment
            assert (platform.getTotalOriginalPosts() == 2) : "Post did not delete";



            // Checking PostIDNotRecognisedException
            try {
                platform.deletePost(756);
            } catch (PostIDNotRecognisedException e) {
                System.out.println(e.getMessage());
            }
            assert ((platform.getTotalOriginalPosts() == 2) && (platform.getTotalEndorsmentPosts() == 7)
                    && (platform.getTotalCommentPosts() == 5)) : "PostIDNotRecognisedException was not thrown";

            // Showing Individual Post ----------------
            // Testing showIndividualPost(int id)

            String postDetails = platform.showIndividualPost(post3);
            System.out.println(postDetails);
            assert (postDetails.length() != 0) : "show individual post is not functioning correctly";

            // Checking PostIDNotRecognisedException
            String postDetails2 = "";
            try {
                postDetails2 = platform.showIndividualPost(735);
            } catch (PostIDNotRecognisedException e) {
                System.out.println(e.getMessage());
            }
            assert (postDetails2.length() == 0) : "PostIDNotRecognisedException has not thrown";

            // Showing Post Children Details --------------------------
            // Testing showPostChildrenDetails(int id)

            StringBuilder postChildrenDetails = platform.showPostChildrenDetails(post3);
            System.out.println(postChildrenDetails);

            // Checking PostIDNotRecognisedException
            try {
                postDetails2 = platform.showIndividualPost(735);
            } catch (PostIDNotRecognisedException e) {
                System.out.println(e.getMessage());
            }
            assert (postDetails2.length() == 0) : "PostIDNotRecognisedException has not thrown";

            // Analytics
            // Testing getNumberOfAccounts(), getTotalOriginalPosts(),
            // getTotalEndorsmentPosts , getTotalCommentPosts
            // getMostEndorsedPost(), getMostEndorsedAccount()

            platform.getNumberOfAccounts();
            platform.getTotalOriginalPosts();
            platform.getTotalEndorsmentPosts();
            platform.getTotalCommentPosts();

            int mostEndorsedPostId = platform.getMostEndorsedPost();
            assert (mostEndorsedPostId == post3) : "The most endorsed post is incorrect";

            int mostEndorsedAccount = platform.getMostEndorsedAccount();
            assert (mostEndorsedAccount == id3) : "The most endorsed account is incorrect";

            // Saving, erasing, loading platform
            // savePlatform(), erasePlatform(), loadPlatform()

            platform.savePlatform("platform");
            platform.erasePlatform();
            platform.loadPlatform("platform.ser");

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
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

    }

}

package socialmedia;

import java.io.IOException;
import java.io.Serializable;





public class SocialMedia extends Serializable{

    int createAccount(String handle) throws IllegalHandleException, InvalidHandleException;

	/**
	 * The method removes the account with the corresponding ID from the platform.
	 * When an account is removed, all of their posts and likes should also be
	 * removed.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 * 
	 * @param id ID of the account.
	 * @throws AccountIDNotRecognisedException if the ID does not match to any
	 *                                         account in the system.
	 */


	 
}
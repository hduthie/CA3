package socialmedia;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class SocialMedia implements Serializable{

	private static final long serialVersionUID = 1L;
	private static ArrayList<Account> accounts = new ArrayList<Account>();

		/**
	 * The method creates an account in the platform with the given handle and
	 * description.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 * 
	 * @param handle      account's handle.
	 * @param description account's description.
	 * @throws IllegalHandleException if the handle already exists in the platform.
	 * @throws InvalidHandleException if the new handle is empty, has more than 30
	 *                                characters, or has white spaces.
	 * @return the ID of the created account.
	 */
	int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException{
		Account account = new Account(handle);
		account.setDescription(description);
		accounts.add(account);
		return account.getId();
		// DO WE NEED A TRY-CATCH??? what do we need to catch
		// Add account to the platform 

		

	}


	/**
	 * The method removes the account with the corresponding handle from the
	 * platform. When an account is removed, all of their posts and likes should
	 * also be removed.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 * 
	 * @param handle account's handle.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 */
	void removeAccount(String handle) throws HandleNotRecognisedException{
		Boolean handleRecognised = false;

		for(Account a: accounts){
			if (a.getHandle().equals(handle)){
				accounts.remove(a);
				handleRecognised = true;
				break;
			}
		}
		if(!handleRecognised){
			throw new HandleNotRecognisedException("The handle " + handle + " is not recognised.");
		}


		// consider whether a try catch is necessary????
	}
	 
		/**
	 * The method updates the description of the account with the respective handle.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 * 
	 * @param handle      handle to identify the account.
	 * @param description new text for description.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 */
	void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException{
		Boolean handleRecognised = false;

		for(Account a: accounts){
			if (a.getHandle().equals(handle)){
				a.setDescription(description);
				handleRecognised = true;
				break;
			}
		}
		if(!handleRecognised){
			throw new HandleNotRecognisedException("The handle " + handle + " is not recognised.");
		}
	}

	

}
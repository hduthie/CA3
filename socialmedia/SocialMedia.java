package socialmedia;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class SocialMedia implements Serializable {

	private static final long serialVersionUID = 1L;
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static ArrayList<Post> posts = new ArrayList<Post>();

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
	int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
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
	void removeAccount(String handle) throws HandleNotRecognisedException {

		Account a = findAccountFromHandle(handle);
		try {
			accounts.remove(a);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

		// consider whether a try catch is necessary????
	}

	/**
	 * The method replaces the oldHandle of an account by the newHandle.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 * 
	 * @param oldHandle account's old handle.
	 * @param newHandle account's new handle.
	 * @throws HandleNotRecognisedException if the old handle does not match to any
	 *                                      account in the system.
	 * @throws IllegalHandleException       if the new handle already exists in the
	 *                                      platform.
	 * @throws InvalidHandleException       if the new handle is empty, has more
	 *                                      than 30 characters, or has white spaces.
	 */
	void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {

		if (checkAccountHandle(newHandle)) {
			Account a = findAccountFromHandle(oldHandle);
			a.setHandle(newHandle);
		}
	}

	/**
	 * The method creates a formatted string summarising the stats of the account
	 * identified by the given handle. The template should be:
	 * 
	 * <pre>
	 * ID: [account ID]
	 * Handle: [account handle]
	 * Description: [account description]
	 * Post count: [total number of posts, including endorsements and replies]
	 * Endorse count: [sum of endorsements received by each post of this account]
	 * </pre>
	 * 
	 * @param handle handle to identify the account.
	 * @return the account formatted summary.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 */
	String showAccount(String handle) throws HandleNotRecognisedException{
		Account a = findAccountFromHandle(handle);
		int numberOfPosts = 0;
		
		for(Post p: posts){
			if(p.getAuthor() == a){
				numberOfPosts += 1;
			}
		} 
		return "ID: " + a.getId() + "\nHandle: " + a.getHandle() + "\nDescription: " + a.getDescription() 
		+ "\nPost count: "+ numberOfPosts + "\nEndorse count: " +  countEndorsements(a);
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
	void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		Boolean handleRecognised = false;

		for (Account a : accounts) {
			if (a.getHandle().equals(handle)) {
				a.setDescription(description);
				handleRecognised = true;
				break;
			}
		}
		if (!handleRecognised) {
			throw new HandleNotRecognisedException("The handle " + handle + " is not recognised.");
		}
	}

	private Account findAccountFromHandle(String handle) throws HandleNotRecognisedException {

		for (Account a : accounts) {
			if (a.getHandle().equals(handle)) {
				return a;
			}
		}
		throw new HandleNotRecognisedException("The handle " + handle + " is not recognised.");

	}

	private static Boolean checkAccountHandle(String handle) throws InvalidHandleException, IllegalHandleException {
		if (Account.isHandleUnique(handle)) {
			if (Account.isHandleValid(handle)) {
				return true;
			} else {
				throw new InvalidHandleException("Handle is invalid: " + handle);
			}
		} else {
			throw new IllegalHandleException("Handle already exists: " + handle);
		}

	}

	private int countEndorsements(Account a) {
		int totalEndorsements = 0;

		// TEST THIS METHOD
		for (Post p : a.getPosts()) {
			for (Post q : p.getReplies()) {
				if (q instanceof Endorsement) {
					totalEndorsements += 1;
				}
			}

		}
		return totalEndorsements;
	}

}
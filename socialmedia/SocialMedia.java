package socialmedia;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class SocialMedia implements SocialMediaPlatform {

	private static final long serialVersionUID = 1L;
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static ArrayList<Post> posts = new ArrayList<Post>();

	/**
	 * The method creates an account in the platform with the given handle.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 * 
	 * @param handle account's handle.
	 * @throws IllegalHandleException if the handle already exists in the platform.
	 * @throws InvalidHandleException if the new handle is empty, has more than 30
	 *                                characters, or has white spaces.
	 * @return the ID of the created account.
	 * 
	 */
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException {
		Account account = new Account(handle);
		accounts.add(account);
		return account.getId();
	}

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
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		Account account = new Account(handle);
		account.setDescription(description);
		accounts.add(account);
		return account.getId();
		// DO WE NEED A TRY-CATCH??? what do we need to catch
		// Add account to the platform

	}

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
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
		Boolean accountIdRecognised = false;
		Account removeAccount = null;

		for (Account account : accounts) {
			if (account.getId() == id) {
				accounts.remove(account);
				removeAccount = account;
				accountIdRecognised = true;
			}
		}

		if (!accountIdRecognised) {
			throw new AccountIDNotRecognisedException("The account ID has not been recognised.");
		}

		for (Post post : posts) {
			if (post.getAuthor() == removeAccount) {
				try {
					deletePost(post.getPostID());
				} catch (PostIDNotRecognisedException e) {
					e.printStackTrace();
				}
			}
		}

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
	public void removeAccount(String handle) throws HandleNotRecognisedException {

		Account a = findAccountFromHandle(handle);
		accounts.remove(a);
		for (Post post : posts) {
			if (post.getAuthor() == a) {
				try {
					deletePost(post.getPostID());
				} catch (PostIDNotRecognisedException e) {
					e.printStackTrace();
				}
			}
		}
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
	public void changeAccountHandle(String oldHandle, String newHandle)
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
	public String showAccount(String handle) throws HandleNotRecognisedException {
		Account a = findAccountFromHandle(handle);
		int numberOfPosts = a.getPosts().size();

		return "ID: " + a.getId() + "\nHandle: " + a.getHandle() + "\nDescription: " + a.getDescription()
				+ "\nPost count: " + numberOfPosts + "\nEndorse count: " + countEndorsements(a);
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
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
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

	/**
	 * The method creates a post for the account identified by the given handle with
	 * the following message.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 * 
	 * @param handle  handle to identify the account.
	 * @param message post message.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 * @throws InvalidPostException         if the message is empty or has more than
	 *                                      100 characters.
	 * @return the sequential ID of the created post.
	 */
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		Account a = findAccountFromHandle(handle);
		if (message.equals("") || message.length() > 100) {
			throw new InvalidPostException("The post : " + message + " is invalid");
		} else {
			Post post = new Post(a, message);
			a.addPostToAccount(post);
			return post.getPostID();
		}

	}

	/**
	 * The method creates an endorsement post of an existing post, similar to a
	 * retweet on Twitter. An endorsement post is a special post. It contains a
	 * reference to the endorsed post and its message is formatted as:
	 * <p>
	 * <code>"EP@" + [endorsed account handle] + ": " + [endorsed message]</code>
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 * 
	 * @param handle of the account endorsing a post.
	 * @param id     of the post being endorsed.
	 * @return the sequential ID of the created post.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system.
	 * @throws NotActionablePostException   if the ID refers to a endorsement post.
	 *                                      Endorsement posts are not endorsable.
	 *                                      Endorsements are not transitive. For
	 *                                      instance, if post A is endorsed by post
	 *                                      B, and an account wants to endorse B, in
	 *                                      fact, the endorsement must refers to A.
	 */
	public int endorsePost(String handle, int id)
			throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {

		Account a = findAccountFromHandle(handle);
		Post postEndorsed = getPostFromId(id);
		if (postEndorsed instanceof Endorsement) {
			throw new NotActionablePostException("Endorsement posts are not endorsable.");
		}
		Endorsement endorsement = new Endorsement(a, postEndorsed);
		postEndorsed.addReply(endorsement);
		postEndorsed.incrementEndorsements();
		a.addPostToAccount(endorsement);
		return endorsement.getPostID();

	}

	/**
	 * The method creates a comment post referring to an existing post, similarly to
	 * a reply on Twitter. A comment post is a special post. It contains a reference
	 * to the post being commented upon.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 * 
	 * @param handle  of the account commenting a post.
	 * @param id      of the post being commented.
	 * @param message the comment post message.
	 * @return the sequential ID of the created post.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system.
	 * @throws NotActionablePostException   if the ID refers to a endorsement post.
	 *                                      Endorsement posts are not endorsable.
	 *                                      Endorsements cannot be commented. For
	 *                                      instance, if post A is endorsed by post
	 *                                      B, and an account wants to comment B, in
	 *                                      fact, the comment must refers to A.
	 * @throws InvalidPostException         if the comment message is empty or has
	 *                                      more than 100 characters.
	 */
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		Post postCommentedOn = getPostFromId(id);
		Account commenter = findAccountFromHandle(handle);
		if (postCommentedOn instanceof Endorsement) {
			throw new NotActionablePostException("You cannot comment on an Endorsement.");
		}
		Comment comment = new Comment(commenter, message, postCommentedOn);
		postCommentedOn.addReply((Post) comment);
		postCommentedOn.incrementComments();
		commenter.addPostToAccount(comment);
		return comment.getPostID();
	}

	/**
	 * The method removes the post from the platform. When a post is removed, all
	 * its endorsements should be removed as well. All replies to this post should
	 * be updated by replacing the reference to this post by a generic empty post.
	 * <p>
	 * The generic empty post message should be "The original content was removed
	 * from the system and is no longer available.". This empty post is just a
	 * replacement placeholder for the post which a reply refers to. Empty posts
	 * should not be linked to any account and cannot be acted upon, i.e., it cannot
	 * be available for endorsements or replies.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 * 
	 * @param id ID of post to be removed.
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system.
	 */
	public void deletePost(int id) throws PostIDNotRecognisedException {
		Post deletedPost = getPostFromId(id);
		GenericEmptyPost genericEmptyPost = new GenericEmptyPost(deletedPost);
		Account deletedPostAccount = deletedPost.getAuthor();
		Boolean hasChildren = true;
		Post currentPost = deletedPost;
		while (hasChildren) {
			if (hasChildren(currentPost)) {
				currentPost = currentPost.getReplies().get(0);
			} else {
				// delete current node, check next node on same level

			}
		}

		// if the post youre deleting is a comment, it must be removed from
		// posts(platform), from the account that coomented it, and from the post its
		// replyting ot
		// what should happen to child comments? generic empty post?
		for (Post p : deletedPost.getReplies()) {
			if ((p instanceof Endorsement) && (posts.contains(p))) {
				posts.remove(p);
				deletedPost.getReplies().remove(p);
				deletedPost.decrementEndorsements();

			} else if (p instanceof Comment) {
				((Comment) p).setReplyingTo(genericEmptyPost);
				posts.remove(p);
				deletedPost.decrementEndorsements();
			}
		}
		posts.remove(deletedPost);
		deletedPostAccount.removePostFromAccount(deletedPost);
	}

	/**
	 * The method generates a formated string containing the details of a single
	 * post. The format is as follows:
	 * 
	 * <pre>
	 * ID: [post ID]
	 * Account: [account handle]
	 * No. endorsements: [number of endorsements received by the post] | No. comments: [number of comments received by the post]
	 * [post message]
	 * </pre>
	 * 
	 * @param id of the post to be shown.
	 * @return a formatted string containing post's details.
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system.
	 */
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		Post post = getPostFromId(id);

		return "ID: " + post.getPostID() + "\nAccount: " + post.getAuthor().getHandle() + "\nNo. endorsements: "
				+ post.getNumberOfEndorsements() + " | No. comments: " + post.getNumberOfComments() + "\n"
				+ post.getMessage();

	}

	/**
	 * The method builds a StringBuilder showing the details of the current post and
	 * all its children posts. The format is as follows:
	 * 
	 * <pre>
	 * {@link #showIndividualPost(int) showIndividualPost(id)}
	 * |
	 * [for reply: replies to the post sorted by ID]
	 * |  > {@link #showIndividualPost(int) showIndividualPost(reply)}
	 * </pre>
	 * 
	 * See an example:
	 * 
	 * <pre>
	 * ID: 1
	 * Account: user1
	 * No. endorsements: 2 | No. comments: 3
	 * I like examples.
	 * |
	 * | > ID: 3
	 *     Account: user2
	 *     No. endorsements: 0 | No. comments: 1
	 *     No more than me...
	 *     |
	 *     | > ID: 5
	 *         Account: user1
	 *         No. endorsements: 0 | No. comments: 1
	 *         I can prove!
	 *         |                                         
	 *         | > ID: 6                                 
	 *             Account: user2                        
	 *             No. endorsements: 0 | No. comments: 0 
	 *             prove it                    
	 * | > ID: 4
	 *     Account: user3
	 *     No. endorsements: 4 | No. comments: 0
	 *     Can't you do better than this?
	 * 
	 * | > ID: 7
	 *     Account: user5
	 *     No. endorsements: 0 | No. comments: 1
	 *     where is the example?
	 *     |
	 *     | > ID: 10
	 *         Account: user1
	 *         No. endorsements: 0 | No. comments: 0
	 *         This is the example!
	 * </pre>
	 * 
	 * Continuing with the example, if the method is called for post ID=5
	 * ({@code showIndividualPost(5)}), the return would be:
	 * 
	 * <pre>
	 * ID: 5
	 * Account: user1
	 * No. endorsements: 0 | No. comments: 1
	 * I can prove!
	 * |                                         
	 * | > ID: 6                                 
	 *     Account: user2                        
	 *     No. endorsements: 0 | No. comments: 0 
	 *     prove it
	 * </pre>
	 * 
	 * @param id of the post to be shown.
	 * @return a formatted StringBuilder containing the details of the post and its
	 *         children.
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system.
	 * @throws NotActionablePostException   if the ID refers to an endorsement post.
	 *                                      Endorsement posts do not have children
	 *                                      since they are not endorsable nor
	 *                                      commented.
	 */
	public StringBuilder showPostChildrenDetails(int id) throws PostIDNotRecognisedException, NotActionablePostException {
		StringBuilder postChildrenDetails = new StringBuilder();
		Post originalPost = getPostFromId(id);
		if (originalPost instanceof Endorsement) {
			throw new NotActionablePostException("Endorsement posts do not have children.");
		}
		showIndividualPost(id);
		Account originalPostAccount = originalPost.getAuthor();
		Boolean hasChildren = true;
		Post currentPost = originalPost;
		int nodeIndexOnCurrentLevel = 0;

		while (currentPost != null) {
			// print current post

			// can you go down?
			if (hasChildren(currentPost)) {
				// yes can go down
				// going down (LHS)
				nodeIndexOnCurrentLevel = 0;
				currentPost = currentPost.getReplies().get(nodeIndexOnCurrentLevel);
			} else {
				// can't go down?
				// can you go adjacent?
				Boolean canGoAdjacent = false;
				while (!(canGoAdjacent)) {

					nodeIndexOnCurrentLevel += 1;

					if (currentPost instanceof Comment) {
						Post parent = ((Comment) currentPost).getReplyingTo();

						// checking if you can go adjacent;
						if (nodeIndexOnCurrentLevel < parent.getReplies().size()) {
							// you go adjacent
							currentPost = parent.getReplies().get(nodeIndexOnCurrentLevel);
							canGoAdjacent = true;
							// break out of while loop, go down as far as possible
						} else {
							canGoAdjacent = false;

							// can't go adjacent, can you go up
							Post parent1 = ((Comment) currentPost).getReplyingTo();
							if (parent1 == originalPost) {
								// can't go up. break
								currentPost = null;
							} else {
								// can go up:
								Post grandparent = ((Comment) parent1).getReplyingTo();
								nodeIndexOnCurrentLevel = grandparent.getReplies().indexOf((parent1));
								currentPost = parent1;
							}
						}

					}
				}

			}
		}

		return postChildrenDetails;
	}

	// End Post-related methods ****************************************

	// Analytics-related methods ****************************************

	/**
	 * This method returns the current total number of accounts present in the
	 * platform. Note, this is NOT the total number of accounts ever created since
	 * the current total should discount deletions.
	 * 
	 * @return the total number of accounts in the platform.
	 */
	public int getNumberOfAccounts() {
		return accounts.size();
	}

	/**
	 * This method returns the current total number of original posts (i.e.,
	 * disregarding endorsements and comments) present in the platform. Note, this
	 * is NOT the total number of posts ever created since the current total should
	 * discount deletions.
	 * 
	 * @return the total number of original posts in the platform.
	 */
	public int getTotalOriginalPosts() {
		int totalOriginalPosts = 0;
		for (Post p : posts) {
			if (!(p instanceof Endorsement) && !(p instanceof Comment)) {
				totalOriginalPosts += 1;
			}
		}
		return totalOriginalPosts;
	}

	/**
	 * This method returns the current total number of endorsement posts present in
	 * the platform. Note, this is NOT the total number of endorsements ever created
	 * since the current total should discount deletions.
	 * 
	 * @return the total number of endorsement posts in the platform.
	 */
	public int getTotalEndorsmentPosts() {
		int totalEndorsementPosts = 0;
		for (Post p : posts) {
			if (p instanceof Endorsement) {
				totalEndorsementPosts += 1;
			}
		}
		return totalEndorsementPosts;

	}

	/**
	 * This method returns the current total number of comments posts present in the
	 * platform. Note, this is NOT the total number of comments ever created since
	 * the current total should discount deletions.
	 * 
	 * @return the total number of comments posts in the platform.
	 */
	public int getTotalCommentPosts() {
		int totalCommentedPosts = 0;
		for (Post p : posts) {
			if (p instanceof Comment) {
				totalCommentedPosts += 1;
			}
		}
		return totalCommentedPosts;
	}

	/**
	 * This method identifies and returns the post with the most number of
	 * endorsements, a.k.a. the most popular post.
	 * 
	 * @return the ID of the most popular post.
	 */
	public int getMostEndorsedPost() {
		Post mostEndorsedPost = null;
		int mostEndorsements = 0;
		for (Post p : posts) {
			if (p.getNumberOfEndorsements() > mostEndorsements) {
				mostEndorsedPost = p;
				mostEndorsements = p.getNumberOfEndorsements();
			}
		}
		return mostEndorsedPost.getPostID();
	}

	/**
	 * This method identifies and returns the account with the most number of
	 * endorsements, a.k.a. the most popular account.
	 * 
	 * @return the ID of the most popular account.
	 */
	public int getMostEndorsedAccount() {
		int mostEndorsements = 0;
		Account mostEndorsedAccount = null;

		for (Account account : accounts) {
			if (account.getNumberOfEndorsements() > mostEndorsements) {
				mostEndorsedAccount = account;
				mostEndorsements = account.getNumberOfEndorsements();
			}
		}
		return mostEndorsedAccount.getId();

	}



		// Management-related methods ****************************************

	/**
	 * Method empties this SocialMediaPlatform of its contents and resets all
	 * internal counters.
	 */
	public void erasePlatform(){

	}

	/**
	 * Method saves this SocialMediaPlatform's contents into a serialised file, with
	 * the filename given in the argument.
	 *
	 * @param filename location of the file to be saved
	 * @throws IOException if there is a problem experienced when trying to save the
	 *                     store contents to the file
	 */
	public void savePlatform(String filename) throws IOException{

	}

	/**
	 * Method should load and replace this SocialMediaPlatform's contents with the
	 * serialised contents stored in the file given in the argument.
	 * <p>
	 * The state of this SocialMediaPlatform's must be be unchanged if any
	 * exceptions are thrown.
	 *
	 * @param filename location of the file to be loaded
	 * @throws IOException            if there is a problem experienced when trying
	 *                                to load the store contents from the file
	 * @throws ClassNotFoundException if required class files cannot be found when
	 *                                loading
	 */
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException{

	}
	
	
	// End Management-related methods ****************************************

	// Internal methods ****************************************

	private Account findAccountFromHandle(String handle) throws HandleNotRecognisedException {

		for (Account a : accounts) {
			if (a.getHandle().equals(handle)) {
				return a;
			}
		}
		throw new HandleNotRecognisedException("The handle " + handle + " is not recognised.");

	}

	private Post getPostFromId(int id) throws PostIDNotRecognisedException {
		for (Post p : posts) {
			if (p.getPostID() == id) {
				return p;
			}
		}
		throw new PostIDNotRecognisedException("The post ID " + id + " is not recognised.");

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
		// counts endorsements on original posts and comments
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

	private Boolean hasChildren(Post post) {
		if (post.getReplies().size() == 0) {
			return false;
		} else {
			return true;
		}

	}

}
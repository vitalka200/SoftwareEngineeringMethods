package il.ac.afeka.electionsystem.bu.exceptions;

public class AuthorizationException extends VotingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4776367721165953714L;

	public AuthorizationException(String message) {
		super("Voter not authorized. Reason: " + message);
	}

}

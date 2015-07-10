package il.ac.afeka.electionsystem.bu.exceptions;

public class AuthenticationException extends VotingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5923229798474135868L;

	public AuthenticationException(String message) {
		super("Voter not authenticated. Reason: " + message);
	}

}

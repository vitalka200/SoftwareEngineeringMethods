package il.ac.afeka.electionsystem.bu.electorslist;

import il.ac.afeka.electionsystem.bu.exceptions.AuthenticationException;
import il.ac.afeka.electionsystem.bu.exceptions.AuthorizationException;


public interface ElectorsList {
	public void AuthenticateCitizen(long citizenId) throws AuthenticationException;
	public void AuthorizeCitizen(long citizenId, long ballotId) throws AuthorizationException;
}

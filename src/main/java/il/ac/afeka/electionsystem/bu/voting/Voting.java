package il.ac.afeka.electionsystem.bu.voting;

import il.ac.afeka.electionsystem.bu.db.external.lists.VotesList;
import il.ac.afeka.electionsystem.bu.exceptions.AuthenticationException;
import il.ac.afeka.electionsystem.bu.exceptions.AuthorizationException;
import il.ac.afeka.electionsystem.bu.exceptions.PartyNotExistException;

public interface Voting {
	public void vote(long citizenId, long ballotId, long partyId)
				throws AuthenticationException, AuthorizationException, PartyNotExistException;
	public VotesList getVotesList();
	
}

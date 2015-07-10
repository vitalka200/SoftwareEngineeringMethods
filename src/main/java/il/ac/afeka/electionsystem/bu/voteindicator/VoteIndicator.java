package il.ac.afeka.electionsystem.bu.voteindicator;

import il.ac.afeka.electionsystem.bu.exceptions.PartyNotExistException;

public interface VoteIndicator {
	public boolean isVoted(long voterId);
	public void setVoted(long voterId);
	public void validateParty(long partyId) throws PartyNotExistException;
}

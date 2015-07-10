package il.ac.afeka.electionsystem.bu.voting;

import il.ac.afeka.electionsystem.bu.db.external.lists.BallotList;
import il.ac.afeka.electionsystem.bu.db.external.lists.PartyList;
import il.ac.afeka.electionsystem.bu.db.external.lists.VotesList;
import il.ac.afeka.electionsystem.bu.db.external.objects.Slip;
import il.ac.afeka.electionsystem.bu.electorslist.ElectorsList;
import il.ac.afeka.electionsystem.bu.electorslist.ElectorsListImpl;
import il.ac.afeka.electionsystem.bu.exceptions.AuthenticationException;
import il.ac.afeka.electionsystem.bu.exceptions.AuthorizationException;
import il.ac.afeka.electionsystem.bu.exceptions.PartyNotExistException;
import il.ac.afeka.electionsystem.bu.voteindicator.VoteIndicator;
import il.ac.afeka.electionsystem.bu.voteindicator.VoteIndicatorImpl;

public class VotingImpl implements Voting {
	private static Voting instance;
	
	private VotingImpl() {}
	public static Voting getInstance() {
		if (instance == null) {
			instance = new VotingImpl();
		}
		return instance;
	}

	@Override
	public void vote(long citizenId, long ballotId, long partyId)
			throws AuthenticationException, AuthorizationException, PartyNotExistException
	{
		ElectorsList eList          = ElectorsListImpl.getInstance();
		VoteIndicator voteIndicator = VoteIndicatorImpl.getInstance();
		PartyList partyList         = PartyList.getInstance();
		BallotList ballotList       = BallotList.getInstance();
		// Verify citizen
		eList.AuthenticateCitizen(citizenId);
		eList.AuthorizeCitizen(citizenId, ballotId);
		
		voteIndicator.validateParty(partyId);
		
		// Create new Slip
		Slip slip = new Slip(partyList.getParty(partyId), ballotList.getBallot(ballotId));
		// Proceed slip
		VotesList.getInstance().updateSlipList(slip);
		
		// Mark Voter
		voteIndicator.setVoted(citizenId);
	}

	@Override
	public VotesList getVotesList() {
		return VotesList.getInstance();
	}

}

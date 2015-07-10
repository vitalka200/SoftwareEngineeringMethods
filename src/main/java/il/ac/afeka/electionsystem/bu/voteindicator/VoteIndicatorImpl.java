package il.ac.afeka.electionsystem.bu.voteindicator;

import il.ac.afeka.electionsystem.bu.db.external.lists.CitizenList;
import il.ac.afeka.electionsystem.bu.db.external.lists.PartyList;
import il.ac.afeka.electionsystem.bu.db.external.lists.VotersList;
import il.ac.afeka.electionsystem.bu.db.external.objects.Citizen;
import il.ac.afeka.electionsystem.bu.db.external.objects.Voter;
import il.ac.afeka.electionsystem.bu.exceptions.PartyNotExistException;

public class VoteIndicatorImpl implements VoteIndicator{
	private static VoteIndicator instance;
	
	private VoteIndicatorImpl() {}
	public static VoteIndicator getInstance() {
		if (instance == null) {
			instance = new VoteIndicatorImpl();
		}
		return instance;
	}

	@Override
	public boolean isVoted(long voterId) {
		Voter voter = VotersList.getInstance().getVoter(voterId);
		return voter != null ? voter.getIsVoted() : false;
	}

	@Override
	public void setVoted(long voterId) {
		Citizen citizen = CitizenList.getInstance().getCitizen(voterId);
		Voter voter = new Voter(citizen);
		voter.setIsVoted(true);
		VotersList.getInstance().updateVoterList(voter);
	}
	@Override
	public void validateParty(long partyId) throws PartyNotExistException {
		if (PartyList.getInstance().getParty(partyId) == null) {
			throw new PartyNotExistException("No such party.");
		}
	}

}

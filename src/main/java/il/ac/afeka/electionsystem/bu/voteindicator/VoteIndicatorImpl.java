package il.ac.afeka.electionsystem.bu.voteindicator;

import il.ac.afeka.electionsystem.bu.db.external.lists.CitizenList;
import il.ac.afeka.electionsystem.bu.db.external.lists.VotersList;
import il.ac.afeka.electionsystem.bu.db.external.objects.Citizen;
import il.ac.afeka.electionsystem.bu.db.external.objects.Voter;

public class VoteIndicatorImpl implements VoteIndicator{

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

}

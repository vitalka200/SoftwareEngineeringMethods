package il.ac.afeka.electionsystem.bu.election;

import il.ac.afeka.electionsystem.bu.db.external.objects.Ballot;
import il.ac.afeka.electionsystem.bu.db.external.objects.Party;

import java.util.Map;

public interface Election {
	public Map<Party, Long> getVotesPerParty();
	public Map<Ballot, Long> getVotesPerBallot();
	public Map<Party, Map<Ballot, Long>>  getVotesPerPartyPerBallot();
}

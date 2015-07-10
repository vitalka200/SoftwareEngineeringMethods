package il.ac.afeka.electionsystem.bu.election;

import il.ac.afeka.electionsystem.bu.db.external.lists.BallotList;
import il.ac.afeka.electionsystem.bu.db.external.lists.PartyList;
import il.ac.afeka.electionsystem.bu.db.external.lists.VotesList;
import il.ac.afeka.electionsystem.bu.db.external.objects.Ballot;
import il.ac.afeka.electionsystem.bu.db.external.objects.Party;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ElectionImpl implements Election{
	private static Election instance;
	
	
	private ElectionImpl() {
		
	}
	
	public static Election getInstance() {
		if (instance == null) {
			instance = new ElectionImpl();
		}
		return instance;
	}

	@Override
	public Map<Party, Long> getVotesPerParty() {
		Map<Party, Long> map = new HashMap<>();
		Collection<Party> pList = PartyList.getInstance().getPartyList();
		for (Party p : pList) {
			List<Ballot> votes = VotesList.getInstance().getVotesForPartyByBallot(p);
			if (votes == null) {
				map.put(p, (long) 0);
			} else {
				map.put(p, (long) votes.size());
			}
		}
		return map;
	}

	@Override
	public Map<Ballot, Long> getVotesPerBallot() {
		Map<Ballot, Long> map = new HashMap<>();
		Collection<Ballot> bList = BallotList.getInstance().getBallotList();
		for (Ballot b : bList) {
			List<Party> votes = VotesList.getInstance().getVotersForBallotByParty(b);
			if (votes == null) {
				map.put(b, (long) 0);
			} else {
				map.put(b, (long) votes.size());
			}
		}
		return map;
	}

	@Override
	public Map<Party, Map<Ballot, Long>> getVotesPerPartyPerBallot() {
		Map<Party, Map<Ballot, Long>> map = new HashMap<>();
		// preparing map
		for (Party p : PartyList.getInstance().getPartyList()) {
			map.put(p, new HashMap<Ballot, Long>());
		}
		
		Collection<Ballot> bList = BallotList.getInstance().getBallotList();
		for (Ballot b : bList) {
			List<Party> votes = VotesList.getInstance().getVotersForBallotByParty(b);
			// We don't need to count check ballot that has no votes
			if (votes != null) {
				Map<Party, Long> pVotes = new HashMap<>();
				// Calculate votes
				for (Party p : votes) {
					if (!pVotes.containsKey(p))
						pVotes.put(p, (long) 1);
					else
						pVotes.put(p, pVotes.get(p)+1);
				}
				// Store Votes
				for (Entry<Party, Long> p : pVotes.entrySet()) {
					Map<Ballot, Long> ballotVotes = map.get(p);
					if (ballotVotes.get(b) == null) {
						ballotVotes.put(b, p.getValue());
					}
					ballotVotes.put(b, ballotVotes.get(b) + p.getValue());
				}
			}
		}
		return map;
	}

}

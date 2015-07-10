package il.ac.afeka.electionsystem.bu.db.external.lists;

import il.ac.afeka.electionsystem.bu.db.external.objects.Ballot;
import il.ac.afeka.electionsystem.bu.db.external.objects.Party;
import il.ac.afeka.electionsystem.bu.db.external.objects.Slip;
import il.ac.afeka.electionsystem.bu.db.internal.DB;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SlipList {

	private static Map<Party, List<Ballot>> partyToBallot;
	private static Map<Ballot, List<Party>> ballotToParty;
	private static Collection<Slip> slipList;
	private static SlipList instance;
	
	public static SlipList getInstance() {
		if (instance == null) {
			instance = new SlipList();
		}
		return instance;
	}
	
	private SlipList() {
		slipList = DB.getInstance().getSlips();
		// For the ease of use we going to create 2 maps
		// party->Ballot (We'll be able to get how may votes each party has in specific ballot)
		// ballot->Party (Well be able to know how many voters voted for specific party in given ballot)
		partyToBallot = new HashMap<>();
		ballotToParty = new HashMap<>();
		for (Slip element: slipList) {
			addSlip(element);
		}
	}
	/**
	 * party->Ballot (We'll be able to get how may votes each party has in specific ballot)
	 * 
	 * @return Votes list for given party
	 */
	public List<Ballot> getVotesForPartyByBallot(Party p) {
		return partyToBallot.get(p);
	}
	/** ballot->Party (Well be able to know how many voters voted for specific party in given ballot)
	 * @return Votes list for given ballot
	 */
	public List<Party> getVotersForBallotByParty(Ballot b) {
		return ballotToParty.get(b);
	}
	
	public void updateSlipList(Slip s) {
		DB.getInstance().saveSlips(slipList);
		addSlip(s);
	}
	
	private void addSlip(Slip s) {
		if (partyToBallot.containsKey(s.getParty())) {
			partyToBallot.get(s.getParty()).add(s.getBallot());
		} else {
			List<Ballot> l = new LinkedList<>();
			l.add(s.getBallot());
			partyToBallot.put(s.getParty(), l);
		}
		
		if (ballotToParty.containsKey(s.getBallot())) {
			ballotToParty.get(s.getBallot()).add(s.getParty());
		} else {
			List<Party> l = new LinkedList<>();
			l.add(s.getParty());
			ballotToParty.put(s.getBallot(), l);
		}
	}
}


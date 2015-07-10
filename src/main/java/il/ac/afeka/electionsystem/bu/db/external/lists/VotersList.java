package il.ac.afeka.electionsystem.bu.db.external.lists;

import il.ac.afeka.electionsystem.bu.db.external.objects.Voter;
import il.ac.afeka.electionsystem.bu.db.internal.DB;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VotersList {

	private static Map<Long, Voter> votersList;
	private static VotersList instance;
	
	public static VotersList getInstance() {
		if (instance == null) {
			instance = new VotersList();
		}
		return instance;
	}
	
	private VotersList() {
		Collection<Voter> list = DB.getInstance().getVoters();
		votersList = new HashMap<>();
		for (Voter element: list) {
			votersList.put(element.getId(), element);
		}
	}
	
	public Voter getVoter(long id) {
		return votersList.get(id);
	}
	
	public void updateVoterList(Voter v) {
		if (! votersList.containsKey(v.getId())) {
			votersList.put(v.getId(), v);
			DB.getInstance().saveVoters(votersList.values());
		}
	}
}


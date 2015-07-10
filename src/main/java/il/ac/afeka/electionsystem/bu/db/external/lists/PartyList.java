package il.ac.afeka.electionsystem.bu.db.external.lists;

import il.ac.afeka.electionsystem.bu.db.external.objects.Party;
import il.ac.afeka.electionsystem.bu.db.internal.DB;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PartyList {

	private static Map<Long,Party> partyList;
	private static PartyList instance;
	
	public static PartyList getInstance() {
		if (instance == null) {
			instance = new PartyList();
		}
		return instance;
	}
	
	private PartyList() {
		Collection<Party> list = DB.getInstance().getParties();
		partyList = new HashMap<>();
		for (Party c: list) {
			partyList.put(c.getId(), c);
		}
	}
	
	public Party getParty(long id) {
		return partyList.get(id);
	}
	
	public void updatePartyList(Party p) {
		if (! partyList.containsKey(p.getId())) {
			partyList.put(p.getId(), p);
			DB.getInstance().saveParties(partyList.values());
		}
	}
}


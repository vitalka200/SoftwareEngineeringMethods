package il.ac.afeka.electionsystem.bu.electorslist;

import il.ac.afeka.electionsystem.bu.db.DB;
import il.ac.afeka.electionsystem.bu.db.objects.Citizen;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CitizenList {

	private static Map<Long,Citizen> citizenList;
	private static CitizenList instance;
	
	public static CitizenList getInstance() {
		if (instance == null) {
			instance = new CitizenList();
		}
		return instance;
	}
	
	private CitizenList() {
		Collection<Citizen> cList = DB.getInstance().getCitizens();
		citizenList = new HashMap<>();
		for (Citizen c: cList) {
			citizenList.put(c.getId(), c);
		}
	}
	
	public Citizen getCitizen(long id) {
		return citizenList.get(id);
	}
	
	public void addCitizen(Citizen c) {
		if (! citizenList.containsKey(c.getId())) {
			citizenList.put(c.getId(), c);
			DB.getInstance().saveCitizens(citizenList.values());
		}
	}
}

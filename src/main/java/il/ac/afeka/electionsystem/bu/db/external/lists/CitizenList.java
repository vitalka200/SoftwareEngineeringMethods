package il.ac.afeka.electionsystem.bu.db.external.lists;

import il.ac.afeka.electionsystem.bu.db.external.objects.Citizen;
import il.ac.afeka.electionsystem.bu.db.internal.DB;

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
		Collection<Citizen> list = DB.getInstance().getCitizens();
		citizenList = new HashMap<>();
		for (Citizen element: list) {
			citizenList.put(element.getId(), element);
		}
	}
	
	public Citizen getCitizen(long id) {
		return citizenList.get(id);
	}
	
	public void updateCitizenList(Citizen c) {
		if (! citizenList.containsKey(c.getId())) {
			citizenList.put(c.getId(), c);
			DB.getInstance().saveCitizens(citizenList.values());
		}
	}
}

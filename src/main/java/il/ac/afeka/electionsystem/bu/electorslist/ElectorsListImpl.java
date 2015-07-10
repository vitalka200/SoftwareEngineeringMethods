package il.ac.afeka.electionsystem.bu.electorslist;

import il.ac.afeka.electionsystem.bu.db.external.lists.CitizenList;


public class ElectorsListImpl implements ElectorsList{

	private CitizenList citizenList;
	private static ElectorsList instance;
	
	
	private ElectorsListImpl() {
		this.citizenList = CitizenList.getInstance();
	}
	
	public static ElectorsList getInstance() {
		if (instance == null) {
			instance = new ElectorsListImpl();
		}
		return instance;
	}

	public boolean AuthCitizen(long citizenId) {
		boolean isAuthenticated = false;
		boolean isAuthorized = false;

		//TODO: add authentication and authorization logic
		
		return isAuthenticated && isAuthorized;
	}
	
	
}

package il.ac.afeka.electionsystem.bu.electorslist;

import il.ac.afeka.electionsystem.bu.db.objects.Citizen;

public class ElectorsListImpl implements ElectorsList{

	private CitizenList citizenList;
	
	public ElectorsListImpl(CitizenList citizenList) {
		this.citizenList = citizenList;
	}
	
	public ElectorsListImpl() {
		this.citizenList = CitizenList.getInstance();
	}

	public boolean AuthCitizen(Citizen citizen) {
		boolean isAuthenticated = false;
		boolean isAuthorized = false;

		//TODO: add authentication and authorization logic
		
		return isAuthenticated && isAuthorized;
	}
}

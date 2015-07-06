package il.ac.afeka.electionsystem.bu.electorslist;

import java.util.ArrayList;

public class ElectorsListImpl implements ElectorsList{

	private CitizenList<Citizen> citizenList;
	
	public ElectorsListImpl(CitizenList<Citizen> citizenList) {
		this.citizenList = citizenList;
	}
	
	public ElectorsListImpl() {
		this.citizenList = new CitizenList<Citizen>();
	}

	public boolean AuthCitizen() {
		boolean isAuthenticated = false;
		boolean isAuthorized = false;

		//TODO: add authentication and authorization logic
		
		return isAuthenticated && isAuthorized;
	}
	
	protected class Citizen {
		private long id;
		private String fName;
		private String lName;

		public Citizen(long id, String firstName, String lastName) {
			setId(id);
			setFirstName(firstName);
			setLastName(lastName);
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getFirstName() {
			return fName;
		}
		public void setFirstName(String fName) {
			this.fName = fName;
		}
		public String getLastName() {
			return lName;
		}
		public void setLastName(String lName) {
			this.lName = lName;
		}
		
	}
	
	protected class CitizenList<Citizen> extends ArrayList<Citizen>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 8898788437896118032L;
		
	}
	
	protected class Ballot {
		private long id;
		
		
	}
}

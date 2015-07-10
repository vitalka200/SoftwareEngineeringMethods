package il.ac.afeka.electionsystem.bu.electorslist;

import il.ac.afeka.electionsystem.bu.db.external.lists.CitizenList;
import il.ac.afeka.electionsystem.bu.db.external.objects.Citizen;


public class ElectorsListImpl implements ElectorsList{

	private CitizenList citizenList;
	private static ElectorsList instance;
	private CitizenPersonaValidator citizenPersonaValidator = new CitizenPersonaValidator();
	private CitizenBallotValidator citizenBallotValidator = new CitizenBallotValidator();
	
	private ElectorsListImpl() {
		this.citizenList = CitizenList.getInstance();
	}
	
	public static ElectorsList getInstance() {
		if (instance == null) {
			instance = new ElectorsListImpl();
		}
		return instance;
	}

	
	public boolean AuthenticateCitizen(long citizenId) {
		Citizen citizen = citizenList.getCitizen(citizenId);
		return citizenPersonaValidator.validate(citizen);
	}
	
	public boolean AuthorizeCitizen(long citizenId, long ballotId) {
		Citizen citizen = citizenList.getCitizen(citizenId);
		return citizenBallotValidator.validate(citizen, ballotId);
	}
	
	protected class CitizenPersonaValidator {
		
		// In the future here can be additional validations
		public boolean validate(Citizen c) {
			return c.getAge() > 18;
		}
	}
	
	protected class CitizenBallotValidator {
		// In the future here can be added additional checks
		public boolean validate(Citizen c, long ballotId) {
			return c.getBallotId() == ballotId;
		}
	}
}

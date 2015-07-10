package il.ac.afeka.electionsystem.bu.electorslist;

import il.ac.afeka.electionsystem.bu.db.external.lists.CitizenList;
import il.ac.afeka.electionsystem.bu.db.external.objects.Citizen;
import il.ac.afeka.electionsystem.bu.exceptions.AuthenticationException;
import il.ac.afeka.electionsystem.bu.exceptions.AuthorizationException;
import il.ac.afeka.electionsystem.bu.voteindicator.VoteIndicatorImpl;


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

	
	public void AuthenticateCitizen(long citizenId) throws AuthenticationException{
		Citizen citizen = citizenList.getCitizen(citizenId);
		if (citizen == null)
			throw new AuthenticationException("Citizen's ID not found or not valid.");
		
		citizenPersonaValidator.validate(citizen);
	}
	
	public void AuthorizeCitizen(long citizenId, long ballotId) throws AuthorizationException {
		Citizen citizen = citizenList.getCitizen(citizenId);
		citizenBallotValidator.validate(citizen, ballotId);
	}
	
	protected class CitizenPersonaValidator {
		
		// In the future here can be additional validations
		public void validate(Citizen c) throws AuthenticationException {
			if (c.getAge() < 18)
				throw new AuthenticationException("Citizen to young to vote.");
		}
	}
	
	protected class CitizenBallotValidator {
		// In the future here can be added additional checks
		public void validate(Citizen c, long ballotId) throws AuthorizationException {
			if (c.getBallotId() != ballotId)
				throw new AuthorizationException("Citizen not belongs to the following ballot.");
			
			if (VoteIndicatorImpl.getInstance().isVoted(c.getId()))
				throw new AuthorizationException("Citizen already voted.");
		}
	}
}

package il.ac.afeka.electionsystem.bu.db.internal;

import il.ac.afeka.electionsystem.bu.db.external.objects.Ballot;
import il.ac.afeka.electionsystem.bu.db.external.objects.Citizen;
import il.ac.afeka.electionsystem.bu.db.external.objects.Party;
import il.ac.afeka.electionsystem.bu.db.external.objects.Slip;
import il.ac.afeka.electionsystem.bu.db.external.objects.Voter;

import java.util.Collection;

public class DB {
	
	private static DB instance;
	private String citizensDB = "citizens.db";
	private String votersDB = "voters.db";
	private String partiesDB = "parties.db";
	private String ballotsDB = "ballots.db";
	private String slipsDB = "slips.db";
	
	private DB() {
		
	}
	
	public static DB getInstance() {
		if (instance == null) {
			instance = new DB();
		}
		return instance;
	}
	
	public void saveCitizens(Collection<Citizen> citizens) {
		saveObjectCollection(citizens, citizensDB);
	}
	
	public Collection<Citizen> getCitizens() {
		return getObjectCollection(citizensDB);
	}
	
	public void saveVoters(Collection<Voter> voters) {
		saveObjectCollection(voters, votersDB);
	}
	
	
	public Collection<Voter> getVoters() {
		return getObjectCollection(votersDB);
	}
	
	public void saveParties(Collection<Party> parties) {
		saveObjectCollection(parties, partiesDB);
	}
	
	
	public Collection<Party> getParties() {
		return getObjectCollection(partiesDB);
	}
	
	public void saveBallots(Collection<Ballot> ballots) {
		saveObjectCollection(ballots, ballotsDB);
	}
	
	
	public Collection<Ballot> getBallots() {
		return getObjectCollection(ballotsDB);
	}
	
	public void saveSlips(Collection<Slip> slips) {
		saveObjectCollection(slips, slipsDB);
	}
	
	
	public Collection<Slip> getSlips() {
		return getObjectCollection(slipsDB);
	}
	
	private <T> void saveObjectCollection(Collection<T> object, String filename) {
		
	}
	
	private <T> Collection<T> getObjectCollection(String fileName) {
		return null;
	}
}

package il.ac.afeka.electionsystem.bu.db.internal;

import il.ac.afeka.electionsystem.bu.db.external.objects.Ballot;
import il.ac.afeka.electionsystem.bu.db.external.objects.Citizen;
import il.ac.afeka.electionsystem.bu.db.external.objects.Party;
import il.ac.afeka.electionsystem.bu.db.external.objects.Slip;
import il.ac.afeka.electionsystem.bu.db.external.objects.Voter;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		return getObjectCollection(citizensDB, Citizen.class);
	}
	
	public void saveVoters(Collection<Voter> voters) {
		saveObjectCollection(voters, votersDB);
	}
	
	
	public Collection<Voter> getVoters() {
		return getObjectCollection(votersDB, Voter.class);
	}
	
	public void saveParties(Collection<Party> parties) {
		saveObjectCollection(parties, partiesDB);
	}
	
	
	public Collection<Party> getParties() {
		return getObjectCollection(partiesDB, Party.class);
	}
	
	public void saveBallots(Collection<Ballot> ballots) {
		saveObjectCollection(ballots, ballotsDB);
	}
	
	
	public Collection<Ballot> getBallots() {
		return getObjectCollection(ballotsDB, Ballot.class);
	}
	
	public void saveSlips(Collection<Slip> slips) {
		saveObjectCollection(slips, slipsDB);
	}
	
	
	public Collection<Slip> getSlips() {
		return getObjectCollection(slipsDB, Slip.class);
	}
	
	private <T> void saveObjectCollection(Collection<T> objects, String filename) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			File new_file = new File(filename + ".new");
			File old_file = new File(filename);
			mapper.writeValue(new_file, objects);
			old_file.delete();
			new_file.renameTo(old_file);
		} catch (IOException e) {
			System.out.println("Can't save data to disk. Exiting... FileName: " + filename);
			System.exit(1);
		}
	}
	
	private <T> Collection<T> getObjectCollection(String filename, Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JavaType javaType = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
			return mapper.readValue(new File(filename), javaType);
		} catch (IOException e) {
			System.out.println("Can't get data from disk. Exiting... FileName: " + filename);
			System.out.println(e.getMessage());
			System.exit(1);
			return null;
		}
	}
}

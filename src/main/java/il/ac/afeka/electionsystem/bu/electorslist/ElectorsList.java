package il.ac.afeka.electionsystem.bu.electorslist;


public interface ElectorsList {
	public boolean AuthenticateCitizen(long citizenId);
	public boolean AuthorizeCitizen(long citizenId, long ballotId);
}

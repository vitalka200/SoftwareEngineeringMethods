package il.ac.afeka.electionsystem.bu.db.external.objects;

public class Voter extends Citizen {
	private boolean isVoted = false;
	private Ballot ballot;
	
	public Voter() {}
	public Voter(long id, String firstName, String lastName,
			Address address, double age, long ballotId) {
		super(id, firstName, lastName, address, age, ballotId);
	}
	
	public Voter(Citizen c) {
		super(c.getId(), c.getFirstName(), c.getFirstName(),
				c.getAddress(), c.getAge(), c.getBallotId());
	}
	
	public void setIsVoted(boolean isVoted) {
		this.isVoted = isVoted;
	}
	
	public boolean getIsVoted() {
		return isVoted;
	}
	
	public void setBallot(Ballot ballot) {
		this.ballot = ballot;
	}
	public Ballot getBallot() {
		return this.ballot;
	} 
	@Override
	public String toString() {
		return "Voter [" + super.toString() + ", isVoted=" + isVoted + "]";
	}
	
	
	
}

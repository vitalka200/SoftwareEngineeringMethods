package il.ac.afeka.electionsystem.bu.db.external.objects;

public class Slip {
	private Party party;
	private Ballot ballot;
	
	public Slip(Party p, Ballot b) {
		this.party = p;
		this.ballot = b;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Ballot getBallot() {
		return ballot;
	}

	public void setBallot(Ballot ballot) {
		this.ballot = ballot;
	}

	@Override
	public String toString() {
		return "Slip [party=" + party + ", ballot=" + ballot + "]";
	}
	
	
}

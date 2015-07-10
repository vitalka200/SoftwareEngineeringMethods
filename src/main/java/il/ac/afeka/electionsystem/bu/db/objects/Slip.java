package il.ac.afeka.electionsystem.bu.db.objects;

public class Slip {
	private Party party;
	private Ballot ballot;
	
	public Slip(Party p, Ballot b) {
		this.party = p;
		this.ballot = b;
	}
}

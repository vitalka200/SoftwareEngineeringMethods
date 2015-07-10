package il.ac.afeka.electionsystem.bu.db.objects;

public class Ballot {
	private long id;
	private String name;
	private Address address;
	
	public Ballot(long id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
}

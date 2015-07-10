package il.ac.afeka.electionsystem.bu.db.external.objects;

public class Citizen {
	private long id;
	private String fName;
	private String lName;
	private Address address;

	public Citizen() {}
	public Citizen(long id, String firstName, String lastName, Address address) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
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
	
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getAddress() {
		return this.address;
	}
	@Override
	public String toString() {
		return "Citizen [id=" + id + ", fName=" + fName + ", lName=" + lName
				+ "]";
	}
	
	
	
	
}

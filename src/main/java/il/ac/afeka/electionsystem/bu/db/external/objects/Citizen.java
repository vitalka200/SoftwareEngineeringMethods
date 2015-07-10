package il.ac.afeka.electionsystem.bu.db.external.objects;

public class Citizen {
	private long id;
	private long ballotId;
	private double age;
	private String fName;
	private String lName;
	private Address address;

	public Citizen() {}
	public Citizen(long id, String firstName, String lastName,
			Address address, double age, long ballotId) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setAge(age);
		setBallotId(ballotId);
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
	public void setAge(double age) {
		this.age = age;
	}
	public double getAge() {
		return age;
	}
	public void setBallotId(long ballotId) {
		this.ballotId = ballotId;
	}
	public long getBallotId() {
		return ballotId;
	}
	@Override
	public String toString() {
		return "Citizen [id=" + id + ", ballotId=" + ballotId + ", age=" + age
				+ ", fName=" + fName + ", lName=" + lName + ", address="
				+ address + "]";
	}
}

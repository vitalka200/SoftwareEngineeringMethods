package il.ac.afeka.electionsystem.bu.db.objects;

public class Address {
	private int houseNum;
	private String street;
	private String town;
	
	public Address(String town, String street, int houseNum) {
		this.houseNum = houseNum;
		this.street = street;
		this.town = town;
	}
	
	
}

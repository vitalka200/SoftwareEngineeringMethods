package il.ac.afeka.electionsystem.bu.db.external.objects;

public class Address {
	private int houseNum;
	private String street;
	private String town;
	
	public Address(String town, String street, int houseNum) {
		this.houseNum = houseNum;
		this.street = street;
		this.town = town;
	}

	public int getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "Address [houseNum=" + houseNum + ", street=" + street
				+ ", town=" + town + "]";
	}
	
	
}

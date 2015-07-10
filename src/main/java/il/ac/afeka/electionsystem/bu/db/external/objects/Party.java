package il.ac.afeka.electionsystem.bu.db.external.objects;

public class Party {
	private long id;
	private String name;
	
	public Party() {}
	public Party(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Party [id=" + id + ", name=" + name + "]";
	}
	
}

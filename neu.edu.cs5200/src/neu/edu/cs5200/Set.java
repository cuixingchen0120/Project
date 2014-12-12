package neu.edu.cs5200;



import java.sql.Date;

public class Set {
	public String id;
	public String name;
	public int total;
	public Date releaseAt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getReleaseAt() {
		return releaseAt;
	}
	public void setReleaseAt(Date releaseAt) {
		this.releaseAt = releaseAt;
	}
	public Set() {
		super();
	}
	public Set(String id, String name, int total, Date releaseAt) {
		super();
		this.id = id;
		this.name = name;
		this.total = total;
		this.releaseAt = releaseAt;
	}

}


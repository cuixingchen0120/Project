package neu.edu.cs5200;

import java.io.Serializable;
import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rate
 *
 */
@Entity

public class Rate implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int rateid;
	private String username;
	private String cardname;
	private double rate;
	private Timestamp daterated;
	private static final long serialVersionUID = 1L;

	public Rate() {
		super();
	}   
	public int getRateid() {
		return this.rateid;
	}

	public void setRateid(int rateid) {
		this.rateid = rateid;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getCardname() {
		return this.cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}   
	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}   
	public Timestamp getDaterated() {
		return this.daterated;
	}

	public void setDaterated(Timestamp daterated) {
		this.daterated = daterated;
	}
   
	public Rate(String username, String cardname, Double rate,
			Timestamp daterated) {
		super();
		this.username = username;
		this.cardname = cardname;
		this.rate = rate;
		this.daterated = daterated;
	}

	public Rate(String cardname) {
		super();
		this.cardname = cardname;
	}

	
}

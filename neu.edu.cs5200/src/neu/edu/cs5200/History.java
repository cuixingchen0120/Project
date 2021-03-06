package neu.edu.cs5200;



import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the history database table.
 * 
 */
@Entity
@NamedQuery(name="History.findAll", query="SELECT h FROM History h")
public class History implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int historyid;

	private String cardname;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datesearched;

	private String username;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public History() {
	}

	public int getHistoryid() {
		return this.historyid;
	}

	public void setHistoryid(int historyid) {
		this.historyid = historyid;
	}

	public String getCardname() {
		return this.cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public Date getDatesearched() {
		return this.datesearched;
	}

	public void setDatesearched(Date datesearched) {
		this.datesearched = datesearched;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public History(String cardname, Date datesearched, String username,
			User user) {
		super();
		this.cardname = cardname;
		this.datesearched = datesearched;
		this.username = username;
		this.user = user;
	}
	
	

}
package neu.edu.cs5200;



import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int commentid;

	private String cardname;

	@Column(name="`COMMENT`")
	private String comment;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String username;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	public Comment() {
	}

	public int getCommentid() {
		return this.commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getCardname() {
		return this.cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Comment(String cardname, String comment, Date date, String username,
			User user) {
		super();
		this.cardname = cardname;
		this.comment = comment;
		this.date = date;
		this.username = username;
		this.user = user;
	}

}

package neu.edu.cs5200;

import java.util.Date;
import javax.persistence.*;

@Entity

//gai persistent!!
public class ShoppingCartHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "UserId", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="CardID", referencedColumnName = "id")
	private Card card;
	
	private int num;
	
	public enum Process {ORDER, DELIVERY}
	private Process process;
	
	@Temporal(TemporalType.DATE)
	public Date date;

	public ShoppingCartHistory() {}
	
	public ShoppingCartHistory(int id, User user, Card card, int num, Process process, Date date) {
		this.id = id;
		this.user = user;
		this.card = card;
		this.num = num;
		this.process = process;
		this.date = date;
	}
	
	public ShoppingCartHistory(User user, Card card, int num, Process process, Date date) {
		this.user = user;
		this.card = card;
		this.num = num;
		this.process = process;
		this.date = date;
	}
	
	public ShoppingCartHistory(User user, Card card, int num, Process process) {
		this.user = user;
		this.card = card;
		this.num = num;
		this.process = process;
		this.date = new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public Process gerProcess() {
		return process;
	}
	public void setProcess(Process process) {
		this.process = process;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

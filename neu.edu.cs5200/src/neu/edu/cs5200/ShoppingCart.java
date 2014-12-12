package neu.edu.cs5200;

import javax.persistence.*;

@Entity

public class ShoppingCart{
	
	@EmbeddedId
	private ShoppingCartPK id;//userId + cardId = primary key  //composite two foreign keys as the primary key
	
	@ManyToOne
	@MapsId("userId")//shoppingcartPK.java
	@JoinColumn(name = "UserId", referencedColumnName = "id")//Pk.java userId
	private User user;
	
	@ManyToOne
	@MapsId("cardId")
	@JoinColumn(name="CardID", referencedColumnName = "id")
	private Card card;
	
	private int orderNum = 0;//current order num
	private int historyNum = 0;//oder but not delivery is not count in history
	
	public ShoppingCart() {
		super();
	}	

	public ShoppingCart(User user, Card card) {
		super();
		this.id = new ShoppingCartPK(user.getId(), card.getId());
		this.user = user;
		this.card = card;
	}
	
	public ShoppingCart(User user, Card card, int orderNum) {
		super();
		this.id = new ShoppingCartPK(user.getId(), card.getId());
		this.user = user;
		this.card = card;
		this.orderNum = orderNum;
	}
	
	public ShoppingCart(User user, Card card, int orderNum, int historyNum) {
		super();
		this.id = new ShoppingCartPK(user.getId(), card.getId());
		this.user = user;
		this.card = card;
		this.orderNum = orderNum;
		this.historyNum = historyNum;
	}
	
	public String toString() {
		return "User " + user.getId() + " ordered " + orderNum + " of card " + card.getId();
	}

	public ShoppingCartPK getId() {
		return id;
	}
	
	public void setId(ShoppingCartPK id) {
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
	
	public int getOrderNum() {
		return orderNum;
	}
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getHistoryNum() {
		return historyNum;
	}
	
	public void setHistoryNum(int historyNum) {
		this.historyNum = historyNum;
	}
}

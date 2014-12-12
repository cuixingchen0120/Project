package neu.edu.cs5200;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
//gai!!
public class ShoppingCartPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private int cardId;

	
	public ShoppingCartPK() {}
	
	public ShoppingCartPK(int userId, int cardId) {
		this.userId = userId;
		this.cardId = cardId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getCardId() {
		return cardId;
	}
	
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		result = prime * result + cardId;
		return result;
	}//override
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ShoppingCartPK other = (ShoppingCartPK) obj;
		return userId == other.userId && cardId == other.cardId;
	}
}

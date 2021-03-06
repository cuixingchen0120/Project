package neu.edu.cs5200;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AverageRate
 *
 */
@Entity

public class AverageRate implements Serializable {
	@Id
    public String cardname;
	public String averagerate;
	
    
	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public String getAveragerate() {
		return averagerate;
	}

	public void setAveragerate(String averagerate) {
		this.averagerate = averagerate;
	}

	public AverageRate(String cardname, String averagerate) {
		super();
		this.cardname = cardname;
		this.averagerate = averagerate;
	}

	private static final long serialVersionUID = 1L;

	public AverageRate() {
		super();
	}

	
   
}


package neu.edu.cs5200;



import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the card database table.
 * 
 */
@Entity
@NamedQuery(name="Card.findAll", query="SELECT c FROM Card c")
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int id;

	public String artist;

	public int cardid;
	
	public String cardsetid;
	
	public String cardsetname;

	public String colors;

	public String convertedmanacost;

	public String description;

	public String flavor;

	public int loyalty;

	public String manacost;

	public String name;

	public int power;

	public byte promo;

	public String rarity;

	public int relatedcardid;

	@Temporal(TemporalType.DATE)
	public Date releasedat;

	public String searchByUser;

	public String searchname;

	public int setnumber;

	public String subtype;

	public byte token;

	public int toughness;
	
	@ManyToMany(mappedBy = "favourCards")
	private Set<User> favourUsers = new HashSet<User>();

	public String type;
	


	public Card() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

	public int getCardid() {
		return cardid;
	}

	public void setCardid(int cardid) {
		this.cardid = cardid;
	}

	public String getArtist() {
		return this.artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getCardsetid() {
		return this.cardsetid;
	}

	public void setCardsetid(String cardsetid) {
		this.cardsetid = cardsetid;
	}

	public String getCardsetname() {
		return this.cardsetname;
	}

	public void setCardsetname(String cardsetname) {
		this.cardsetname = cardsetname;
	}

	public String getColors() {
		return this.colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public String getConvertedmanacost() {
		return this.convertedmanacost;
	}

	public void setConvertedmanacost(String convertedmanacost) {
		this.convertedmanacost = convertedmanacost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFlavor() {
		return this.flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getLoyalty() {
		return this.loyalty;
	}

	public void setLoyalty(int loyalty) {
		this.loyalty = loyalty;
	}

	public String getManacost() {
		return this.manacost;
	}

	public void setManacost(String manacost) {
		this.manacost = manacost;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return this.power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public byte getPromo() {
		return this.promo;
	}

	public void setPromo(byte promo) {
		this.promo = promo;
	}

	public String getRarity() {
		return this.rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public int getRelatedcardid() {
		return this.relatedcardid;
	}

	public void setRelatedcardid(int relatedcardid) {
		this.relatedcardid = relatedcardid;
	}

	public Date getReleasedat() {
		return this.releasedat;
	}

	public void setReleasedat(Date releasedat) {
		this.releasedat = releasedat;
	}

	public String getSearchByUser() {
		return this.searchByUser;
	}

	public void setSearchByUser(String searchByUser) {
		this.searchByUser = searchByUser;
	}

	public String getSearchname() {
		return this.searchname;
	}

	public void setSearchname(String searchname) {
		this.searchname = searchname;
	}

	public int getSetnumber() {
		return this.setnumber;
	}

	public void setSetnumber(int setnumber) {
		this.setnumber = setnumber;
	}

	public String getSubtype() {
		return this.subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public byte getToken() {
		return this.token;
	}

	public void setToken(byte token) {
		this.token = token;
	}

	public int getToughness() {
		return this.toughness;
	}

	public void setToughness(int toughness) {
		this.toughness = toughness;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<User> getFavourUsers() {
		return favourUsers;
	}
	
	public void setFavourUsers(Set<User> favourUsers) {
		this.favourUsers = favourUsers;
	}







	public Card(int cardid, int relatedcardid, int setNumber, String name,
			String searchName, String description, String flavor,
			String colors, String manacost, String convertedManaCost,
			String cardSetName, String type, String subType, int power,
			String searchByUser) {
		super();
		this.cardid = cardid;
		this.relatedcardid = relatedcardid;
		this.setnumber = setNumber;
		this.name = name;
		this.searchname = searchName;
		this.description = description;
		this.flavor = flavor;
		this.colors = colors;
		this.manacost = manacost;
		this.convertedmanacost = convertedManaCost;
		this.cardsetname = cardSetName;
		this.type = type;
		this.subtype = subType;
		this.power = power;
		this.searchByUser = searchByUser;
	}
	
	public Card(int id, int setNumber, String name, String manacost,
			String convertedManaCost, String cardSetName, String type,
			String subType, int power, int toughness, int loyalty,
			String rarity, String flavor, String description) {
		super();
		this.id = id;
		this.setnumber = setNumber;
		this.name = name;
		this.manacost = manacost;
		this.convertedmanacost = convertedManaCost;
		this.cardsetname = cardSetName;
		this.type = type;
		this.subtype = subType;
		this.power = power;
		this.toughness = toughness;
		this.loyalty = loyalty;
		this.rarity = rarity;
		this.flavor = flavor;
		this.description = description;
	}

	public Card(int setNumber, String name, String type, String subType,
			int power, int toughness, String manacost, String rarity,
			String cardSetName) {
		super();
		this.setnumber = setNumber;
		this.name = name;
		this.type = type;
		this.subtype = subType;
		this.power = power;
		this.toughness = toughness;
		this.manacost = manacost;
		this.rarity = rarity;
		this.cardsetname = cardSetName;
	}
	
	public Card(int id, int relatedCardId, int setNumber, String name,
			String colors) {
		super();
		this.id = id;
		this.relatedcardid = relatedCardId;
		this.setnumber = setNumber;
		this.name = name;
		this.colors = colors;
	}

	
}




	













	

   


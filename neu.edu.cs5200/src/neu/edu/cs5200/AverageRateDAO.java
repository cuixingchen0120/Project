package neu.edu.cs5200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AverageRateDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("neu.edu.cs5200");
	EntityManager em = null;
	
	private String urlApi = "http://api.mtgdb.info/cards/[name]";
	public AverageRateDAO(){
		em = factory.createEntityManager();
	}	
	
    public void createAverageRate(AverageRate averagerate){
    	em.getTransaction().begin();
    	em.persist(averagerate);
    	em.getTransaction().commit();
    	em.close();
    }
    
	public void deleteAverageRate(){
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM AverageRate a");
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		}

    public void CalculateRate(){

    	em.getTransaction().begin();
    	Query Q1 = em.createQuery("SELECT r.cardname FROM Rate r GROUP BY r.cardname");
    	List result1 = Q1.getResultList();
    	int n = 0;
    	int totalnum = result1.size();	
    	
		while(n < totalnum){
			
		Query Q2 = em.createQuery("SELECT SUM(r.rate)/COUNT(r.cardname) FROM Rate r Where r.cardname =:cardname GROUP BY r.cardname ");
		Q2.setParameter("cardname", result1.get(n));	
		Double scale = (Double)Q2.getSingleResult();  
		DecimalFormat fnum = new DecimalFormat("#.0"); 
		String arate = fnum.format(scale); 
		String cardname = (String)result1.get(n);
		
		AverageRateDAO dao = new AverageRateDAO(); 
        AverageRate app1 = new AverageRate (cardname,arate);
		dao.createAverageRate(app1);
			
    	n=n+1; 
    	}
    	
        em.getTransaction().commit();
	    em.close();
	    
    }
    
	public List<AverageRate> Output(){
		em.getTransaction().begin();
		List<AverageRate> averagerates = new ArrayList<AverageRate>();
		AverageRate averagerate = new AverageRate();
    	Query Q1 = em.createQuery("SELECT a.cardname FROM AverageRate a ORDER BY a.averagerate DESC");
    	Query Q2 = em.createQuery("SELECT a.averagerate FROM AverageRate a ORDER BY a.averagerate DESC");
    	List result1 = Q1.getResultList();
    	List result2 = Q2.getResultList();
    	int totalnum = result1.size();	
    	int n = 0;
    	if(totalnum > 9){
    		while(n < 10){
    			averagerate = new AverageRate(averagerate.cardname,averagerate.averagerate);
    			averagerate.cardname=result1.get(n).toString();
    			averagerate.averagerate=result2.get(n).toString();
    			averagerates.add(averagerate);
    	    	n=n+1; 
    	    	}
    		} 
    	else{
    		System.out.println("Error");
    	}

        em.getTransaction().commit();

        return averagerates;  
    }
    
	 public List<Card> Getinfo() throws MalformedURLException{
			AverageRateDAO dao = new AverageRateDAO();
			List<AverageRate> averagerates = dao.Output();
			List<Card> cards = new ArrayList<Card>();
			Card card = new Card();

			int n = 0;
			
			while(n < 10){

				String urlStr = urlApi.replace("[name]", averagerates.get(n).getCardname());
				
		        try {
					URL url = new URL(urlStr);
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					InputStream stream = connection.getInputStream();
					InputStreamReader reader = new InputStreamReader(stream);
					BufferedReader buffer = new BufferedReader(reader);
					String line;
					String json = "";
					while((line = buffer.readLine()) != null) {
						json += line;
					}
					
					
					JSONParser parser = new JSONParser();
					try { 
						
						JSONArray root = (JSONArray) parser.parse(json);
						JSONObject data = (JSONObject) root.get(0);
						
						card = new Card(card.id, card.setnumber, card.name, card.manacost,
								card.convertedmanacost, card.cardsetname, card.type,
								card.subtype, card.power, card.toughness, card.loyalty,
								card.rarity, card.flavor, card.description);
						card.id =  Integer.parseInt((data.get("id").toString()));
						card.setnumber = Integer.parseInt((data.get("setNumber").toString()));
						card.name = data.get("name").toString();
						card.type = data.get("type").toString();
						if(data.get("subType")!=null){
							card.subtype = (String) data.get("subType");}
							else{card.subtype = null;}			
						
						card.power = Integer.parseInt((data.get("power").toString()));
						card.toughness = Integer.parseInt((data.get("toughness").toString()));
						card.manacost = data.get("manaCost").toString();
						card.rarity = data.get("rarity").toString();
		                card.cardsetname = data.get("cardSetName").toString();
		    			card.description = data.get("description").toString();
						if(data.get("flavor")!=null){
							card.flavor = (String) data.get("flavor");}
							else{card.flavor = null;}	
		    			card.convertedmanacost = data.get("convertedManaCost").toString();
		    			card.loyalty = Integer.parseInt((data.get("loyalty").toString()));

		                cards.add(card);
		    			n = n+1;
					    }
					     
				 catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	   }

	        return cards;

		}

    public static void main(String[] args) {
    	AverageRateDAO dao = new AverageRateDAO();
    	 dao.deleteAverageRate();
    	AverageRateDAO dao1 = new AverageRateDAO();
    	 dao1.CalculateRate();
    	AverageRateDAO dao2 = new AverageRateDAO();
    	 dao2.Output();
        AverageRateDAO dao3 = new AverageRateDAO();
       	 try {
		dao3.Getinfo();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}

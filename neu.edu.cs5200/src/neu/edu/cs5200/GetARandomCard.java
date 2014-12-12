package neu.edu.cs5200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetARandomCard {
	
	private String urlApi ="http://api.mtgdb.info/cards/random";
	

	public Card getCardByRandom(){
		
		
		
		
		try {
			
			URL url = new URL(urlApi);
			System.out.println(urlApi);
			HttpURLConnection connection =(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream stream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line;
			String json = "";
			while((line = buffer.readLine())!=null){
				json += line;
				System.out.println(json);
			}
			
			
			
			JSONParser parser = new JSONParser();
			try {
				JSONObject root = (JSONObject) parser.parse(json);
				
				System.out.println(root);
				
			
			
			
				
				JSONArray colors = (JSONArray) root.get("colors");
				System.out.println(colors);
				//JSONArray rulings = (JSONArray) root.get("rulings");
				//JSONObject firstRulings = (JSONObject) rulings.get(0);
				
				//Ruling ruling = new Ruling();
				
				/*how to transform the date type ? */
				//ruling.releasedAt = (Date) ( firstRulings.get("releasedAt");
				
				
			//ruling.rule = (String) firstRulings.get("rule");
				
				
				//JSONArray formats = (JSONArray) root.get("formats");
				
				Card card = new Card();
				card.id =  Integer.parseInt((root.get("id").toString()));
				card.relatedcardid = Integer.parseInt((root.get("relatedCardId").toString()));
				card.setnumber = Integer.parseInt((root.get("setNumber").toString()));
				card.name = root.get("name").toString();
				card.searchname = root.get("searchName").toString();
				card.description = root.get("description").toString();
				card.flavor = root.get("flavor").toString();
				card.colors = root.get("colors").toString();
				card.manacost = root.get("manaCost").toString();
				card.convertedmanacost = root.get("convertedManaCost").toString();
				card.cardsetname = root.get("cardSetName") .toString();
				card.type = root.get("type").toString();
				if(root.get("subType")!=null){
					card.subtype = (String) root.get("subType");}
					else{card.subtype = null;}
				
				card.power = Integer.parseInt((root.get("power").toString()));
				card.searchByUser = Global.username;
				
				card = new Card(card.id,card.relatedcardid,card.setnumber,card.name,card.searchname,card.description,card.flavor,card.colors,card.manacost,card.convertedmanacost,card.cardsetname,card.type,card.subtype,card.power,card.searchByUser);
						
				//System.out.println(card.id);
				//System.out.println(card.colors);
				//System.out.println(card.getName());
				
				return card;
				
			} catch (ParseException e) {
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
		
		return null;
			
	
	}
	
	
	public static void main(String[] args) {
		GetARandomCard noob = new GetARandomCard();
		noob.getCardByRandom();

	}

}

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

public class GetACardByName {
	
	private String urlApi = "http://api.mtgdb.info/cards/[name]";
	
	public Card getCardByName(String name){
		
		String urlStr = urlApi.replace("[name]", name);
		
		//System.out.println(urlStr);
		
		try {
			URL url = new URL(urlStr);
			
			HttpURLConnection connection =(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream stream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line;
			String json = "";
			while((line = buffer.readLine())!=null){
				json += line;
			}
			
			
			
			JSONParser parser = new JSONParser();
			try {
				JSONArray root = (JSONArray) parser.parse(json);
				JSONObject data = (JSONObject) root.get(0);
			
				
				
				JSONArray colors = (JSONArray) data.get("colors");
				
				//JSONArray rulings = (JSONArray) data.get("rulings");
				//JSONObject firstRulings = (JSONObject) rulings.get(0);
				
				//Ruling ruling = new Ruling();
				
				/*how to transform the date type ? */
				//ruling.releasedAt = (Date) ( firstRulings.get("releasedAt");
				
				
				//ruling.rule = (String) firstRulings.get("rule");
				
				
				//JSONArray formats = (JSONArray) data.get("formats");
				
				Card card = new Card();
				card.cardid =  Integer.parseInt((data.get("id").toString()));
				card.relatedcardid = Integer.parseInt((data.get("relatedCardId").toString()));
				card.setnumber = Integer.parseInt((data.get("setNumber").toString()));
				card.name = data.get("name").toString();
				card.searchname = data.get("searchName").toString();
				card.description = data.get("description").toString();
				card.flavor = data.get("flavor").toString();
				card.colors = data.get("colors").toString();
				card.manacost = data.get("manaCost").toString();
				card.convertedmanacost = data.get("convertedManaCost").toString();
				card.cardsetname = data.get("cardSetName").toString();
				card.type = data.get("type").toString();
				if(data.get("subType")!=null){
				card.subtype = (String) data.get("subType");}
				else{card.subtype = null;}
				card.power = Integer.parseInt((data.get("power").toString()));
				card.searchByUser = Global.username;
				card = new Card(card.cardid,card.relatedcardid,card.setnumber,card.name,card.searchname,card.description,card.flavor,card.colors,card.manacost,card.convertedmanacost,card.cardsetname,card.type,card.subtype,card.power,card.searchByUser);
						
			
				
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
		// TODO Auto-generated method stub
//		GetACardByName get = new GetACardByName();
//		Card card = new Card();
//		card = get.getCardByName("Skinrender");
//		System.out.println(card.getName());
	}

}

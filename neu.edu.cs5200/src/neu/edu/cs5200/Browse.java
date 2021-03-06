package neu.edu.cs5200;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Browse {
	
	private String urlApi = "http://api.mtgdb.info/sets/[id]/cards/";
	private String urlApi2 = "http://api.mtgdb.info/sets/[id]/";
	
    public List<Card> readAllCardBySet(String cardSetId) throws MalformedURLException{
    
    	String urlStr = urlApi.replace("[id]", cardSetId);
    	String urlStr2 = urlApi2.replace("[id]", cardSetId);
		List<Card> cards = new ArrayList<Card>();
    	int t=0;
    	
		URL url2;
		try {
			url2 = new URL(urlStr2);
			HttpURLConnection connection2 = (HttpURLConnection) url2
					.openConnection();
			connection2.setRequestMethod("GET");
			InputStream stream2 = connection2.getInputStream();
			InputStreamReader reader2 = new InputStreamReader(stream2);
			BufferedReader buffer2 = new BufferedReader(reader2);
			String line2;
			String json2 = "";
			while ((line2 = buffer2.readLine()) != null) {
				json2 += line2;
			}
			
		    JSONParser parser2 = new JSONParser();
			try { 
				JSONObject root = (JSONObject) parser2.parse(json2);
				JSONArray data = (JSONArray) root.get("cardIds");
				Set cardtotal = new Set();
				Set facttotal = new Set();
				Set name = new Set();
				cardtotal.total = Integer.parseInt((root.get("total").toString()));
				facttotal.total = data.size();
				name.name = root.get("name").toString();
				t = facttotal.total;
				String setname = name.name;
				System.out.println(cardtotal.total);
				System.out.println(t);
				System.out.println(setname);
				}catch (ParseException e) {
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
			Card card = new Card();
			
			JSONParser parser = new JSONParser();
			try { 
				int totalnum = t;
				int number=0;

				while(number<totalnum){
				JSONArray root = (JSONArray) parser.parse(json);
				JSONObject data = (JSONObject) root.get(number);	
				
				card = new Card(card.setnumber,card.name,card.type,card.subtype,card.power,card.toughness,card.manacost,card.rarity,card.cardsetname);
				
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
                          
				cards.add(card);
			    number = number+1;
				}
				
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

        return cards;

	}
		
    public static void main (String[] args){
    	Browse listall = new Browse();
    	try {
			listall.readAllCardBySet("ZEN");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
    
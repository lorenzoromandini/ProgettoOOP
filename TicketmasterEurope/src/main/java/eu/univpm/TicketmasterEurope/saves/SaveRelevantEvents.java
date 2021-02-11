/**
 * 
 */
package eu.univpm.TicketmasterEurope.saves;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import eu.univpm.TicketmasterEurope.model.Country;
import eu.univpm.TicketmasterEurope.model.Date;
import eu.univpm.TicketmasterEurope.model.Dealer;
import eu.univpm.TicketmasterEurope.model.Event;
import eu.univpm.TicketmasterEurope.model.EventsArray;
import eu.univpm.TicketmasterEurope.model.Genre;
import eu.univpm.TicketmasterEurope.model.Location;
import eu.univpm.TicketmasterEurope.model.Market;
import eu.univpm.TicketmasterEurope.model.Place;
import eu.univpm.TicketmasterEurope.model.Prices;
import eu.univpm.TicketmasterEurope.service.JSON_Converter;
import eu.univpm.TicketmasterEurope.service.Service;
import eu.univpm.TicketmasterEurope.service.ServiceManagement;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */

public class SaveRelevantEvents {
	
	/**
	 * apikey è la key necessaria per ottenere informazioni da Ticketmaster
	 */
	private String apikey = "GP6psuWJBWvDCvq13mLNVDY3ktVMdHRI";
	
	
	/**
	 * Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il codice di tale paese
	 * @param countryCode - codice del paese in cui ha luogo l'evento
	 * @return JSONObject object
	 */
	public JSONObject RelevantEvents(String countryCode, String segment) {
		
		JSONObject relevantsObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events?countryCode="
		              + countryCode + "&segmentName=" + segment + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		relevantsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		return relevantsObject; 
	}
	
	
    public EventsArray getRelevantEventsSelectedfromApi(String countryCode, String segment) {	
		
		JSONObject relevantEventsSelectedObject = RelevantEvents(countryCode, segment);
									
		EventsArray eventsArray = new EventsArray();		
		
		JSONObject embeddedObject = relevantEventsSelectedObject.getJSONObject("_embedded");
		JSONArray countryEventsArray = embeddedObject.getJSONArray("events");
		JSONObject pageObject = relevantEventsSelectedObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		JSONObject object;
		
		int dimensione = 5;
		
		Vector<Event> vector = new Vector<Event>(dimensione); 
		
		for (int i = 0; i < dimensione; i++) {
			
			Event event = new Event();      //creo un nuovo oggetto di tipo event
			
			object = countryEventsArray.getJSONObject(i);   //i-esimo blocco nel vettore degli eventi
			
			try {
				
			event.setName(object.getString("name"));   //setto il nome dell'evento con la stringa che corrisponde a "name"
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			event.setId(object.getString("id"));   //setto l'id dell'evento con la stringa che corrisponde a "id"
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			event.setUrl(object.getString("url"));  //setto l'url dell'evento con la stringa che corrisponde a "url"
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			Dealer dealer = new Dealer();			//creo un ogetto di tipo Dealer
			String url = object.getString("url");
			String source = null;
			if(url.contains("universe")) source = "universe";
			else if(url.contains("ticketmaster")) source = "ticketmaster";
			else if(url.contains("frontgate")) source = "frontgate";
			else source = "tmr";
			dealer.setSource(source);
			
			event.setDealer(dealer);
			
			try {
				
			event.setInfo(object.getString("info"));   //setto l'info dell'evento con la stringa che corrisponde a "info"
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			Date data = new Date();        //creo un nuovo oggetto di tipo Date
			
			try {
				
			JSONObject datesObject = object.getJSONObject("dates");               //creo un JSONArray che corrisponde all'array "dates"
			JSONObject startDateObject = datesObject.getJSONObject("start");      //creo un JSONArray che corrisponde all'array "start"	
			data.setDataInizio(startDateObject.getString("localDate"));		      //setto la data della data con la stringa che corrisponde a "localDate"
			data.setOrarioInizio(startDateObject.getString("localTime"));         //setto l'orario della data con la stringa che corrisponde a "localTime"			
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			event.setDate(data);	          //setto la data dell'evento con l'oggetto di tipo data appena creato
			
			Prices prices = new Prices();     //creo un nuovo oggetto di tipo prices
			
			try {
				
			JSONArray pricesArray = object.getJSONArray("priceRanges");    //creo un JSONArray che corrisponde all'array "priceRanges"
			JSONObject pricesObject = pricesArray.getJSONObject(0);        //creo un JSONObject a partire dal informationsArray precedente
			prices.setCurrency(pricesObject.getString("currency"));        //setto la valuta con la stringa che corrisponde a "currency"
			prices.setMaxPrice(pricesObject.getDouble("max"));             //setto il prezzo massimo con la stringa che corrisponde a "max"
			prices.setMinPrice(pricesObject.getDouble("min"));             //setto il prezzo minimo con la stringa che corrisponde a "min"
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			event.setPrices(prices);				//setto le informations dell'evento con l'oggetto di tipo infromations appena creato		
			
			Genre genre = new Genre();              //creo un ogetto di tipo Genre
			
			try {
				
			JSONArray classificationsArray = object.getJSONArray("classifications");      //creo un JSONArray che corrisponde all'array "classifications"
			JSONObject classificationsObject = classificationsArray.getJSONObject(0);     //creo un JSONObject a partire dal informationsArray precedente
			JSONObject segmentObject = classificationsObject.getJSONObject("segment");    //creo un JSONArray che corrisponde all'array "segment"
			genre.setSegmentName(segmentObject.getString("name"));                        //setto il nome del tipologia con la stringa che corrisponde a "name"
			JSONObject genreObject = classificationsObject.getJSONObject("genre");        //creo un JSONArray che corrisponde all'array "genre"
			genre.setGenreName(genreObject.getString("name"));                            //setto il nome del genre con la stringa che corrisponde a "name"
			JSONObject subGenreObject = classificationsObject.getJSONObject("subGenre");  //creo un JSONArray che corrisponde all'array "subGenre"
			genre.setSubGenreName(subGenreObject.getString("name"));                      //setto il nome del sottogenere con la stringa che corrisponde a "name"
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			event.setGenre(genre);                                      //setto il genere dell'evento con l'oggetto genre appena creato
			
			Location location = new Location();                          //creo un ogetto di tipo location
			 
		    JSONObject lowerEmbeddedObj = object.getJSONObject("_embedded");  //creo un JSONobject che corrisponde al oggetto "embedded"
		   
		    try {
		    	
		    JSONArray venuesArray = lowerEmbeddedObj.getJSONArray("venues");   //creo un JSONArray che corrisponde all'array "vanues"
		    JSONObject lowerFirstObject = venuesArray.getJSONObject(0);        //creo un JSONObject a partire dal venuesArray precedente
		   
		    Place placement = new Place();                               //creo un ogetto di tipo place
		    
            try {
		    
		    placement.setPlacement(lowerFirstObject.getString("name"));         //setto il nome del tipologia con la stringa che corrisponde a "name"
		    JSONObject addressObject = lowerFirstObject.getJSONObject("address");
		    placement.setAddress(addressObject.getString("line1"));            //setto la linea con la stringa che corrisponde a "line1"
		    JSONObject cityObject = lowerFirstObject.getJSONObject("city");
		    placement.setCity(cityObject.getString("name"));
		    location.setPlace(placement);                   //setto il luogo dell'evento con l'oggetto placement appena creato
		    
		    } catch(Exception e) {
				e.printStackTrace();
			}
		
		    Country country = new Country();                         //creo un ogetto di tipo Country
		    
		    try {
		    	
		    JSONObject countryObject = lowerFirstObject.getJSONObject("country");
		    country.setCountry(countryObject.getString("name"));
		    country.setCountryCode(countryObject.getString("countryCode"));
		    location.setCountry(country);             //setto lo stato  dell'evento con l'oggetto country appena creato
		    
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
		    Market market = new Market();                         //creo un ogetto di tipo Market
		    
		    try {
		    	
		    JSONArray marketArray = lowerFirstObject.getJSONArray("markets");
		    JSONObject marketObject = marketArray.getJSONObject(0);	    
		    market.setMarketName(marketObject.getString("name"));		    
		    market.setMarketId(marketObject.getString("id"));
		    location.setMarket(market);         //setto il market dell'evento con l'oggetto location appena creato
		    
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
		    event.setLocation(location);      //setto l'evento dell'evento con l'oggetto location appena creato
		    
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
			vector.add(event);	
			
		}
		
		eventsArray.setVector(vector);
		eventsArray.setTotalEvents(totalElements);
		eventsArray.setShowedEvents(dimensione);
		
		return eventsArray;
	}
    
    
    public String StoreRelevantEvents(String countryCode, String segment) throws IOException {
    	
   		EventsArray eventsArray = getRelevantEventsSelectedfromApi(countryCode, segment);        
        
		JSONObject object = new JSONObject();
		JSON_Converter json_converter = new JSON_Converter();
        
		object = json_converter.JSON_converter(eventsArray);
		
		String nomeDirectory = "Relevant_Events";
		
		String pathDirectory = System.getProperty("user.dir") + "/" + nomeDirectory;
        
		String nomeFile = countryCode + "_Relevant_Events";
				
		String path = pathDirectory + "/" + nomeFile + ".txt";
				 
		File directory = new File(pathDirectory);
		 
		if(!directory.isDirectory()) {
		 
		  directory.mkdir();
		 
		}
		
		File file = new File(path);
        
		try{
			
		    if(!file.exists()) {
		        file.createNewFile();
		    }

		    FileWriter fileWriter = new FileWriter(file, true);
			
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
		    bufferedWriter.write(object.toString()); 
		    bufferedWriter.write("\n");
		    bufferedWriter.close();
		    
		} catch(IOException e) {
		    System.out.println(e);
		}
		
		return path;
		
	}
    
    
    public String StoreCountryEvents(String countryCode) throws IOException {
    	
    	Service service = new ServiceManagement();
    	
   		EventsArray eventsArray = service.getCountryEventsSelectedfromApi(countryCode);        
        
		JSONObject object = new JSONObject();
		JSON_Converter json_converter = new JSON_Converter();
        
		object = json_converter.JSON_converter(eventsArray);
        
        String nomeDirectory = "Total_Events";
		
		String pathDirectory = System.getProperty("user.dir") + "/" + nomeDirectory;
        
		String nomeFile = countryCode + "_Total_Events";
				
		String path = pathDirectory + "/" + nomeFile + ".txt";
				 
		File directory = new File(pathDirectory);
		 
		if(!directory.isDirectory()) {
		 
		  directory.mkdir();
		 
		}
		
		File file = new File(path);
        
		try{
			
		    if(!file.exists()) {
		        file.createNewFile();
		    }

		    FileWriter fileWriter = new FileWriter(file, true);
			
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(object.toString());  
		    bufferedWriter.write("\n");
		    bufferedWriter.close();
		    
		} catch(IOException e) {
		    System.out.println(e);
		}
		
		return "Il file è stato salvato in " + path;
		
	}
        

}

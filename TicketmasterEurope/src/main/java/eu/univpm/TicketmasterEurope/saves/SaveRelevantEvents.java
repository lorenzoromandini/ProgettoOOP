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

import eu.univpm.TicketmasterEurope.exception.VoidGetException;
import eu.univpm.TicketmasterEurope.exception.WrongCountryException;
import eu.univpm.TicketmasterEurope.exception.WrongValueException;
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

/** Questa classe ha la funzione di creare una directory che viene riempita tramite la creazione di file contenenti le 
 * informazioni relative ai primi 5 eventi per rilevanza per ciascuna tipologia per ogni paese europeo
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class SaveRelevantEvents {
	
	Service service = new ServiceManagement();
	
	
	/** Questo metodo utilizza getSegmentEvents della classe Servicemanagementper andare a selezionare le informazioni desiderate 
	 * relative ad un evento (id, nome, url, source, info, data, orario, valuta, paese, città, indirizzo, placement, market, 
	 * prezzo minimo, prezzo massimo, tipologia, genere, sottogenere, eventi mostrati, eventi totali)
	 * 
	 * @param segment tipologia di evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return un vettore di 5 eventi contenente le informazioni desiderate degli eventi che hanno luogo nel paese indicato e
	 * in base alla tipologia di evento scelta
	 * @throws WrongValueException se viene inserita una tipologia di evento non ammessa
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
    public EventsArray getRelevantEventsSelectedfromApi(String segment, String countryCode) throws WrongCountryException, WrongValueException {	
		
		JSONObject relevantEventsSelectedObject = service.getSegmentEvents(segment, countryCode);
									
		EventsArray eventsArray = new EventsArray();		
		
		JSONObject embeddedObject = relevantEventsSelectedObject.getJSONObject("_embedded");
		JSONArray countryEventsArray = embeddedObject.getJSONArray("events");
		JSONObject pageObject = relevantEventsSelectedObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		JSONObject object;
		
		int dimensione = 5;
		
		Vector<Event> vector = new Vector<Event>(dimensione); 
		
		for (int i = 0; i < dimensione; i++) {
			
			Event event = new Event();      
			
			object = countryEventsArray.getJSONObject(i);  
			
			try {
				
			event.setName(object.getString("name"));  
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			event.setId(object.getString("id"));   
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			event.setUrl(object.getString("url"));  
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			Dealer dealer = new Dealer();			
			String url = object.getString("url");
			String source = null;
			if(url.contains("universe")) source = "universe";
			else if(url.contains("ticketmaster")) source = "ticketmaster";
			else if(url.contains("frontgate")) source = "frontgate";
			else source = "tmr";
			dealer.setSource(source);
			
			event.setDealer(dealer);
			
			try {
				
			event.setInfo(object.getString("info")); 
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			Date data = new Date();        
			
			try {
				
			JSONObject datesObject = object.getJSONObject("dates");              
			JSONObject startDateObject = datesObject.getJSONObject("start");     	
			data.setDataInizio(startDateObject.getString("localDate"));		    
			data.setOrarioInizio(startDateObject.getString("localTime"));       		
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			event.setDate(data);	          
			
			Prices prices = new Prices();     
			
			try {
				
			JSONArray pricesArray = object.getJSONArray("priceRanges");    
			JSONObject pricesObject = pricesArray.getJSONObject(0);        
			prices.setCurrency(pricesObject.getString("currency"));        
			prices.setMaxPrice(pricesObject.getDouble("max"));             
			prices.setMinPrice(pricesObject.getDouble("min"));             
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			event.setPrices(prices);						
			
			Genre genre = new Genre();              
			
			try {
				
			JSONArray classificationsArray = object.getJSONArray("classifications");      
			JSONObject classificationsObject = classificationsArray.getJSONObject(0);     
			JSONObject segmentObject = classificationsObject.getJSONObject("segment");   
			genre.setSegmentName(segmentObject.getString("name"));                        
			JSONObject genreObject = classificationsObject.getJSONObject("genre");        
			genre.setGenreName(genreObject.getString("name"));                            
			JSONObject subGenreObject = classificationsObject.getJSONObject("subGenre");  
			genre.setSubGenreName(subGenreObject.getString("name"));                      
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			event.setGenre(genre);                                      
			
			Location location = new Location();                          
			 
		    JSONObject lowerEmbeddedObj = object.getJSONObject("_embedded");  
		   
		    try {
		    	
		    JSONArray venuesArray = lowerEmbeddedObj.getJSONArray("venues");   
		    JSONObject lowerFirstObject = venuesArray.getJSONObject(0);        
		   
		    Place placement = new Place();                               
		    
            try {
		    
		    placement.setPlacement(lowerFirstObject.getString("name"));         
		    JSONObject addressObject = lowerFirstObject.getJSONObject("address");
		    placement.setAddress(addressObject.getString("line1"));            
		    JSONObject cityObject = lowerFirstObject.getJSONObject("city");
		    placement.setCity(cityObject.getString("name"));
		    location.setPlace(placement);                   
		    
		    } catch(Exception e) {
				e.printStackTrace();
			}
		
		    Country country = new Country();                         
		    
		    try {
		    	
		    JSONObject countryObject = lowerFirstObject.getJSONObject("country");
		    country.setCountry(countryObject.getString("name"));
		    country.setCountryCode(countryObject.getString("countryCode"));
		    location.setCountry(country);             
		    
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
		    Market market = new Market();                         
		    
		    try {
		    	
		    JSONArray marketArray = lowerFirstObject.getJSONArray("markets");
		    JSONObject marketObject = marketArray.getJSONObject(0);	    
		    market.setMarketName(marketObject.getString("name"));		    
		    market.setMarketId(marketObject.getString("id"));
		    location.setMarket(market);         
		    
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
		    event.setLocation(location);      
		    
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
    
    
    /** Questo metodo permette di scrivere 5 eventi in base al paese e alla tipologia scelta all'interno di un file (se non esiste 
     * viene creato) che è contenuto a sua volta all'interno di una directory (se non esiste viene creata)
     * 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @param segment tipologia di evento 
	 * @return una stringa contenente il path del file salvato
	 * @throws IOException se si verificano errori di output su file
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 * @throws WrongValueException se viene inserita una tipologia di evento non ammessa
     */
    public String StoreSegmentRelevantEvents(String countryCode, String segment) throws IOException, WrongCountryException, WrongValueException {
    	
   		EventsArray eventsArray = getRelevantEventsSelectedfromApi(segment, countryCode);        
        
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
    
    
    /** Questo metodo permette di scrivere gli eventi in base al paese scelto all'interno di un file (se non esiste 
     * viene creato) che è contenuto a sua volta all'interno di una directory (se non esiste viene creata)
     * 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return una stringa contenente il path del file salvato
	 * @throws IOException se si verificano errori di output su file
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
     */
    public String StoreCountryEvents(String countryCode) throws IOException, WrongCountryException {
    	
    	Service service = new ServiceManagement();
    	
    	VoidGetException Exception = new VoidGetException();
    	
    	Exception.countryStringException(countryCode);
    	
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

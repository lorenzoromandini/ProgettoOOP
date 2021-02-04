/**
 * 
 */
package eu.univpm.TicketmasterEurope.service;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import eu.univpm.TicketmasterEurope.model.*;

/** Questa classe è l'implementazione dell'interfaccia Service
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */

@Service

public class ServiceManagement implements eu.univpm.TicketmasterEurope.service.Service {
	
	/**
	 * apikey è la key necessaria per ottenere informazioni da Ticketmaster
	 */
	private String apikey = "GP6psuWJBWvDCvq13mLNVDY3ktVMdHRI";
	
	/**
	 * Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il codice di tale paese
	 * @param countryCode - codice del paese in cui ha luogo l'evento
	 * @return JSONObject object
	 */
	public JSONObject getCountryEvents(String countryCode) {
		
		JSONObject countryEventsObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events?size=200&sort=date,asc&countryCode="
		              + countryCode + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		countryEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		return countryEventsObject; 
	}

	
	/**
	 * Questo metodo utilizza getCountryEvents per andare a selezionare le informazioni desiderate relative ad un evento
	 * (id, nome, url, info, data, orario, valuta, prezzo minimo, prezzo massimo, tipologia, genere e sottogenere)
	 * @param countryCode - codice del paese in cui ha luogo l'evento
	 * @return Location location - oggetto contenente le informazioni desiderate dell'evento e il luogo in cui si svolge
	 */
	public EventsArray getCountryEventsSelectedfromApi(String countryCode) {	
		
		JSONObject countryEventsSelectedObject = getCountryEvents(countryCode);
									
		EventsArray eventsArray = new EventsArray();		
		
		JSONObject embeddedObject = countryEventsSelectedObject.getJSONObject("_embedded");
		JSONObject pageObject = countryEventsSelectedObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		JSONArray countryEventsArray = embeddedObject.getJSONArray("events");
		JSONObject object;
		
		int dimensione;
		
		if(totalElements < 200) dimensione = totalElements;
		else dimensione = 200;
		
		Vector<Event> vector = new Vector<Event>(dimensione); 
		
		for (int i = 0; i < dimensione; i++) {
			
			Event evento = new Event();
			
			object = countryEventsArray.getJSONObject(i);
			
			try {
				
			evento.setName(object.getString("name"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			evento.setId(object.getString("id"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			evento.setUrl(object.getString("url"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			evento.setInfo(object.getString("info"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			Date data = new Date();
			
			try {
				
			JSONObject datesObject = object.getJSONObject("dates");
			JSONObject startDateObject = datesObject.getJSONObject("start");		
			data.setData(startDateObject.getString("localDate"));		
			data.setOrario(startDateObject.getString("localTime"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			evento.setDate(data);	
			
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
			
			evento.setPrices(prices);						
			
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
			
			evento.setGenre(genre);
			
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
		    
		    evento.setLocation(location);
		    
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
			vector.add(evento);	
			
		}
		
		eventsArray.setVector(vector);
		
		return eventsArray;
	}
	
	
    public JSONObject getMarketEvents(String marketId) {
		
		JSONObject marketEventsObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events?size=200&sort=date,asc&marketId="
		              + marketId + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		marketEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		return marketEventsObject; 	
	}

    
	/**
	 * Questo metodo utilizza getCountryEvents per andare a selezionare le informazioni desiderate relative ad un evento
	 * (id, nome, url, info, data, orario, valuta, prezzo minimo, prezzo massimo, tipologia, genere e sottogenere)
	 * @param countryCode - codice del paese in cui ha luogo l'evento
	 * @return Location location - oggetto contenente le informazioni desiderate dell'evento e il luogo in cui si svolge
	 */
	public EventsArray getMarketEventsSelectedfromApi(String marketId) {	
		
		JSONObject marketEventsSelectedObject = getMarketEvents(marketId);
									
		EventsArray eventsArray = new EventsArray();		
		
		JSONObject embeddedObject = marketEventsSelectedObject.getJSONObject("_embedded");
		JSONObject pageObject = marketEventsSelectedObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		JSONArray marketEventsArray = embeddedObject.getJSONArray("events");
		JSONObject object;
		
		int dimensione;
		
		if(totalElements < 200) dimensione = totalElements;
		else dimensione = 200;
		
		Vector<Event> vector = new Vector<Event>(dimensione); 
		
		for (int i = 0; i < dimensione; i++) {
			
			Event evento = new Event();
			
			object = marketEventsArray.getJSONObject(i);
			
			try {
				
			evento.setName(object.getString("name"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			evento.setId(object.getString("id"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			evento.setUrl(object.getString("url"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			evento.setInfo(object.getString("info"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			Date data = new Date();
			
			try {
				
			JSONObject datesObject = object.getJSONObject("dates");
			JSONObject startDateObject = datesObject.getJSONObject("start");		
			data.setData(startDateObject.getString("localDate"));		
			data.setOrario(startDateObject.getString("localTime"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			evento.setDate(data);	
			
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
			
			evento.setPrices(prices);						
			
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
			
			evento.setGenre(genre);
			
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
		    
		    evento.setLocation(location);
		    
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
			vector.add(evento);	
			
		}
		
		eventsArray.setVector(vector);
		
		return eventsArray;
	}
	
	
     public JSONObject getSourceEvents(String source) {
		
		JSONObject sourceEventsObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events?size=200&sort=date,asc&source="
		              + source + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		sourceEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		return sourceEventsObject; 
	}
     
     
	/**
	 * Questo metodo utilizza getCountryEvents per andare a selezionare le informazioni desiderate relative ad un evento
	 * (id, nome, url, info, data, orario, valuta, prezzo minimo, prezzo massimo, tipologia, genere e sottogenere)
	 * @param countryCode - codice del paese in cui ha luogo l'evento
	 * @return Location location - oggetto contenente le informazioni desiderate dell'evento e il luogo in cui si svolge
	 */
	public EventsArray getSourceEventsSelectedfromApi(String source) {	
		
		JSONObject sourceEventsSelectedObject = getSourceEvents(source);
									
		EventsArray eventsArray = new EventsArray();		
		
		JSONObject embeddedObject = sourceEventsSelectedObject.getJSONObject("_embedded");
		JSONObject pageObject = sourceEventsSelectedObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		JSONArray sourceEventsArray = embeddedObject.getJSONArray("events");
		JSONObject object;
		
		int dimensione;
		
		if(totalElements < 200) dimensione = totalElements;
		else dimensione = 200;
		
		Vector<Event> vector = new Vector<Event>(dimensione); 
		
		for (int i = 0; i < dimensione; i++) {
			
			Event evento = new Event();
			
			object = sourceEventsArray.getJSONObject(i);
			
			try {
				
			evento.setName(object.getString("name"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			evento.setId(object.getString("id"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			evento.setUrl(object.getString("url"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				
			evento.setInfo(object.getString("info"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			Date data = new Date();
			
			try {
				
			JSONObject datesObject = object.getJSONObject("dates");
			JSONObject startDateObject = datesObject.getJSONObject("start");		
			data.setData(startDateObject.getString("localDate"));		
			data.setOrario(startDateObject.getString("localTime"));
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			evento.setDate(data);	
			
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
			
			evento.setPrices(prices);						
			
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
			
			evento.setGenre(genre);
			
			Location location = new Location();
			
			try {
			 
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
		    
		    evento.setLocation(location);
		    
		    } catch(Exception e) {
				e.printStackTrace();
			}
		    
			 } catch(Exception e) {
					e.printStackTrace();
				}
		    
			vector.add(evento);	
			
		}
		
		eventsArray.setVector(vector);
		
		return eventsArray;
	}

	
	
	

}
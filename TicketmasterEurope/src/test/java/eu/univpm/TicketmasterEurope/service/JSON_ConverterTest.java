/**
 * 
 */
package eu.univpm.TicketmasterEurope.service;

import java.io.IOException;
import java.util.Vector;
import static org.junit.Assert.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import eu.univpm.TicketmasterEurope.exception.WrongCountryException;
import eu.univpm.TicketmasterEurope.model.*;


/** Questa classe contiene il test della classe JSON_Converter
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class JSON_ConverterTest {

	Vector<Event> vector;
	EventsArray eventsArray;
	Event event;
	Dealer dealer;
	Date data;
	Prices prices;
	Genre genre;
	Location location;
	Place place;
	Country country;
	Market market;
	JSON_Converter json_converter;
	

	/** Inizializza tutti i componenti necessari per il test
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		vector = new Vector<Event>();
		eventsArray = new EventsArray();
		event = new Event();
		dealer = new Dealer();
		data = new Date();
		prices = new Prices();
		genre = new Genre();
		location = new Location();
		place = new Place();
		country = new Country();
		market = new Market();
		json_converter = new JSON_Converter();
		
	}
	

	/** Distrugge tutto ciò che è stato costruito dal setUp()
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		
	}

	
	/** Test che verifica la corretta conversione in JSON
	 * 
	 * @throws IOException, WrongCountryException
	 */
	@Test
	@DisplayName("Conversione corretta")
	void JSON_Creator() throws IOException, WrongCountryException {
		
		event.setName("Gabriel Garzon-Montano");
		event.setId("1AgZA-4Gkenw1Pn");
		event.setUrl("https://www.ticketmaster.co.uk/gabriel-garzonmontano-london-04-07-2020/event/35005855AAC8A96A");

		place.setAddress("133a Rye Lane");
		place.setCity("London");
		place.setPlacement("Peckham Audio");
		location.setPlace(place);

		country.setCountry("Great Britain");
		country.setCountryCode("GB");
		location.setCountry(country);

		market.setMarketId("201");
		market.setMarketName("All of United Kingdom");
		location.setMarket(market);
		
		dealer.setSource("ticketmaster");

		data.setDataInizio("2020-04-07");
		data.setOrarioInizio("19:30:00");
		
		genre.setSegmentName("Music");
		genre.setGenreName("R&B");
		genre.setSubGenreName("Soul");

		prices.setCurrency("GBP");
		prices.setMaxPrice(14.5);
	    prices.setMinPrice(14.5);

		event.setDate(data);
		event.setDealer(dealer);
		event.setLocation(location);
		event.setGenre(genre);
		event.setPrices(prices);

		vector.add(event);
		eventsArray.setVector(vector);

		JSONArray array = new JSONArray();
		JSONObject events = new JSONObject();
    	JSONObject obj = new JSONObject();
    		
    	try {
		obj.put("source", (eventsArray.getVector()).get(0).getDealer().getSource());
		} catch(Exception e) {
			e.printStackTrace();
		} 
    
    	try {
	    obj.put("placement", (eventsArray.getVector()).get(0).getLocation().getPlace().getPlacement());
    	} catch(Exception e) {
			e.printStackTrace();
		}
	    
	    try {
	    obj.put("address", (eventsArray.getVector()).get(0).getLocation().getPlace().getAddress());
	    } catch(Exception e) {
			e.printStackTrace();
		}
	    
	    try {
	    obj.put("city", (eventsArray.getVector()).get(0).getLocation().getPlace().getCity());
	    } catch(Exception e) {
			e.printStackTrace();
		}
	    
	    try {
	    obj.put("country", (eventsArray.getVector()).get(0).getLocation().getCountry().getCountry());
	    } catch(Exception e) {
			e.printStackTrace();
		}
	    
	    try {
	    obj.put("countryCode", (eventsArray.getVector()).get(0).getLocation().getCountry().getCountryCode());
	    } catch(Exception e) {
			e.printStackTrace();
		}
	    
	    try {
	    obj.put("marketId",  (eventsArray.getVector()).get(0).getLocation().getMarket().getMarketId());
	    } catch(Exception e) {
			e.printStackTrace();
		}
	    
	    try {
	    obj.put("marketName", (eventsArray.getVector()).get(0).getLocation().getMarket().getMarketName());
	    } catch(Exception e) {
			e.printStackTrace();
		}
	    
	    try {
		obj.put("startDate", (eventsArray.getVector()).get(0).getDate().getDataInizio());
	    } catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		obj.put("startTime", (eventsArray.getVector()).get(0).getDate().getOrarioInizio());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		obj.put("segment", (eventsArray.getVector()).get(0).getGenre().getSegmentName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		obj.put("genre", (eventsArray.getVector()).get(0).getGenre().getGenreName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		obj.put("subGenre", (eventsArray.getVector()).get(0).getGenre().getSubGenreName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		obj.put("id", (eventsArray.getVector()).get(0).getId());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		obj.put("eventName", (eventsArray.getVector()).get(0).getName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		obj.put("url", (eventsArray.getVector()).get(0).getUrl());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		obj.put("info", (eventsArray.getVector()).get(0).getInfo());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		obj.put("currency", (eventsArray.getVector()).get(0).getPrices().getCurrency());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		obj.put("minPrice", (eventsArray.getVector()).get(0).getPrices().getMinPrice());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
		obj.put("maxPrice", (eventsArray.getVector()).get(0).getPrices().getMaxPrice());
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
		array.put(obj);
    
	events.put("Events", array);
	events.put("totalEvents", eventsArray.getTotalEvents());
	events.put("showedEvents", eventsArray.getShowedEvents());
			
    assertEquals(events.toString(), json_converter.JSON_converter(eventsArray).toString());

	}
	
	


}


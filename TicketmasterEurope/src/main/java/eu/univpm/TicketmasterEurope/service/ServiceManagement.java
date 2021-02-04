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
		String Url = "https://app.ticketmaster.com/discovery/v2/events?size=200&countryCode=" + countryCode + "&apikey="+ apikey;
		
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
						
		/*
		Country country = new Country(countryCode);
		
		Location location = new Location(country);
		
		Event event = new Event(location);
		*/					
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
			evento.setName(object.getString("name"));
			evento.setId(object.getString("id"));
			evento.setUrl(object.getString("url"));
			//evento.setInfo(object.getString("info"));
			
			Date data = new Date();
			JSONObject datesObject = object.getJSONObject("dates");
			JSONObject startDateObject = datesObject.getJSONObject("start");
			data.setData(startDateObject.getString("localDate"));
			//data.setOrario(startDateObject.getString("localTime"));
			evento.setDate(data);
			/*
			Prices prices = new Prices();
			JSONArray pricesArray = object.getJSONArray("priceRanges");
			JSONObject pricesObject = pricesArray.getJSONObject(0);
			prices.setCurrency(pricesObject.getString("currency"));
			prices.setMaxPrice(pricesObject.getDouble("max"));
			prices.setMinPrice(pricesObject.getDouble("min"));
			evento.setPrices(prices);
			*/
			
			/*
			Genre genre = new Genre();
			JSONArray classificationsArray = object.getJSONArray("classifications");
			JSONObject classificationsObject = classificationsArray.getJSONObject(0);
			JSONObject segmentObject = classificationsObject.getJSONObject("segment");
			genre.setSegmentName(segmentObject.getString("name"));
			JSONObject genreObject = classificationsObject.getJSONObject("genre");
			genre.setGenreName(genreObject.getString("name"));
			JSONObject subGenreObject = classificationsObject.getJSONObject("subGenre");
			genre.setSubGenreName(subGenreObject.getString("name"));	
			evento.setGenre(genre);
			*/
			
		    JSONObject lowerEmbeddedObj = object.getJSONObject("_embedded");
		    JSONArray venuesArray = lowerEmbeddedObj.getJSONArray("venues");
		    JSONObject lowerFirstObject = venuesArray.getJSONObject(0);
		   
		    Location locationX = new Location();
		    Place placement = new Place();
		    placement.setPlacement(lowerFirstObject.getString("name"));
		   // JSONObject addressObject = lowerFirstObject.getJSONObject("address");
		    //placement.setAddress(addressObject.getString("line1"));
		    JSONObject cityObject = lowerFirstObject.getJSONObject("city");
		    placement.setCity(cityObject.getString("name"));
		    locationX.setPlace(placement);
		
		    Country countryX = new Country();
		    JSONObject countryObject = lowerFirstObject.getJSONObject("country");
		    countryX.setCountry(countryObject.getString("name"));
		    countryX.setCountryCode(countryObject.getString("countryCode"));
		    locationX.setCountry(countryX);
		    
		    /*
		    Market market = new Market();
		    JSONArray marketArray = lowerFirstObject.getJSONArray("markets");
		    JSONObject marketObject = marketArray.getJSONObject(0);
		    market.setMarketName(marketObject.getString("name"));
		    market.setMarketId(marketObject.getString("id"));
		    locationX.setMarket(market);
		    */
		    
		    evento.setLocation(locationX);
		    
			vector.add(evento);
				
			}
		
		eventsArray.setVector(vector);
		
		return eventsArray;
	}

	

}
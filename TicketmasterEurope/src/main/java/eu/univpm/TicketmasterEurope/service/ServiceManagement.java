/**
 * 
 */
package eu.univpm.TicketmasterEurope.service;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import eu.univpm.TicketmasterEurope.model.*;

/** Questa classe è l'implementazione dell'interfaccia Service
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class ServiceManagement implements Service {
	
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
		String Url = "https://app.ticketmaster.com/discovery/v2/events.json?&countryCode=" + countryCode + "&apikey="+ apikey;
		
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
	public Location getCountryEventsSelectedfromApi(String countryCode) {
		
		JSONObject countryEventsSelectedObject = getCountryEvents(countryCode);
		
		Location location = new Location(countryCode);
		
		location = getCountryfromApi(countryCode);
		
		JSONArray countryEventsArray = countryEventsSelectedObject.getJSONArray("events");  
		JSONObject object;
		
		Vector<Event> vector = new Vector<Event>(countryEventsArray.length());
			
		for (int i = 0; i < countryEventsArray.length(); i++) {
			
			Event event = new Event();
			
			object = countryEventsArray.getJSONObject(i);
			event.setName(object.getString("name"));
			event.setId(object.getString("id"));
			event.setUrl(object.getString("url"));
			event.setInfo(object.getString("info"));
			
			Date data = new Date();
			JSONArray datesArray = object.getJSONArray("dates");
			JSONObject datesObject = datesArray.getJSONObject(0);
			JSONArray startDateArray = datesObject.getJSONArray("start");
			JSONObject startDateObject = startDateArray.getJSONObject(0);
			data.setData(startDateObject.getString("localDate"));
			data.setOrario(startDateObject.getString("localTime"));
			event.setDate(data);
			
			Prices prices = new Prices();
			JSONArray pricesArray = object.getJSONArray("priceRanges");
			JSONObject pricesObject = pricesArray.getJSONObject(0);
			prices.setCurrency(pricesObject.getString("currency"));
			prices.setMaxPrice(pricesObject.getDouble("max"));
			prices.setMinPrice(pricesObject.getDouble("min"));
			event.setFeatures(prices);
			
			Genre genre = new Genre();
			JSONArray classificationsArray = object.getJSONArray("classifications");
			JSONObject classificationsObject = classificationsArray.getJSONObject(0);
			JSONArray segmentArray = classificationsObject.getJSONArray("segment");
			JSONObject segmentObject = segmentArray.getJSONObject(0);
			genre.setSegmentName(segmentObject.getString("name"));
			JSONArray genreArray = classificationsObject.getJSONArray("genre");
			JSONObject genreObject = genreArray.getJSONObject(0);
			genre.setGenreName(genreObject.getString("name"));
			JSONArray subGenreArray = classificationsObject.getJSONArray("subGenre");
			JSONObject subGenreObject = subGenreArray.getJSONObject(0);
			genre.setSubGenreName(subGenreObject.getString("name"));	
			event.setGenre(genre);

			}
						
		location.setEvento(vector);
		
		return location;
		
	}
	
	
	private Location getCountryfromApi(String countryCode) {
		
		JSONObject CountryObject = getCountryEvents(countryCode);
		
		Location location = new Location(countryCode);
		
			
			
	}
	

	public JSONObject getMarketEvents(int marketId) {
		
	}

	public Location getMarketEventsSelectedfromApi(int marketId) {
	}
	
	
	

}

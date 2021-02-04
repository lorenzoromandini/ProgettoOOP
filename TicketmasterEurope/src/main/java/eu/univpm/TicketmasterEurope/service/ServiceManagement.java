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
	public EventsArray getCountryEventsSelectedfromApi(String countryCode) {	
		
		JSONObject countryEventsSelectedObject = getCountryEvents(countryCode);
						
		/*
		Country country = new Country(countryCode);
		
		Location location = new Location(country);
		
		Event event = new Event(location);
		*/					
		EventsArray eventsArray = new EventsArray();		
		
		//JSONObject embeddedObject = countryEventsSelectedObject.getJSONObject("_embedded");
		JSONObject pageObject = countryEventsSelectedObject.getJSONObject("page");
		int totalPages = pageObject.getInt("totalPages");
		int totalElements = pageObject.getInt("totalElements");
		int totalSize = pageObject.getInt("size");
		//JSONArray countryEventsArray = embeddedObject.getJSONArray("events");
		//JSONObject object;
		
		Vector<Event> vector = new Vector<Event>(totalElements); 
		
		for(int j = 0; j < totalPages; j++) {
			
			JSONObject countryEventsObject;
			String Url = "https://app.ticketmaster.com/discovery/v2/events.json?&countryCode=" + countryCode + 
					"&page=" + j + "&apikey="+ apikey;
			
			RestTemplate restTemplate = new RestTemplate();
			
			countryEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
			
			JSONObject countryPage = countryEventsObject;
			
			JSONObject embeddedObjectX = countryPage.getJSONObject("_embedded");
			JSONArray countryEventsArray = embeddedObjectX.getJSONArray("events");
			
			while ((totalElements - (j*totalSize) >= 20)) {
		
		for (int i = 0; i < totalSize; i++) {
			
			Event evento = new Event();
			
			JSONObject object = countryEventsArray.getJSONObject(i);
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
			
			};
			
			if ((totalElements - (j*totalSize)) < 20) {
				
				for (int i = 0; i < (totalElements - (j*totalSize)); i++) {
					
					Event evento = new Event();
					
					JSONObject object = countryEventsArray.getJSONObject(i);
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
				
			}
		
		}
		
		eventsArray.setVector(vector);
		
		return eventsArray;
	}

	

/*
	public JSONObject getMarketEvents(String marketId) {
		
		JSONObject marketEventsObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events.json?&marketId=" + marketId + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		marketEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		return marketEventsObject;
		
	}
	*/

	/**
	 * Questo metodo utilizza getCountryEvents per andare a selezionare le informazioni desiderate relative ad un evento
	 * (id, nome, url, info, data, orario, valuta, prezzo minimo, prezzo massimo, tipologia, genere e sottogenere)
	 * @param countryCode - codice del paese in cui ha luogo l'evento
	 * @return Location location - oggetto contenente le informazioni desiderate dell'evento e il luogo in cui si svolge
	 */
	
	/*
	public EventsArray getMarketEventsSelectedfromApi(String marketId) {
		
		JSONObject marketEventsSelectedObject = getMarketEvents(marketId);
						
		Market market  = new Market(marketId);
		
		Location location = new Location(market);
		
		Event evento = new Event(location);
							
		EventsArray eventsArray = new EventsArray(evento);
		
		eventsArray = getMarketInfofromApi(marketId);
		
		
		JSONObject embeddedObject = marketEventsSelectedObject.getJSONObject("_embedded");
		JSONArray countryEventsArray = embeddedObject.getJSONArray("events");
		JSONObject object;
		
		Vector<Event> vector = new Vector<Event>(countryEventsArray.length()); 
					
		for (int i = 0; i < countryEventsArray.length(); i++) {
						
			Event event = new Event(location);
					
			object = countryEventsArray.getJSONObject(i);
			event.setName(object.getString("name"));
			event.setId(object.getString("id"));
			event.setUrl(object.getString("url"));
			event.setInfo(object.getString("info"));
			
			Date data = new Date();
			JSONObject datesObject = object.getJSONObject("dates");
			JSONObject startDateObject = datesObject.getJSONObject("start");
			data.setData(startDateObject.getString("localDate"));
			data.setOrario(startDateObject.getString("localTime"));
			event.setDate(data);
			
			Prices prices = new Prices();
			JSONArray pricesArray = object.getJSONArray("priceRanges");
			JSONObject pricesObject = pricesArray.getJSONObject(0);
			prices.setCurrency(pricesObject.getString("currency"));
			prices.setMaxPrice(pricesObject.getDouble("max"));
			prices.setMinPrice(pricesObject.getDouble("min"));
			event.setPrices(prices);
			
			Genre genre = new Genre();
			JSONArray classificationsArray = object.getJSONArray("classifications");
			JSONObject classificationsObject = classificationsArray.getJSONObject(0);
			JSONObject segmentObject = classificationsObject.getJSONObject("segment");
			genre.setSegmentName(segmentObject.getString("name"));
			JSONObject genreObject = classificationsObject.getJSONObject("genre");
			genre.setGenreName(genreObject.getString("name"));
			JSONObject subGenreObject = classificationsObject.getJSONObject("subGenre");
			genre.setSubGenreName(subGenreObject.getString("name"));	
			event.setGenre(genre);
			vector.add(event);

			}
		
		eventsArray.setVector(vector);
		 
		return eventsArray;
		
	}
	
	
	public EventsArray getMarketInfofromApi(String marketId) {
		
		JSONObject marketEventsObject = getMarketEvents(marketId);
		
		Market market = new Market(marketId);
		
		Location location = new Location(market);
		
		Event evento = new Event(location);
							
		EventsArray eventsArray = new EventsArray(evento);
		
		JSONObject embeddedObject = marketEventsObject.getJSONObject("_embedded");
		JSONArray eventsArrayParameter = embeddedObject.getJSONArray("events");
		
        Vector<Event> vector = new Vector<Event>(eventsArrayParameter.length()); 
	
		
		for(int i = 0; i < eventsArrayParameter.length(); i++) {
			
			JSONObject firstObject = eventsArrayParameter.getJSONObject(i);
		    JSONObject lowerEmbeddedObj = firstObject.getJSONObject("_embedded");
		    JSONArray venuesArray = lowerEmbeddedObj.getJSONArray("venues");
		    JSONObject lowerFirstObject = venuesArray.getJSONObject(0);
		    
		    Place placement = new Place();
		    placement.setPlacement(lowerFirstObject.getString("name"));
		    JSONObject addressObject = lowerFirstObject.getJSONObject("address");
		    JSONObject addressNameObject = addressObject.getJSONObject("line1");
		    placement.setAddress(addressNameObject.getString("line1"));
		    JSONObject cityObject = lowerFirstObject.getJSONObject("city");
		    JSONObject cityNameObject = cityObject.getJSONObject("name");
		    placement.setCity(cityNameObject.getString("name"));
		    location.setPlace(placement);
		    
		    Country country = new Country();
		    JSONObject countryObject = lowerFirstObject.getJSONObject("country");
		    JSONObject countryNameObject = countryObject.getJSONObject("name");
		    JSONObject countryCodeObject = countryObject.getJSONObject("countryCode");
		    country.setCountry(countryNameObject.getString("name"));
		    country.setCountryCode(countryCodeObject.getString("countryCode"));
		    location.setCountry(country);
		    
		    Market marketX = new Market();
		    JSONArray marketArray = lowerFirstObject.getJSONArray("markets");
		    JSONObject marketObject = marketArray.getJSONObject(0);
		    JSONObject marketNameObject = marketObject.getJSONObject("name");
		    JSONObject marketIdObject = marketObject.getJSONObject("Id");
		    marketX.setMarketName(marketNameObject.getString("name"));
		    marketX.setMarketId(marketIdObject.getString("id"));
		    location.setMarket(market);
		    
		    evento.setLocation(location);
		    
		    vector.add(evento);
		
		}
		
		eventsArray.setVector(vector);
		
		return eventsArray;
		
	}
	
	*/
	
	}


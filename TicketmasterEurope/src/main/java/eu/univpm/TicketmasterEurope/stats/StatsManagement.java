/**
 * 
 */
package eu.univpm.TicketmasterEurope.stats;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import eu.univpm.TicketmasterEurope.exception.VoidGetException;
import eu.univpm.TicketmasterEurope.exception.WrongCountryException;
import eu.univpm.TicketmasterEurope.exception.WrongValueException;
import eu.univpm.TicketmasterEurope.service.ID_Converter;


/** Questa classe è l'implementazione dell'interfaccia Stats
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
 
public class StatsManagement implements Stats {
	
	VoidGetException Exception = new VoidGetException();
	
	ID_Converter converter = new ID_Converter();
	
	private static LocalDate data = java.time.LocalDate.now();
			
	LocalDateTime now = LocalDateTime.now();
	
	int hour = now.getHour();
	int minute = now.getMinute();
	int second = now.getSecond();
	
	String time = "T" + hour + ":" + minute + ":" + second + "Z";
	
	/**
	 * apikey è la key necessaria per ottenere informazioni da Ticketmaster
	 */
	private String apikey = "GP6psuWJBWvDCvq13mLNVDY3ktVMdHRI";
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il codice di tale paese
	 * 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @param period indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un paese in un determinato periodo 
	 * e tutte le relative informazioni
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
	public JSONObject getCountryEvents(String countryCode, int period) throws WrongCountryException {
		
		Exception.countryStringException(countryCode);

        JSONObject countryEventsObject;
		
        String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode=" + countryCode 
                   + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		countryEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = countryEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("totalEvents", totalElements);

		return object;
		
	}
	
	
	public JSONObject getMarketEvents(String marketId, int period) throws WrongValueException {
		
		Exception.marketStringException(marketId);

		JSONObject marketEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&marketId=" + marketId 
				   + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		marketEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = marketEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("market", marketId);
		object.put("totalEvents", totalElements);

		return object;

	}
	
	
   public JSONObject getSegmentEvents(String countryCode, String segment, int period) throws WrongCountryException, WrongValueException {
	   
	   Exception.countryStringException(countryCode);
	   Exception.segmentStringException(segment);
	   	   	   		
		JSONObject segmentEventsObject;
					
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
	              + countryCode + "&segmentName="+ segment + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
	   
		RestTemplate restTemplate = new RestTemplate();
		
		segmentEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = segmentEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("segment", segment);
		object.put("totalEvents", totalElements);

		return object;
		
	}
	
	
	public JSONObject getGenreEvents(String countryCode, String genre, int period) throws WrongCountryException, WrongValueException {
		
		Exception.countryStringException(countryCode);
		Exception.genreStringException(genre);
		
		String genreId = converter.genreIdConverter(genre);
		
		JSONObject genreEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
		              + countryCode + "&genreId="+ genreId + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		genreEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = genreEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("genre", genre);
		object.put("totalEvents", totalElements);

		return object;

	}


	public JSONObject getSubGenreEvents(String countryCode, String subGenre, int period) throws WrongCountryException, WrongValueException {
		
		Exception.countryStringException(countryCode);
		Exception.subgenreStringException(subGenre);

        String subGenreId = converter.subGenreIdConverter(subGenre);

		JSONObject subGenreEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
		              + countryCode + "&subGenreId="+ subGenreId + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		subGenreEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = subGenreEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("subgenre", subGenre);
		object.put("totalEvents", totalElements);

		return object;
		
	}
	
	
    public JSONObject getSourceEvents(String countryCode, String source, int period) throws WrongCountryException, WrongValueException {
    	
    	Exception.countryStringException(countryCode);
    	Exception.sourceStringException(source);
		
		JSONObject sourceEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
	              + countryCode + "&source="+ source + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		sourceEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = sourceEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("source", source);
		object.put("totalEvents", totalElements);

		return object;
		
	}
    
}


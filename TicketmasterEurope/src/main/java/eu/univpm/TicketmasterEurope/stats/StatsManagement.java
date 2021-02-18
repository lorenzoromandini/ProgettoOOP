/**
 * 
 */
package eu.univpm.TicketmasterEurope.stats;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
	
	LocalDateTime data = LocalDateTime.now();

	/**
	 * apikey è la key necessaria per ottenere informazioni da Ticketmaster
	 */
	private String apikey = "GP6psuWJBWvDCvq13mLNVDY3ktVMdHRI";
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il codice di tale paese e in base al periodo scelto
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
        
        data = data.truncatedTo(ChronoUnit.SECONDS);
		
        String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode=" + countryCode 
                   + "&endDateTime=" + data.plusMonths(period) + "Z&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		countryEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = countryEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("totalEvents", totalElements);

		return object;
		
	}
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un market tramite il suo codice e in base al periodo scelto
	 * 
	 * @param marketId codice del market in cui ha luogo l'evento
	 * @param period indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un market in un dato periodo e 
	 * tutte le relative informazioni
	 * @throws WrongValueException se viene inserito un market non ammesso
	 */
	public JSONObject getMarketEvents(String marketId, int period) throws WrongValueException {
		
		Exception.marketStringException(marketId);

		JSONObject marketEventsObject;
		
        data = data.truncatedTo(ChronoUnit.SECONDS);
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&marketId=" + marketId 
				   + "&endDateTime=" + data.plusMonths(period) + "Z&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		marketEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = marketEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("market", marketId);
		object.put("totalEvents", totalElements);

		return object;

	}
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il suo codice e li filtra in base 
	 * alla tipologia scelta e al periodo indicato
	 * 
	 * @param segment tipologia di evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @param period indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un paese e in base alla tipologia desiderata, 
	 * con tutte le relative informazioni	 
	 * @throws WrongValueException se viene inserita una tipologia di evento non ammessa
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
   public JSONObject getSegmentEvents(String countryCode, String segment, int period) throws WrongCountryException, WrongValueException {
	   
	    Exception.countryStringException(countryCode);
	    Exception.segmentStringException(segment);
	   	   	   		
		JSONObject segmentEventsObject;
		
        data = data.truncatedTo(ChronoUnit.SECONDS);
        
        String segmentIndex;
        
    	if (segment.equals("Arts")) {
    		
    		segment = "KZFzniwnSyZfZ7v7na";
    		segmentIndex = "segmentId";
    		
    	}
    	
    	else segmentIndex = "segmentName";
					
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
	              + countryCode + "&" + segmentIndex + "=" + segment + "&endDateTime=" + data.plusMonths(period) + "Z&apikey="+ apikey;
	   
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
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il suo codice e li filtra in base 
	 * al genere scelto e al periodo indicato
	 * 
	 * @param genre genere di evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @param period indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un paese e in base al genere desiderato, 
	 * con tutte le relative informazioni	 
	 * @throws WrongValueException se viene inserito un genere di evento non ammesso
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
	public JSONObject getGenreEvents(String countryCode, String genre, int period) throws WrongCountryException, WrongValueException {
		
		Exception.countryStringException(countryCode);
		Exception.genreStringException(genre);
		
		String genreId = converter.genreIdConverter(genre);
		
		JSONObject genreEventsObject;
		
        data = data.truncatedTo(ChronoUnit.SECONDS);
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
		              + countryCode + "&genreId="+ genreId + "&endDateTime=" + data.plusMonths(period) + "Z&apikey="+ apikey;
		
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


	/** Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il suo codice e li filtra in base 
	 * al sottogenere scelto e al periodo indicato
	 * 
	 * @param subGenre sottogenere di evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @param period indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un paese e in base al sottogenere desiderato, 
	 * con tutte le relative informazioni	 
	 * @throws WrongValueException se viene inserito un sottogenere di evento non ammesso
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
	public JSONObject getSubGenreEvents(String countryCode, String subGenre, int period) throws WrongCountryException, WrongValueException {
		
		Exception.countryStringException(countryCode);
		Exception.subgenreStringException(subGenre);

        String subGenreId = converter.subGenreIdConverter(subGenre);

		JSONObject subGenreEventsObject;
		
        data = data.truncatedTo(ChronoUnit.SECONDS);
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
		              + countryCode + "&subGenreId="+ subGenreId + "&endDateTime=" + data.plusMonths(period) + "Z&apikey="+ apikey;
		
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
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il suo codice e li filtra in base 
	 * al distributore scelto e al periodo indicato
	 * 
	 * @param source distributore dei biglietti dell'evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @param period indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un paese e in base al distributore desiderato, 
	 * con tutte le relative informazioni	 
	 * @throws WrongValueException se viene inserito un distributore non ammesso
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
    public JSONObject getSourceEvents(String countryCode, String source, int period) throws WrongCountryException, WrongValueException {
    	
    	Exception.countryStringException(countryCode);
    	Exception.sourceStringException(source);
		
		JSONObject sourceEventsObject;
		
        data = data.truncatedTo(ChronoUnit.SECONDS);
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
	              + countryCode + "&source="+ source + "&endDateTime=" + data.plusMonths(period) + "Z&apikey="+ apikey;
		
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

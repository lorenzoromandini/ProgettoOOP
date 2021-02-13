/**
 * 
 */
package eu.univpm.TicketmasterEurope.service;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import eu.univpm.TicketmasterEurope.exception.VoidGetException;
import eu.univpm.TicketmasterEurope.exception.WrongCountryException;
import eu.univpm.TicketmasterEurope.exception.WrongValueException;
import eu.univpm.TicketmasterEurope.model.*;


/** Questa classe implementa l'interfaccia Service
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class ServiceManagement implements Service {
	
	VoidGetException Exception = new VoidGetException();
	
	ID_Converter converter = new ID_Converter();
	
	ServiceEventsInformations events = new ServiceEventsInformations();
	
	/**
	 * apikey è la key necessaria per ottenere informazioni da Ticketmaster
	 */
	private String apikey = "GP6psuWJBWvDCvq13mLNVDY3ktVMdHRI";
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il codice di tale paese
	 * 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un paese e tutte le relative informazioni
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
	public JSONObject getCountryEvents(String countryCode) throws WrongCountryException {
		
		Exception.countryStringException(countryCode);
						
		JSONObject countryEventsObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events?size=200&sort=date,asc&countryCode="
		              + countryCode + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		countryEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		return countryEventsObject; 
	}

	
	/** Questo metodo utilizza getCountryEvents per andare a selezionare le informazioni desiderate relative ad un evento
	 * (id, nome, url, source, info, data, orario, valuta, paese, città, indirizzo, placement, market, prezzo minimo, prezzo massimo, 
	 * tipologia, genere, sottogenere, eventi mostrati, eventi totali)
	 * 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return un vettore di eventi contenente le informazioni desiderate degli eventi che hanno luogo nel paese indicato
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
	public EventsArray getCountryEventsSelectedfromApi(String countryCode) throws WrongCountryException {	
						
		JSONObject countryEventsSelectedObject = getCountryEvents(countryCode);
		
		return events.getServiceEventsInformations(countryEventsSelectedObject);
				
	}
									
		
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un market tramite il codice di tale market
	 * 
	 * @param marketId codice del market in cui ha luogo l'evento
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un market e tutte le relative informazioni	 
	 * @throws WrongValueException se viene inserito un market non ammesso
	 */
    public JSONObject getMarketEvents(String marketId) throws WrongValueException {
    	
    	Exception.marketStringException(marketId);
		
		JSONObject marketEventsObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events?size=200&sort=date,asc&marketId="
		              + marketId + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		marketEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		return marketEventsObject; 	
	}

    
	/** Questo metodo utilizza getMarketEvents per andare a selezionare le informazioni desiderate relative ad un evento
	 * (id, nome, url, source, info, data, orario, valuta, paese, città, indirizzo, placement, market, prezzo minimo, prezzo massimo, 
	 * tipologia, genere, sottogenere, eventi mostrati, eventi totali)
	 * 
	 * @param marketId codice del market in cui ha luogo l'evento
	 * @return un vettore di eventi contenente le informazioni desiderate degli eventi che hanno luogo nel market indicato
	 * @throws WrongValueException se viene inserito un market non ammesso
	 */
	public EventsArray getMarketEventsSelectedfromApi(String marketId) throws WrongValueException {	
		
		JSONObject marketEventsSelectedObject = getMarketEvents(marketId);
									
		return events.getServiceEventsInformations(marketEventsSelectedObject);

	}
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il suo codice e li filtra in base 
	 * alla tipologia scelta
	 * 
	 * @param segment tipologia di evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un paese e in base alla tipologia desiderata, 
	 * con tutte le relative informazioni	 
	 * @throws WrongValueException se viene inserita una tipologia di evento non ammessa
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
    public JSONObject getSegmentEvents(String segment, String countryCode) throws WrongValueException, WrongCountryException {
    	 
    	 Exception.countryStringException(countryCode);
    	 Exception.segmentStringException(segment);
		
		JSONObject segmentEventsObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events?size=200&sort=date,asc&segmentName="
		              + segment + "&countryCode=" + countryCode + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		segmentEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		return segmentEventsObject; 
	}
     
     
	/** Questo metodo utilizza getMarketEvents per andare a selezionare le informazioni desiderate relative ad un evento
	 * (id, nome, url, source, info, data, orario, valuta, paese, città, indirizzo, placement, market, prezzo minimo, prezzo massimo, 
	 * tipologia, genere, sottogenere, eventi mostrati, eventi totali)
	 * 
	 * @param segment tipologia di evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return un vettore di eventi contenente le informazioni desiderate degli eventi che hanno luogo nel paese indicato e
	 * in base alla tipologia di evento scelta
	 * @throws WrongValueException se viene inserita una tipologia di evento non ammessa
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
	public EventsArray getSegmentEventsSelectedfromApi(String segment, String countryCode) throws WrongValueException, WrongCountryException {	
		
		JSONObject segmentEventsSelectedObject = getSegmentEvents(segment, countryCode);
		
		return events.getServiceEventsInformations(segmentEventsSelectedObject);

	}
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il suo codice e li filtra in base 
	 * al genere scelto
	 * 
	 * @param genre genere di evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un paese e in base al genere desiderato, 
	 * con tutte le relative informazioni	 
	 * @throws WrongValueException se viene inserito un genere di evento non ammesso
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
    public JSONObject getGenreEvents(String genre, String countryCode) throws WrongValueException, WrongCountryException {
   	 
   	 Exception.countryStringException(countryCode);
   	 Exception.genreStringException(genre);
   	 
   	 String genreId = converter.genreIdConverter(genre);
		
		JSONObject genreEventsObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events?size=200&sort=date,asc&genreId="
		              + genreId + "&countryCode=" + countryCode + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		genreEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		return genreEventsObject; 
	}
    
    
	/** Questo metodo utilizza getGenreEvents per andare a selezionare le informazioni desiderate relative ad un evento
	 * (id, nome, url, source, info, data, orario, valuta, paese, città, indirizzo, placement, market, prezzo minimo, prezzo massimo, 
	 * tipologia, genere, sottogenere, eventi mostrati, eventi totali)
	 * 
	 * @param genre genere di evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return un vettore di eventi contenente le informazioni desiderate degli eventi che hanno luogo nel paese indicato e
	 * in base al genere di evento scelto
	 * @throws WrongValueException se viene inserito un genere di evento non ammesso
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
	public EventsArray getGenreEventsSelectedfromApi(String genre, String countryCode) throws WrongValueException, WrongCountryException {	
		
		JSONObject genreEventsSelectedObject = getSourceEvents(genre, countryCode);
									
		return events.getServiceEventsInformations(genreEventsSelectedObject);

	}
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il suo codice e li filtra in base 
	 * al sottogenere scelto
	 * 
	 * @param subGenre sottogenere di evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un paese e in base al sottogenere desiderato, 
	 * con tutte le relative informazioni	 
	 * @throws WrongValueException se viene inserito un sottogenere di evento non ammesso
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
    public JSONObject getSubGenreEvents(String subGenre, String countryCode) throws WrongValueException, WrongCountryException {
   	 
   	 Exception.countryStringException(countryCode);
   	 Exception.subgenreStringException(subGenre);
   	 
   	 String subGenreId = converter.subGenreIdConverter(subGenre);
		
		JSONObject subGenreEventsObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events?size=200&sort=date,asc&subGenreId="
		              + subGenreId + "&countryCode=" + countryCode + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		subGenreEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		return subGenreEventsObject; 
	}
    
    
	/** Questo metodo utilizza getSubGenreEvents per andare a selezionare le informazioni desiderate relative ad un evento
	 * (id, nome, url, source, info, data, orario, valuta, paese, città, indirizzo, placement, market, prezzo minimo, prezzo massimo, 
	 * tipologia, genere, sottogenere, eventi mostrati, eventi totali)
	 * 
	 * @param subGenre sottogenere di evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return un vettore di eventi contenente le informazioni desiderate degli eventi che hanno luogo nel paese indicato e
	 * in base al sottogenere di evento scelto
	 * @throws WrongValueException se viene inserito un sottogenere di evento non ammesso
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
	public EventsArray getSubGenreEventsSelectedfromApi(String subGenre, String countryCode) throws WrongValueException, WrongCountryException {	
		
		JSONObject subGenreEventsSelectedObject = getSubGenreEvents(subGenre, countryCode);
		
		return events.getServiceEventsInformations(subGenreEventsSelectedObject);

	}
	
	
	/** Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il suo codice e li filtra in base 
	 * al distributore scelto
	 * 
	 * @param source distributore dei biglietti dell'evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return un JSONObject contenente tutti gli eventi che si svolgono in un paese e in base al distributore desiderato, 
	 * con tutte le relative informazioni	 
	 * @throws WrongValueException se viene inserito un distributore non ammesso
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
    public JSONObject getSourceEvents(String source, String countryCode) throws WrongValueException, WrongCountryException {
   	 
   	 Exception.countryStringException(countryCode);
   	 Exception.sourceStringException(source);
		
		JSONObject sourceEventsObject;
		String Url = "https://app.ticketmaster.com/discovery/v2/events?size=200&sort=date,asc&source="
		              + source + "&countryCode=" + countryCode + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		sourceEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		return sourceEventsObject; 
	}
    
    
	/** Questo metodo utilizza getSourceEvents per andare a selezionare le informazioni desiderate relative ad un evento
	 * (id, nome, url, source, info, data, orario, valuta, paese, città, indirizzo, placement, market, prezzo minimo, prezzo massimo, 
	 * tipologia, genere, sottogenere, eventi mostrati, eventi totali)
	 * 
	 * @param source distributore di biglietti dell'evento 
	 * @param countryCode codice del paese in cui ha luogo l'evento
	 * @return un vettore di eventi contenente le informazioni desiderate degli eventi che hanno luogo nel paese indicato e
	 * in base al distributore di biglietti scelto
	 * @throws WrongValueException se viene inserito un distributore non ammesso
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
	public EventsArray getSourceEventsSelectedfromApi(String source, String countryCode) throws WrongValueException, WrongCountryException {	
		
		JSONObject sourceEventsSelectedObject = getSourceEvents(source, countryCode);
		
		return events.getServiceEventsInformations(sourceEventsSelectedObject);

	}

	
	

}
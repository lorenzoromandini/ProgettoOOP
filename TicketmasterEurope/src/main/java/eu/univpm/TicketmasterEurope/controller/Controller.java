/**
 * 
 */
package eu.univpm.TicketmasterEurope.controller;

import java.io.IOException;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.univpm.TicketmasterEurope.service.JSON_Converter;
import eu.univpm.TicketmasterEurope.stats.EuroCountries;
import eu.univpm.TicketmasterEurope.service.*;
import eu.univpm.TicketmasterEurope.exception.*;
import eu.univpm.TicketmasterEurope.filters.Filter;
import eu.univpm.TicketmasterEurope.model.*;
import eu.univpm.TicketmasterEurope.saves.SaveRelevantEvents;


/** Questa classe gestisce tutte le chiamate al server che il client può effettuare
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */

@RestController

public class Controller {
	
	Service service = new ServiceManagement();
	
	VoidGetException Exception = new VoidGetException();
	
	
	/** Rotta di tipo GET che mostra gli eventi che hanno luogo nel paese scelto dall'utente,
	 * con le proprie caratteristiche selezionate dallo sviluppatore 
	 * 
	 * @param countryCode rappresenta il codice del paese di cui si vogliono visualizzare gli eventi (sono ammessi solo codici di paesi europei)
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo (la lista dei codici ammessi è disponibile nel file "Codes and Names")
	 */
	@GetMapping(value = "/countryEvents") 
	public ResponseEntity<Object> getCountryEvent(@RequestParam String countryCode) throws WrongCountryException {
		
		EventsArray eventsArray = service.getCountryEventsSelectedfromApi(countryCode);
		
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
		
	    }
	
	
	/** Rotta di tipo GET che mostra gli eventi che hanno luogo nel market scelto dall'utente, 
	 * con le proprie caratteristiche selezionate dallo sviluppatore 
	 * 
	 * @param marketId rappresenta il codice del market di cui si vogliono visualizzare gli eventi (sono ammessi solo codici di market europei)
	 * @return gli eventi in ordine cronologico che hanno luogo nel market scelto
	 * @throws WrongValueException se viene inserito il codice di un market non europeo (la lista dei codici ammessi è disponibile nel file "Codes and Names")
	 */
	@GetMapping(value = "/marketEvents") 
	public ResponseEntity<Object> getMarketEvent(@RequestParam String marketId) throws WrongValueException {
		
        EventsArray eventsArray = service.getMarketEventsSelectedfromApi(marketId);	
        
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }
	
	
	/** Rotta di tipo GET che mostra gli eventi che hanno luogo nel paese e della tipologia scelti dall'utente, 
	 * con le proprie caratteristiche selezionate dallo sviluppatore 
	 * 
	 * @param segment tipologia di evento (le tipologie in cui si suddividono gli eventi sono: "Arts & Theatre", "Miscellaneous", "Music" e "Sports")
	 * @param countryCode countryCode rappresenta il codice del paese di cui si vogliono visualizzare gli eventi (sono ammessi solo codici di paesi europei)
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto e della tipologia desiderata
	 * @throws WrongValueException se viene inserita una tipologia di evento non ammessa
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo (la lista dei codici ammessi è disponibile nel file "Codes and Names")
	 */
	@GetMapping(value = "/segmentCountryEvents") 
	public ResponseEntity<Object> getSegmentEvent(@RequestParam String segment, String countryCode) throws WrongValueException, WrongCountryException {
		
        EventsArray eventsArray = service.getSegmentEventsSelectedfromApi(segment, countryCode);	
        
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	
    }
	
	
	/** Rotta di tipo GET che mostra gli eventi che hanno luogo nel paese e del genere scelti dall'utente, 
	 * con le proprie caratteristiche selezionate dallo sviluppatore 
	 * 
	 * @param genre genere di evento (la lista dei generi ammessi è disponibile nel file "Codes and Names")
	 * @param countryCode countryCode rappresenta il codice del paese di cui si vogliono visualizzare gli eventi (sono ammessi solo codici di paesi europei)
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto e del genere desiderato
	 * @throws WrongValueException se viene inserito un genere di evento non ammesso (la lista dei generi ammessi è disponibile nel file "Codes and Names")
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo (la lista dei codici ammessi è disponibile nel file "Codes and Names")
	 */
	@GetMapping(value = "/genreCountryEvents") 
	public ResponseEntity<Object> getGenreEvent(@RequestParam String genre, String countryCode) throws WrongValueException, WrongCountryException {
		
        EventsArray eventsArray = service.getGenreEventsSelectedfromApi(genre, countryCode);
        
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	
    }
	
	
	/** Rotta di tipo GET che mostra gli eventi che hanno luogo nel paese e del sottogenere scelti dall'utente, 
	 * con le proprie caratteristiche selezionate dallo sviluppatore 
	 * 
	 * @param subgenre sottogenere di evento (la lista dei sottogeneri ammessi è disponibile nel file "Codes and Names")
	 * @param countryCode countryCode rappresenta il codice del paese di cui si vogliono visualizzare gli eventi (sono ammessi solo codici di paesi europei)
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto e del sottogenere desiderato
	 * @throws WrongValueException se viene inserito un sottogenere di evento non ammesso (la lista dei generi ammessi è disponibile nel file "Codes and Names")
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo (la lista dei codici ammessi è disponibile nel file "Codes and Names")
	 */
	@GetMapping(value = "/subgenreCountryEvents") 
	public ResponseEntity<Object> getSubGenreEvent(@RequestParam String subgenre, String countryCode) throws WrongValueException, WrongCountryException {
		
        EventsArray eventsArray = service.getSubGenreEventsSelectedfromApi(subgenre, countryCode);	
        
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	
    }
	
	
	/** Rotta di tipo GET che mostra gli eventi che hanno luogo nel paese e del distributore scelti dall'utente, 
	 * con le proprie caratteristiche selezionate dallo sviluppatore 
	 * 
	 * @param source distributore dei biglietti dell'evento (i distributori dei biglietti degli eventi sono: "ticketmaster", "universe", "frontgate" e "tmr")
	 * @param countryCode countryCode rappresenta il codice del paese di cui si vogliono visualizzare gli eventi (sono ammessi solo codici di paesi europei)
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto e del distributore desiderato
	 * @throws WrongValueException se viene inserito un distributore non ammesso (i distributori dei biglietti degli eventi sono: "ticketmaster", "universe", "frontgate" e "tmr")
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo (la lista dei codici ammessi è disponibile nel file "Codes and Names")
	 */
	@GetMapping(value = "/sourceCountryEvents") 
	public ResponseEntity<Object> getSourceEvent(@RequestParam String source, String countryCode) throws WrongValueException, WrongCountryException {
		
        EventsArray eventsArray = service.getSourceEventsSelectedfromApi(source, countryCode);		
        
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	
    }
	
	/** Rotta di tipo GET che mostra gli eventi che hanno luogo nel paese scelto tramite la parola chiave inserita dall'utente,
	 * con le proprie caratteristiche selezionate dallo sviluppatore 
	 * 
	 * @param keyword parola chiave
	 * @param countryCode countryCode rappresenta il codice del paese di cui si vogliono visualizzare gli eventi (sono ammessi solo codici di paesi europei)
	 * @return gli eventi in ordine cronologico che hanno luogo nel paese scelto tramite la parola chiave inserita
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo (la lista dei codici ammessi è disponibile nel file "Codes and Names")
	 */
	@GetMapping(value = "/keywordCountryEvents") 
	public ResponseEntity<Object> getKeywordEvent(@RequestParam String keyword, String countryCode) throws WrongCountryException {
		
        EventsArray eventsArray = service.getKeywordEventsSelectedfromApi(keyword, countryCode);		
        
		JSONObject obj = new JSONObject();
		JSON_Converter jsonconverter = new JSON_Converter();
		
		obj = jsonconverter.JSON_converter(eventsArray);
		
		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	
    }
	
	
	/** Rotta di tipo POST che filtra gli eventi in base alle richieste dell'utente
	 * 
	 * L'utente deve inserire un JSONObject del tipo riportato nei seguenti esempi:
	 * 
	 * {
	 *     "comparison": "country",
     *     "elements": [
     *        {
     *          "name": "GB"
     *        },
     *        {
     *          "name": "DE"
     *        },
     *        {
     *          "name": "FR"
     *        }
     *      ],
     *     "param": "segment",
     *     "value": "Sports",
     *     "period": 6
     *  }
     *  
     *  - oppure - 
     *  
     *  {
	 *     "comparison": "segment",
     *     "elements": [
     *        {
     *          "name": "Sports"
     *        },
     *        {
     *          "name": "Music"
     *      ],
     *     "param": "country",
     *     "value": "ES",
     *     "period": 3
     *  }
     *  
     * PARAM - comparison: rappresenta che tipo di elementi si vogliono confrontare tra loro: si possono confrontare tra loro country,
     * market, segment, genre, subGenre o source.
     * PARAM elements: sono gli elementi che si vogliono confrontare. 
     * PARAM - param: rappresenta il parametro su cui si vuole effettuare il confronto (è uno tra segment, genre, subGenre, source, country o market; 
     * nel caso in cui comparison sia country oppure market, allora param può assumere il valore total ad indicare la scelta di
     * voler conoscere il numero totale di eventi; nel caso in cui comparison non sia né country né market, allora param può assumere
     * solamente il valore country).
     * PARAM - value: rappresenta il valore del parametro su cui si vuole effettuare il confronto.
	 * PARAM - period: indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto (può essere un 
	 * valore tra 1, 3, 6 oppure 12).
     *  	 
	 * @param body è un JSONObject del tipo riportato sopra
	 * @return un JSONArray di JSONObject che mostrano i vari elements con il relativo numero di eventi e infine quali tra
	 * questi presentano il maggiore ed il minor numero di eventi
	 * @throws WrongComparisonException se viene inserito un comparison diverso da country, market, source, segment, genre o subgenre
	 * @throws WrongPeriodException se il periodo inserito non è uno tra 1, 3, 6 o 12
	 * @throws WrongParameterException se il parametro inserito non è uno tra country, segment, genre, subGenre, source
	 * @throws WrongValueException se viene inserito un valore di param non ammesso
	 */
	@PostMapping(value = "/filters")
	public ResponseEntity<Object> filters(@RequestBody String body) throws WrongComparisonException, WrongPeriodException, WrongValueException, WrongParameterException {
		
		JSONObject object = new JSONObject(body);
        JSONArray array = new JSONArray();
        
        EuroCountries countries = new EuroCountries();
        
        String comparison = object.getString("comparison");
        
        array = object.getJSONArray("elements");
        
        Vector<String> elements = new Vector<String>(array.length());
        
        for(int i = 0; i < array.length(); i++) {
        	
            JSONObject obj = new JSONObject();
            obj = array.getJSONObject(i);
            elements.add(obj.getString("name"));
            
        }
        
        String param = object.getString("param");
        String value = object.getString("value"); 
        int period = object.getInt("period");
        
        if (comparison.equals("country") && param.equals("total") && value.equals("all"))
        	elements = countries.getEuroCountries();
		
        Filter filter = new Filter(comparison, elements, param, value, period);
		
		try {
        	return new ResponseEntity<>(filter.getFilter().toString(),HttpStatus.OK);
        }
		catch(WrongComparisonException e) {
        	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
		catch(WrongPeriodException e) {
	        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	    }
		catch(WrongValueException e) {
        	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
		catch(WrongParameterException e) {
        	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);	
        } 
		catch (WrongCountryException e) {
        	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);	
		}
		
		
	}
	
	
	/** Rotta di tipo GET che salva gli eventi che hanno luogo nel paese inserito dall'utente
	 * 
	 * @param countryCode countryCode rappresenta il codice del paese di cui si vogliono visualizzare gli eventi (sono ammessi solo codici di paesi europei)
	 * @return gli eventi che hanno luogo nel paese inserito dall'utente
	 * @throws IOException se si verificano errori di output su file
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo (la lista dei codici ammessi è disponibile nel file "Codes and Names")
	 */
	@GetMapping(value = "/saveEvents") 
	public ResponseEntity<Object> saveCountryEvents(@RequestParam String countryCode) throws IOException, WrongCountryException {
		
		SaveRelevantEvents save = new SaveRelevantEvents();
		
        String path = save.StoreCountryEvents(countryCode);
		
		return new ResponseEntity<>(path, HttpStatus.OK); 
		
    }
	
	
		
}
	

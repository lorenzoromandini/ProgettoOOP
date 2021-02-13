/**
 * 
 */
package eu.univpm.TicketmasterEurope.service;

import eu.univpm.TicketmasterEurope.exception.WrongCountryException;
import eu.univpm.TicketmasterEurope.exception.WrongValueException;
import eu.univpm.TicketmasterEurope.model.*;

import org.json.JSONObject;

/** Questa classe è l'interfaccia di ServiceManagement e contiene alcuni dei metodi richiamati dal Controller
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public interface Service {
	
	public abstract JSONObject getCountryEvents(String countryCode) throws WrongCountryException;
	public abstract EventsArray getCountryEventsSelectedfromApi(String contryCode) throws WrongCountryException;
	public abstract JSONObject getMarketEvents(String marketId) throws WrongValueException;
	public abstract EventsArray getMarketEventsSelectedfromApi(String marketId) throws WrongValueException;
	public abstract JSONObject getSourceEvents(String source, String countryCode) throws WrongValueException, WrongCountryException;
	public abstract EventsArray getSourceEventsSelectedfromApi(String source, String countryCode) throws WrongValueException, WrongCountryException;
	public abstract JSONObject getSegmentEvents(String segment, String countryCode) throws WrongValueException, WrongCountryException;
	public abstract EventsArray getSegmentEventsSelectedfromApi(String segment, String countryCode) throws WrongValueException, WrongCountryException;
	public abstract JSONObject getGenreEvents(String genre, String countryCode) throws WrongValueException, WrongCountryException;
	public abstract EventsArray getGenreEventsSelectedfromApi(String genre, String countryCode) throws WrongValueException, WrongCountryException;
	public abstract JSONObject getSubGenreEvents(String subGenre, String countryCode) throws WrongValueException, WrongCountryException;
	public abstract EventsArray getSubGenreEventsSelectedfromApi(String subgenre, String countryCode) throws WrongValueException, WrongCountryException;

}

/**
 * 
 */
package eu.univpm.TicketmasterEurope.stats;

import org.json.JSONObject;

import eu.univpm.TicketmasterEurope.exception.WrongCountryException;
import eu.univpm.TicketmasterEurope.exception.WrongValueException;


/** Questa classe è l'interfaccia di StatsManagement
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public interface Stats {
	
	public abstract JSONObject getCountryEvents(String countryCode, int period) throws WrongCountryException;
	public abstract JSONObject getMarketEvents(String marketId, int period) throws WrongCountryException, WrongValueException;
	public abstract JSONObject getSegmentEvents(String countryCode, String segment, int period) throws WrongValueException, WrongCountryException;
	public abstract JSONObject getGenreEvents(String countryCode, String genre, int period) throws WrongCountryException, WrongValueException;
	public abstract JSONObject getSubGenreEvents(String countryCode, String subGenre, int period) throws WrongCountryException, WrongValueException;
	public abstract JSONObject getSourceEvents(String countryCode, String source, int period) throws WrongCountryException, WrongValueException;

}
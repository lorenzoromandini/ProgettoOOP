/**
 * 
 */
package eu.univpm.TicketmasterEurope.stats;

import org.json.JSONObject;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public interface Stats {
	
	public abstract JSONObject getCountryEvents(String countryCode, int period);
	public abstract JSONObject getMarketEvents(String marketId, int period);
	public abstract JSONObject getSegmentEvents(String countryCode, String segment, int period);
	public abstract JSONObject getGenreEvents(String countryCode, String genre, int period);
	public abstract JSONObject getSubGenreEvents(String countryCode, String subGenre, int period);
	public abstract JSONObject getSourceEvents(String countryCode, String source, int period);

}
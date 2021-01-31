/**
 * 
 */
package eu.univpm.TicketmasterEurope.service;

import eu.univpm.TicketmasterEurope.model.*;

import org.json.JSONObject;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public interface Service {
	
	public abstract JSONObject getCountryEvents(String countryCode);
	public abstract JSONObject getMarketEvents(int marketId);
	public abstract Location getCountryEventsSelectedfromApi(String contryCode);
	public abstract Location getMarketEventsSelectedfromApi(int marketId);	
	

}

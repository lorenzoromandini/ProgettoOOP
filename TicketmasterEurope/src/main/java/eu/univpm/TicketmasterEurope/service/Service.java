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
	//public abstract JSONObject getMarketEvents(String marketId);
	public abstract EventsArray getCountryEventsSelectedfromApi(String contryCode);
	//public abstract EventsArray getMarketEventsSelectedfromApi(String marketId);	
	//public abstract EventsArray getMarketInfofromApi(String marketId);
	

}

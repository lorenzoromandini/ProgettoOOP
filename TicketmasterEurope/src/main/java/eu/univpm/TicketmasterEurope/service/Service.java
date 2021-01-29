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
	
	public abstract JSONObject getCountryEvents(String country);
	public abstract Location getCountryEventsfromApi(String country);	
	

}

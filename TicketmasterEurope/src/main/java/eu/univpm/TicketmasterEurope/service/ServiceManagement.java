/**
 * 
 */
package eu.univpm.TicketmasterEurope.service;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import eu.univpm.TicketmasterEurope.model.Location;

/**
 * @author loren
 *
 */
public class ServiceManagement implements Service {
	
	/**
	 * api_key è la key necessaria per ottenere informazioni da Ticketmaster
	 */
	private String api_key = "GP6psuWJBWvDCvq13mLNVDY3ktVMdHRI";
	
	/**
	 * Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il suo codice
	 * @param countryCode - codice del paese in cui ha luogo l'evento
	 * @return JSONObject object
	 */
	public JSONObject getCountryEvents(String countryCode) {
		
		JSONObject object;
		String url = "https://app.ticketmaster.com/discovery/v2/events.json?&countryCode=" + countryCode + "&apikey="+ api_key;
		
		RestTemplate restTemplate = new RestTemplate();
		
		object = new JSONObject(restTemplate.getForObject(url, String.class));
		
		return object;
		
	}

	public Location getCountryEventsSelectedfromApi(String countryCode) {

	}

	public JSONObject getMarketEvents(int marketId) {
		
	}

	public Location getMarketEventsSelectedfromApi(int marketId) {
	}
	
	
	

}

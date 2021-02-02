/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author loren
 *
 */
public class Country {
	
	/**
	 *  Indica lo stato dell'evento
	 */
	private String country;
	
	/**
	 *  Indica il codice dello stato dell'evento
	 */
	private String countryCode;
	
	
	/** Restituisce lo stato dell'evento
	 * @return country
	 */
	public String getCountry() {
		return country;
	}


	/** Setta lo stato dell'evento
	 * @param String country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}

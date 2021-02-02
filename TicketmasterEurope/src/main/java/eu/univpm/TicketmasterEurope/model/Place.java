/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author loren
 *
 */
public class Place {
	
	/**
	 *  Indica il luogo dell'evento
	 */
	private String placement;
	
	/**
	 *  Indica l'indirizzo dell'evento
	 */
	private String address;
	
	/**
	 *  Indica la città dell'evento
	 */
	private String city;
	
	
	/** Restituisce il luogo dell'evento
	 * @return placement
	 */
	public String getPlacement() {
		return placement;
	}


	/** Setta il luogo dell'eventp
	 * @param String placement
	 */
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	
	/** Resituisce l'indirizzo dell'evento
	 * @return address
	 */
	public String getAddress() {
		return address;
	}


	/** Setta l'indirizzo dell'evento
	 * @param String address
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/** Restituisce la città dell'evento
	 * @return city
	 */
	public String getCity() {
		return city;
	}


	/** Setta la città dell'evento
	 * @param String city
	 */
	public void setCity(String city) {
		this.city = city;
	}

}

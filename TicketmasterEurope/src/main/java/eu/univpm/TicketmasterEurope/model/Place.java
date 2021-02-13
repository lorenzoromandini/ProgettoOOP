/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/** Questa classe descrive il posto in cui si svolge l'evento
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class Place {
	
	/**
	 *  Indica il luogo fisico dell'evento
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
	
	
	/** Costruttore della classe
	 */
	public Place() {
		this.address = null;
		this.city = null;
		this.placement = null;
	}
	
	
	/** Restituisce il luogo fisico dell'evento
	 * @return il luogo fisico dell'evento
	 */
	public String getPlacement() {
		return placement;
	}


	/** Setta il luogo fisico dell'evento
	 * @param placement luogo fisico dell'evento
	 */
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	
	/** Resituisce l'indirizzo dell'evento
	 * @return l'indirizzo dell'evento
	 */
	public String getAddress() {
		return address;
	}


	/** Setta l'indirizzo dell'evento
	 * @param address indirizzo dell'evento
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/** Restituisce la città dell'evento
	 * @return la città dell'evento
	 */
	public String getCity() {
		return city;
	}


	/** Setta la città dell'evento
	 * @param city città dell'evento
	 */
	public void setCity(String city) {
		this.city = city;
	}

	
	/** Override del metodo toString
	 * @return stringa che rappresenta il posto in cui si svolge l'evento
	 */
	@Override
	public String toString() {
		return "placement=" + placement + ", address=" + address + ", city=" + city +"";
	}

	
	/** Override del metodo equals
	 * @param obj oggetto Place da confrontare
	 * @return true o false a seconda che i due oggetti siano uguali
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (placement == null) {
			if (other.placement != null)
				return false;
		} else if (!placement.equals(other.placement))
			return false;
		return true;
	}
	
	

}

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
	
	
	public Place() {
		super();
		}
	
	public Place(String city) {
		super();
		this.city = city;
		}
	
	public Place(String placement, String address) {
		super();
		this.placement = placement;
		this.address = address;
		}
	
	public Place(String placement, String address, String city) {
		super();
		this.placement = placement;
		this.address = address;
		this.city = city;
		}
	
	
	
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
	
	@Override
	public String toString() {
		return "Place [placement=" + placement + ", address=" + address + ", city=" + city +"]";
	}


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

/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

import java.util.Vector;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Location {
	
	private String placement;
	private String address;
	private String city;
	private String country;
	private String countrycode;
	private Vector<Event> evento = new Vector<Event>();
	
	
	public Location() {
		super();
		this.placement = null;
		this.address = null;
		this.city = null;
		this.country = null;
		this.countrycode = null;
	}


	/**
	 * @param placement
	 */
	public Location(String placement) {
		this.placement = placement;
		this.address = null;
		this.city = null;
		this.country = null;
		this.countrycode = null;
	}


	/**
	 * @param city
	 * @param countrycode
	 */
	public Location(String city, String countrycode) {
		this.placement = null;
		this.address = null;
		this.city = city; 
		this.country = null; 
		this.countrycode = countrycode;
	}


	/**
	 * @param address
	 * @param city
	 * @param country
	 */
	public Location(String address, String city, String countrycode) {
		this.placement = null;
		this.address = address;
		this.city = city;
		this.country = null;
		this.countrycode = countrycode;
	}


	/**
	 * @param placement
	 * @param address
	 * @param city
	 * @param country
	 * @param countrycode
	 */
	public Location(String placement, String address, String city, String country, String countrycode) {
		super();
		this.placement = placement;
		this.address = address;
		this.city = city;
		this.country = country;
		this.countrycode = countrycode;
	}


	/**
	 * @return the placement
	 */
	public String getPlacement() {
		return placement;
	}


	/**
	 * @param placement the placement to set
	 */
	public void setPlacement(String placement) {
		this.placement = placement;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	/**
	 * @return the countrycode
	 */
	public String getCountrycode() {
		return countrycode;
	}


	/**
	 * @param countrycode the countrycode to set
	 */
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	
	
	/**
     * Metodo che restituisce il vettore di event.
     * @return vector.
     */
	public Vector<Event> getVector() {
		return evento;
	}

	/**
     * Metodo che setta il vettore di event.
     * @param vettore di event.
     */
	public void setVector(Vector<Event> evento) {
		this.evento = evento;
	}
	
	/**
     * Metodo che scrive il vettore come una stringa.
     * @return String toReturn che rappresenta le informazioni essenziali relative all'evento.
     */
	public String toStringVector() {
		String toReturn = "";
		for (int i = 0; i < evento.size(); i++)
			toReturn += evento.get(i).toString();
		return toReturn;
	}

	/**
	 * Override del metodo toString.
	 * @return String che rappresenta la località e la sua ubicazione.
	 */
	@Override
	public String toString() {		
		return "placement = " + placement + ", address = " + address + ", city = " + city + ", country =" + country +
				", countrycode = " + countrycode + ", eventArray = " + toStringVector();
	}
	
	
	/**
	 * Override del metodo equals.
	 * @param oggetto Location da confrontare.
	 * @return true o false a seconda che i due oggetti siano uguali.
	 */
	@Override
	public boolean equals(Object obj) {		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (placement == null) {
			if (other.placement != null)
				return false;
		} else if (!placement.equals(other.placement))
			return false;
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
		if (country == null) {
			if (other.country != null)
				return false;
	   } else if (!country.equals(other.country))
			return false;
		if (countrycode == null) {
			if (other.countrycode != null)
				return false;
	   } else if (!countrycode.equals(other.countrycode))
			return false;
		return true;
	}
	
	

}

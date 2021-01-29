/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

import java.util.Vector;

/** Questa classe rappresenta le proprietà di ogni location e i relativi eventi che si svolgono in quel luogo.
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Location {
	
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
	
	/**
	 *  Indica lo stato dell'evento
	 */
	private String country;
	
	/**
	 *  Indica il codice dello stato dell'evento
	 */
	private String countrycode;
	
	/**
	 *  Vettore contentente le caratteristiche dei vari eventi che hanno luogo in una determinata location
	 */
	private Vector<Event> evento = new Vector<Event>();
	
	
	/**
	 * Costruttore dell'oggetto
	 */
	public Location() {
		this.placement = null;
		this.address = null;
		this.city = null;
		this.country = null;
		this.countrycode = null;
		//this.eventArray = null
	}


	/** Costruttore dell'oggetto
	 * @param placement - luogo dell'evento
	 */
	public Location(String placement) {
		this.placement = placement;
		this.address = null;
		this.city = null;
		this.country = null;
		this.countrycode = null;
		//this.eventArray = null
	}


	/** Costruttore dell'oggetto
	 * @param city - città dell'evento
	 * @param country - stato dell'evento
	 */
	public Location(String city, String country) {
		this.placement = null;
		this.address = null;
		this.city = city; 
		this.country = null; 
		this.country = country;
		//this.eventArray = null
	}


	/** Costruttore dell'oggetto
	 * @param address - indirizzo dell'evento
	 * @param city - città dell'evento
	 * @param country - stato dell'evento
	 */
	public Location(String address, String city, String country) {
		this.placement = null;
		this.address = address;
		this.city = city;
		this.country = null;
		this.country = country;
		//this.eventArray = null
	}


	/** Costruttore dell'oggetto
	 * @param placement - luogo dell'evento
	 * @param address - indirizzo dell'evento
	 * @param city - città dell'evento
	 * @param country - stato dell'evento
	 * @param countrycode - codice dello stato dell'evento
	 */
	public Location(String placement, String address, String city, String country, String countrycode) {
		this.placement = placement;
		this.address = address;
		this.city = city;
		this.country = country;
		this.countrycode = countrycode;
		//this.eventArray = null
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
	
	
	/** Restituisce il codice dello stato dell'evento
	 * @return countrycode
	 */
	public String getCountrycode() {
		return countrycode;
	}


	/** Setta il codice dello stato dell'evento
	 * @param String countrycode 
	 */
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	
	
	/** Restituisce il vettore di Event della location
     * @return vector
     */
	public Vector<Event> getVector() {
		return evento;
	}

	/** Setta il vettore di Event della location
     * @param Vector<Event> vector
     */
	public void setVector(Vector<Event> evento) {
		this.evento = evento;
	}
	
	/**
	 *  Scrive il vettore degli eventi come una stringa
     * @return String toReturn - rappresenta le informazioni relative all'evento.
     */
	public String toStringVector() {
		String toReturn = "";
		for (int i = 0; i < evento.size(); i++)
			toReturn += evento.get(i).toString();
		return toReturn;
	}

	/**
	 * Override del metodo toString.
	 * @return String - rappresenta la location e i suoi eventi
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

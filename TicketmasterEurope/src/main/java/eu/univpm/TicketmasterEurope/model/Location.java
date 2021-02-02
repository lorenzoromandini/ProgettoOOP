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
	
	private Place place;
	
	private Country country;
	
	private Market market;
	
	/**
	 *  Vettore contentente le caratteristiche dei vari eventi che hanno luogo in una determinata location
	 */
	private Vector<Event> evento = new Vector<Event>();
	

	/**
	 * 
	 */
	public Location() {
		super();
	}
	

	/**
	 * @param place
	 */
	public Location(Place place) {
		super();
		this.place = place;
	}


	/**
	 * @param country
	 */
	public Location(Country country) {
		super();
		this.country = country;
	}


	/**
	 * @param market
	 */
	public Location(Market market) {
		super();
		this.market = market;
	}


	/**
	 * @param evento
	 */
	public Location(Vector<Event> evento) {
		super();
		this.evento = evento;
	}


	/**
	 * @param place
	 * @param country
	 * @param market
	 * @param evento
	 */
	public Location(Place place, Country country, Market market, Vector<Event> evento) {
		super();
		this.place = place;
		this.country = country;
		this.market = market;
		this.evento = evento;
	}


	/**
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}


	/**
	 * @param place the place to set
	 */
	public void setPlace(Place place) {
		this.place = place;
	}


	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}


	/**
	 * @return the market
	 */
	public Market getMarket() {
		return market;
	}


	/**
	 * @param market the market to set
	 */
	public void setMarket(Market market) {
		this.market = market;
	}


	/** Restituisce il vettore di Event della location
     * @return evento
     */
	public Vector<Event> getEvento() {
		return evento;
	}

	/** Setta il vettore di Event della location
     * @param Vector<Event> evento
     */
	public void setEvento(Vector<Event> evento) {
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


	@Override
	public String toString() {
		return "Location [place=" + place + ", country=" + country + ", market=" + market + ", evento=" + toStringVector() + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (market == null) {
			if (other.market != null)
				return false;
		} else if (!market.equals(other.market))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}
	
}

	

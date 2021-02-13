/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/** Questa classe rappresenta le proprietà di ogni location in cui si svolge l'evento
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class Location {
	
	/**
	 * Oggetto di tipo Place
	 */
	private Place place;
	
	/**
	 * Oggetto di tipo Country
	 */
	private Country country;
	
	/**
	 * Oggetto di tipo Market
	 */
	private Market market;
	

	/** Costruttore della classe
	 */
	public Location() {
		this.place = null;
		this.country = null;
		this.market = null;
	}
	

	/** Restituisce il posto in cui si svolge l'evento
	 * @return il posto in cui si svolge l'evento
	 */
	public Place getPlace() {
		return place;
	}


	/** Setta il posto in cui si svolge l'evento
	 * @param place posto in cui si svolge l'evento
	 */
	public void setPlace(Place place) {
		this.place = place;
	}


	/** Restituisce il paese in cui si svolge l'evento
	 * @return il paese in cui si svolge l'evento
	 */
	public Country getCountry() {
		return country;
	}


	/** Setta il paese in cui si svolge l'evento
	 * @param country paese in cui si svolge l'evento
	 */
	public void setCountry(Country country) {
		this.country = country;
	}


	/** Restituisce il market in cui si svolge l'evento
	 * @return il market in cui si svolge l'evento
	 */
	public Market getMarket() {
		return market;
	}


	/** Setta il market in cui si svolge l'evento
	 * @param market market in cui si svolge l'evento
	 */
	public void setMarket(Market market) {
		this.market = market;
	}

	
	/** Override del metodo toString
	 * @return stringa che rappresenta posto, paese e market in cui si svolge l'evento
	 */
	@Override
	public String toString() {
		return "place=" + place + ", country=" + country + ", market=" + market + "";
	}


	/** Override del metodo equals
	 * @param obj oggetto Location da confrontare
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
		Location other = (Location) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
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

	

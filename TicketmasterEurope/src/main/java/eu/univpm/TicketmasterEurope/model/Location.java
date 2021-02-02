/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/** Questa classe rappresenta le proprietà di ogni location e i relativi eventi che si svolgono in quel luogo.
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Location {
	
	private Place place;
	
	private Country country;
	
	private Market market;
	

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
	 * @param place
	 * @param country
	 * @param market
	 * @param evento
	 */
	public Location(Place place, Country country, Market market) {
		this.place = place;
		this.country = country;
		this.market = market;
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


	@Override
	public String toString() {
		return "Location [place=" + place + ", country=" + country + ", market=" + market + "]";
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

	

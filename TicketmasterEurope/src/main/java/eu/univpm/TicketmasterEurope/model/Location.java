/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author loren
 *
 */
public class Location {
	
	private String placement;
	private String address;
	private String city;
	private String country;
	private String countrycode;
	
	
	public Location() {
		super();
	}


	/**
	 * @param placement
	 */
	public Location(String placement) {
		super();
		this.placement = placement;
	}


	/**
	 * @param city
	 * @param country
	 */
	public Location(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}


	/**
	 * @param address
	 * @param city
	 * @param country
	 */
	public Location(String address, String city, String country) {
		super();
		this.address = address;
		this.city = city;
		this.country = country;
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
	 * Override del metodo toString.
	 * @return String che rappresenta la città.
	 */
	@Override
	public String toString() {
		return "placement = " + placement + ", address = " + address + ", city = " + city +
				", country =" + country + ", countrycode = " + countrycode;
		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location loc = (Location) obj;
		if (placement == null) {
			if (loc.placement != null)
				return false;
		} else if (!placement.equals(loc.placement))
			return false;
		if (address == null) {
			if (loc.address != null)
				return false;
	} else if (!address.equals(loc.address))
			return false;
		if (city == null) {
			if (loc.city != null)
				return false;
		} else if (!city.equals(loc.city))
			return false;
		if (country == null) {
			if (loc.country != null)
				return false;
	   } else if (!country.equals(loc.country))
			return false;
		if (countrycode == null) {
			if (loc.countrycode != null)
				return false;
	   } else if (!countrycode.equals(loc.countrycode))
			return false;
		
		return true;
	}
	
	
	
	
	

	

}

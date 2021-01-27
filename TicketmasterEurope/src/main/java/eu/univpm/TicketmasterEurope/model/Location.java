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
	 */
	public Location(String placement, String address, String city, String country) {
		super();
		this.placement = placement;
		this.address = address;
		this.city = city;
		this.country = country;
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
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}

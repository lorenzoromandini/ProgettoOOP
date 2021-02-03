/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author loren
 *
 */
public class Country {
	
	/**
	 *  Indica lo stato dell'evento
	 */
	private String country;
	
	/**
	 *  Indica il codice dello stato dell'evento
	 */
	private String countryCode;
	
	
	public Country() {
		super();
		}
	
	public Country(String countryCode) {
		super();
		this.countryCode = countryCode;
	}
	
	public Country(String country, String countryCode) {
		super();
		this.country = country;
		this.countryCode = countryCode;
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

	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {  
		this.countryCode = countryCode;
	}
	
	@Override
	public String toString() {
		return "country=" + country + ", countryCode=" + countryCode + "";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		return true;
	}
	
}

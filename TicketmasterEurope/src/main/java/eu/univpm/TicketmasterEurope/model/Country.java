/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/** Questa classe implementa le infomazioni relative al paese in cui si svolge l'evento
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class Country {
	
	/**
	 *  Indica il paese in cui si svolge l'evento
	 */
	private String country;
	
	/**
	 *  Indica il codice del paese in cui si svolge l'evento
	 */
	private String countryCode;
	
	
	/** Costruttore della classe
	 */
	public Country() {
		this.country = null;
		this.countryCode = null;
		}
	
	
	/** Costruttore della classe
	 * @param countryCode codice del paese in cui si svolge l'evento
	 */
	public Country(String countryCode) {
		this.country = null;
		this.countryCode = countryCode;
	}
	
	
	/** Restituisce il paese in cui si svolge l'evento
	 * @return il paese in cui si svolge l'evento
	 */
	public String getCountry() {
		return country;
	}


	/** Setta il paese in cui si svolge l'evento
	 * @param country paese in cui si svolge l'evento
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	
	/** Restituisce il codice del paese in cui si svolge l'evento
	 * @return il codice del paese in cui si svolge l'evento
	 */
	public String getCountryCode() {
		return countryCode;
	}
	
	
	/** Setta il codice del paese in cui si svolge l'evento
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {  
		this.countryCode = countryCode;
	}
	
	
	/** Override del metodo toString
	 * @return stringa che rappresenta country e countryCode in cui si svolge l'evento
	 */
	@Override
	public String toString() {
		return "country=" + country + ", countryCode=" + countryCode + "";
	}

	
	/** Override del metodo equals
	 * @param obj oggetto Country da confrontare
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

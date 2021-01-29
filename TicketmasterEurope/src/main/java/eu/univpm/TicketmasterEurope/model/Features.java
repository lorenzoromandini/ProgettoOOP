/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Items {
	
	/**
	 *  Indica la valuta del biglietto
	 */
	
	private String currency;   		
	
	/**
	 *  Indica il prezzo minimo
	 */
	
	private double minPrince;   	
	
	/**
	 *  Indica il prezzo massimo
	 */
	
	private double maxPrice;    
	
	/**
	 *  Indica la piattaforma che si occupa della vendita dei biglietti
	 */
	
	private String source;
	
	
	/** Costruttore vuoto che imposta tutti i parametri a null
	 * @param currency
	 * @param minPrince
	 * @param maxPrice
	 * @param source
	 */
	public Items() {
		this.currency = null;
		this.minPrince = 0;
		this.maxPrice = 0;
		this.source = null;
		
	}
	

	/** Costruttore che imposta il parametro source e imposta gli altri parametri a null
	 * @param currency
	 * @param minPrince
	 * @param maxPrice
	 * @param source
	 * 
	 */
	public Items(String source) {
		this.currency = null;
		this.minPrince = 0;
		this.maxPrice = 0;
		this.source = source;
	}

	
	/** Costruttore che imposta il parametro minPrince e maxPrice e imposta gli altri parametri a null
	 * @param currency
	 * @param minPrince
	 * @param maxPrice
	 * @param source
	 */
	public Items(double minPrince, double maxPrice) {
		this.currency = null;
		this.minPrince = minPrince;
		this.maxPrice = maxPrice;
		this.source = null;
	}


	/** Costruttore che imposta il parametro currency, minPrince e maxPrice e imposta il parametro source a null
	 * @param currency
	 * @param minPrince
	 * @param maxPrice
	 * @param source
	 */
	public Items(String currency, double minPrince, double maxPrice) {
		this.currency = currency;
		this.minPrince = minPrince;
		this.maxPrice = maxPrice;
		this.source = null;
	}


	/** Costruttore completo 
	 * @param currency
	 * @param minPrince
	 * @param maxPrice
	 * @param source
	 */
	public Items(String currency, double minPrince, double maxPrice, String source) {
		this.currency = currency;
		this.minPrince = minPrince;
		this.maxPrice = maxPrice;
		this.source = source;
	}
 

	@Override
	public String toString() {
		return "currency = " + currency + ", minPrince = " + minPrince + ", maxPrice = " + maxPrice + ", source = " + source;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (Double.doubleToLongBits(maxPrice) != Double.doubleToLongBits(other.maxPrice))
			return false;
		if (Double.doubleToLongBits(minPrince) != Double.doubleToLongBits(other.minPrince))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}
	
	
}
	
	
	
	
	
	
	
	
	
		
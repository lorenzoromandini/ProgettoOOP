/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/** Questa classe rappresenta delle caratteristiche di ogni evento.
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Features {
	
	/**
	 *  Indica la valuta con cui pagare il biglietto
	 */
	private String currency;   		
	
	/**
	 *  Indica il prezzo minimo
	 */
	private double minPrice;   	
	
	/**
	 *  Indica il prezzo massimo
	 */
	private double maxPrice;    
	
	/**
	 *  Indica la piattaforma che si occupa della vendita dei biglietti
	 */
	private String source;
	
	
	/** Costruttore dell'oggetto
	 * 
	 */
	public Features() {
		this.currency = null;
		this.minPrice = 0;
		this.maxPrice = 0;
		this.source = null;
	}
	
    /** Costruttore dell'oggetto
	 * @param source - piattaforma che si occupa della vendita dei biglietti
	 */
	public Features(String source) {
		this.currency = null;
		this.minPrice = 0;
		this.maxPrice = 0;
		this.source = source;
	}

	
	/** Costruttore dell'oggetto
	 * @param minPrice - prezzo minimo
	 * @param maxPrice - prezzo massimo
	 */
	public Features(double minPrice, double maxPrice) {
		this.currency = null;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.source = null;
	}


	/** Costruttore dell'oggetto
	 * @param currency - valuta con cui pagare il biglietto
	 * @param minPrice - prezzo minimo
	 * @param maxPrice - prezzo massimo
	 */
	public Features(String currency, double minPrice, double maxPrice) {
		this.currency = currency;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.source = null;
	}


	/** Costruttore dell'oggetto
	 * @param currency - valuta con cui pagare il biglietto
	 * @param minPrince - prezzo minimo
	 * @param maxPrice - prezzo massimo
	 * @param source - piattaforma che si occupa della vendita dei biglietti
	 */
	public Features(String currency, double minPrice, double maxPrice, String source) {
		this.currency = currency;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.source = source;
	}
 

	@Override
	public String toString() {
		return "currency = " + currency + ", minPrice = " + minPrice + ", maxPrice = " + maxPrice + ", source = " + source;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Features other = (Features) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (Double.doubleToLongBits(maxPrice) != Double.doubleToLongBits(other.maxPrice))
			return false;
		if (Double.doubleToLongBits(minPrice) != Double.doubleToLongBits(other.minPrice))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}
	
	
}
	
	
	
	
	
	
	
	
	
		
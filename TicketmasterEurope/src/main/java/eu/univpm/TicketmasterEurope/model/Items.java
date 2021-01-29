/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Items {
	
	private String currency;   		
	private double minPrince;   	
	private double maxPrice;    	
	private String source;
	
	
	/**
	 * 
	 */
	public Items() {
		super();
	}
	

	/**
	 * @param source
	 */
	public Items(String source) {
		super();
		this.source = source;
	}

	
	/**
	 * @param minPrince
	 * @param maxPrice
	 */
	public Items(double minPrince, double maxPrice) {
		super();
		this.minPrince = minPrince;
		this.maxPrice = maxPrice;
	}


	/**
	 * @param currency
	 * @param minPrince
	 * @param maxPrice
	 */
	public Items(String currency, double minPrince, double maxPrice) {
		super();
		this.currency = currency;
		this.minPrince = minPrince;
		this.maxPrice = maxPrice;
	}


	/**
	 * @param currency
	 * @param minPrince
	 * @param maxPrice
	 * @param source
	 */
	public Items(String currency, double minPrince, double maxPrice, String source) {
		super();
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
	
	
	
	
	
	
	
	
	
		
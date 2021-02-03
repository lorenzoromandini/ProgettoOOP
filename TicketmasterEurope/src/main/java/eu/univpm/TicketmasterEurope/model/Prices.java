/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/** Questa classe rappresenta delle caratteristiche di ogni evento
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Prices {
	
	/**
	 *  Indica la valuta con cui pagare il biglietto
	 */
	private String currency;   		
	
	/**
	 *  Indica il prezzo minimo del biglietto
	 */
	private double minPrice;   	
	
	/**
	 *  Indica il prezzo massimo del biglietto
	 */
	private double maxPrice;    
	
	
	/** Costruttore dell'oggetto
	 * 
	 */
	public Prices() {
		this.currency = null;
		this.minPrice = 0;
		this.maxPrice = 0;
	}
	
    /** Costruttore dell'oggetto
	 * @param currency - valuta del prezzo del biglietto
	 */
	public Prices(String currency) {
		this.currency = null;
		this.minPrice = 0;
		this.maxPrice = 0;
	}

	
	/** Costruttore dell'oggetto
	 * @param minPrice - prezzo minimo
	 * @param maxPrice - prezzo massimo
	 */
	public Prices(double minPrice, double maxPrice) {
		this.currency = null;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}


	/** Costruttore dell'oggetto
	 * @param currency - valuta con cui pagare il biglietto
	 * @param minPrince - prezzo minimo
	 * @param maxPrice - prezzo massimo
	 */
	public Prices(String currency, double minPrice, double maxPrice) {
		this.currency = currency;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the minPrice
	 */
	public double getMinPrice() {
		return minPrice;
	}

	/**
	 * @param minPrice the minPrice to set
	 */
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	/**
	 * @return the maxPrice
	 */
	public double getMaxPrice() {
		return maxPrice;
	}

	/**
	 * @param maxPrice the maxPrice to set
	 */
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}


	/**
	 * Override del metodo toString.
	 * @return Prices - rappresenta data e orario dell'evento
	 */
	@Override
	public String toString() {
		return "currency = " + currency + ", minPrice = " + minPrice + ", maxPrice = " + maxPrice + "";
	}

	
	/**
	 * Override del metodo equals.
	 * @param oggetto Prices da confrontare.
	 * @return true o false a seconda che i due oggetti siano uguali.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prices other = (Prices) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (Double.doubleToLongBits(maxPrice) != Double.doubleToLongBits(other.maxPrice))
			return false;
		if (Double.doubleToLongBits(minPrice) != Double.doubleToLongBits(other.minPrice))
			return false;
		return true;
	}
	
	
}
	
	
	
	
	
	
	
	
	
		
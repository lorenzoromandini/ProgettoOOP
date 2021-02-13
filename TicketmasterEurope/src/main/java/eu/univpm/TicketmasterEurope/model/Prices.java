/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/** Questa classe rappresenta le caratteristiche relative ai prezzi dei biglietti dell'evento
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
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
	 */
	public Prices() {
		this.currency = null;
		this.minPrice = 0;
		this.maxPrice = 0;
	}

	
	/** Restituisce la valuta del prezzo del biglietto
	 * @return la valuta del prezzo del biglietto
	 */
	public String getCurrency() {
		return currency;
	}

	
	/** Setta la valuta del prezzo del biglietto
	 * @param currency valuta del prezzo del biglietto
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
	/** Restituisce il prezzo minimo del biglietto
	 * @return il prezzo minimo del biglietto
	 */
	public double getMinPrice() {
		return minPrice;
	}

	
	/** Setta il prezzo minimo del biglietto
	 * @param minPrice prezzo minimo del biglietto
	 */
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	
	/** Restituisce il prezzo massimo del biglietto
	 * @return il prezzo massimo del biglietto
	 */
	public double getMaxPrice() {
		return maxPrice;
	}

	
	/** Setta il prezzo massimo del biglietto
	 * @param maxPrice prezzo massimo del biglietto
	 */
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}


	/** Override del metodo toString
	 * @return stringa che rappresenta valuta, prezzo minimo e prezzo massimo del biglietto
	 */
	@Override
	public String toString() {
		return "currency = " + currency + ", minPrice = " + minPrice + ", maxPrice = " + maxPrice + "";
	}

	
	/** Override del metodo equals
	 * @param obj oggetto Prices da confrontare
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
	
	
	
	
	
	
	
	
	
		
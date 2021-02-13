/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/** Questa classe descrive il distributore dei biglietti degli eventi
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class Dealer {
	
	/**
	 * Indica il distributore dei biglietti dell'evento
	 */
	private String source;
	
	
	/** Costruttore della classe
	 */
	public Dealer() {
		this.source = null;
	}


	/** Costruttore della classe
	 * @param source distributore dei biglietti dell'evento
	 */
	public Dealer(String source) {
		this.source = source;
	}


	/** Restituisce il distributore dei biglietti dell'evento
	 * @return il distributore dei biglietti dell'evento
	 */
	public String getSource() {
		return source;
	}


	/** Setta il distributore dei biglietti dell'evento
	 * @param source distributore dei biglietti dell'evento
	 */
	public void setSource(String source) {
		this.source = source;
	}


	/** Override del metodo equals
	 * @param obj oggetto Dealer da confrontare
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
		Dealer other = (Dealer) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}
	
	

}

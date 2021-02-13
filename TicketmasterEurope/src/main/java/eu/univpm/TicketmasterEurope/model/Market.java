/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/** Questa classe descrive il market in cui si svolge l'evento
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class Market {
	
	/**
	 * Indica l'id del raggruppamento demografico regionale 
	 */
	private String marketId;
	
	/**
	 * Indica il nome del raggruppamento demografico regionale 
	 */
	private String marketName;
	
	
	/** Costruttore della classe
	 */
	public Market() {
		this.marketId = null;
		this.marketName = null;
	}


	/** Restituisce il codice del market in cui si svolge l'evento
	 * @return il codice del market in cui si svolge l'evento
	 */
	public String getMarketId() {
		return marketId;
	}


	/** Setta il codice del market in cui si svolge l'evento
	 * @param marketId codice del market in cui si svolge l'evento
	 */
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}


	/** Restituisce il nome del market in cui si svolge l'evento
	 * @return il nome del market in cui si svolge l'evento
	 */
	public String getMarketName() {
		return marketName;
	}


	/** Setta il nome del market in cui si svolge l'evento
	 * @param marketName nome del market in cui si svolge l'evento
	 */
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	
	/** Override del metodo toString
	 * @return stringa che rappresenta marketId e marketName in cui si svolge l'evento
	 */
	@Override
	public String toString() {
		return "marketId=" + marketId + ", marketName=" + marketName + "";
	}

	
	/** Override del metodo equals
	 * @param obj oggetto Market da confrontare
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
		Market other = (Market) obj;
		if (marketId == null) {
			if (other.marketId != null)
				return false;
		} else if (!marketId.equals(other.marketId))
			return false;
		if (marketName == null) {
			if (other.marketName != null)
				return false;
		} else if (!marketName.equals(other.marketName))
			return false;
		return true;
	}

	
	
}

/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/** Questa classe rappresenta le date e gli orari di ogni evento
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Date {
	
	/**
	 *  Indica la data di inizio dell'evento
	 */
	private String dataInizio;
	
	/** 
	 * Indica l'orario di inizio dell'evento
	 */
	private String orarioInizio;
	
	
	/** Costruttore della classe
	 */
	public Date() {
		this.dataInizio = null;
		this.orarioInizio = null;	
		}
	
	
	/** Restituisce la data di inizio dell'evento
	 * @return la data di inizio dell'evento 
	 */
	public String getDataInizio() {
		return dataInizio;
	}
 

	/** Setta la data di inizio dell'evento
	 * @param dataInizio data di inizio dell'evento
	 */
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}


	/** Restituisce l'orario di inizio dell'evento
	 * @return l'orario di inizio dell'evento
	 */
	public String getOrarioInizio() {
		return orarioInizio;
	}


	/** Setta l'orario di terminazione dell'evento
	 * @param orarioInizio orario di inizio dell'evento
	 */
	public void setOrarioInizio(String orarioInizio) {
		this.orarioInizio = orarioInizio;
	}

	
	/** Override del metodo toString
	 * @return stringa che rappresenta data e orario dell'evento
	 */
	@Override
	public String toString() {
		return "dataInizio=" + dataInizio + ", orarioInizio=" + orarioInizio + "";
	}


	/** Override del metodo equals
	 * @param obj oggetto Date da confrontare
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
		Date other = (Date) obj;
		if (dataInizio == null) {
			if (other.dataInizio != null)
				return false;
		} else if (!dataInizio.equals(other.dataInizio))
			return false;
		if (orarioInizio == null) {
			if (other.orarioInizio != null)
				return false;
		} else if (!orarioInizio.equals(other.orarioInizio))
			return false;
		return true;
	}
	

}

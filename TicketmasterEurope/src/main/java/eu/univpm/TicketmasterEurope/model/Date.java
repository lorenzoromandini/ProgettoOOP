/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/** Questa classe rappresenta le date e gli orari di ogni evento.
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
	
	/**
	 *  Indica la data di terminazione dell'evento
	 */
	private String dataFine;
	
	/** 
	 * Indica l'orario di terminazione dell'evento
	 */
	private String orarioFine;
	
	
	/** Costruttore dell'oggetto
	 */
	public Date() {
		this.dataInizio = null;
		this.orarioInizio = null;	
		this.dataFine = null;
		this.orarioFine = null;
		}
	
	
	/** Restituisce la data di inizio dell'evento
	 * @return dataInizio
	 */
	public String getDataInizio() {
		return dataInizio;
	}
 

	/** Setta la data di inizio dell'evento
	 * @param String dataInizio
	 */
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}


	/** Restituisce l'orario di inizio dell'evento
	 * @return orarioInizio
	 */
	public String getOrarioInizio() {
		return orarioInizio;
	}


	/** Setta l'orario di terminazione dell'evento
	 * @param String orarioInizio
	 */
	public void setOrarioInizio(String orarioInizio) {
		this.orarioInizio = orarioInizio;
	}


	/** Restituisce la data di terminazione dell'evento
	 * @return dataFine
	 */
	public String getDataFine() {
		return dataFine;
	}


	/** Setta la data di terminazione dell'evento
	 * @param String dataFine
	 */
	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}


	/** Restituisce l'orario di terminazione dell'evento
	 * @return orarioFine
	 */
	public String getOrarioFine() {
		return orarioFine;
	}


	/** Setta l'orario di terminazione dell'evento
	 * @param String orarioFine
	 */
	public void setOrarioFine(String orarioFine) {
		this.orarioFine = orarioFine;
	}

	
	/**
	 * Override del metodo toString.
	 * @return Date - rappresenta data e orario dell'evento
	 */
	@Override
	public String toString() {
		return "dataInizio=" + dataInizio + ", orarioInizio=" + orarioInizio + ", dataFine=" + dataFine
				+ ", orarioFine=" + orarioFine + "";
	}


	/**
	 * Override del metodo equals.
	 * @param oggetto Date da confrontare.
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
		Date other = (Date) obj;
		if (dataFine == null) {
			if (other.dataFine != null)
				return false;
		} else if (!dataFine.equals(other.dataFine))
			return false;
		if (dataInizio == null) {
			if (other.dataInizio != null)
				return false;
		} else if (!dataInizio.equals(other.dataInizio))
			return false;
		if (orarioFine == null) {
			if (other.orarioFine != null)
				return false;
		} else if (!orarioFine.equals(other.orarioFine))
			return false;
		if (orarioInizio == null) {
			if (other.orarioInizio != null)
				return false;
		} else if (!orarioInizio.equals(other.orarioInizio))
			return false;
		return true;
	}
	

}

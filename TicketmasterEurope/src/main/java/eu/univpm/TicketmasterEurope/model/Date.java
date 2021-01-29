/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Date {
	
	/**
	 *  Indica la data (di inizio e fine) dell'evento
	 */
	private String data;
	
	/** 
	 * Indica l'orario (di inizio e fine) dell'evento
	 */
	private String orario;
	
	
	/** Costruttore completo
	 * @param data
	 * @param orario
	 */
	public Date(String data, String orario) {
		this.data = data;
		this.orario = orario;
	}
	
	
	/** 
	 * @return Data dell'evento
	 */
	public String getData() {
		return data;
	}


	/**
	 * @param Imposta la data dell'evento
	 */
	public void setData(String data) {
		this.data = data;
	}

 
	/**
	 * @return Orario dell'evento
	 */
	public String getOrario() {
		return orario;
	}


	/**
	 * @param Imposta l'orario dell'evento
	 */
	public void setOrario(String orario) {
		this.orario = orario;
	}
	
	/**
	 * Override del metodo toString.
	 * @return Date che rappresenta data e orario dell'evento
	 */
	@Override
	public String toString() {
		return "data = " + data + ", orario = " + orario;
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
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (orario == null) {
			if (other.orario != null)
				return false;
		} else if (!orario.equals(other.orario))
			return false;
		return true;		
	}


	
	
	
	
	

	
	

}

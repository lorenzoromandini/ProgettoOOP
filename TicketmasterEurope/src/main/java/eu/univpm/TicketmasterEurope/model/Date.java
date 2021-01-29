/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Date {
	
	private String data;
	private String orario;
	
	
	/**
	 * @param data
	 * @param orario
	 */
	public Date(String data, String orario) {
		this.data = data;
		this.orario = orario;
	}
	
	
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

 
	/**
	 * @return the orario
	 */
	public String getOrario() {
		return orario;
	}


	/**
	 * @param orario the orario to set
	 */
	public void setOrario(String orario) {
		this.orario = orario;
	}
	
	
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

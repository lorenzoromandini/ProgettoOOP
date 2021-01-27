/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/**
 * @author loren
 *
 */
public class Date {
	
	private String data;
	private String orario;
	
	
	/**
	 * @param data
	 * @param orario
	 */
	public Date(String data, String orario) {
		
		super();
		this.data = data;
		this.orario = orario;
		
	}


	public String getData() {
		
		return data;
		
	}


	public void setData(String data) {
		
		this.data = data;
		
	}


	public String getOrario() {
		
		return orario;
		
	}


	public void setOrario(String orario) {
		
		this.orario = orario;
		
	}
	
	
	@Override
	public String toString() {
		
		return data +  "  " + orario;
		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date date = (Date) obj;
		if (data == null) {
			if (date.data != null)
				return false;
		} else if (!data.equals(date.data))
			return false;
		if (orario == null) {
			if (date.orario != null)
				return false;
		} else if (!orario.equals(date.orario))
			return false;
		return true;
		
	}
	
	
	
	
	
	
	

	
	

}

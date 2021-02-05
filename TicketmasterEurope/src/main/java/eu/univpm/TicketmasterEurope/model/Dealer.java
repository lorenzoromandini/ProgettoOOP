/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class Dealer {
	
	private String source;
	
	
	/**
	 * 
	 */
	public Dealer() {
		super();
	}


	/**
	 * @param source
	 */
	public Dealer(String source) {
		super();
		this.source = source;
	}


	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}


	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}


	@Override
	public String toString() {
		return "source = " + source + "";
	}


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

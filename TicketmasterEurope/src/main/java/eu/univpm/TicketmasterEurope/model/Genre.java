/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/** Questa classe rappresenta la tipologia, il genere e il sottogenere di ogni evento.
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Genre {
	
	/**
	 *  Indica la tipologia dell'evento
	 */	
	private String segmentName;		
	
	/**
	 *  Indica il genere dell'evento
	 */	
	private String genreName;	
	
	/**
	 *  Indica il sottogenere dell'evento
	 */	
	private String subGenreName;
		
	
	/** Costruttore dell'oggetto
	 */
	public Genre() {
		this.segmentName = null;
		this.genreName = null;
		this.subGenreName = null;
	}

	
	/** Restituisce la tipologia dell'evento
	 * @return la tipologia dell'evento
	 */
	public String getSegmentName() {
		return segmentName;
	}


	/** Setta la tipologia dell'evento
	 * @param segmentName tipologia dell'evento
	 */
	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}


	/** Restituisce il genere dell'evento
	 * @return il genere dell'evento
	 */
	public String getGenreName() {
		return genreName;
	}


	/** Setta il genere dell'evento
	 * @param genreName genere dell'evento
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}


	/** Restituisce il sottogenere dell'evento
	 * @return il sottogenere dell'evento
	 */
	public String getSubGenreName() {
		return subGenreName;
	}


	/** Setta il sottogenere dell'evento
	 * @param subGenreName sottogenere dell'evento
	 */
	public void setSubGenreName(String subGenreName) {
		this.subGenreName = subGenreName;
	}


	/** Override del metodo toString
	 * @return stringa che rappresenta tipologia, genere e sottogenere dell'evento
	 */
	@Override
	public String toString() {
		return "segmentName= " + segmentName + ", genreName= " + genreName + ", subGenreName= " + subGenreName + "";
	}

	
	/** Override del metodo equals
	 * @param obj oggetto Genre da confrontare
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
		Genre other = (Genre) obj;
		if (genreName == null) {
			if (other.genreName != null)
				return false;
		} else if (!genreName.equals(other.genreName))
			return false;
		if (segmentName == null) {
			if (other.segmentName != null)
				return false;
		} else if (!segmentName.equals(other.segmentName))
			return false;
		if (subGenreName == null) {
			if (other.subGenreName != null)
				return false;
		} else if (!subGenreName.equals(other.subGenreName))
			return false;
		return true;
	}
	
	
	
	
}

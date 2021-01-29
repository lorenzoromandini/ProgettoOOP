/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Genre {
	
	/**
	 *  Indica il genere dell'evento
	 */	
	
	private String segmentName;		
	
	/**
	 *  Indica 
	 */	
	
	private String genreName;	
	
	/**
	 *  Indica l'id dell'evento
	 */	
	
	private String subGenreName;
		
	
	/** Costruttore vuoto che imposta tutti i parametri a null
	 * @param segmentName
	 * @param genreName
	 * @param subGenreName
	 */
	public Genre() {
		this.segmentName = null;
		this.genreName = null;
		this.subGenreName = null;
	}

	
	/** Costruttore che imposta il parametro segmentName e imposta gli altri parametri a null
	 * @param segmentName
	 * @param genreName
	 * @subgenreName
	 */
	public Genre(String segmentName) {		
		this.segmentName = segmentName;
		this.genreName = null;
		this.subGenreName = null;
	}
	
	
	/** Costruttore che imposta il parametro genreName e subGenreName e imposta segmentName a null
	 * @param segmentName
	 * @param genreName
	 * @param subGenreName
	 */
	public Genre(String genreName, String subGenreName) {
		this.segmentName = null;
		this.genreName = genreName;
		this.subGenreName = subGenreName;
	}

 
	/** Costruttore completo
	 * @param segmentName
	 * @param genreName
	 * @param subGenreName
	 */
	public Genre(String segmentName, String genreName, String subGenreName) {
		this.segmentName = segmentName;
		this.genreName = genreName;
		this.subGenreName = subGenreName;
	}


	@Override
	public String toString() {
		return "segmentName = " + segmentName + ", genreName = " + genreName + ", subGenreName = " + subGenreName;
	}


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

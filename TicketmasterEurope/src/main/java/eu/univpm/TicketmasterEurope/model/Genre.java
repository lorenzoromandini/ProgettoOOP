/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Genre {

	private String segmentName;		
	private String genreName;		
	private String subGenreName;
		
	
	/**
	 * 
	 */
	public Genre() {
		super();
	}

	
	/**
	 * @param segmentName
	 */
	public Genre(String segmentName) {
		super();
		this.segmentName = segmentName;
	}
	
	
	/**
	 * @param genreName
	 * @param subGenreName
	 */
	public Genre(String genreName, String subGenreName) {
		super();
		this.genreName = genreName;
		this.subGenreName = subGenreName;
	}


	/**
	 * @param segmentName
	 * @param genreName
	 * @param subGenreName
	 */
	public Genre(String segmentName, String genreName, String subGenreName) {
		super();
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

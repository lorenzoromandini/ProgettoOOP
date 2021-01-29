/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Items {
	
	private String currency;   		
	private double minPrince;   	
	private double maxPrice;    	
	private String segmentName;		
	private String genreName;		
	private String subGenreName;
	private String source;
	
	
	/**
	 * 
	 */
	public Items() {
		super();
	}


	/**
	 * @param segmentName
	 */
	public Items(String segmentName) {
		super();
		this.segmentName = segmentName;
	}


	/**
	 * @param genreName
	 * @param subGenreName
	 */
	public Items(String genreName, String subGenreName) {
		super();
		this.genreName = genreName;
		this.subGenreName = subGenreName;
	}


	/**
	 * @param segmentName
	 * @param genreName
	 * @param subGenreName
	 */
	public Items(String segmentName, String genreName, String subGenreName) {
		super();
		this.segmentName = segmentName;
		this.genreName = genreName;
		this.subGenreName = subGenreName;
	}


	/**
	 * @param currency
	 * @param minPrince
	 * @param maxPrice
	 */
	public Items(String currency, double minPrince, double maxPrice) {
		super();
		this.currency = currency;
		this.minPrince = minPrince;
		this.maxPrice = maxPrice;
	}


	/**
	 * @param currency
	 * @param minPrince
	 * @param maxPrice
	 * @param segmentName
	 * @param genreName
	 * @param subGenreName
	 */
	public Items(String currency, double minPrince, double maxPrice, String segmentName, String genreName,
			String subGenreName) {
		super();
		this.currency = currency;
		this.minPrince = minPrince;
		this.maxPrice = maxPrice;
		this.segmentName = segmentName;
		this.genreName = genreName;
		this.subGenreName = subGenreName;
	}


	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	/**
	 * @return the minPrince
	 */
	public double getMinPrince() {
		return minPrince;
	}
	
	
	/**
	 * @param minPrince the minPrince to set
	 */
	public void setMinPrince(double minPrince) {
		this.minPrince = minPrince;
	}
	
	
	/**
	 * @return the maxPrice
	 */
	public double getMaxPrice() {
		return maxPrice;
	}
	
	
	/**
	 * @param maxPrice the maxPrice to set
	 */
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	
	/**
	 * @return the segmentName
	 */
	public String getSegmentName() {
		return segmentName;
	}
	
	
	/**
	 * @param segmentName the segmentName to set
	 */
	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}
	
	
	/**
	 * @return the genreName
	 */
	public String getGenreName() {
		return genreName;
	}
	
	
	/**
	 * @param genreName the genreName to set
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
	
	/**
	 * @return the subGenreName
	 */
	public String getSubGenreName() {
		return subGenreName;
	}
	
		
	/**
	 * @param subGenreName the subGenreName to set
	 */
	public void setSubGenreName(String subGenreName) {
		this.subGenreName = subGenreName;
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
		return "currency =" + currency + ", minPrince =" + minPrince + ", maxPrice =" + maxPrice
				+ ", segmentName =" + segmentName + ", genreName =" + genreName + ", subGenreName =" + subGenreName
				+ ", source =" + source;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (genreName == null) {
			if (other.genreName != null)
				return false;
		} else if (!genreName.equals(other.genreName))
			return false;
		if (Double.doubleToLongBits(maxPrice) != Double.doubleToLongBits(other.maxPrice))
			return false;
		if (Double.doubleToLongBits(minPrince) != Double.doubleToLongBits(other.minPrince))
			return false;
		if (segmentName == null) {
			if (other.segmentName != null)
				return false;
		} else if (!segmentName.equals(other.segmentName))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (subGenreName == null) {
			if (other.subGenreName != null)
				return false;
		} else if (!subGenreName.equals(other.subGenreName))
			return false;
		return true;
	}
	

}
	
	
	


	
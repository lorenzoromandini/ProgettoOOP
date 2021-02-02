/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author loren
 *
 */
public class Market {
	
	/**
	 * Indica l'id del raggruppamento demografico regionale 
	 */
	private String marketId;
	
	/**
	 * Indica il nome del raggruppamento demografico regionale 
	 */
	private String marketName;
	
	
	/**
	 * 
	 */
	public Market() {
		super();
	}


	/**
	 * @param marketId
	 */
	public Market(String marketId) {
		super();
		this.marketId = marketId;
	}


	/**
	 * @param marketId
	 * @param marketName
	 */
	public Market(String marketId, String marketName) {
		super();
		this.marketId = marketId;
		this.marketName = marketName;
	}


	/**
	 * @return the marketId
	 */
	public String getMarketId() {
		return marketId;
	}


	/**
	 * @param marketId the marketId to set
	 */
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}


	/**
	 * @return the marketName
	 */
	public String getMarketName() {
		return marketName;
	}


	/**
	 * @param marketName the marketName to set
	 */
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}


	@Override
	public String toString() {
		return "Market [marketId=" + marketId + ", marketName=" + marketName + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Market other = (Market) obj;
		if (marketId == null) {
			if (other.marketId != null)
				return false;
		} else if (!marketId.equals(other.marketId))
			return false;
		if (marketName == null) {
			if (other.marketName != null)
				return false;
		} else if (!marketName.equals(other.marketName))
			return false;
		return true;
	}

	
	
}

/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;


/** Questa classe rappresenta le informazioni di ogni evento
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Event {
	
	/**
	 *  Indica l'id dell'evento
	 */
	private String id;
	
	/**
	 *  Indica il nome dell'evento
	 */	
	private String name;
	
	/**
	 * Indica l'url dell'evento
	 */
	private String url;
	
	/**
	 *  Indica le info dell'evento
	 */	
	private String info;
	
	/**
	 * Oggetto di tipo Date
	 */
	private Date date;
	
	/**
	 * Oggetto di tipo Genre
	 */
	private Genre genre;
	
	/**
	 * Oggetto di tipo Prices
	 */
	private Prices prices;
	
	/**
	 * Oggetto di tipo Dealer
	 */
	private Dealer dealer;
		
	/** 
	 * Oggetto di tipo Location
	 */
	private Location location;
	

	/** Costruttore della classe
	 */
	public Event() {
		this.id = null;
		this.name = null;
		this.url = null;
		this.info = null;
		this.date = null;
		this.genre = null;
		this.prices = null;
		this.dealer = null;
		this.location = null;
	}


	/** Restituisce l'id dell'evento
	 * @return l'id dell'evento
	 */
	public String getId() {	
		return id;		
	}


	/** Setta l'id dell'evento
	 * @param id id dell'evento
	 */
	public void setId(String id) {		
		this.id = id;		
	}


	/** Restituisce il nome dell'evento
	 * @return il nome dell'evento
	 */
	public String getName() {		
		return name;		
	}


	/** Setta il nome dell'evento
	 * @param name nome dell'evento
	 */
	public void setName(String name) {		
		this.name = name;		
	}


	/** Restituisce l'url dell'evento
	 * @return l'url dell'evento
	 */
	public String getUrl() {
		return url;
	}


	/** Setta l'url dell'evento
	 * @param url url dell'evento
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	/** Restituisce le info dell'evento
	 * @return le info dell'evento
	 */
	public String getInfo() {		
		return info;		
	}


	/** Setta le info dell'evento
	 * @param info info dell'evento
	 */
	public void setInfo(String info) {		
		this.info = info;		
	}

	
	/** Restituisce la data e l'orario di inizio dell'evento
	 * @return data e orario di inizio dell'evento
	 */
	public Date getDate() {
		return date;
	}


	/** Setta la data e l'orario di inizio dell'evento
	 * @param date data e orario di inizio dell'evento
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/** Restituisce i generi dell'evento
	 * @return i generi dell'evento
	 */
	public Genre getGenre() {
		return genre;
	}


	/** Setta i generi dell'evento
	 * @param genre generi dell'evento
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	/** Restituisce le infomazioni relative ai costi del biglietto dell'evento
	 * @return le infomazioni relative ai costi del biglietto dell'evento
	 */
	public Prices getPrices() {
		return prices;
	}


	/** Setta le infomazioni relative ai costi del biglietto dell'evento
	 * @param prices infomazioni relative ai costi del biglietto dell'evento
	 */
	public void setPrices(Prices prices) {
		this.prices = prices;
	}


	/** Restituisce il distributore dei biglietti dell'evento
	 * @return il distributore dei biglietti dell'evento
	 */
	public Dealer getDealer() {
		return dealer;
	}


	/** Setta il distributore dei biglietti dell'evento
	 * @param dealer distributore dei biglietti dell'evento
	 */
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}


	/** Restituisce il luogo in cui si svolge l'evento
	 * @return il luogo in cui si svolge l'evento
	 */
	public Location getLocation() {
		return location;
	}


	/** Setta il luogo in cui si svolge l'evento
	 * @param location luogo in cui si svolge l'evento
	 */
	public void setLocation(Location location) {
		this.location = location;
	}


	/** Override del metodo toString.
	 * @return stringa che rappresenta le informazioni relative all'evento
	 */
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", url=" + url + ", info=" + info + ", date=" + date + ", genre="
				+ genre + ", prices=" + prices + "dealer=" + dealer + ", location=" + location + "";
	}
	

	/** Override del metodo equals
	 * @param obj oggetto Event da confrontare
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
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prices == null) {
			if (other.prices != null)
				return false;
		} else if (!prices.equals(other.prices))
			return false;
		if (dealer == null) {
			if (other.dealer != null)
				return false;
		} else if (!dealer.equals(other.dealer))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
		
	
	
}

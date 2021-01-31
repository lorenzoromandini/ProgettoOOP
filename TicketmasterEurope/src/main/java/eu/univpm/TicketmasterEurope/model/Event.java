/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/** Questa classe rappresenta le informazioni di ogni evento.
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
	 * Indica l'url del source dell'evento
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
	

	/** Costruttore dell'oggetto
	 * 
	 */
	public Event() {
		this.id = null;
		this.name = null;
		this.url = null;
		this.info = null;
		this.date = null;
		this.genre = null;
		this.prices = null;
	}
	
  
	/** Costruttore dell'oggetto
	 * @param name
	 */
	public Event(String name) {		
		this.id = null;
		this.name = name;
		this.url = null;
		this.info = null;
		this.date = null;
		this.genre = null;
		this.prices = null;
	}
	

	/** Costruttore dell'oggetto
	 * @param date
	 */
	public Event(Date date) {
		this.id = null;
		this.name = null;
		this.url = null;
		this.info = null;
		this.date = date;
		this.genre = null;
		this.prices = null;
	}


	/** Costruttore dell'oggetto
	 * @param genre
	 */
	public Event(Genre genre) {
		this.id = null;
		this.name = null;
		this.url = null;
		this.info = null;
		this.date = null;
		this.genre = genre;
		this.prices = null;
	}


	/** Costruttore dell'oggetto
	 * @param prices
	 */
	public Event(Prices prices) {
		this.id = null;
		this.name = null;
		this.url = null;
		this.info = null;
		this.date = null;
		this.genre = null;
		this.prices = prices;
	}


	/** Costruttore dell'oggetto
	 * @param id
	 * @param name
	 */
	public Event(String id, String name) {		
		this.id = id;
		this.name = name;
		this.url = null;
		this.info = null;	
		this.date = null;
		this.genre = null;
		this.prices = null;
	}


	/** Costruttore dell'oggetto
	 * @param id
	 * @param name
	 * @param url
	 */
	public Event(String id, String name, String url) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.info = null;
		this.date = null;
		this.genre = null;
		this.prices = null;
	}
	

	/** Costruttore dell'oggetto
	 * @param id
	 * @param name
	 * @param url
	 * @param info
	 * @param date
	 * @param genre
	 * @param prices
	 */
	public Event(String id, String name, String url, String info, Date date, Genre genre, Prices prices) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.info = info;
		this.date = date;
		this.genre = genre;
		this.prices = prices;
	}


	/** Restituisce l'id dell'evento
	 * @return id 
	 */
	public String getId() {	
		return id;		
	}


	/** Setta l'id dell'evento
	 * @param String id
	 */
	public void setId(String id) {		
		this.id = id;		
	}


	/** Restituisce il nome dell'evento
	 * @return name
	 */
	public String getName() {		
		return name;		
	}


	/** Setta il nome dell'evento
	 * @param String name
	 */
	public void setName(String name) {		
		this.name = name;		
	}


	/** Restituisce l'url del source dell'evento
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	/** Setta l'url del source dell'evento
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	/** Restituisce le info dell'evento
	 * @return info
	 */
	public String getInfo() {		
		return info;		
	}


	/** Setta le info dell'evento
	 * @param String info
	 */
	public void setInfo(String info) {		
		this.info = info;		
	}

	
	/** Restituisce la data e l'orario dell'evento
	 * @return date
	 */
	public Date getDate() {
		return date;
	}


	/** Setta la data e l'orario dell'evento
	 * @param Date date
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/** Restituisce il genere dell'evento
	 * @return genre
	 */
	public Genre getGenre() {
		return genre;
	}


	/** Setta il genere dell'evento
	 * @param Genre genre
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	/** Restituisce le caratteristiche dell'evento
	 * @return prices
	 */
	public Prices getFeatures() {
		return prices;
	}


	/** Setta le caratteristiche dell'evento
	 * @param Prices prices
	 */
	public void setFeatures(Prices prices) {
		this.prices = prices;
	}
	

	/**
	 * Override del metodo toString.
	 * @return String - rappresenta le informazioni relative all'evento.
	 */
	@Override
	public String toString() {
		return "id = " + id + ", name = " + name + ", url = " + url + ", info = " + info + ", date = " + date + 
				", genre = " + genre + ", prices = " + prices;
	}


	/**
	 * Override del metodo equals.
	 * @param oggetto Event da confrontare.
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
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (prices == null) {
			if (other.prices != null)
				return false;
		} else if (!prices.equals(other.prices))
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}


	





	
	
	

	


}

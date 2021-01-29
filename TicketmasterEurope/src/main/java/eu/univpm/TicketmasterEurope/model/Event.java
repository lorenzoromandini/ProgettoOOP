/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
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
	 *  Indica l'info dell'evento
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
	 * Oggetto di tipo Items
	 */
	private Items items;
	

	/** Costruttore vuoto che imposta tutti i parametri a null
	 * @param id
	 * @param name
	 * @param info
	 */
	public Event() {
		this.id = null;
		this.name = null;
		this.info = null;
	}
	
  
	/** Costruttore che imposta il parametro name e imposta gli altri parametri a null
	 * @param id
	 * @param name
	 * @param info
	 */
	public Event(String name) {		
		this.id = null;
		this.name = name;
		this.info = null;		
	}
	

	/**
	 * @param date
	 */
	public Event(Date date) {
		super();
		this.date = date;
	}


	/**
	 * @param genre
	 */
	public Event(Genre genre) {
		super();
		this.genre = genre;
	}


	/**
	 * @param items
	 */
	public Event(Items items) {
		super();
		this.items = items;
	}


	/** Costruttore che imposta il parametro name e id e imposta il parametro info a null
	 * @param id
	 * @param name
	 * @param info
	 */
	public Event(String id, String name) {		
		this.id = id;
		this.name = name;
		this.info = null;		
	}


	/** Costruttore completo
	 * @param id
	 * @param name
	 * @param info
	 */
	public Event(String id, String name, String info) {
		this.id = id;
		this.name = name;
		this.info = info;		
	}
	

	/**
	 * @param id
	 * @param name
	 * @param info
	 * @param date
	 * @param genre
	 * @param items
	 */
	public Event(String id, String name, String info, Date date, Genre genre, Items items) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.date = date;
		this.genre = genre;
		this.items = items;
	}


	/**
	 * @return id dell'evento
	 */
	public String getId() {	
		return id;		
	}


	/**
	 * @param Imposta l'id dell'evento
	 */
	public void setId(String id) {		
		this.id = id;		
	}


	/**
	 * @return Nome dell'evento
	 */
	public String getName() {		
		return name;		
	}


	/**
	 * @param Imposta il nome dell'evento
	 */
	public void setName(String name) {		
		this.name = name;		
	}


	/**
	 * @return Info dell'evento
	 */
	public String getInfo() {		
		return info;		
	}


	/**
	 * @param Imposta l'info dell'evento
	 */
	public void setInfo(String info) {		
		this.info = info;		
	}

	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}


	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	/**
	 * @return the items
	 */
	public Items getItems() {
		return items;
	}


	/**
	 * @param items the items to set
	 */
	public void setItems(Items items) {
		this.items = items;
	}


	/**
	 * Override del metodo toString.
	 * @return String che rappresenta le informazioni relative all'evento.
	 */
	@Override
	public String toString() {
		return "id = " + id + ", name = " + name + ", info = " + info + ", date = " + date + ", genre = " + genre
				+ ", items = " + items;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
	   } else if (!info.equals(other.info))
			return false;
		return true;
	}


	




	
	
	

	


}

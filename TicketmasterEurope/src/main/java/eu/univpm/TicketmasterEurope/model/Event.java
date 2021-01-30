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
	 * Oggetto di tipo Features
	 */
	private Features features;
	

	/** Costruttore dell'oggetto
	 * 
	 */
	public Event() {
		this.id = null;
		this.name = null;
		this.info = null;
		this.date = null;
		this.genre = null;
		this.features = null;
	}
	
  
	/** Costruttore dell'oggetto
	 * @param name
	 */
	public Event(String name) {		
		this.id = null;
		this.name = name;
		this.info = null;
		this.date = null;
		this.genre = null;
		this.features = null;
	}
	

	/** Costruttore dell'oggetto
	 * @param date
	 */
	public Event(Date date) {
		this.id = null;
		this.name = null;
		this.info = null;
		this.date = date;
		this.genre = null;
		this.features = null;
	}


	/** Costruttore dell'oggetto
	 * @param genre
	 */
	public Event(Genre genre) {
		this.id = null;
		this.name = null;
		this.info = null;
		this.date = null;
		this.genre = genre;
		this.features = null;
	}


	/** Costruttore dell'oggetto
	 * @param features
	 */
	public Event(Features features) {
		this.id = null;
		this.name = null;
		this.info = null;
		this.date = null;
		this.genre = null;
		this.features = features;
	}


	/** Costruttore dell'oggetto
	 * @param id
	 * @param name
	 */
	public Event(String id, String name) {		
		this.id = id;
		this.name = name;
		this.info = null;	
		this.date = null;
		this.genre = null;
		this.features = null;
	}


	/** Costruttore dell'oggetto
	 * @param id
	 * @param name
	 * @param info
	 */
	public Event(String id, String name, String info) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.date = null;
		this.genre = null;
		this.features = null;
	}
	

	/** Costruttore dell'oggetto
	 * @param id
	 * @param name
	 * @param info
	 * @param date
	 * @param genre
	 * @param features
	 */
	public Event(String id, String name, String info, Date date, Genre genre, Features features) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.date = date;
		this.genre = genre;
		this.features = features;
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
	 * @return features
	 */
	public Features getFeatures() {
		return features;
	}


	/** Setta le caratteristiche dell'evento
	 * @param Features features
	 */
	public void setFeatures(Features features) {
		this.features = features;
	}


	/**
	 * Override del metodo toString.
	 * @return String - rappresenta le informazioni relative all'evento.
	 */
	@Override
	public String toString() {
		return "id = " + id + ", name = " + name + ", info = " + info + ", date = " + date + ", genre = " + genre
				+ ", features = " + features;
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

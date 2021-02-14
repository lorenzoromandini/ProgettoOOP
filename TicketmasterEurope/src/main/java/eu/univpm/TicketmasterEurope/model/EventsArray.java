/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

import java.util.Vector;


/** Questa classe svolge la funzione di contenere gli eventi all'interno di un vettore
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class EventsArray {
	
	/**
	 * Indica il numero totale di eventi esistenti
	 */
	private int totalEvents;
	
	/**
	 * Indica il numero di eventi mostrati
	 */
	private int showedEvents;
	
	/**
	 *  Vettore contentente i vari eventi con le loro caratteristiche
	 */
	private Vector<Event> vector = new Vector<Event>();
	
	
	/** Costruttore della classe
	 */
	public EventsArray() {
		this.totalEvents = 0;
		this.showedEvents = 0;
		this.vector = null;
	}


	/** Costruttore dell'oggetto
	 * @param vector vettore degli eventi
	 */
	public EventsArray(Vector<Event> vector) {
		this.vector = vector;
	}
	

	/** Restituisce il numero totale degli eventi
	 * @return il numero totale degli eventi
	 */
	public int getTotalEvents() {
		return totalEvents;
	}


	/** Setta il numero totale degli eventi
	 * @param totalEvents numero totale degli eventi
	 */
	public void setTotalEvents(int totalEvents) {
		this.totalEvents = totalEvents;
	}


	/** Restituisce il numero degli eventi mostrati
	 * @return il numero degli eventi mostrati
	 */
	public int getShowedEvents() {
		return showedEvents;
	}


	/** Setta il numero degli eventi mostrati
	 * @param showedEvents numero degli eventi mostrati
	 */
	public void setShowedEvents(int showedEvents) {
		this.showedEvents = showedEvents;
	}


	/** Restituisce il vettore degli eventi
     * @return il vettore degli eventi
     */
	public Vector<Event> getVector() {
		return vector;
	}

	
	/** Setta il vettore degli eventi
     * @param evento vettore degli eventi
     */
	public void setVector(Vector<Event> evento) {
		this.vector = evento;
	}

	
	/** Scrive il vettore degli eventi come una stringa
     * @return stringa che rappresenta le informazioni relative agli eventi
     */
	public String toStringVector() {
		String toReturn = "";
		for (int i = 0; i < vector.size(); i++)
			toReturn += vector.get(i).toString();
		return toReturn;
	}


	/** Override del metodo toString
	 * @return stringa che rappresenta il numero totale degli eventi, il numero degli eventi mostrati ed il vettore degli eventi
	 */
	@Override
	public String toString() {
		return "totalEvents=" + totalEvents + ", showedEvents=" + showedEvents + ", vector=" + vector + "";
	}


	/** Override del metodo equals
	 * @param obj oggetto EventsArray da confrontare
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
		EventsArray other = (EventsArray) obj;
		if (showedEvents != other.showedEvents)
			return false;
		if (totalEvents != other.totalEvents)
			return false;
		if (vector == null) {
			if (other.vector != null)
				return false;
		} else if (!vector.equals(other.vector))
			return false;
		return true;
	}
	
	
}
	
	
	
	

	
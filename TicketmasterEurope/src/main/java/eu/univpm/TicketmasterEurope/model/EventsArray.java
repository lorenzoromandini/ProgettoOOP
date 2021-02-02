/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

import java.util.Vector;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class EventsArray {
	
	private Event event;
	
	/**
	 *  Vettore contentente le caratteristiche dei vari eventi che hanno luogo in una determinata location
	 */
	private Vector<Event> vector = new Vector<Event>();
	
	
	/**
	 * 
	 */
	public EventsArray() {
		super();
	}
	
	
	/**
	 * @param event
	 */
	public EventsArray(Event event) {
		super();
		this.event = event;
	}


	/**
	 * @param evento
	 */
	public EventsArray(Vector<Event> vector) {
		this.vector = vector;
	}
	
	
	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}


	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}


	/** Restituisce il vettore di Event della location
     * @return evento
     */
	public Vector<Event> getVector() {
		return vector;
	}

	
	/** Setta il vettore di Event della location
     * @param Vector<Event> evento
     */
	public void setVector(Vector<Event> evento) {
		this.vector = evento;
	}

	
	/**
	 *  Scrive il vettore degli eventi come una stringa
     * @return String toReturn - rappresenta le informazioni relative all'evento.
     */
	public String toStringVector() {
		String toReturn = "";
		for (int i = 0; i < vector.size(); i++)
			toReturn += vector.get(i).toString();
		return toReturn;
	}


	@Override
	public String toString() {
		return "EventsArray [event=" + event + ", vector=" + vector + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventsArray other = (EventsArray) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (vector == null) {
			if (other.vector != null)
				return false;
		} else if (!vector.equals(other.vector))
			return false;
		return true;
	}
	
	
}
	
	
	
	

	
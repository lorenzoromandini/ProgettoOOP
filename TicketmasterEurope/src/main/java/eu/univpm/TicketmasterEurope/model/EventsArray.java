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
	
	private int totalEvents;
	
	private int showedEvents;
	
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
	 * @param evento
	 */
	public EventsArray(Vector<Event> vector) {
		this.vector = vector;
	}
	

	/**
	 * @return the totalEvents
	 */
	public int getTotalEvents() {
		return totalEvents;
	}


	/**
	 * @param totalEvents the totalEvents to set
	 */
	public void setTotalEvents(int totalEvents) {
		this.totalEvents = totalEvents;
	}


	/**
	 * @return the showedEvents
	 */
	public int getShowedEvents() {
		return showedEvents;
	}


	/**
	 * @param showedElvents the showedEvents to set
	 */
	public void setShowedEvents(int showedEvents) {
		this.showedEvents = showedEvents;
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
		return "totalEvents=" + totalEvents + ", showedEvents=" + showedEvents + ", vector=" + vector + "";
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
	
	
	
	

	
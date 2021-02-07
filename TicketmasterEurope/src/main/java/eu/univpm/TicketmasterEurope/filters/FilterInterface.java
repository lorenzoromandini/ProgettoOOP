/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Vector;

import org.json.JSONArray;

import eu.univpm.TicketmasterEurope.exception.WrongValueException;


/** Questa è l'interfaccia contenente i metodi per il filtraggio di value
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public interface FilterInterface {

	public abstract JSONArray OneMonth(Vector<String> countries, String value) throws WrongValueException;
	public abstract JSONArray ThreeMonths(Vector<String> countries, String value) throws WrongValueException;
	public abstract JSONArray SixMonths(Vector<String> countries, String value) throws WrongValueException;
	public abstract JSONArray TwelveMonths(Vector<String> countries, String value) throws WrongValueException;

} 

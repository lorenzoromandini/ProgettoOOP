/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Vector;

import org.json.JSONArray;

import eu.univpm.TicketmasterEurope.exception.WrongCountryException;
import eu.univpm.TicketmasterEurope.exception.WrongValueException;


/** Questa è l'interfaccia contenente il metodo per il filtraggio in base al value e al periodo
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public interface FilterMonthInterface {

	public abstract JSONArray Months(Vector<String> countries, String value, int period) throws WrongValueException, WrongCountryException;

}
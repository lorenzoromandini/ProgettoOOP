/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Vector;

import org.json.JSONArray;

import eu.univpm.TicketmasterEurope.exception.WrongCountryException;
import eu.univpm.TicketmasterEurope.exception.WrongValueException;


/** Questa è l'interfaccia contenente i metodi per il filtraggio globale degli eventi per country o per market
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public interface CountryMarketFilterInterface {
	
	public abstract JSONArray MonthsCountryMarket(Vector<String> countriesmarkets, int period) throws WrongCountryException, WrongValueException;

} 
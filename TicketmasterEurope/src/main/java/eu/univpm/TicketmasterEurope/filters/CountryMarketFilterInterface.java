/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Vector;

import org.json.JSONArray;


/** Questa è l'interfaccia contenente i metodi per il filtraggio globale degli eventi per country o per market
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public interface CountryMarketFilterInterface {
	
	public abstract JSONArray OneMonthCountryMarket(Vector<String> countriesmarkets);
	public abstract JSONArray ThreeMonthsCountryMarket(Vector<String> countriesmarkets);
	public abstract JSONArray SixMonthsCountryMarket(Vector<String> countriesmarkets);
	public abstract JSONArray TwelveMonthsCountryMarket(Vector<String> countriesmarkets);

} 

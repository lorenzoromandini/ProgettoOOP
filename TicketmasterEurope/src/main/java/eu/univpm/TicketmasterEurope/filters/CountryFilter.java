/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import eu.univpm.TicketmasterEurope.exception.VoidGetException;
import eu.univpm.TicketmasterEurope.exception.WrongCountryException;
import eu.univpm.TicketmasterEurope.stats.Stats;
import eu.univpm.TicketmasterEurope.stats.StatsManagement;

/** Questa classe implementa CountryMarketFilterInterface e contiene i metodi per il filtraggio degli eventi in 
 *  un paese in funzione del periodo su cui si vuole effettuare tale ricerca
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class CountryFilter implements CountryMarketFilterInterface {
	
	
	Stats stats = new StatsManagement();
	
	VoidGetException Exception = new VoidGetException();
	
	
	 /** Questo metodo calcola il numero totale di eventi che hanno luogo nei paesi inseriti in un dato periodo.
	 * Restituisce un JSONArray contenente JSONObject che rappresentano i paesi e il numero totale di eventi di ciasccuno,
	 * oltre a mostrare quale di essi ospita il maggior numero di eventi e quale il minor numero di eventi
	 * 
	 * @param countries vettore di paesi
	 * @param period indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo 
	 */
	public JSONArray MonthsCountryMarket(Vector<String> countries, int period) throws WrongCountryException  {
		
		Exception.countryVectorException(countries);
		
        JSONArray countryEvents = new JSONArray();
				
		Iterator<String> it = countries.iterator();
		
		int i = 0;
		
		String maxCountry = null;
		String minCountry = null;
		int maxEvent = 0;
		int minEvent = 999999;
				
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getCountryEvents(it.next(), period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("country: ", countries.get(i));
			couple.put("totalEvents: ", totalElements);
			
			countryEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minCountry = countries.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxCountry = countries.get(i);
			}

			i++;
				
			}
		
		JSONObject maxCountryEvents = new JSONObject();
		maxCountryEvents.put("Country with most events: ", maxCountry);
		maxCountryEvents.put("totalEvents: ", maxEvent);
		JSONObject minCountryEvents = new JSONObject();
		minCountryEvents.put("Country with least events: ", minCountry);
		minCountryEvents.put("totalEvents: ", minEvent);
		
		countryEvents.put(maxCountryEvents);
		countryEvents.put(minCountryEvents);
		
		return countryEvents;
		
	 }
    


}

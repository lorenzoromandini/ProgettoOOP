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
import eu.univpm.TicketmasterEurope.exception.WrongValueException;
import eu.univpm.TicketmasterEurope.stats.Stats;
import eu.univpm.TicketmasterEurope.stats.StatsManagement;

/** Questa classe implementa FilterMonthInterface e contiene i metodi per il filtraggio degli eventi di 
 *  un source in base al paese e in funzione del periodo su cui si vuole effettuare tale ricerca
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class SourceComparison implements FilterMonthInterface {
	
	Stats stats = new StatsManagement();
	
	VoidGetException Exception = new VoidGetException();
	

	public JSONArray Months(Vector<String> sources, String country, int period) throws WrongValueException, WrongCountryException {
		
		Exception.sourceVectorException(sources);
		Exception.countryStringException(country);
		
		JSONArray sourceEvents = new JSONArray();
		
		Iterator<String> it = sources.iterator();
		
		int i = 0;
		
		String maxSource = null;
		String minSource = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSourceEvents(country, it.next(), period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("source: ", sources.get(i));
			couple.put("totalEvents: ", totalElements);
			sourceEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSource = sources.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSource = sources.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSourceEvents = new JSONObject();
		maxSourceEvents.put("Source with most events: ", maxSource);
		maxSourceEvents.put("totalEvents: ", maxEvent);
		JSONObject minSourceEvents = new JSONObject();
		minSourceEvents.put("Source with least events: ", minSource);
		minSourceEvents.put("totalEvents: ", minEvent);
		
		sourceEvents.put(maxSourceEvents);
		sourceEvents.put(minSourceEvents);
		
		return sourceEvents;

    }
	
 
	
}
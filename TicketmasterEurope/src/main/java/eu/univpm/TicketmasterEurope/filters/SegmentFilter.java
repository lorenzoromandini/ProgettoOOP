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
import eu.univpm.TicketmasterEurope.stats.*;


/** Questa classe implementa FilterMonthInterface e contiene i metodi per il filtraggio degli eventi in 
 *  un paese in base al segment e in funzione del periodo su cui si vuole effettuare tale ricerca
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class SegmentFilter implements FilterMonthInterface {
	
	StatsManagement stats = new StatsManagement();
	
	VoidGetException Exception = new VoidGetException();
	

	 /** Questo metodo calcola il numero totale di eventi di un determinato paese appartenenti ad una determinata tipologia in un dato periodo.
	 * Restituisce un JSONArray contenente JSONObject che rappresentano i paesi e il numero totale di eventi di ciascuno, 
	 * oltre a mostrare quale di essi ospita il maggior numero di eventi e quale il minor numero di eventi
	 * 
	 * @throws WrongValueException se viene inserita una tipologia di evento non ammesso 
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo
	 */
	public JSONArray Months(Vector<String> countries, String segment, int period) throws WrongValueException, WrongCountryException {
		
		Exception.countryVectorException(countries);
		Exception.segmentStringException(segment);
		
		JSONArray segmentEvents = new JSONArray();
		
		Iterator<String> it = countries.iterator();
		
		int i = 0;
		
		String maxCountry = null;
		String minCountry = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSegmentEvents(it.next(), segment, period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("country: ", countries.get(i));
			couple.put("totalEvents: ", totalElements);
			segmentEvents.put(couple);
			
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
		
		segmentEvents.put(maxCountryEvents);
		segmentEvents.put(minCountryEvents);
		
		return segmentEvents;
		
	}


}
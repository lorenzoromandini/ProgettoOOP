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

/** Questa classe implementa FilterMonthInterface e contiene i metodi per il filtraggio degli eventi in 
 *  un paese in base al source e in funzione del periodo su cui si vuole effettuare tale ricerca
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class SourceFilter implements FilterMonthInterface {
	
	Stats stats = new StatsManagement();
	
	VoidGetException Exception = new VoidGetException();
	

	 /** Questo metodo calcola il numero totale di eventi di un determinato paese distribuiti da un determinato source in un dato periodo.
	 * Restituisce un JSONArray contenente JSONObject che rappresentano i paesi e il numero totale di eventi di ciascuno, 
	 * oltre a mostrare quale di essi ospita il maggior numero di eventi e quale il minor numero di eventi
	 * 
	 * @param countries vettore di paesi
	 * @param source distributore dei biglietti dell'evento
	 * @param period indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto
	 * @throws WrongValueException se viene inserito un source non ammesso 
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo
	 */
	public JSONArray Months(Vector<String> countries, String source, int period) throws WrongValueException, WrongCountryException {
		
		Exception.countryVectorException(countries);
		Exception.sourceStringException(source);
		
		JSONArray sourceEvents = new JSONArray();
		
		Iterator<String> it = countries.iterator();
		
		int i = 0;
		
		String maxCountry = null;
		String minCountry = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSourceEvents(it.next(), source, period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("country: ", countries.get(i));
			couple.put("totalEvents: ", totalElements);
			sourceEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
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
		
		sourceEvents.put(maxCountryEvents);
		sourceEvents.put(minCountryEvents);
		
		return sourceEvents;

    }

 
	
}
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
 *  un segment in base al paese e in funzione del periodo su cui si vuole effettuare tale ricerca
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class SegmentComparison implements FilterMonthInterface {
	
	Stats stats = new StatsManagement();
	
	VoidGetException Exception = new VoidGetException();
	

	public JSONArray Months(Vector<String> segments, String country, int period) throws WrongValueException, WrongCountryException {
		
		Exception.segmentVectorException(segments);
		Exception.countryStringException(country);
		
		JSONArray segmentEvents = new JSONArray();
		
		Iterator<String> it = segments.iterator();
		
		int i = 0;
		
		String maxSegment = null;
		String minSegment = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSegmentEvents(country, it.next(), period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("segment: ", segments.get(i));
			couple.put("totalEvents: ", totalElements);
			segmentEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSegment = segments.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSegment = segments.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSegmentEvents = new JSONObject();
		maxSegmentEvents.put("Segment with most events: ", maxSegment);
		maxSegmentEvents.put("totalEvents: ", maxEvent);
		JSONObject minSegmentEvents = new JSONObject();
		minSegmentEvents.put("Segment with least events: ", minSegment);
		minSegmentEvents.put("totalEvents: ", minEvent);
		
		segmentEvents.put(maxSegmentEvents);
		segmentEvents.put(minSegmentEvents);
		
		return segmentEvents;

    }
	


	
}
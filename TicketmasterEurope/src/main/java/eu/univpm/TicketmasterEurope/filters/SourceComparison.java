/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import eu.univpm.TicketmasterEurope.exception.WrongValueException;
import eu.univpm.TicketmasterEurope.stats.Stats;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class SourceComparison implements FilterInterface {
	
	Stats stats;
	

	public JSONArray OneMonth(Vector<String> sources, String country) throws WrongValueException {
		
		JSONArray sourceEvents = new JSONArray();
		
		Vector<JSONObject> sourceVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = sources.iterator();
		
		int i = 0;
		
		String maxSource = null;
		String minSource = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSourceEvents(country, it.next(), 1);
			sourceVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", sources.get(i));
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
	

	public JSONArray ThreeMonths(Vector<String> sources, String country) throws WrongValueException {
		
        JSONArray sourceEvents = new JSONArray();
		
		Vector<JSONObject> sourceVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = sources.iterator();
		
		int i = 0;
		
		String maxSource = null;
		String minSource = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSourceEvents(country, it.next(), 3);
			sourceVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", sources.get(i));
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
	

	public JSONArray SixMonths(Vector<String> sources, String country) throws WrongValueException {
		
        JSONArray sourceEvents = new JSONArray();
		
		Vector<JSONObject> sourceVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = sources.iterator();
		
		int i = 0;
		
		String maxSource = null;
		String minSource = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSourceEvents(country, it.next(), 6);
			sourceVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", sources.get(i));
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
	

	public JSONArray TwelveMonths(Vector<String> sources, String country) throws WrongValueException {
		
        JSONArray sourceEvents = new JSONArray();
		
		Vector<JSONObject> sourceVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = sources.iterator();
		
		int i = 0;
		
		String maxSource = null;
		String minSource = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSourceEvents(country, it.next(), 12);
			sourceVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", sources.get(i));
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


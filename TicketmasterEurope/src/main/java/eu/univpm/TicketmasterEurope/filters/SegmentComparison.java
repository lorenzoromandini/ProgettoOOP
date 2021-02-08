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
public class SegmentComparison implements FilterInterface {
	
	Stats stats;
	

	public JSONArray OneMonth(Vector<String> segments, String country) throws WrongValueException {
		
		JSONArray segmentEvents = new JSONArray();
		
		Vector<JSONObject> segmentVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = segments.iterator();
		
		int i = 0;
		
		String maxSegment = null;
		String minSegment = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSegmentEvents(country, it.next(), 1);
			segmentVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", segments.get(i));
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
	

	public JSONArray ThreeMonths(Vector<String> segments, String country) throws WrongValueException {
		
        JSONArray segmentEvents = new JSONArray();
		
		Vector<JSONObject> segmentVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = segments.iterator();
		
		int i = 0;
		
		String maxSegment = null;
		String minSegment = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSegmentEvents(country, it.next(), 3);
			segmentVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", segments.get(i));
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
	

	public JSONArray SixMonths(Vector<String> segments, String country) throws WrongValueException {
		
        JSONArray segmentEvents = new JSONArray();
		
		Vector<JSONObject> segmentVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = segments.iterator();
		
		int i = 0;
		
		String maxSegment = null;
		String minSegment = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSegmentEvents(country, it.next(), 6);
			segmentVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", segments.get(i));
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
	

	public JSONArray TwelveMonths(Vector<String> segments, String country) throws WrongValueException {
		
        JSONArray segmentEvents = new JSONArray();
		
		Vector<JSONObject> segmentVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		
		Iterator<String> it = segments.iterator();
		
		int i = 0;
		
		String maxSegment = null;
		String minSegment = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSegmentEvents(country, it.next(), 12);
			segmentVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Country: ", segments.get(i));
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


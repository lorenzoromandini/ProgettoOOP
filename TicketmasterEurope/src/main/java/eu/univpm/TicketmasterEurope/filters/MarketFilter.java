/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import eu.univpm.TicketmasterEurope.exception.WrongValueException;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class MarketFilter implements FilterInterface {
	
	Stats stats = new Stats();
	

	public JSONArray OneMonth(Vector<String> markets, String value) throws WrongValueException {
		
        JSONArray marketEvents = new JSONArray();
		
		Vector<JSONObject> marketVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		Vector<JSONObject> market_totalEvents = new Vector<JSONObject>();
		
		Iterator<String> it = markets.iterator();
		
		int i = 0;
		
		String maxMarket = null;
		String minMarket = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.totalMarketEvents(it.next(), value);
			marketVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Market: ", markets.get(i));
			couple.put("totalEvents: ", totalElements);
			market_totalEvents.add(couple);
			marketEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minMarket = markets.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxMarket = markets.get(i);
			}

			i++;
				
			}
		
		JSONObject maxMarketEvents = new JSONObject();
		maxMarketEvents.put("Market with most events: ", maxMarket);
		maxMarketEvents.put("totalEvents: ", maxEvent);
		JSONObject minMarketEvents = new JSONObject();
		minMarketEvents.put("Market with least events: ", minMarket);
		minMarketEvents.put("totalEvents: ", minEvent);
		
		marketEvents.put(maxMarketEvents);
		marketEvents.put(minMarketEvents);

    }

	public JSONArray ThreeMonths(Vector<String> markets, String value) throws WrongValueException {
		
        JSONArray marketEvents = new JSONArray();
		
		Vector<JSONObject> marketVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		Vector<JSONObject> market_totalEvents = new Vector<JSONObject>();
		
		Iterator<String> it = markets.iterator();
		
		int i = 0;
		
		String maxMarket = null;
		String minMarket = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.totalMarketEvents(it.next(), value);
			marketVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Market: ", markets.get(i));
			couple.put("totalEvents: ", totalElements);
			market_totalEvents.add(couple);
			marketEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minMarket = markets.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxMarket = markets.get(i);
			}

			i++;
				
			}
		
		JSONObject maxMarketEvents = new JSONObject();
		maxMarketEvents.put("Market with most events: ", maxMarket);
		maxMarketEvents.put("totalEvents: ", maxEvent);
		JSONObject minMarketEvents = new JSONObject();
		minMarketEvents.put("Market with least events: ", minMarket);
		minMarketEvents.put("totalEvents: ", minEvent);
		
		marketEvents.put(maxMarketEvents);
		marketEvents.put(minMarketEvents);
		
	}

	public JSONArray SixMonths(Vector<String> markets, String value) throws WrongValueException {
		
        JSONArray marketEvents = new JSONArray();
		
		Vector<JSONObject> marketVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		Vector<JSONObject> market_totalEvents = new Vector<JSONObject>();
		
		Iterator<String> it = markets.iterator();
		
		int i = 0;
		
		String maxMarket = null;
		String minMarket = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.totalMarketEvents(it.next(), value);
			marketVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Market: ", markets.get(i));
			couple.put("totalEvents: ", totalElements);
			market_totalEvents.add(couple);
			marketEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minMarket = markets.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxMarket = markets.get(i);
			}

			i++;
				
			}
		
		JSONObject maxMarketEvents = new JSONObject();
		maxMarketEvents.put("Market with most events: ", maxMarket);
		maxMarketEvents.put("totalEvents: ", maxEvent);
		JSONObject minMarketEvents = new JSONObject();
		minMarketEvents.put("Market with least events: ", minMarket);
		minMarketEvents.put("totalEvents: ", minEvent);
		
		marketEvents.put(maxMarketEvents);
		marketEvents.put(minMarketEvents);
		
	}

	public JSONArray TwelveMonths(Vector<String> markets, String value) throws WrongValueException {
		
        JSONArray marketEvents = new JSONArray();
		
		Vector<JSONObject> marketVector = new Vector<JSONObject>();
		Vector<Integer> totalEvents = new Vector<Integer>();
		Vector<JSONObject> market_totalEvents = new Vector<JSONObject>();
		
		Iterator<String> it = markets.iterator();
		
		int i = 0;
		
		String maxMarket = null;
		String minMarket = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.totalMarketEvents(it.next(), value);
			marketVector.add(object);
			int totalElements = object.getInt("totalElements");
			totalEvents.add(totalElements);
			
			JSONObject couple = new JSONObject();
			couple.put("Market: ", markets.get(i));
			couple.put("totalEvents: ", totalElements);
			market_totalEvents.add(couple);
			marketEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minMarket = markets.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxMarket = markets.get(i);
			}

			i++;
				
			}
		
		JSONObject maxMarketEvents = new JSONObject();
		maxMarketEvents.put("Market with most events: ", maxMarket);
		maxMarketEvents.put("totalEvents: ", maxEvent);
		JSONObject minMarketEvents = new JSONObject();
		minMarketEvents.put("Market with least events: ", minMarket);
		minMarketEvents.put("totalEvents: ", minEvent);
		
		marketEvents.put(maxMarketEvents);
		marketEvents.put(minMarketEvents);
		
	}
 
	
}

/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import eu.univpm.TicketmasterEurope.stats.Stats;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class MarketFilter implements CountryMarketFilterInterface {
	
	Stats stats;
	

	public JSONArray OneMonthCountryMarket(Vector<String> markets)  {
		
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
			object = stats.getMarketEvents(it.next(), 1);
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
		
		return marketEvents;

    }

	public JSONArray ThreeMonthsCountryMarket(Vector<String> markets) {
		
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
			object = stats.getMarketEvents(it.next(), 3);
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
		
		return marketEvents;
		
	}

	public JSONArray SixMonthsCountryMarket(Vector<String> markets) {
		
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
			object = stats.getMarketEvents(it.next(), 6);
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
		
		return marketEvents;
		
	}

	public JSONArray TwelveMonthsCountryMarket(Vector<String> markets) {
		
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
			object = stats.getMarketEvents(it.next(), 12);
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
		
		return marketEvents;
		
	}


}

/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import eu.univpm.TicketmasterEurope.stats.Stats;
import eu.univpm.TicketmasterEurope.stats.StatsManagement;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class MarketFilter implements CountryMarketFilterInterface {
	
	Stats stats = new StatsManagement();
	

	public JSONArray OneMonthCountryMarket(Vector<String> markets)  {
		
        JSONArray marketEvents = new JSONArray();
		
		Iterator<String> it = markets.iterator();
		
		int i = 0;
		
		String maxMarket = null;
		String minMarket = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getMarketEvents(it.next(), 1);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("market: ", markets.get(i));
			couple.put("totalEvents: ", totalElements);
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
		
		Iterator<String> it = markets.iterator();
		
		int i = 0;
		
		String maxMarket = null;
		String minMarket = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getMarketEvents(it.next(), 3);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("market: ", markets.get(i));
			couple.put("totalEvents: ", totalElements);
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
		
		Iterator<String> it = markets.iterator();
		
		int i = 0;
		
		String maxMarket = null;
		String minMarket = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getMarketEvents(it.next(), 6);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("market: ", markets.get(i));
			couple.put("totalEvents: ", totalElements);
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
		
		Iterator<String> it = markets.iterator();
		
		int i = 0;
		
		String maxMarket = null;
		String minMarket = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getMarketEvents(it.next(), 12);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("market: ", markets.get(i));
			couple.put("totalEvents: ", totalElements);
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
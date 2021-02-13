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


/** Questa classe implementa CountryMarketFilterInterface e contiene i metodi per il filtraggio degli eventi in 
 *  un market in funzione del periodo su cui si vuole effettuare tale ricerca
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class MarketFilter implements CountryMarketFilterInterface {
	
	Stats stats = new StatsManagement();
	
	VoidGetException Exception = new VoidGetException();
	

	 /** Questo metodo calcola il numero totale di eventi che hanno luogo nei market inseriti in un dato periodo.
	 * Restituisce un JSONArray contenente JSONObject che rappresentano i market e il numero totale di eventi di ciascuno, 
	 * oltre a mostrare quale di essi ospita il maggior numero di eventi e quale il minor numero di eventi
	 * 
	 * @param markets vettore di market
	 * @param period indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto
     * @throws WrongValueException se viene inserito il codice di un market non europeo 
	 */
	public JSONArray MonthsCountryMarket(Vector<String> markets, int period) throws WrongValueException, WrongCountryException  {
		
		Exception.marketVectorException(markets);
		
        JSONArray marketEvents = new JSONArray();
		
		Iterator<String> it = markets.iterator();
		
		int i = 0;
		
		String maxMarket = null;
		String minMarket = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getMarketEvents(it.next(), period);
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
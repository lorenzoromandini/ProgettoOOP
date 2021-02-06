/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.time.LocalDate;
import java.util.Vector;
import org.json.JSONArray;

import eu.univpm.TicketmasterEurope.exception.*;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Filter {
	
	private Vector<String> countries = new Vector<String>();
	
	private Vector<String> markets = new Vector<String>();
	
	private String param;
	
	private String value;
	
	private LocalDate data = java.time.LocalDate.now();
	
	private int period;

	
	/**
	 * 
	 */
	public Filter() {
		super();
	}


	/**
	 * @param countries
	 * @param markets
	 * @param param
	 * @param value
	 * @param data
	 * @param period
	 */
	public Filter(Vector<String> countries, Vector<String> markets, String param, String value, LocalDate data, int period) {
		super();
		this.countries = countries;
		this.markets = markets;
		this.param = param;
		this.value = value;
		this.data = data;
		this.period = period;
	}
	
	
	public JSONArray PeriodParameterValueFilter() throws WrongPeriodException, WrongParameterException, WrongValueException {
		
		JSONArray array = new JSONArray ();
		
		if(period == 1) {
			
			else if (param.equals("marketId")) {
				MarketFilter filter = new MarketFilter();
				array = filter.OneMonth(markets, value);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.OneMonth(countries, value);
			} 
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.OneMonth(countries, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.OneMonth(countries, value);
				
            }
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.OneMonth(countries, value);
				
			}
			
		    else  throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
                                                           + "segment, genre, subGenre, source");
			
		}
			
		if(period == 3) {
			
			else if (param.equals("marketId")) {
				MarketFilter filter = new MarketFilter();
				array = filter.ThreeMonths(markets, value);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.ThreeMonths(countries, value);
			}
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.ThreeMonths(countries, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.ThreeMonths(countries, value);
				
			}
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.ThreeMonths(countries, value);
				
			}
			
		    else  throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
                                                           + "segment, genre, subGenre, source");
			
		}
				
		if(period == 6) {
			
			else if (param.equals("marketId")) {
				MarketFilter filter = new MarketFilter();
				array = filter.SixMonths(markets, value);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.SixMonths(countries, value);
			}
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.SixMonths(countries, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.SixMonths(countries, value);
				
			}
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.SixMonths(countries, value);
				
			}
			
		    else  throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
		    		                                       + "segment, genre, subGenre, source");
			
		}
		
		if(period == 12) {
			
			else if (param.equals("marketId")) {
				MarketFilter filter = new MarketFilter();
				array = filter.TwelveMonths(markets, value);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.TwelveMonths(countries, value);
			}
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.TwelveMonths(countries, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.TwelveMonths(countries, value);
				
			}
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.TwelveMonth(countries, value);
				
			}
			
		    else throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
                                                          + "segment, genre, subGenre, source");
			
		}
		
        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		
		return array;
	
   }
	

	

}

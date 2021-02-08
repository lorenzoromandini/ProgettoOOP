/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Vector;
import org.json.JSONArray;

import eu.univpm.TicketmasterEurope.exception.*;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class Filter {
	
	private String comparison;
	
	private Vector<String> elements = new Vector<String>();
		
	private String param;
	
	private String value;
	
	private int period;
	
	
	/**
	 * 
	 */
	public Filter() {
		super();
	}


	/**
	 * @param comparison
	 * @param elements
	 * @param param
	 * @param value
	 * @param period
	 */
	public Filter(String comparison, Vector<String> elements, String param, String value, int period) {
		super();
		this.comparison = comparison;
		this.elements = elements;
		this.param = param;
		this.value = value;
		this.period = period;
	}

	
	public JSONArray getFilter() throws WrongComparisonException, WrongPeriodException, WrongParameterException, WrongValueException {
		
		JSONArray array = new JSONArray ();
		
		if(comparison == "country") {
			
		}
		
		else if(comparison == "market") {
			
		}
		
		else if(comparison == "source") {
			
		}
		
		else if(comparison == "segment") {
			
		}
        
		else if(comparison == "genre") {
			
		}
        
		else if(comparison == "subgenre") {
			
		}
		
		if(period == 1) {
			
			if (param.equals("countryevents")) {
				CountryFilter filter = new CountryFilter();
				array = filter.OneMonthCountryMarket(elements);
			}
			
			if (param.equals("marketevents")) {
				MarketFilter filter = new MarketFilter();
				array = filter.OneMonthCountryMarket(elements);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.OneMonth(elements, value);
			} 
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.OneMonth(elements, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.OneMonth(elements, value);
				
            }
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.OneMonth(elements, value);
				
			}
			
		    else throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
                                                          + "segment, genre, subGenre, source");
			
		}
			
		else if(period == 3) {
			
			if (param.equals("countryevents")) {
				CountryFilter filter = new CountryFilter();
				array = filter.ThreeMonthsCountryMarket(elements);
			}
			
			if (param.equals("marketevents")) {
				MarketFilter filter = new MarketFilter();
				array = filter.ThreeMonthsCountryMarket(elements);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.ThreeMonths(elements, value);
			}
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.ThreeMonths(elements, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.ThreeMonths(elements, value);
				
			}
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.ThreeMonths(elements, value);
				
			}
			
		    else throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
                                                          + "segment, genre, subGenre, source");
			
		}
				
		else if(period == 6) {
			
			if (param.equals("countryevents")) {
				CountryFilter filter = new CountryFilter();
				array = filter.SixMonthsCountryMarket(elements);
			}
			
			if (param.equals("marketevents")) {
				MarketFilter filter = new MarketFilter();
				array = filter.SixMonthsCountryMarket(elements);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.SixMonths(elements, value);
			}
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.SixMonths(elements, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.SixMonths(elements, value);
				
			}
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.SixMonths(elements, value);
				
			}
			
		    else throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
		    		                                      + "segment, genre, subGenre, source");
			
		}
		
		else if(period == 12) {
			
			if (param.equals("countryevents")) {
				CountryFilter filter = new CountryFilter();
				array = filter.TwelveMonthsCountryMarket(elements);
			}
			
			if (param.equals("marketevents")) {
				MarketFilter filter = new MarketFilter();
				array = filter.TwelveMonthsCountryMarket(elements);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.TwelveMonths(elements, value);
			}
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.TwelveMonths(elements, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.TwelveMonths(elements, value);
				
			}
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.TwelveMonths(elements, value);
				
			}
			
		    else throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
                                                          + "segment, genre, subGenre, source");
			
		}
		
        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		
		return array;
	
   }
	

	

}

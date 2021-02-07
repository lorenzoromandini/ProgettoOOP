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
	
	private Vector<String> countriesmarkets = new Vector<String>();
		
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
	 * @param countriesmarkets
	 * @param param
	 * @param value
	 * @param data
	 * @param period
	 */
	public Filter(Vector<String> countriesmarkets, String param, String value, int period) {
		
		this.countriesmarkets = countriesmarkets;
		this.param = param;
		this.value = value;
		this.period = period;
	}
	
	
	public JSONArray PeriodParameterValueFilter() throws WrongPeriodException, WrongParameterException, WrongValueException {
		
		JSONArray array = new JSONArray ();
		
		if(period == 1) {
			
			if (param.equals("country")) {
				CountryFilter filter = new CountryFilter();
				array = filter.OneMonthCountryMarket(countriesmarkets);
			}
			
			if (param.equals("market")) {
				MarketFilter filter = new MarketFilter();
				array = filter.OneMonthCountryMarket(countriesmarkets);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.OneMonth(countriesmarkets, value);
			} 
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.OneMonth(countriesmarkets, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.OneMonth(countriesmarkets, value);
				
            }
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.OneMonth(countriesmarkets, value);
				
			}
			
		    else throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
                                                          + "segment, genre, subGenre, source");
			
		}
			
		else if(period == 3) {
			
			if (param.equals("country")) {
				CountryFilter filter = new CountryFilter();
				array = filter.OneMonthCountryMarket(countriesmarkets);
			}
			
			if (param.equals("market")) {
				MarketFilter filter = new MarketFilter();
				array = filter.OneMonthCountryMarket(countriesmarkets);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.ThreeMonths(countriesmarkets, value);
			}
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.ThreeMonths(countriesmarkets, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.ThreeMonths(countriesmarkets, value);
				
			}
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.ThreeMonths(countriesmarkets, value);
				
			}
			
		    else throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
                                                          + "segment, genre, subGenre, source");
			
		}
				
		else if(period == 6) {
			
			if (param.equals("country")) {
				CountryFilter filter = new CountryFilter();
				array = filter.OneMonthCountryMarket(countriesmarkets);
			}
			
			if (param.equals("market")) {
				MarketFilter filter = new MarketFilter();
				array = filter.OneMonthCountryMarket(countriesmarkets);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.SixMonths(countriesmarkets, value);
			}
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.SixMonths(countriesmarkets, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.SixMonths(countriesmarkets, value);
				
			}
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.SixMonths(countriesmarkets, value);
				
			}
			
		    else throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
		    		                                      + "segment, genre, subGenre, source");
			
		}
		
		else if(period == 12) {
			
			if (param.equals("country")) {
				CountryFilter filter = new CountryFilter();
				array = filter.OneMonthCountryMarket(countriesmarkets);
			}
			
			if (param.equals("market")) {
				MarketFilter filter = new MarketFilter();
				array = filter.OneMonthCountryMarket(countriesmarkets);
			}
			
			else if (param.equals("segment")) {
				SegmentFilter filter = new SegmentFilter();
				array = filter.TwelveMonths(countriesmarkets, value);
			}
			
			else if (param.equals("genre")) {
				GenreFilter filter = new GenreFilter();
				array = filter.TwelveMonths(countriesmarkets, value);
			}
			
			else if (param.equals("subGenre")) {
				SubGenreFilter filter = new SubGenreFilter();
				array = filter.TwelveMonths(countriesmarkets, value);
				
			}
			
			else if (param.equals("source")) {
				SourceFilter filter = new SourceFilter();
				array = filter.TwelveMonths(countriesmarkets, value);
				
			}
			
		    else throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra marketId, "
                                                          + "segment, genre, subGenre, source");
			
		}
		
        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		
		return array;
	
   }
	

	

}

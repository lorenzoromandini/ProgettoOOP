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
	
	private String param;
	
	private String value;
	
	private LocalDate data = java.time.LocalDate.now();
	
	private int period;

	
	/**
	 * @param countries
	 * @param param
	 * @param value
	 * @param data
	 * @param period
	 */
	public Filter(Vector<String> countries, String param, String value, LocalDate data, int period) {
		super();
		this.countries = countries;
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
				array = filter.OneMonth(countries, value);
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
			
		    else  throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra placement,"
					                                       + " city, marketId, segment, genre, subGenre");
			
		}
			
		if(period == 3) {
			
			else if (param.equals("marketId")) {
				MarketFilter filter = new MarketFilter();
				array = filter.ThreeMonths(countries, value);
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
			
		    else  throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra placement,"
					                                       + " city, marketId, segment, genre, subGenre");
			
		}
				
		if(period == 6) {
			
			else if (param.equals("marketId")) {
				MarketFilter filter = new MarketFilter();
				array = filter.SixMonths(countries, value);
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
			
		    else  throw new WrongParameterException (param + " non è un ammesso. Inserisci una stringa tra placement,"
					                                       + " city, marketId, segment, genre, subGenre");
			
		}
		
		if(period == 12) {
			
			else if (param.equals("marketId")) {
				MarketFilter filter = new MarketFilter();
				array = filter.TwelveMonths(countries, value);
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
			
		    else throw new WrongParameterException (param + " non è una stringa ammessa. Inserisci una stringa tra placement,"
					                                       + " city, marketId, segment, genre, subGenre");
			
		}
		
        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero che sia o 1 o 3 o 6 o 12.");
		
		return array;
	
   }
	

	

}

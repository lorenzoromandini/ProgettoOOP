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
		
		JSONArray array = new JSONArray();
		
		if(comparison.equals("country")) {
			
			if(period == 1) {
				
				if (param.equals("total")) {
					CountryFilter filter = new CountryFilter();
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
				
			    else throw new WrongParameterException (param + " non è un parametro ammesso. Inserisci una stringa tra marketId, "
	                                                          + "segment, genre, subGenre, source");
				
			}
				
			else if(period == 3) {
				
				if (param.equals("total")) {
					CountryFilter filter = new CountryFilter();
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
				
			    else throw new WrongParameterException (param + " non è un parametro ammesso. Inserisci una stringa tra marketId, "
	                                                          + "segment, genre, subGenre, source");
				
			}
					
			else if(period == 6) {
				
				if (param.equals("total")) {
					CountryFilter filter = new CountryFilter();
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
				
			    else throw new WrongParameterException (param + " non è un parametro ammesso. Inserisci una stringa tra marketId, "
			    		                                      + "segment, genre, subGenre, source");
				
			}
			
			else if(period == 12) {
				
				if (param.equals("total")) {
					CountryFilter filter = new CountryFilter();
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
				
			    else throw new WrongParameterException (param + " non è un parametro ammesso. Inserisci una stringa tra marketId, "
	                                                          + "segment, genre, subGenre, source");
				
			}
			
	        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
			
		}
		
		else if(comparison.equals("market")) {
			
            if(period == 1) {
				
				if (param.equals("total")) {
					MarketFilter filter = new MarketFilter();
					array = filter.OneMonthCountryMarket(elements);
				}
				
				else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa total.");
				
		    }
            
            else if(period == 3) {
				
				if (param.equals("total")) {
					MarketFilter filter = new MarketFilter();
					array = filter.ThreeMonthsCountryMarket(elements);
				}
				
				else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa total.");
				
		    }
            
            else if(period == 6) {
				
				if (param.equals("total")) {
					MarketFilter filter = new MarketFilter();
					array = filter.SixMonthsCountryMarket(elements);
				}
				
				else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa total.");
				
		    }
            
            else if(period == 12) {
				
				if (param.equals("total")) {
					MarketFilter filter = new MarketFilter();
					array = filter.TwelveMonthsCountryMarket(elements);
				}
				
				else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa total.");
				
		    }
            
            else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
			
		    }
		
		else if(comparison.equals("source")) {
			
			if(period == 1) {
				
				if (param.equals("country")) {
					SourceComparison filter = new SourceComparison();
					array = filter.OneMonth(elements, value);
				}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
			else if(period == 3) {
			
        	if (param.equals("country")) {
				SourceComparison filter = new SourceComparison();
				array = filter.ThreeMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
			else if(period == 6) {
			
        	if (param.equals("country")) {
				SourceComparison filter = new SourceComparison();
				array = filter.SixMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
			else if(period == 12) {
			
        	if (param.equals("country")) {
				SourceComparison filter = new SourceComparison();
				array = filter.TwelveMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		
	    }
		
		else if(comparison.equals("segment")) {
			
            if(period == 1) {
				
				if (param.equals("country")) {
					SegmentComparison filter = new SegmentComparison();
					array = filter.OneMonth(elements, value);
				}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 3) {
			
        	if (param.equals("country")) {
        		SegmentComparison filter = new SegmentComparison();
				array = filter.ThreeMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 6) {
			
        	if (param.equals("country")) {
        		SegmentComparison filter = new SegmentComparison();
				array = filter.SixMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 12) {
			
        	if (param.equals("country")) {
        		SegmentComparison filter = new SegmentComparison();
				array = filter.TwelveMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
			
		}
        
		else if(comparison.equals("genre")) {
			
            if(period == 1) {
				
				if (param.equals("country")) {
					GenreComparison filter = new GenreComparison();
					array = filter.OneMonth(elements, value);
				}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 3) {
			
        	if (param.equals("country")) {
        		GenreComparison filter = new GenreComparison();
				array = filter.ThreeMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 6) {
			
        	if (param.equals("country")) {
        		GenreComparison filter = new GenreComparison();
				array = filter.SixMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 12) {
			
        	if (param.equals("country")) {
        		GenreComparison filter = new GenreComparison();
				array = filter.TwelveMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
			
		}
        
		else if(comparison.equals("subgenre")) {
			
            if(period == 1) {
				
				if (param.equals("country")) {
					SubGenreComparison filter = new SubGenreComparison();
					array = filter.OneMonth(elements, value);
				}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 3) {
			
        	if (param.equals("country")) {
        		SubGenreComparison filter = new SubGenreComparison();
				array = filter.ThreeMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 6) {
			
        	if (param.equals("country")) {
        		SubGenreComparison filter = new SubGenreComparison();
				array = filter.SixMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 12) {
			
        	if (param.equals("country")) {
        		SubGenreComparison filter = new SubGenreComparison();
				array = filter.TwelveMonths(elements, value);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
			
		}
		
		else throw new WrongComparisonException(comparison + " non è una stringa ammessa. Inserisci una stringa tra "
			                                               + "country, market, source, segment, genre o subgenre.");
		
		return array;
		
	}
	
	
}
		
		
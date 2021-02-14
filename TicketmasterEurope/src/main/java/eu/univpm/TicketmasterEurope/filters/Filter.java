/**
 * 
 */
package eu.univpm.TicketmasterEurope.filters;

import java.util.Vector;
import org.json.JSONArray;

import eu.univpm.TicketmasterEurope.exception.*;


/** Questa classe contiene i metodi necessari al filtraggio
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class Filter {
	
	/**
	 * Indica il tipo di elementi che si vogliono confrontare
	 */
	private String comparison;
	
	/**
	 * Indica il vettore degli elementi da confrontare
	 */
	private Vector<String> elements = new Vector<String>();
		
	/**
	 * Indica il parametro su cui si vuole effettuare il confronto
	 */
	private String param;
	
	/**
	 * Indica il valore del parametro su cui si vuole effettuare il confronto
	 */
	private String value;
	
	/**
	 * Indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto
	 */
	private int period;


	/** Costruttore della classe
	 * 
	 * @param comparison è una String che rappresenta il tipo di elementi che si vogliono confrontare
	 * @param elements é un Vector di String che rappresenta il vettore degli elementi da confrontare
	 * @param param è una String che rappresenta il parametro su cui si vuole effettuare il confronto
	 * @param value è una String che rappresenta il valore del parametro su cui si vuole effettuare il confronto
	 * @param period è un int che rappresenta il periodo temporale (in mesi) su cui si vuole effettuare il confronto
	 */
	public Filter(String comparison, Vector<String> elements, String param, String value, int period) {
		this.comparison = comparison;
		this.elements = elements;
		this.param = param;
		this.value = value;
		this.period = period;
	}

	
	/** Questo metodo filtra il comparison, il param e il period. Richiama altri metodi per filtrare il value.
	 * 
	 * @return array - JSONArray contenente gli elementi filtrati e le statische relative al numero di eventi
	 * @throws WrongComparisonException se la String inserita non è una tra country, market, source, segment, genre o subgenre
	 * @throws WrongPeriodException se l'int inserito non è uno tra 1, 3, 6 o 12
	 * @throws WrongParameterException se la String inserita non è una tra country, segment, genre, subGenre, source
	 * @throws WrongValueException se la String inserita per value è errata
	 * @throws WrongCountryException se viene inserito il codice di un paese non europeo
	 */
	public JSONArray getFilter() throws WrongComparisonException, WrongPeriodException, WrongParameterException, WrongValueException, WrongCountryException {
		
		JSONArray array = new JSONArray();
		
		if(comparison.equals("country")) {
			
			if(period == 1) {
				
				if (param.equals("total")) { 
					CountryFilter filter = new CountryFilter();
					array = filter.MonthsCountryMarket(elements, 1);
				}
				
				else if (param.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.Months(elements, value, 1);
				} 
				
				else if (param.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.Months(elements, value, 1);
				}
				
				else if (param.equals("subGenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.Months(elements, value, 1);
					
	            }
				
				else if (param.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.Months(elements, value, 1);
					
				}
				
			    else throw new WrongParameterException (param + " non è un parametro ammesso. Inserisci una stringa tra marketId, "
	                                                          + "segment, genre, subGenre, source");
				
			}
				
			else if(period == 3) {
				
				if (param.equals("total")) {
					CountryFilter filter = new CountryFilter();
					array = filter.MonthsCountryMarket(elements, 3);
				}
				
				else if (param.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.Months(elements, value, 3);
				}
				
				else if (param.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.Months(elements, value, 3);
				}
				
				else if (param.equals("subGenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.Months(elements, value, 3);
					
				}
				
				else if (param.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.Months(elements, value, 3);
					
				}
				
			    else throw new WrongParameterException (param + " non è un parametro ammesso. Inserisci una stringa tra marketId, "
	                                                          + "segment, genre, subGenre, source");
				
			}
					
			else if(period == 6) {
				
				if (param.equals("total")) {
					CountryFilter filter = new CountryFilter();
					array = filter.MonthsCountryMarket(elements, 6);
				}
				
				else if (param.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.Months(elements, value, 6);
				}
				
				else if (param.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.Months(elements, value, 6);
				}
				
				else if (param.equals("subGenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.Months(elements, value, 6);
					
				}
				
				else if (param.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.Months(elements, value, 6);
					
				}
				
			    else throw new WrongParameterException (param + " non è un parametro ammesso. Inserisci una stringa tra marketId, "
			    		                                      + "segment, genre, subGenre, source");
				
			}
			
			else if(period == 12) {
				
				if (param.equals("total")) {
					CountryFilter filter = new CountryFilter();
					array = filter.MonthsCountryMarket(elements, 12);
				}
				
				else if (param.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.Months(elements, value, 12);
				}
				
				else if (param.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.Months(elements, value, 12);
				}
				
				else if (param.equals("subGenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.Months(elements, value, 12);
					
				}
				
				else if (param.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.Months(elements, value, 12);
					
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
					array = filter.MonthsCountryMarket(elements, 1);
				}
				
				else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa total.");
				
		    }
            
            else if(period == 3) {
				
				if (param.equals("total")) {
					MarketFilter filter = new MarketFilter();
					array = filter.MonthsCountryMarket(elements, 3);
				}
				
				else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa total.");
				
		    }
            
            else if(period == 6) {
				
				if (param.equals("total")) {
					MarketFilter filter = new MarketFilter();
					array = filter.MonthsCountryMarket(elements, 6);
				}
				
				else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa total.");
				
		    }
            
            else if(period == 12) {
				
				if (param.equals("total")) {
					MarketFilter filter = new MarketFilter();
					array = filter.MonthsCountryMarket(elements, 12);
				}
				
				else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa total.");
				
		    }
            
            else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
			
		    }
		
		else if(comparison.equals("source")) {
			
			if(period == 1) {
				
				if (param.equals("country")) {
					SourceComparison filter = new SourceComparison();
					array = filter.Months(elements, value, 1);
				}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
			else if(period == 3) {
			
        	if (param.equals("country")) {
				SourceComparison filter = new SourceComparison();
				array = filter.Months(elements, value, 3);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
			else if(period == 6) {
			
        	if (param.equals("country")) {
				SourceComparison filter = new SourceComparison();
				array = filter.Months(elements, value, 6);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
			else if(period == 12) {
			
        	if (param.equals("country")) {
				SourceComparison filter = new SourceComparison();
				array = filter.Months(elements, value, 12);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		
	    }
		
		else if(comparison.equals("segment")) {
			
            if(period == 1) {
				
				if (param.equals("country")) {
					SegmentComparison filter = new SegmentComparison();
					array = filter.Months(elements, value, 1);
				}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 3) {
			
        	if (param.equals("country")) {
        		SegmentComparison filter = new SegmentComparison();
				array = filter.Months(elements, value, 3);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 6) {
			
        	if (param.equals("country")) {
        		SegmentComparison filter = new SegmentComparison();
				array = filter.Months(elements, value, 6);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 12) {
			
        	if (param.equals("country")) {
        		SegmentComparison filter = new SegmentComparison();
				array = filter.Months(elements, value, 12);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
			
		}
        
		else if(comparison.equals("genre")) {
			
            if(period == 1) {
				
				if (param.equals("country")) {
					GenreComparison filter = new GenreComparison();
					array = filter.Months(elements, value, 1);
				}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 3) {
			
        	if (param.equals("country")) {
        		GenreComparison filter = new GenreComparison();
				array = filter.Months(elements, value, 3);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 6) {
			
        	if (param.equals("country")) {
        		GenreComparison filter = new GenreComparison();
				array = filter.Months(elements, value, 6);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 12) {
			
        	if (param.equals("country")) {
        		GenreComparison filter = new GenreComparison();
				array = filter.Months(elements, value, 12);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
        else throw new WrongPeriodException (period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
			
		}
        
		else if(comparison.equals("subgenre")) {
			
            if(period == 1) {
				
				if (param.equals("country")) {
					SubGenreComparison filter = new SubGenreComparison();
					array = filter.Months(elements, value, 1);
				}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 3) {
			
        	if (param.equals("country")) {
        		SubGenreComparison filter = new SubGenreComparison();
				array = filter.Months(elements, value, 3);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 6) {
			
        	if (param.equals("country")) {
        		SubGenreComparison filter = new SubGenreComparison();
				array = filter.Months(elements, value, 6);
			}
			
			else throw new WrongParameterException (param + " non è un parametro ammesso. Puoi inserire solo la stringa country.");
			
	    }
        
            else if(period == 12) {
			
        	if (param.equals("country")) {
        		SubGenreComparison filter = new SubGenreComparison();
				array = filter.Months(elements, value, 12);
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
package eu.univpm.TicketmasterEurope.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import eu.univpm.TicketmasterEurope.exception.*;


/** Questa classe contiene il test della classe Filter, verificando il corretto lancio delle eccezioni WrongComparisonException,
 * WrongParameterException e WrongPeriodException
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class FilterTest {
	
	Filter filter;
	private Vector<String> elements;
	
	
	/** Inizializza le componenti utili al test
    * @throws java.lang.Exception
    */
	@BeforeEach
	void setUp() throws Exception {
		elements = new Vector<String>();
	}
	
	
	/** Serve per distruggere ciò che è stato creato dal setUp
     * @throws java.lang.Exception
     */
	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	
    /** Questo Test verifica se viene generata correttamente l'eccezione WrongComparisonException
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongComparatorException.")
    void WrongComparisonExceptionTest() {
		
    	elements.add("GB");
        elements.add("FR");
        
        filter = new Filter("stati", elements, "subenre", "Pop", 6);
    	
        WrongComparisonException e = assertThrows(WrongComparisonException.class, () -> {filter.getFilter();});
    
        assertEquals("stati non è una stringa ammessa. Inserisci una stringa tra country, market, source, segment, genre o subgenre.", e.getMessage());    
    }
	
	
    /** Questo Test verifica se viene generata correttamente l'eccezione WrongParameterException
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongParameterException")
    void WrongParameterExceptionTest() {
		
    	elements.add("201");
        elements.add("202");
        
        filter = new Filter("market", elements, "genere", "Rock", 12);
    	
        WrongParameterException e = assertThrows(WrongParameterException.class, () -> {filter.getFilter();});
    
        assertEquals("genere non è un parametro ammesso. Puoi inserire solo la stringa total.", e.getMessage());
        
    }
	
    
	/** Questo Test verifica se viene generata correttamente l'eccezione WrongPeriodException
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongPeriodException")
    void WrongPeriodExceptionTest() {
		
    	elements.add("Sports");
        elements.add("Music");
        
        filter = new Filter("segment", elements, "country", "DE", 9);
    	
        WrongPeriodException e = assertThrows(WrongPeriodException.class, () -> {filter.getFilter();});
    
        assertEquals("9 non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.", e.getMessage());
        
    }
	
    

}
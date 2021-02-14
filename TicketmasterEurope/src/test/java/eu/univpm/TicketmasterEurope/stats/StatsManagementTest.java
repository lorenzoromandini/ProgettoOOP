package eu.univpm.TicketmasterEurope.stats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import eu.univpm.TicketmasterEurope.exception.*;


/** Questa classe contiene il test della classe SegmentFilter, verificando il corretto lancio delle eccezioni WrongCountryException
 * e WrongValueException
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class StatsManagementTest {
	
	StatsManagement stats; 
	
	
	/** Inizializza le componenti utili al test
    * @throws java.lang.Exception
    */
	@BeforeEach
	void setUp() throws Exception {
		
		stats = new StatsManagement();
		
	}
	
	
	/** Serve per distruggere ciò che è stato creato dal setUp
     * @throws java.lang.Exception
     */
	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	
    /** Questo Test verifica se viene generata correttamente l'eccezione WrongCountryException
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongCountryException.")
    void WrongCountryExceptionTest() {
            	
        WrongCountryException e = assertThrows(WrongCountryException.class, () -> {stats.getCountryEvents("US", 3);});
    
        assertEquals("US non è un valore ammesso.", e.getMessage());    
    }
	
	
    /** Questo Test verifica se viene generata correttamente l'eccezione WrongValueException
	 */
    @Test
    @DisplayName("Corretta generazione dell'eccezione WrongValueException.")
    void WrongValueExceptionTest() {
            	
        WrongValueException e = assertThrows(WrongValueException.class, () -> {stats.getSegmentEvents("GB", "musica", 12);});
    
        assertEquals("musica non è un valore ammesso.", e.getMessage());    
    }
	
    

}
/**
 * 
 */
package eu.univpm.TicketmasterEurope.saves;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import eu.univpm.TicketmasterEurope.exception.WrongCountryException;
import eu.univpm.TicketmasterEurope.exception.WrongValueException;


/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */
public class SaveRelevantEventsTest {
	
	SaveRelevantEvents save;
	
	
	/** Inizializza le componenti necessarie per i test.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		save = new SaveRelevantEvents();
		
		}
	
	/** Distrugge quello che è stato creato dal BeforeEach.
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	/** Test che controlla il corretto salvataggio del file
	 * 
	 * @throws IOException, WrongCountryException, WrongValueException
	 */
	@Test
	@DisplayName("Salvataggio del file avvenuto in modo corretto")
	void fileSaver() throws IOException, WrongCountryException, WrongValueException {
		
		String countryCode = "GB";
		
		String segment = "Music";
		
		String nomeDirectory = "Relevant_Events";

		String pathDirectory = System.getProperty("user.dir") + "/" + nomeDirectory;

		String nomeFile = countryCode + "_Relevant_Events";
		
		String path = pathDirectory + "/" + nomeFile + ".txt";
		
		File file = new File(path);
 
		try{
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			System.out.println(e);
		}		
		
		assertEquals(path, save.StoreSegmentRelevantEvents(countryCode, segment));			
	}
	
	
	/** Test che verifica la corretta creazione della directory
	 * 
	 * @throws IOException, WrongCountryException
	 */
	@Test
	@DisplayName("Creazione della directory avvenuta in modo corretto")
	void directorySaver() throws IOException, WrongCountryException {
		
		String countryCode = "GB";
				
		String path = save.StoreCountryEvents(countryCode);
		
		path.replaceAll("/GB_Total_Events", "");
				
		assertEquals(path, save.StoreCountryEvents(countryCode));
		
	}
	
	
	
}
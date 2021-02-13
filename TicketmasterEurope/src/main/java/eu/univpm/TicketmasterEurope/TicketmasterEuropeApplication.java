package eu.univpm.TicketmasterEurope;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eu.univpm.TicketmasterEurope.saves.BootSaveEuroEvents;


/** Avvia l'applicazione Spring
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 * 
 */

@SpringBootApplication

public class TicketmasterEuropeApplication {

	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(TicketmasterEuropeApplication.class, args);
		
		/** Una volta avviato il programma, salverà su una serie di file gli eventi più rilevanti per tipologia relativi
		 * a tutti i paesi europei, richiamando il metodo SaveBootEvents della classe BootSaveEuroEvents
		 */		
		BootSaveEuroEvents boot = new BootSaveEuroEvents();
		
		boot.SaveBootEvents();
		
	}
	
}
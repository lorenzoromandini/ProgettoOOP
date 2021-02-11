package eu.univpm.TicketmasterEurope;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eu.univpm.TicketmasterEurope.saves.BootSaveEuroEvents;


@SpringBootApplication
public class TicketmasterEuropeApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TicketmasterEuropeApplication.class, args);
		
		
		BootSaveEuroEvents boot = new BootSaveEuroEvents();
		
		boot.SaveBootEvents();
		
	}
	
}
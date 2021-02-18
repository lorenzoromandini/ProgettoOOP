package eu.univpm.TicketmasterEurope.stats;

import java.util.Vector;


/** Questa classe contiene tutti i countryCode europei supportati da Ticketmaster
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class EuroCountries {
	
	Vector<String> countries = new Vector<String>();
	
	
	/** Questo metodo serve ad inserire tutti i countryCode europei all'interno di un vettore di stringhe e verrà richiamato 
	 * dal Controller nel caso in cui l'utente desideri confrontare gli eventi fra tutti i paesi europei
	 * 
	 * @return void riempie semplicemente il vettore di stringhe con i countryCode
	 */
	public Vector<String> getEuroCountries() {
				
		countries.add("AD");
		countries.add("AT");
		countries.add("BE");
		countries.add("BG");
		countries.add("HR");
		countries.add("CY");
		countries.add("CZ");
		countries.add("DK");
		countries.add("EE");
		countries.add("FO");
		countries.add("FI");
		countries.add("FR");
		countries.add("DE");
		countries.add("GE");
		countries.add("GI");
		countries.add("GB");
		countries.add("GR");
		countries.add("HU");
		countries.add("IS");
		countries.add("IE");
		countries.add("IT");
		countries.add("LT");
		countries.add("LU");
		countries.add("MT");
		countries.add("MC");
		countries.add("ME");
		countries.add("NL");
		countries.add("ND");
		countries.add("NO");
		countries.add("PL");
		countries.add("PT");
		countries.add("RO");
		countries.add("RU");
		countries.add("RS");
		countries.add("SK");
		countries.add("SI");
		countries.add("ES");
		countries.add("SE");
		countries.add("CH");
		countries.add("TR");
		countries.add("UA");

		return countries;
		
	}
	
	
	
	
}

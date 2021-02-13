/**
 * 
 */
package eu.univpm.TicketmasterEurope.exception;

/** Questa classe contiene il metodo che segnala l'eccezione riguardante una stringa non ammessa per param
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class WrongParameterException extends Exception {
	
	String message;
	
	
	/** Costruttore della classe
	 * @param message rappresenta il messaggio di errore
	 */
	public WrongParameterException(String message) {
		
		this.message = message;
	}
	
	
	/** Restituisce un messaggio di errore passato al costruttore quando viene inserita una stringa non ammessa per param
	 * @return String che contiene il messaggio d'errore che viene stampato
	 */
	public String getMessage() {
		return message;
	}
	
	
}

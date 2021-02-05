/**
 * 
 */
package eu.univpm.TicketmasterEurope.exception;

/**
 * Questa classe  contiene il metodo che segnala l'eccezione riguardante un numero non concesso del periodo. 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class WrongPeriodException extends Exception {
	
	String message;
	/**
	 * Questo è il costruttore.
	 * @param message rappresenta il messaggio di errore.
	 */
	public WrongPeriodException(String message) {
		
		this.message = message;
	}
	
	/**
	 * Restituisce un messaggio di errore passato al costruttore quando viene inserito un numero non ammesso.
	 * @return String che contiene il messaggio d'errore che viene stampato.
	 */
	public String getMessage() {
		return message;
	}
}

/**
 * 
 */
package eu.univpm.TicketmasterEurope.saves;


/** Questa classe serve a salvare gli eventi in base al paese e alla tipologia scelti, richiamando il metodo 
 * StoreSegmentRelevantEvents della classe SaveRelevantEvents, in modo automatico all'avvio del programma
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 *
 */
public class BootSaveEuroEvents {
	
	
	/** Questo metodo non ha parametri passati come argomento né restituisce qualcosa, in quanto svolge unicamente il compito
	 * di salvare gli eventi all'interno di file contenuti in una directory, una volta avviato il programma
	 */
	public void SaveBootEvents() {

		SaveRelevantEvents save = new SaveRelevantEvents();
		
		
        try {
			
			save.StoreSegmentRelevantEvents("AD", "Arts & Theatre");
			
		}  catch(Exception e) {
			e.printStackTrace();
		}
        
        try {
			
			save.StoreSegmentRelevantEvents("AD", "Miscellaneous");
			
		}  catch(Exception e) {
			e.printStackTrace();
		}

        try {
			
			save.StoreSegmentRelevantEvents("AD", "Music");
			
		}  catch(Exception e) {
			e.printStackTrace();
		}

        try {
			
			save.StoreSegmentRelevantEvents("AD", "Sports");
			
		}  catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			save.StoreSegmentRelevantEvents("AT", "Arts & Theatre");
			
		}  catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			save.StoreSegmentRelevantEvents("AT", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			save.StoreSegmentRelevantEvents("AT", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {

			save.StoreSegmentRelevantEvents("AT", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("BE", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("BE", "Miscellaneous");
			
		}  catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("BE", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("BE", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("BG", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("BG", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("BG", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("BG", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("HR", "Arts & Theatre");

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("HR", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("HR", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("HR", "Sports");

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {

			save.StoreSegmentRelevantEvents("CY", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("CY", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("CY", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("CY", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("CZ", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("CZ", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("CZ", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("CZ", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			save.StoreSegmentRelevantEvents("DK", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("DK", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("DK", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("DK", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			save.StoreSegmentRelevantEvents("EE", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("EE", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("EE", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("EE", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("FO", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("FO", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("FO", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("FO", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("FI", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("FI", "Miscellaneous");

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("FI", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("FI", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("FR", "Arts & Theatre");

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("FR", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			save.StoreSegmentRelevantEvents("FR", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("FR", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			save.StoreSegmentRelevantEvents("GE", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GE", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GE", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GE", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("DE", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("DE", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("DE", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("DE", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GI", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GI", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GI", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GI", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GB", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GB", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GB", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GB", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GR", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GR", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GR", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("GR", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("HU", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("HU", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("HU", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("HU", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			save.StoreSegmentRelevantEvents("IS", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("IS", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("IS", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("IS", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("IE", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("IE", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("IE", "Music");

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("IE", "Sports");	
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("IT", "Arts & Theatre");
				
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("IT", "Miscellaneous");

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("IT", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("IT", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("LT", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("LT", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("LT", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
		
			save.StoreSegmentRelevantEvents("LT", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("LU", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("LU", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("LU", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("LU", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("MT", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("MT", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("MT", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("MT", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("MC", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("MC", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("MC", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("MC", "Sports");

			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ME", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ME", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ME", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ME", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("NL", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("NL", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("NL", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("NL", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ND", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ND", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ND", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ND", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("NO", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("NO", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("NO", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("NO", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("PL", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("PL", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("PL", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("PL", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		
		try {
			
			save.StoreSegmentRelevantEvents("PT", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("PT", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("PT", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("PT", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("RO", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("RO", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("RO", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("RO", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			save.StoreSegmentRelevantEvents("RU", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("RU", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("RU", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("RU", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("RS", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("RS", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("RS", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("RS", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("SK", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("SK", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("SK", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("SK", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("SI", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("SI", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("SI", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("SI", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ES", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ES", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ES", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("ES", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("SE", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			save.StoreSegmentRelevantEvents("SE", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("SE", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("SE", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("CH", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("CH", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("CH", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("CH", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			save.StoreSegmentRelevantEvents("TR", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("TR", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("TR", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("TR", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("UA", "Arts & Theatre");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("UA", "Miscellaneous");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("UA", "Music");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			
			save.StoreSegmentRelevantEvents("UA", "Sports");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

						
	}
	
	
}
	

/**
 * 
 */
package eu.univpm.TicketmasterEurope.stats;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;


/** Questa classe è l'implementazione dell'interfaccia Stats
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
 
public class StatsManagement implements Stats {
	
	
	private static LocalDate data = java.time.LocalDate.now();
			
	LocalDateTime now = LocalDateTime.now();
	
	int hour = now.getHour();
	int minute = now.getMinute();
	int second = now.getSecond();
	
	String time = "T" + hour + ":" + minute + ":" + second + "Z";
	
	/**
	 * apikey è la key necessaria per ottenere informazioni da Ticketmaster
	 */
	private String apikey = "GP6psuWJBWvDCvq13mLNVDY3ktVMdHRI";
	
	
	public JSONObject getCountryEvents(String countryCode, int period) {

       JSONObject countryEventsObject;
		
        String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode=" + countryCode 
                   + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		countryEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = countryEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("totalEvents", totalElements);

		return object;
		
	}
	
	
	public JSONObject getMarketEvents(String marketId, int period) {

		JSONObject marketEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&marketId=" + marketId 
				   + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		marketEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = marketEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("market", marketId);
		object.put("totalEvents", totalElements);

		return object;

	}
	
	
   public JSONObject getSegmentEvents(String countryCode, String segment, int period) {
	   	   	   		
		JSONObject segmentEventsObject;
					
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
	              + countryCode + "&segmentName="+ segment + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
	   
		RestTemplate restTemplate = new RestTemplate();
		
		segmentEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = segmentEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("segment", segment);
		object.put("totalEvents", totalElements);

		return object;
		
	}
	
	
	public JSONObject getGenreEvents(String countryCode, String genre, int period) {
		
		String genreId = null;
		
		if (genre.equals("Alternative")) genreId = "KnvZfZ7vAvv";
		else if (genre.equals("Aquatics")) genreId = "KnvZfZ7vAeI";
		else if (genre.equals("Athletic Races")) genreId = "KnvZfZ7vAet";
		else if (genre.equals("Basketball")) genreId = "KnvZfZ7vAde";
		else if (genre.equals("Blues")) genreId = "KnvZfZ7vAvd";
		else if (genre.equals("Boxing")) genreId = "KnvZfZ7vAdA";
		else if (genre.equals("Children's Theatre")) genreId = "KnvZfZ7v7na";
		else if (genre.equals("Circus & Specialty Acts")) genreId = "KnvZfZ7v7n1";
		else if (genre.equals("Classical")) genreId = "KnvZfZ7vAeJ";
		else if (genre.equals("Comedy")) genreId = "KnvZfZ7vAe1";
		else if (genre.equals("Community/Civic")) genreId = "KnvZfZ7vAAE";
		else if (genre.equals("Country")) genreId = "KnvZfZ7vAv6";
		else if (genre.equals("Cricket")) genreId = "KnvZfZ7vAdk";
		else if (genre.equals("Cycling")) genreId = "KnvZfZ7vAda";
		else if (genre.equals("Dance")) genreId = "KnvZfZ7v7nI";
		else if (genre.equals("Dance/Electronic")) genreId = "KnvZfZ7vAvF";
		else if (genre.equals("Equestrian")) genreId = "KnvZfZ7vAd1";
		else if (genre.equals("Family")) genreId = "KnvZfZ7vA1n";
		else if (genre.equals("Fashion")) genreId = "KnvZfZ7v7nn";
		else if (genre.equals("Folk")) genreId = "KnvZfZ7vAva";
		else if (genre.equals("Hip-Hop/Rap")) genreId = "KnvZfZ7vAv1";
		else if (genre.equals("Hobby/Special Interest Expos")) genreId = "KnvZfZ7vAAJ";
		else if (genre.equals("Ice Shows")) genreId = "KnvZfZ7v7lI";
		else if (genre.equals("Jazz")) genreId = "KnvZfZ7vAvE";
		else if (genre.equals("Magic & Illusion")) genreId = "KnvZfZ7v7lv";
		else if (genre.equals("Martial Arts")) genreId = "KnvZfZ7vA7d";
		else if (genre.equals("Metal")) genreId = "KnvZfZ7vAvt";
		else if (genre.equals("Miscellaneous")) genreId = "KnvZfZ7vA7A";
		else if (genre.equals("Miscellaneous Theatre")) genreId = "KnvZfZ7v7ld";
		else if (genre.equals("Motorsports/Racing")) genreId = "KnvZfZ7vA7k";
		else if (genre.equals("Performance Art")) genreId = "KnvZfZ7v7l6";
		else if (genre.equals("Pop")) genreId = "KnvZfZ7vAev";
		else if (genre.equals("Reggae")) genreId = "KnvZfZ7vAed";
		else if (genre.equals("Rock")) genreId = "KnvZfZ7vAeA";
		else if (genre.equals("Rugby")) genreId = "KnvZfZ7vA71";
		else if (genre.equals("R&B")) genreId = "KnvZfZ7vAee";
		else if (genre.equals("Spectacular")) genreId = "KnvZfZ7v7la";
		else if (genre.equals("Theatre")) genreId = "KnvZfZ7v7l1";
		else if (genre.equals("Undefined")) genreId = "KnvZfZ7v7ll";
		else if (genre.equals("Variety")) genreId = "KnvZfZ7v7lJ";
		else if (genre.equals("Volleyball")) genreId = "KnvZfZ7vAA7";
		else if (genre.equals("World")) genreId = "KnvZfZ7vAeF";
		else if (genre.equals("Wrestling")) genreId = "KnvZfZ7vAAk";
		
		JSONObject genreEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
		              + countryCode + "&genreId="+ genreId + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		genreEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = genreEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("genre", genre);
		object.put("totalEvents", totalElements);

		return object;

	}


	public JSONObject getSubGenreEvents(String countryCode, String subGenre, int period) {

        String subGenreId = null;
		
		if (subGenre.equals("Adult Contemporary")) subGenreId = "KZazBEonSMnZfZ7vk1l";
		else if (subGenre.equals("Alternative")) subGenreId = "KZazBEonSMnZfZ7vAvJ";
		else if (subGenre.equals("Alternative Rock")) subGenreId = "KZazBEonSMnZfZ7v6dt";
		else if (subGenre.equals("Aquatics")) subGenreId = "KZazBEonSMnZfZ7vF1a";
		else if (subGenre.equals("Athletic Races")) subGenreId = "KZazBEonSMnZfZ7vF11";
		else if (subGenre.equals("Blues")) subGenreId = "KZazBEonSMnZfZ7vAAd";
		else if (subGenre.equals("Blues-Rock")) subGenreId = "KZazBEonSMnZfZ7v676";
		else if (subGenre.equals("Boxing")) subGenreId = "KZazBEonSMnZfZ7vFJJ";
		else if (subGenre.equals("British Folk-Rock")) subGenreId = "KZazBEonSMnZfZ7v671";
		else if (subGenre.equals("Burlesque")) subGenreId = "KZazBEonSMnZfZ7vaaE";
		else if (subGenre.equals("Cabaret")) subGenreId = "KZazBEonSMnZfZ7vAv7";
		else if (subGenre.equals("Children's Theatre")) subGenreId = "KZazBEonSMnZfZ7v7na";
		else if (subGenre.equals("Circus")) subGenreId = "KZazBEonSMnZfZ7v7n1";
		else if (subGenre.equals("Classical/Vocal")) subGenreId = "KZazBEonSMnZfZ7vF1A";
		else if (subGenre.equals("Club Dance")) subGenreId = "KZazBEonSMnZfZ7vAJ1";
		else if (subGenre.equals("Comedy")) subGenreId = "KZazBEonSMnZfZ7vF17";
		else if (subGenre.equals("Community/Civic")) subGenreId = "KZazBEonSMnZfZ7vFlv";
		else if (subGenre.equals("Country")) subGenreId = "KZazBEonSMnZfZ7vAFa";
		else if (subGenre.equals("Cricket")) subGenreId = "KZazBEonSMnZfZ7vFJE";
		else if (subGenre.equals("Cycling")) subGenreId = "KZazBEonSMnZfZ7vFEv";
		else if (subGenre.equals("Dance")) subGenreId = "KZazBEonSMnZfZ7v7nl";
		else if (subGenre.equals("Disco")) subGenreId = "KZazBEonSMnZfZ7vAJn";
		else if (subGenre.equals("Drama")) subGenreId = "KZazBEonSMnZfZ7v7lt";
		else if (subGenre.equals("Dressage")) subGenreId = "KZazBEonSMnZfZ7vFEe";
		else if (subGenre.equals("Equestrian")) subGenreId = "KZazBEonSMnZfZ7vFEd";
		else if (subGenre.equals("European Pop")) subGenreId = "KZazBEonSMnZfZ7v6At";
		else if (subGenre.equals("Fashion")) subGenreId = "KZazBEonSMnZfZ7v7le";
		else if (subGenre.equals("Folk")) subGenreId = "KZazBEonSMnZfZ7vAn7";
		else if (subGenre.equals("French Rap")) subGenreId = "KZazBEonSMnZfZ7vaa1";
		else if (subGenre.equals("Hard Rock")) subGenreId = "KZazBEonSMnZfZ7v6kl";
		else if (subGenre.equals("Heavy Metal")) subGenreId = "KZazBEonSMnZfZ7vkFd";
		else if (subGenre.equals("Hobby/Special Interest Expos")) subGenreId = "KZazBEonSMnZfZ7vFnl";
		else if (subGenre.equals("Ice Shows")) subGenreId = "KZazBEonSMnZfZ7vAv6";
		else if (subGenre.equals("Indie Pop")) subGenreId = "KZazBEonSMnZfZ7vkEk";
		else if (subGenre.equals("Indie Rock")) subGenreId = "KZazBEonSMnZfZ7vAde";
		else if (subGenre.equals("Jazz")) subGenreId = "KZazBEonSMnZfZ7vkda";
		else if (subGenre.equals("Latin")) subGenreId = "KZazBEonSMnZfZ7vFdJ";
		else if (subGenre.equals("Magic")) subGenreId = "KZazBEonSMnZfZ7v7l7";
		else if (subGenre.equals("Men Professional")) subGenreId = "KZazBEonSMnZfZ7vFJ6";
		else if (subGenre.equals("Metalcore")) subGenreId = "KZazBEonSMnZfZ7vaJk";
		else if (subGenre.equals("Miscellaneous")) subGenreId = "KZazBEonSMnZfZ7vFIt";
		else if (subGenre.equals("Miscellaneous Theatre")) subGenreId = "KZazBEonSMnZfZ7v7lk";
		else if (subGenre.equals("Mixed Martial Arts")) subGenreId = "KZazBEonSMnZfZ7vFIE";
		else if (subGenre.equals("Musical")) subGenreId = "KnvZfZ7v7l1";
		else if (subGenre.equals("Nu-Metal")) subGenreId = "KZazBEonSMnZfZ7vaJ6";
		else if (subGenre.equals("Other")) subGenreId = "KZazBEonSMnZfZ7vaav";
		else if (subGenre.equals("Performance Art")) subGenreId = "KZazBEonSMnZfZ7v7l1";
		else if (subGenre.equals("Pop")) subGenreId = "KZazBEonSMnZfZ7v6F1";
		else if (subGenre.equals("Rap-Rock")) subGenreId = "KZazBEonSMnZfZ7vkel";
		else if (subGenre.equals("Reggae")) subGenreId = "KZazBEonSMnZfZ7vknl";
		else if (subGenre.equals("Rugby Union")) subGenreId = "KZazBEonSMnZfZ7vFtJ";
		else if (subGenre.equals("Rock")) subGenreId = "KZazBEonSMnZfZ7v6da";
		else if (subGenre.equals("Rock & Roll")) subGenreId = "KZazBEonSMnZfZ7v6an";
		else if (subGenre.equals("R&B")) subGenreId = "KZazBEonSMnZfZ7vkIt";
		else if (subGenre.equals("Scandinavia")) subGenreId = "KZazBEonSMnZfZ7vF6E";
		else if (subGenre.equals("Soul")) subGenreId = "KZazBEonSMnZfZ7vknE";
		else if (subGenre.equals("Southern Rock")) subGenreId = "KZazBEonSMnZfZ7v61J";
		else if (subGenre.equals("Spectacular")) subGenreId = "KZazBEonSMnZfZ7v7lE";
		else if (subGenre.equals("Undefined")) subGenreId = "KZazBEonSMnZfZ7vAv1";
		else if (subGenre.equals("Urban")) subGenreId = "KZazBEonSMnZfZ7vkdA";
		else if (subGenre.equals("Variety")) subGenreId = "KZazBEonSMnZfZ7vAvA";
		else if (subGenre.equals("Volleyball")) subGenreId = "KZazBEonSMnZfZ7vFn6";
		else if (subGenre.equals("Witchstep")) subGenreId = "KZazBEonSMnZfZ7va1k";
		else if (subGenre.equals("World")) subGenreId = "KZazBEonSMnZfZ7v6Jt";
		else if (subGenre.equals("Wrestling")) subGenreId = "KZazBEonSMnZfZ7vFna";

		JSONObject subGenreEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
		              + countryCode + "&subGenreId="+ subGenreId + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		subGenreEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = subGenreEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("subgenre", subGenre);
		object.put("totalEvents", totalElements);

		return object;
		
	}
	
	
    public JSONObject getSourceEvents(String countryCode, String source, int period) {
		
		JSONObject sourceEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
	              + countryCode + "&source="+ source + "&endDateTime=" + data.plusMonths(period) + time + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		sourceEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = sourceEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country", countryCode);
		object.put("source", source);
		object.put("totalEvents", totalElements);

		return object;
		
	}
    
}


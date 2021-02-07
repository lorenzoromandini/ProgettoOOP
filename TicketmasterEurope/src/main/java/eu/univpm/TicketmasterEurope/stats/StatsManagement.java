/**
 * 
 */
package eu.univpm.TicketmasterEurope.stats;

import java.time.LocalDate;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import eu.univpm.TicketmasterEurope.model.*;

/** Questa classe è l'implementazione dell'interfaccia Stats
 * 
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */


public class StatsManagement implements Stats {
	
	private LocalDate datanow = java.time.LocalDate.now();
	
	/**
	 * apikey è la key necessaria per ottenere informazioni da Ticketmaster
	 */
	private String apikey = "GP6psuWJBWvDCvq13mLNVDY3ktVMdHRI";
	
	
	public JSONObject getCountryEvents(String countryCode, int period) {

       JSONObject countryEventsObject;
		
        String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode=" + countryCode 
                   + "&=endDateTime" + datanow.plusMonths(period) + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		countryEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = countryEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("Country: ", countryCode);
		object.put("totalEvents: ", totalElements);

		return object;
		
	}
	
	
	public JSONObject getMarketEvents(String marketId, int period) {

		JSONObject marketEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&marketId=" + marketId 
				   + "&=endDateTime" + datanow.plusMonths(period) + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		marketEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = marketEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("Market: ", marketId);
		object.put("totalEvents: ", totalElements);

		return object;

	}
	
	
   public JSONObject getSegmentEvents(String countryCode, String segment, int period) {
		
		JSONObject segmentEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
	              + countryCode + "&segmentName="+ segment + "&=endDateTime" + datanow.plusMonths(period) + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		segmentEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = segmentEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("Country: ", segment);
		object.put("totalEvents: ", totalElements);

		return object;
		
	}
	
	
	public JSONObject getGenreEvents(String countryCode, String genre, int period) {
		
		String genreId = null;
		
		if (genre == "Alternative") genreId = "KnvZfZ7vAvv";
		else if (genre == "Aquatics") genreId = "KnvZfZ7vAeI";
		else if (genre == "Athletic Races") genreId = "KnvZfZ7vAet";
		else if (genre == "Basketball") genreId = "KnvZfZ7vAde";
		else if (genre == "Blues") genreId = "KnvZfZ7vAvd";
		else if (genre == "Boxing") genreId = "KnvZfZ7vAdA";
		else if (genre == "Children's Theatre") genreId = "KnvZfZ7v7na";
		else if (genre == "Circus & Specialty Acts") genreId = "KnvZfZ7v7n1";
		else if (genre == "Classical") genreId = "KnvZfZ7vAeJ";
		else if (genre == "Comedy") genreId = "KnvZfZ7vAe1";
		else if (genre == "Community/Civic") genreId = "KnvZfZ7vAAE";
		else if (genre == "Country") genreId = "KnvZfZ7vAv6";
		else if (genre == "Cricket") genreId = "KnvZfZ7vAdk";
		else if (genre == "Cycling") genreId = "KnvZfZ7vAda";
		else if (genre == "Dance") genreId = "KnvZfZ7v7nI";
		else if (genre == "Dance/Electronic") genreId = "KnvZfZ7vAvF";
		else if (genre == "Equestrian") genreId = "KnvZfZ7vAd1";
		else if (genre == "Family") genreId = "KnvZfZ7vA1n";
		else if (genre == "Fashion") genreId = "KnvZfZ7v7nn";
		else if (genre == "Folk") genreId = "KnvZfZ7vAva";
		else if (genre == "Hip-Hop/Rap") genreId = "KnvZfZ7vAv1";
		else if (genre == "Hobby/Special Interest Expos") genreId = "KnvZfZ7vAAJ";
		else if (genre == "Ice Shows") genreId = "KnvZfZ7v7lI";
		else if (genre == "Jazz") genreId = "KnvZfZ7vAvE";
		else if (genre == "Magic & Illusion") genreId = "KnvZfZ7v7lv";
		else if (genre == "Martial Arts") genreId = "KnvZfZ7vA7d";
		else if (genre == "Metal") genreId = "KnvZfZ7vAvt";
		else if (genre == "Miscellaneous") genreId = "KnvZfZ7vA7A";
		else if (genre == "Miscellaneous Theatre") genreId = "KnvZfZ7v7ld";
		else if (genre == "Motorsports/Racing") genreId = "KnvZfZ7vA7k";
		else if (genre == "Performance Art") genreId = "KnvZfZ7v7l6";
		else if (genre == "Pop") genreId = "KnvZfZ7vAev";
		else if (genre == "Reggae") genreId = "KnvZfZ7vAed";
		else if (genre == "Rock") genreId = "KnvZfZ7vAeA";
		else if (genre == "Rugby") genreId = "KnvZfZ7vA71";
		else if (genre == "R&B") genreId = "KnvZfZ7vAee";
		else if (genre == "Spectacular") genreId = "KnvZfZ7v7la";
		else if (genre == "Theatre") genreId = "KnvZfZ7v7l1";
		else if (genre == "Undefined") genreId = "KnvZfZ7v7ll";
		else if (genre == "Variety") genreId = "KnvZfZ7v7lJ";
		else if (genre == "Volleyball") genreId = "KnvZfZ7vAA7";
		else if (genre == "World") genreId = "KnvZfZ7vAeF";
		else if (genre == "Wrestling") genreId = "KnvZfZ7vAAk";
		
		JSONObject genreEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
		              + countryCode + "&genreId="+ genreId + "&=endDateTime" + datanow.plusMonths(period) + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		genreEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = genreEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("Country: ", countryCode);
		object.put("totalEvents: ", totalElements);

		return object;

	}


	public JSONObject getSubGenreEvents(String countryCode, String subGenre, int period) {

        String subGenreId = null;
		
		if (subGenre == "Alternative") subGenreId = "KnvZfZ7vAvv";
		else if (subGenre == "Aquatics") subGenreId = "KnvZfZ7vAeI";
		else if (subGenre == "Athletic Races") subGenreId = "KnvZfZ7vAet";
		else if (subGenre == "Basketball") subGenreId = "KnvZfZ7vAde";
		else if (subGenre == "Blues") subGenreId = "KnvZfZ7vAvd";
		else if (subGenre == "Boxing") subGenreId = "KnvZfZ7vAdA";
		else if (subGenre == "Children's Theatre") subGenreId = "KnvZfZ7v7na";
		else if (subGenre == "Circus & Specialty Acts") subGenreId = "KnvZfZ7v7n1";
		else if (subGenre == "Classical") subGenreId = "KnvZfZ7vAeJ";
		else if (subGenre == "Comedy") subGenreId = "KnvZfZ7vAe1";
		else if (subGenre == "Community/Civic") subGenreId = "KnvZfZ7vAAE";
		else if (subGenre == "Country") subGenreId = "KnvZfZ7vAv6";
		else if (subGenre == "Cricket") subGenreId = "KnvZfZ7vAdk";
		else if (subGenre == "Cycling") subGenreId = "KnvZfZ7vAda";
		else if (subGenre == "Dance") subGenreId = "KnvZfZ7v7nI";
		else if (subGenre == "Dance/Electronic") subGenreId = "KnvZfZ7vAvF";
		else if (subGenre == "Equestrian") subGenreId = "KnvZfZ7vAd1";
		else if (subGenre == "Family") subGenreId = "KnvZfZ7vA1n";
		else if (subGenre == "Fashion") subGenreId = "KnvZfZ7v7nn";
		else if (subGenre == "Folk") subGenreId = "KnvZfZ7vAva";
		else if (subGenre == "Hip-Hop/Rap") subGenreId = "KnvZfZ7vAv1";
		else if (subGenre == "Hobby/Special Interest Expos") subGenreId = "KnvZfZ7vAAJ";
		else if (subGenre == "Ice Shows") subGenreId = "KnvZfZ7v7lI";
		else if (subGenre == "Jazz") subGenreId = "KnvZfZ7vAvE";
		else if (subGenre == "Magic & Illusion") subGenreId = "KnvZfZ7v7lv";
		else if (subGenre == "Martial Arts") subGenreId = "KnvZfZ7vA7d";
		else if (subGenre == "Metal") subGenreId = "KnvZfZ7vAvt";
		else if (subGenre == "Miscellaneous") subGenreId = "KnvZfZ7vA7A";
		else if (subGenre == "Miscellaneous Theatre") subGenreId = "KnvZfZ7v7ld";
		else if (subGenre == "Motorsports/Racing") subGenreId = "KnvZfZ7vA7k";
		else if (subGenre == "Performance Art") subGenreId = "KnvZfZ7v7l6";
		else if (subGenre == "Pop") subGenreId = "KnvZfZ7vAev";
		else if (subGenre == "Reggae") subGenreId = "KnvZfZ7vAed";
		else if (subGenre == "Rock") subGenreId = "KnvZfZ7vAeA";
		else if (subGenre == "Rugby") subGenreId = "KnvZfZ7vA71";
		else if (subGenre == "R&B") subGenreId = "KnvZfZ7vAee";
		else if (subGenre == "Spectacular") subGenreId = "KnvZfZ7v7la";
		else if (subGenre == "Theatre") subGenreId = "KnvZfZ7v7l1";
		else if (subGenre == "Undefined") subGenreId = "KnvZfZ7v7ll";
		else if (subGenre == "Variety") subGenreId = "KnvZfZ7v7lJ";
		else if (subGenre == "Volleyball") subGenreId = "KnvZfZ7vAA7";
		else if (subGenre == "World") subGenreId = "KnvZfZ7vAeF";
		else if (subGenre == "Wrestling") subGenreId = "KnvZfZ7vAAk";
		
		JSONObject subGenreEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
		              + countryCode + "&subGenreId="+ subGenreId + "&=endDateTime" + datanow.plusMonths(period) + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		subGenreEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = subGenreEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("Country: ", countryCode);
		object.put("totalEvents: ", totalElements);

		return object;
		
	}



}
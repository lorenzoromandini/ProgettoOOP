/**
 * 
 */
package eu.univpm.TicketmasterEurope.stats;

import java.time.LocalDate;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;


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
		
		object.put("country: ", countryCode);
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
		
		object.put("market: ", marketId);
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
		
		object.put("country: ", countryCode);
		object.put("segment", segment);
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
		
		object.put("country: ", countryCode);
		object.put("genre", genre);
		object.put("totalEvents: ", totalElements);

		return object;

	}


	public JSONObject getSubGenreEvents(String countryCode, String subGenre, int period) {

        String subGenreId = null;
		
		if (subGenre == "Adult Contemporary") subGenreId = "KZazBEonSMnZfZ7vk1l";
		else if (subGenre == "Alternative") subGenreId = "KZazBEonSMnZfZ7vAvJ";
		else if (subGenre == "Alternative Rock") subGenreId = "KZazBEonSMnZfZ7v6dt";
		else if (subGenre == "Aquatics") subGenreId = "KZazBEonSMnZfZ7vF1a";
		else if (subGenre == "Athletic Races") subGenreId = "KZazBEonSMnZfZ7vF11";
		else if (subGenre == "Blues") subGenreId = "KZazBEonSMnZfZ7vAAd";
		else if (subGenre == "Blues-Rock") subGenreId = "KZazBEonSMnZfZ7v676";
		else if (subGenre == "Boxing") subGenreId = "KZazBEonSMnZfZ7vFJJ";
		else if (subGenre == "British Folk-Rock") subGenreId = "KZazBEonSMnZfZ7v671";
		else if (subGenre == "Burlesque") subGenreId = "KZazBEonSMnZfZ7vaaE";
		else if (subGenre == "Cabaret") subGenreId = "KZazBEonSMnZfZ7vAv7";
		else if (subGenre == "Children's Theatre") subGenreId = "KZazBEonSMnZfZ7v7na";
		else if (subGenre == "Circus") subGenreId = "KZazBEonSMnZfZ7v7n1";
		else if (subGenre == "Classical/Vocal") subGenreId = "KZazBEonSMnZfZ7vF1A";
		else if (subGenre == "Club Dance") subGenreId = "KZazBEonSMnZfZ7vAJ1";
		else if (subGenre == "Comedy") subGenreId = "KZazBEonSMnZfZ7vF17";
		else if (subGenre == "Community/Civic") subGenreId = "KZazBEonSMnZfZ7vFlv";
		else if (subGenre == "Country") subGenreId = "KZazBEonSMnZfZ7vAFa";
		else if (subGenre == "Cricket") subGenreId = "KZazBEonSMnZfZ7vFJE";
		else if (subGenre == "Cycling") subGenreId = "KZazBEonSMnZfZ7vFEv";
		else if (subGenre == "Dance") subGenreId = "KZazBEonSMnZfZ7v7nl";
		else if (subGenre == "Disco") subGenreId = "KZazBEonSMnZfZ7vAJn";
		else if (subGenre == "Drama") subGenreId = "KZazBEonSMnZfZ7v7lt";
		else if (subGenre == "Dressage") subGenreId = "KZazBEonSMnZfZ7vFEe";
		else if (subGenre == "Equestrian") subGenreId = "KZazBEonSMnZfZ7vFEd";
		else if (subGenre == "European Pop") subGenreId = "KZazBEonSMnZfZ7v6At";
		else if (subGenre == "Fashion") subGenreId = "KZazBEonSMnZfZ7v7le";
		else if (subGenre == "Folk") subGenreId = "KZazBEonSMnZfZ7vAn7";
		else if (subGenre == "French Rap") subGenreId = "KZazBEonSMnZfZ7vaa1";
		else if (subGenre == "Hard Rock") subGenreId = "KZazBEonSMnZfZ7v6kl";
		else if (subGenre == "Heavy Metal") subGenreId = "KZazBEonSMnZfZ7vkFd";
		else if (subGenre == "Hobby/Special Interest Expos") subGenreId = "KZazBEonSMnZfZ7vFnl";
		else if (subGenre == "Ice Shows") subGenreId = "KZazBEonSMnZfZ7vAv6";
		else if (subGenre == "Indie Pop") subGenreId = "KZazBEonSMnZfZ7vkEk";
		else if (subGenre == "Indie Rock") subGenreId = "KZazBEonSMnZfZ7vAde";
		else if (subGenre == "Jazz") subGenreId = "KZazBEonSMnZfZ7vkda";
		else if (subGenre == "Latin") subGenreId = "KZazBEonSMnZfZ7vFdJ";
		else if (subGenre == "Magic") subGenreId = "KZazBEonSMnZfZ7v7l7";
		else if (subGenre == "Men Professional") subGenreId = "KZazBEonSMnZfZ7vFJ6";
		else if (subGenre == "Metalcore") subGenreId = "KZazBEonSMnZfZ7vaJk";
		else if (subGenre == "Miscellaneous") subGenreId = "KZazBEonSMnZfZ7vFIt";
		else if (subGenre == "Miscellaneous Theatre") subGenreId = "KZazBEonSMnZfZ7v7lk";
		else if (subGenre == "Mixed Martial Arts") subGenreId = "KZazBEonSMnZfZ7vFIE";
		else if (subGenre == "Musical") subGenreId = "KnvZfZ7v7l1";
		else if (subGenre == "Nu-Metal") subGenreId = "KZazBEonSMnZfZ7vaJ6";
		else if (subGenre == "Other") subGenreId = "KZazBEonSMnZfZ7vaav";
		else if (subGenre == "Performance Art") subGenreId = "KZazBEonSMnZfZ7v7l1";
		else if (subGenre == "Pop") subGenreId = "KZazBEonSMnZfZ7v6F1";
		else if (subGenre == "Rap-Rock") subGenreId = "KZazBEonSMnZfZ7vkel";
		else if (subGenre == "Reggae") subGenreId = "KZazBEonSMnZfZ7vknl";
		else if (subGenre == "Rugby Union") subGenreId = "KZazBEonSMnZfZ7vFtJ";
		else if (subGenre == "Rock") subGenreId = "KZazBEonSMnZfZ7v6da";
		else if (subGenre == "Rock & Roll") subGenreId = "KZazBEonSMnZfZ7v6an";
		else if (subGenre == "R&B") subGenreId = "KZazBEonSMnZfZ7vkIt";
		else if (subGenre == "Scandinavia") subGenreId = "KZazBEonSMnZfZ7vF6E";
		else if (subGenre == "Soul") subGenreId = "KZazBEonSMnZfZ7vknE";
		else if (subGenre == "Southern Rock") subGenreId = "KZazBEonSMnZfZ7v61J";
		else if (subGenre == "Spectacular") subGenreId = "KZazBEonSMnZfZ7v7lE";
		else if (subGenre == "Undefined") subGenreId = "KZazBEonSMnZfZ7vAv1";
		else if (subGenre == "Urban") subGenreId = "KZazBEonSMnZfZ7vkdA";
		else if (subGenre == "Variety") subGenreId = "KZazBEonSMnZfZ7vAvA";
		else if (subGenre == "Volleyball") subGenreId = "KZazBEonSMnZfZ7vFn6";
		else if (subGenre == "Witchstep") subGenreId = "KZazBEonSMnZfZ7va1k";
		else if (subGenre == "World") subGenreId = "KZazBEonSMnZfZ7v6Jt";
		else if (subGenre == "Wrestling") subGenreId = "KZazBEonSMnZfZ7vFna";
		else if (subGenre == "") subGenreId = "";

		JSONObject subGenreEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
		              + countryCode + "&subGenreId="+ subGenreId + "&=endDateTime" + datanow.plusMonths(period) + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		subGenreEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = subGenreEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country: ", countryCode);
		object.put("subgenre", subGenre);
		object.put("totalEvents: ", totalElements);

		return object;
		
	}
	
	
    public JSONObject getSourceEvents(String countryCode, String source, int period) {
		
		JSONObject sourceEventsObject;
		
		String Url = "https://app.ticketmaster.com/discovery/v2/events?&countryCode="
	              + countryCode + "&source="+ source + "&=endDateTime" + datanow.plusMonths(period) + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		sourceEventsObject = new JSONObject(restTemplate.getForObject(Url, String.class));
		
		JSONObject pageObject = sourceEventsObject.getJSONObject("page");
		int totalElements = pageObject.getInt("totalElements");
		
		JSONObject object = new JSONObject();
		
		object.put("country: ", countryCode);
		object.put("source", source);
		object.put("totalEvents: ", totalElements);

		return object;
		
	}



}
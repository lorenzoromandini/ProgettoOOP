/**
 * 
 */
package eu.univpm.TicketmasterEurope.service;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.project.WeatherApp.model.City;
import com.project.WeatherApp.model.Coordinates;
import com.project.WeatherApp.model.Weather;

import eu.univpm.TicketmasterEurope.model.Location;

/**
 * @author Lorenzo Romandini
 * @author Nicholas Urbanelli
 */
public class ServiceManagement implements Service {
	
	/**
	 * apikey è la key necessaria per ottenere informazioni da Ticketmaster
	 */
	private String apikey = "GP6psuWJBWvDCvq13mLNVDY3ktVMdHRI";
	
	/**
	 * Questo metodo va a prendere da Ticketmaster gli eventi in un paese tramite il codice di tale paese
	 * @param countryCode - codice del paese in cui ha luogo l'evento
	 * @return JSONObject object
	 */
	public JSONObject getCountryEvents(String countryCode) {
		
		JSONObject CountryEventsObject;
		String url = "https://app.ticketmaster.com/discovery/v2/events.json?&countryCode=" + countryCode + "&apikey="+ apikey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		CountryEventsObject = new JSONObject(restTemplate.getForObject(url, String.class));
		
		return CountryEventsObject;
		
	}

	public Location getCountryEventsSelectedfromApi(String countryCode) {
		
		JSONObject CountryEventsSelectedObject = getCountryEvents(countryCode);
		
		Location location = new Location(countryCode);
		
		location = getCountryfromApi(countryCode);
		
		JSONArray countryArray = CountryEventsSelectedObject.getJSONArray("events");  
		JSONObject ;
		
		Vector<Weather> vector = new Vector<Weather>(weatherArray.length());
		
		
	
			
			
			for (int i = 0; i<weatherArray.length(); i++) {
				
				Weather weather = new Weather();
				counter = weatherArray.getJSONObject(i); // assegna a counter il JSONObject corrispondente all'i-esimo JSONObject sottoinsieme di list
				weather.setVisibility(counter.getInt("visibility")); // visibility è stand-alone
				weather.setData(counter.getString("dt_txt"));
				JSONArray arrayW = counter.getJSONArray("weather"); // i-esimo sottoinsieme weather di list
				JSONObject objectW = arrayW.getJSONObject(0); 
				weather.setDescription(objectW.getString("description")); // campo description del sottoinsieme weather
				weather.setMain(objectW.getString("main")); // campo main del sottoinsieme weather
				JSONObject objectW2 = counter.getJSONObject("main");  // i-esimo sottoinsieme main di list
				weather.setTemp_max(objectW2.getDouble("temp_max")); // campo temp_max del sottoinsieme main
				weather.setTemp_min(objectW2.getDouble("temp_min"));
				weather.setFeels_like(objectW2.getDouble("feels_like"));
				vector.add(weather); 
		
			}
		
		city.setVector(vector);
		
		return city;
		
	}
	
	
	private Location getCountryfromApi(String countryCode) {
		
		JSONObject CountryObject = getCountryEvents(countryCode);
		
		Location location = new Location(countryCode);
		
			
			JSONObject cityObj = object.getJSONObject("city");
			String country = (String) cityObj.get("country");
			int id = (int) cityObj.get("id");
			JSONObject coordinatesObj = cityObj.getJSONObject("coord");
			double latitude = (double) coordinatesObj.get("lat");
			double longitude = (double) coordinatesObj.get("lon");
			Coordinates coordinates = new Coordinates(latitude,longitude); 
			city.setCountry(country);
			city.setId(id);
			city.setCoordinates(coordinates);
		
		return city;
	}
	

	public 

	public JSONObject getMarketEvents(int marketId) {
		
	}

	public Location getMarketEventsSelectedfromApi(int marketId) {
	}
	
	
	

}

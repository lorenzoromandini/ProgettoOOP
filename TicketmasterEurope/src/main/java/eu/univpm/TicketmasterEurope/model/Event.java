/**
 * 
 */
package eu.univpm.TicketmasterEurope.model;

/**
 * @author loren
 *
 */
public class Event {
	
	private String id;
	private String name;
	private String url;
	private String info;
	

	/**
	 * 
	 */
	public Event() {
		super();
	}
	


	/**
	 * @param id
	 */
	public Event(String id) {
		super();
		this.id = id;
	}

  
	/**
	 * @param name
	 */
	public Event(String name) {
		super();
		this.name = name;
	}


	/**
	 * @param id
	 * @param name
	 * @param url
	 * @param info
	 */
	public Event(String id, String name, String url, String info) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.info = info;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}

	

	


}

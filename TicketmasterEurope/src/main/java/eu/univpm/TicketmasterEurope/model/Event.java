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
	 * @param name
	 */
	public Event(String name) {
		super();
		this.name = name;
	}
	


	/**
	 * @param id
	 * @param name
	 */
	public Event(String id, String name) {
		super();
		this.id = id;
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event ev = (Event) obj;
		if (id == null) {
			if (ev.id != null)
				return false;
		} else if (!id.equals(ev.id))
			return false;
		if (name == null) {
			if (ev.name != null)
				return false;
		} else if (!name.equals(ev.name))
			return false;
		if (url == null) {
				if (ev.url != null)
					return false;
		} else if (!url.equals(ev.url))
				return false;
		if (info == null) {
			if (ev.info != null)
				return false;
	   } else if (!info.equals(ev.info))
			return false;
		
		return true;
	}




	
	
	

	


}

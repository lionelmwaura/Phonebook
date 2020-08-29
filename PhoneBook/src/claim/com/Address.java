package claim.com;



public class Address {
	
	private String street;
	private String zip;
	private String city;
	private String State;
	
	
	// Getters and Setters
	public String getStreet() {
		return street;
	}
	public String getZip() {
		return zip;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return State;
	}
	
	
	public Address() {
		
	}
	public void Address(String street, String city, String state, String zip) {
		this.city = city;
		this.State = state;
		this.street = street;
		this.zip = zip;
	}
	
	public String formatData() {
		return getStreet() + "," + getCity() + "," + getState() + "," + getZip();
	}
	
	
	
	
}

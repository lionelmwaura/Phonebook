package claim.com;


public class Entry {
	
	private String Name;
	private String fName;
	private String lName;
	private String phone;
	private Address address;
	
	public Entry() {
		
	}
	
	
	//getters
	public Address getAddress() {
		return this.address;
	}
	public String getFName() {
		return this.fName;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getlName() {
		return this.lName;
	}
	public String getName() {
		return this.Name;
	}
	
	//Setters
	public void setFName(String fName) {
		this.fName = fName;
	}
	public void setLName(String lName) {
		this.lName = lName;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	// to string method
	public String toString() {
		return "[" + this.Name + ", " + this.address.formatData() + ", " + this.phone + "]";
	}
	
	
	
}

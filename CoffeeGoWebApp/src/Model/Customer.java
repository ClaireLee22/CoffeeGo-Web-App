package Model;

/**
 * This class represents customers who use CoffeeGo web app.
 * It is dervided from User class.
 */
public class Customer extends User {
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	
	/**
	 * Constructor: create an Customer object w/o specified parameters
	 */
	public Customer() {
		super();
		address = "";
		city = "";
		state = "";
		zipcode = "";
		country= "";
	}
	
	/**
	 * Constructor: create an Customer object w specified usename and password
	 * @param un: username
	 * @param pwd: password
	 */
	public Customer(String un, String pwd) {
		super(un, pwd);
		address = "";
		city = "";
		state = "";
		zipcode = "";
		country= "";
	}
    
	/**
	 * Constructor: create an Customer object w specified firstName, lastName, address, city, state, zipcode, usename and password
	 * @param fn: firstName
	 * @param ln: lastName
	 * @param ad: address
	 * @param city: city
	 * @param state: state
	 * @param zipcode: zipcode
	 * @param country: country
	 * @param un: username
	 * @param pwd: password
	 */
	public Customer(String fn, String ln, String ad, String city, String state, String zipcode, String country, String un, String pwd) {
		super(fn, ln, un, pwd);
		address = ad;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country= country;
	}

	/**
	 * This method is used to get address
	 * @return address: address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method is used to set address
	 * @param address: address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * This method is used to get city
	 * @return city: city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * This method is used to set city
	 * @param city: city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * This method is used to get state
	 * @return state: state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * This method is used to set state
	 * @param state: state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * This method is used to get zipcode
	 * @return zipcode: zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * This method is used to set zipcode
	 * @param zipcode: zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	/**
	 * This method is used to get country
	 * @return country: country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * This method is used to set country
	 * @param country: country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
}


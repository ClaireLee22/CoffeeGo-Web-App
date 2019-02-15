package Model;
import java.io.Serializable;

/**
 * This class represents the shipping information authorized by checkout customer.
 * It implements the Serializable interface.
 */
public class Shipping implements Serializable{
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String email;
	

	/**
	 * Constructor: create an shipping object w/o specified parameters
	 */
	public Shipping() {

	}
    
	/**
	 * This method is used to get firstName
	 * @return firstName: first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method is used to set firstName
	 * @param firstName: first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method is used to get lastName
	 * @return lastName: last name
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * This method is used to set lastName
	 * @param lastName: last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	/**
	 * This method is used to get email
	 * @return email: email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method is used to set email
	 * @param email: email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

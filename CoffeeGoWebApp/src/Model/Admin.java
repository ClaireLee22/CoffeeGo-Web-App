package Model;

/**
 * This class represents the Administrator in CoffeeGo web app.
 * It is derived from User class.
 */


public class Admin extends User {
	String employeeID;
	
	/**
	 * Constructor: create an Admin object w/o specified parameters
	 */
	public Admin() {
		employeeID = "";
	}
	
	/**
	 * Constructor: create an Admin object w/o specified username and password
	 * @param un: username
	 * @param pwd: password
	 */
	public Admin( String un, String pwd) {
		super(un, pwd);
		employeeID = "";
	}
	
	/**
	 * Constructor: create an Admin object w/o specified firstName, lastName, username and password
	 * @param fn: firstName
	 * @param ln: lastname
	 * @param un: username
	 * @param pwd: password
	 */
	public Admin(String fn, String ln, String un, String pwd) {
		super(fn, ln, un, pwd);
		employeeID = "";
	}
    
	/**
	 * This method is used to get employeeID
	 * @return name: enployeeID
	 */
	public String getEmployeeID() {
		return employeeID;
	}

	/**
	 * This method is used to set employeeID
	 * @param employeeID: employee ID
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
}

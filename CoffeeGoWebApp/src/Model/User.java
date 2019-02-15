package Model;

/**
 * This class represents the users including customers, admins who use CoffeeGo web app
 */
public class User {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	/**
	 * Constructor: create an User object w/o specified parameters
	 */
	public User() {
	}
	
	/**
	 * Constructor: create an User object w/ specified userName, password
	 * @param un: username
	 * @param pwd: password
	 */
	public User(String un, String pwd) {
		firstName = "";
		lastName = "";
		userName = un;
		password = pwd;
	}
	
	/**
	 * Constructor: create an User object w/ specified firstNamw, lastName, userName, password
	 * @param fn: firstname
	 * @param ln: lastname
	 * @param un: username
	 * @param pwd: password
	 */
	public User(String fn, String ln, String un, String pwd) {
		firstName = fn;
		lastName = ln;
		userName = un;
		password = pwd;
	}
	
	/**
	 * This method is used to get first name
	 * @return firstName: first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * This method is used to set first name
	 * @param firstName: first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * This method is used to get last name
	 * @return lastName: last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * This method is used to set last name
	 * @param lastName: last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * This method is used to get username
	 * @return username: username
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * This method is used to set username
	 * @param userName: username
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * This method is used to get password
	 * @return password: password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * This method is used to set password
	 * @param password: password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}

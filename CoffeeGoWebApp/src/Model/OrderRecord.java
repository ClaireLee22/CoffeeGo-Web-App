package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents transaction records in CoffeeGo web app.
 */
public class OrderRecord {
	private String firstName;
	private String lastName;
	private String confirmationID;
	private ArrayList<ShoppingCartItem> items;
	private String grandPrice;
	private Date date;
	
	
	/**
	 * Constructor: create an OrderRecord object w/o specified parameters
	 */
	public OrderRecord() {
		
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
	 * This method is used to set lasttName
	 * @param lastName: last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * This method is used to get confirmationID
	 * @return confirmationID: order comfirmation number
	 */
	public String getConfirmationID() {
		return confirmationID;
	}
	
	/**
	 * This method is used to set confirmationID
	 * @param confirmationID: order comfirmation number
	 */
	public void setConfirmationID(String confirmationID) {
		this.confirmationID = confirmationID;
	}
	
	/**
	 * This method is used to get items
	 * @return items: items in the order
	 */
	public ArrayList<ShoppingCartItem> getItems() {
		return items;
	}
	
	/**
	 * This method is used to set items
	 * @param items: items in the order
	 */
	public void setItems(ArrayList<ShoppingCartItem> items) {
		this.items = items;
	}
	
	/**
	 * This method is used to get garndPrice
	 * @return grandPrice: totals in the order
	 */
	public String getGrandPrice() {
		return grandPrice;
	}
	
	/**
	 * This method is used to set garndPrice
	 * @param grandPrice: totals in the order
	 */
	public void setGrandPrice(String grandPrice) {
		this.grandPrice = grandPrice;
	}
	
	/**
	 * This method is used to get date
	 * @return date: transaction date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * This method is used to set date
	 * @param date: transaction date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * This method is used to get String which convert ShoppingCartItem objects to String for storing in SQL
	 * @return record: String type of items
	 */
	public String getStringItems() {
		String record = "";
		for (ShoppingCartItem s : items) {
			record += s.getProductCode() + ": " + s.getOrderQuantity() + "\n";
		}
		return record;
		
	}
	
	/**
	 * This method is used to get String which convert Date objects to String for storing in SQL
	 * @return String: String type of Date
	 */
	public String getStringDate() {
		return date.toString();
	}
	
}

package Model;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * This class represents the shpping cart in customer's purchase
 * It implements the Serializable interface.
 */
public class ShoppingCart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<ShoppingCartItem> shoppingItems; 
	protected static int nextOrderNumber = 1;
	
	/**
	 * Constructor: create an ShoppingCart object w/o specified parameters
	 */
	public ShoppingCart() {
		shoppingItems = new ArrayList<>();
	}
	

	/**
	 * This method is used to get shoppingItems
	 * @return shoppingItems: shopping items in shopping cart
	 */
	public ArrayList<ShoppingCartItem> getShoppingItems() {
		return shoppingItems;
	}
	
	/**
	 * This method is used to allow customer to add items to shopping cart
	 * @param s: shopping cart item
	 */
	public synchronized void addItem(ShoppingCartItem s) {
		shoppingItems.add(s); 
	}
	
	/**
	 * This method is used to allow customer to remove items from shopping cart
	 * @param s: ShoppingCartItem object
	 */
	public synchronized void removeItem(ShoppingCartItem s) {
		shoppingItems.remove(s);
	}
	
	/**
	 * This method is used to print the order confirmation to compete the order process
	 * @param shipping: Shipping object
	 * @param billing: Billing object
	 * @return confirmationNum: confirmation number
	 * @throws ShoppingCartException if error saving order
	 */
	public String completeOrder(Shipping shipping, Billing billing) throws ShoppingCartException {
		try
        {
            int orderNumber = 0;

            // Make sure no other threads can be generating an order number.
            synchronized (this)
            {
                orderNumber = nextOrderNumber;
                nextOrderNumber = nextOrderNumber + 1;
            }
            PrintWriter out = new PrintWriter(new FileOutputStream("order"+orderNumber));

            // Print the shipping info.
            out.println(shipping.getFirstName() + " " + shipping.getLastName());
            out.println(shipping.getAddress());
            out.print(shipping.getCity());
            out.println(shipping.getState());
            out.println(shipping.getZipcode());
            out.println(shipping.getCountry());
            out.println(shipping.getEmail());

            // Print the billing info.
            out.println(billing.getNameOnCard());
            out.println(billing.getCreditCardNumber());
            out.println(billing.getCreditCardExpMonth());
            out.println(billing.getCreditCardExpYear());

            // Print out the items.
            for (ShoppingCartItem s: shoppingItems) {
            	out.println(s.getProductCode()+","+ s.getOrderQuantity());
            }
            
            out.close();

            // Return a confirmation number (the order number as a string in this case).
            String confirmationNum = ""+orderNumber;
            return confirmationNum;
        }
        catch (Exception exc)
        {
            throw new ShoppingCartException(
                "Error saving order: "+exc.toString());
        }
		
    }
	
	/**
	 * This method is used to calculate the amount to pay for tax and dispaly on shopping cart page
	 * @return stringSubtotal: String type of calcuated subtotal
	 */
	public String getTax() {
		Locale locale = new Locale("en", "US"); 
		NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
		double subtotal = 0.0;
		double taxRate = 0.075;
		for(ShoppingCartItem s: shoppingItems) {
			subtotal += s.getPrice()* s.getOrderQuantity();
		}
		subtotal *= taxRate;
		String stringSubtotal = currency.format(subtotal);
		return stringSubtotal;
	}
	

	/**
	 * This method is used to calculate grand totals and dispaly on shopping cart page
	 * @return stringTotal: String type of calcuated total
	 */
	public String getGrandTotal() {
		Locale locale = new Locale("en", "US"); 
		NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
		double taxRate = 0.075;
		double total = 0.0;
		double shippingfee = 5.99;
		for(ShoppingCartItem s: shoppingItems) {
			total += s.getPrice()* s.getOrderQuantity();
		}
		total += total * taxRate;
		total += shippingfee;
		String stringTotal = currency.format(total);
		return stringTotal;
	}
	
	/**
	 * This method is used to clear shopping cart after the order is completed
	 */
	public void clearShoppingCart() {
		shoppingItems.clear();
	}
}


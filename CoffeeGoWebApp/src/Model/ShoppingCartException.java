package Model;

/**
 * This class is responsible to handle exception in shopping cart
 */
public class ShoppingCartException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor: create an ShoppingCartException object w/o specified parameters
	 */
	public ShoppingCartException(){
    }

	/**
	 * Constructor: create an ShoppingCartException object w/ specified message
	 * @param message: error message
	 */
    public ShoppingCartException(String message)
    {
        super(message);
    }
}

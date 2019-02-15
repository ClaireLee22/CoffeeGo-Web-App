package Model;
import java.io.Serializable;

/**
 * This class represents the shpping cart items in customer's purchase
 * It implements the Serializable interface.
 */
public class ShoppingCartItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String productCode;
	private String productName;
	private double price;
	public int orderQuantity;
	private String image;
	
	/**
	 * Constructor: create an ShoppingCartItem object w/o specified parameters
	 */
	public ShoppingCartItem() {
	
	}
	
	/**
	 * Constructor: create an ShoppingCartItem object w/ specified product code, product name, product price, order quantity, product image url
	 * @param pc: product code
	 * @param pn: product name
	 * @param p: product price
	 * @param oq: order quantity
	 * @param img: product image url
	 */
	public ShoppingCartItem(String pc, String pn, double p, int oq, String img) {
		productCode = pc;
		productName = pn;
		price = p;
		orderQuantity = oq;
		image = img;
	}
	
	/**
	 * This method is used to get productCode
	 * @return productCode: product code
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * This method is used to set productCode
	 * @param productCode: product code
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * This method is used to get productName
	 * @return productName: product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * This method is used to set productName
	 * @param productName: product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * This method is used to get price
	 * @return price: product price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * This method is used to set price
	 * @param price: product price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * This method is used to get orderQuantity
	 * @return orderQuantity: product orderQuantity
	 */
	public int getOrderQuantity() {
		return orderQuantity;
	}

	/**
	 * This method is used to set orderQuantity
	 * @param orderQuantity: product orderQuantity
	 */
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	/**
	 * This method is used to get image
	 * @return image: product image url
	 */
	public String getImage() {
		return image;
	}

	/**
	 * This method is used to set image
	 * @param image: product image url
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	
}

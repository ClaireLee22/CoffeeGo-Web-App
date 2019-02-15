package Model;


/**
 * This class represents the products in GoffeeGo web app.
 */
public class Product {
	private String productCode;
	private String productCatalog;
	private String name;
	private String description;
	private double price;
	private int quantity;// add products
	private int inventory;
	private String imagesrc;
	
	
	/**
	 * Constructor: create a Product object w/o specified parameters
	 */
	public Product() {
		
	}
	
	/**
	 * Constructor: create a Product object w/ specified productCode
	 * @param pc: productCode
	 */
	public Product(String pc) {
		productCode = pc;
	}
	
	/**
	 * Constructor: create a Product object w/ specified productCode, productCatalog, name, decription, price, inventory, imagesrc
	 * @param productCode: product code
	 * @param productCatalog: product catalog
	 * @param name: product name
	 * @param description: product description
	 * @param price: product price
	 * @param inventory: product inventory
	 * @param imagesrc: product imag URL
	 */
	public Product(String productCode, String productCatalog, String name, String description, double price, int inventory, String imagesrc) {
		this.productCode = productCode;
		this.productCatalog = productCatalog;
		this.name = name;
		this.description = description;
		this.price = price;
		this.inventory= inventory;
		this.imagesrc = imagesrc;
		quantity = 0;
	}
	
	/**
	 * This method is used to get inventory
	 * @return inventory: product inventory
	 */
	public int getInventory() {
		return inventory;
	}

	/**
	 * This method is used to set inventory
	 * @param inventory: product inventory
	 */
	public void setInventory(int inventory) {
		this.inventory = inventory;
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
	 * This method is used to get productCatalog
	 * @return productCatalog: product catalog
	 */
	public String getProductCatalog() {
		return productCatalog;
	}

	/**
	 * This method is used to set productCatalog
	 * @param productCatalog: product catalog
	 */
	public void setProductCatalog(String productCatalog) {
		this.productCatalog = productCatalog;
	}
	
	/**
	 * This method is used to get description
	 * @return description: product description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method is used to set description
	 * @param description: product description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * This method is used to get price
	 * @return proce: product price
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
	 * This method is used to get name
	 * @return name: product name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method is used to set name
	 * @param name: product name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * This method is used to get quantity
	 * @return quantity: product qantity will be add as admim manages products
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * This method is used to set quantity
	 * @param quantity: product qantity will be add as admim manages products
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * This method is used to get imagesrc
	 * @return imagesrc: product image url
	 */
	public String getImagesrc() {
		return imagesrc;
	}

	/**
	 * This method is used to Set imagesrc
	 * @param imagesrc: product image url
	 */
	public void setImagesrc(String imagesrc) {
		this.imagesrc = imagesrc;
	}
	

}

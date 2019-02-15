package Dao;

import java.util.ArrayList;
import Model.Product;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class represents product database in coffeeGo web app.
 * It is derived from MySOLAccess class
 */
public class ProductDBAccess extends MySQLAccess{
	/**
	 * Constructor: create an CustomerDBManage object w/o specified parameters
	 */
    public ProductDBAccess() {
    	
	};
    
	/**
	 * This method is used to get product list from product database
	 * @return productList: product list
	 */
    public ArrayList<Product> getProductList() {
		ArrayList<Product> productList = new ArrayList<>();
		//SQL SELECT query. 
	    String query = "SELECT productCode, productCatalog, name, description, price, inventory, image FROM CoffeeGoDB.products";
	    
	    try {
		    // create the java statement
		    Statement st = getConnection().createStatement();
		   
		    // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
		  
		    // iterate through the java resultset
		    while (rs.next()) {
			    String  productCode= rs.getString("productCode");
			    String productCatalog = rs.getString("productCatalog");
            	String name = rs.getString("name");
            	String description = rs.getString("description");
        		double price = rs.getDouble("price");
        		int inventory = rs.getInt("inventory");
        		String image = rs.getString("image");
        		Product product = new Product(productCode,productCatalog,name,description,price,inventory,image);
			    productList.add(product);
		    }
		    st.close();
		    return productList;
	    } catch(SQLException e) {
	    	return null;
	    }
	}
	
    /**
	 * This method is used to get a specified product information
	 * @param productCode: productCode
	 * @param image: image url
	 * @return p: Product object
	 */
    public Product getProduct(String productCode, String image) {
    	String sql = 
    			"SELECT productCode, productCatalog, name, description, price, inventory, image " +
    	        "FROM CoffeeGoDB.products " +
    			"WHERE productCode = ?  AND image = ? ";
    	try (PreparedStatement st = getConnection().prepareStatement(sql)) {
    		// set the preparedstatement parameters
    		st.setString(1, productCode);
    		st.setString(2, image);
    		ResultSet rs = st.executeQuery();
    		if (rs.next()) {
    			String productCatalog = rs.getString("productCatalog");
            	String name = rs.getString("name");
            	String description = rs.getString("description");
        		double price = rs.getDouble("price");
        		int inventory = rs.getInt("inventory");
        		//String image = rs.getString("image");
        		Product p = new Product(productCode,productCatalog,name,description,price,inventory,image);
        		rs.close();
    		    return p;
    		} else {
    			rs.close();
    		    return null;
    		}
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;
	    }
    }
    
    /**
	 * This method is used to get a specified product information
	 * @param productCode: productCode
	 * @return p: Product object
	 */
    public Product getProduct(String productCode) {
    	String sql = 
    			"SELECT productCode, productCatalog, name, description, price, inventory, image " +
    	        "FROM CoffeeGoDB.products " +
    			"WHERE productCode = ? ";
    	try (PreparedStatement st = getConnection().prepareStatement(sql)) {
    		// set the preparedstatement parameters
    		st.setString(1, productCode);
    		ResultSet rs = st.executeQuery();
    		if (rs.next()) {
    			String productCatalog = rs.getString("productCatalog");
            	String name = rs.getString("name");
            	String description = rs.getString("description");
        		double price = rs.getDouble("price");
        		int inventory = rs.getInt("inventory");
        		String image = rs.getString("image");
        		Product p = new Product(productCode,productCatalog,name,description,price,inventory,image);
        		rs.close();
    		    return p;
    		} else {
    			rs.close();
    		    return null;
    		}
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;
	    }
    }
    
    /**
	 * This method is used to add new product information into product databse by admin
	 * @param p: Product object
	 * @return boolean: if new product information is added to product database, return true. Otherwise, return false.
	 */
    public boolean addProduct(Product p) {
    	String sql = 
    			"INSERT INTO CoffeeGoDB.products (productCode, productCatalog, name, description, price, inventory, image) " +
    	        "VALUES (?,?,?,?,?,?,?)";
    	try ( PreparedStatement st = getConnection().prepareStatement(sql);) {
    		// set the preparedstatement parameters
		    st.setString(1, p.getProductCode());
		    st.setString(2, p.getProductCatalog());
		    st.setString(3, p.getName());
		    st.setString(4, p.getDescription());
		    st.setDouble(5, p.getPrice());
		    st.setInt(6, p.getInventory());
		    st.setString(7, p.getImagesrc());
		   
		    // call executeUpdate to execute our sql update statement
		    st.executeUpdate();
		    return true;
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }
    
    /**
	 * This method is used to update a specified product information in product databse by admin
	 * @param p: Product object
	 * @return boolean: if new product information is updated in product database, return true. Otherwise, return false.
	 */
    public boolean updateProduct(Product p) {
    	String sql = 
			"UPDATE CoffeeGoDB.products " +
			"SET productCatalog = ?, name = ?, description = ?, price = ?, inventory = ?, image = ? " + 
	        "WHERE productCode = ? "; 
    	try ( PreparedStatement st = getConnection().prepareStatement(sql);) {
    		// set the preparedstatement parameters
    		st.setString(1, p.getProductCatalog());
    		st.setString(2, p.getName());
		    st.setString(3, p.getDescription());
		    st.setDouble(4, p.getPrice());
		    st.setInt(5, p.getInventory());
		    st.setString(6, p.getImagesrc());
		    st.setString(7, p.getProductCode());
		    // call executeUpdate to execute our sql update statement
		    st.executeUpdate();
		    return true;
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }
    
    /**
	 * This method is used to delete a product information in product databse by admin
	 * @param p: Product object
	 * @return boolean: if new product information is deleted, return true. Otherwise, return false.
	 */
    public boolean deleteProduct(Product p) {
    	String sql = 
			"DELETE FROM CoffeeGoDB.products " +
	        "WHERE productCode = ? "; 
    	try (PreparedStatement st = getConnection().prepareStatement(sql);) {
    		// set the preparedstatement parameters
		    st.setString(1, p.getProductCode());
		    // call executeUpdate to execute our sql update statement
		    st.executeUpdate();
		    return true;
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }
    
}

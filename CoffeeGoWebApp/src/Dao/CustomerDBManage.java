package Dao;
import java.util.ArrayList;

import Model.Customer;


import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**This class is allow Admin to access customer database in order to manage customers information
 * It is derived from MySOLAccess class
 */
public class CustomerDBManage extends MySQLAccess{
	
	/**
	 * Constructor: create an CustomerDBManage object w/o specified parameters
	 */
    public CustomerDBManage() {
    	
	};
	
	/**
	 * This method is used to get customer-type user list from customer database
	 * @return customerList: customer-type user list
	 */
    public ArrayList<Customer> getCustomerList() {
		ArrayList<Customer> customerList = new ArrayList<>();
		//SQL SELECT query. 
	    String query = "SELECT firstName, lastName, address, city, state, zipcode, country, username, password FROM CoffeeGoDB.customers";

	    
	    try {
		    // create the java statement
		    Statement st = getConnection().createStatement();
		   
		    // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
		  
		    // iterate through the java resultset
		    while (rs.next()) {
		    	String  firstName = rs.getString("firstName");
		    	String  lastName = rs.getString("lastName");
		    	String  address = rs.getString("address");
		    	String  city = rs.getString("city");
		    	String  state = rs.getString("state");
		    	String  zipcode = rs.getString("zipcode");
		    	String  country = rs.getString("country");
			    String  username = rs.getString("username");
			    String  password = rs.getString("password");
			    Customer customer = new Customer(firstName, lastName, address, city, state, zipcode, country, username, password);
			    customerList.add(customer);
		    }
		    rs.close();
		    return customerList;
	    } catch(SQLException e) {
	    	return null;
	    }
	}
	
    /**
	 * This method is used to get a specified customer information
	 * @param username: username
	 * @return c: Customer object
	 */
    public Customer getCustomer(String username) {
		//SQL SELECT query. 
	    String sql = "SELECT username, firstName, lastName, address, city, state, zipcode, country, password " +
	    		       "FROM CoffeeGoDB.customers " +
	    		       "WHERE username = ?";
	    
	    try (PreparedStatement st = getConnection().prepareStatement(sql))
	    {
	    	st.setString(1, username);
		    // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery();
		  
		    // iterate through the java resultset
		    if (rs.next()) {
		    	String  firstName = rs.getString("firstName");
		    	String  lastName = rs.getString("lastName");
		    	String  address = rs.getString("address");
		    	String  city = rs.getString("city");
		    	String  state = rs.getString("state");
		    	String  zipcode = rs.getString("zipcode");
		    	String  country = rs.getString("country");
			    String  password = rs.getString("password");
			    Customer c = new Customer(firstName, lastName, address, city, state, zipcode, country, username, password);
			 
			    rs.close();
			    return c;
		    }
		    else {
		    rs.close();
		    return null;
		    }
	    } catch(SQLException e) {
	    	return null;
	    }
	}
    
    /**
	 * This method is used to add new customer information into customer databse by admin
	 * @param c: Customer object
	 * @return boolean: if new customer information is added to customer database, return true. Otherwise, return false.
	 */
    public boolean AddCustomer(Customer c) {
    	String sql = 
    			"INSERT INTO CoffeeGoDB.customers (firstName, lastName, address, city, state, zipcode, country, username, password) " +
    	        "VALUES (?,?,?,?,?,?,?,?,?)";
    	try ( PreparedStatement st = getConnection().prepareStatement(sql);) {
    		// set the preparedstatement parameters
		    st.setString(1, c.getFirstName());
		    st.setString(2, c.getLastName());
		    st.setString(3, c.getAddress());
		    st.setString(4, c.getCity());
		    st.setString(5, c.getState());
		    st.setString(6, c.getZipcode());
		    st.setString(7, c.getCountry());
		    st.setString(8, c.getUserName());
		    st.setString(9, c.getPassword());
		    // call executeUpdate to execute our sql update statement
		    st.executeUpdate();
		    return true;
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }
    
    /**
	 * This method is used to update a specified customer information in customer databse by admin
	 * @param c: Customer object
	 * @return boolean: if new customer information is updated in customer database, return true. Otherwise, return false.
	 */
    public boolean updateCustomer(Customer c) {
    	String sql = 
			"UPDATE CoffeeGoDB.customers " +
    	    "SET password = ? " + 
	        "WHERE username = ? "; 
    	try ( PreparedStatement st = getConnection().prepareStatement(sql);) {
    		// set the preparedstatement parameters
    		st.setString(1, c.getPassword());
		    st.setString(2, c.getUserName());
		    // call executeUpdate to execute our sql update statement
		    st.executeUpdate();
		    return true;
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }
    
    /**
	 * This method is used to delete a customer information in customer databse by admin
	 * @param c: Customer object
	 * @return boolean: if new customer information is deleted, return true. Otherwise, return false.
	 */
    public boolean deleteCustomer(Customer c) {
    	String sql = 
			"DELETE FROM CoffeeGoDB.customers " +
	        "WHERE username = ? AND password = ? "; 
    	try (PreparedStatement st = getConnection().prepareStatement(sql);) {
    		// set the preparedstatement parameters
		    st.setString(1, c.getUserName());
		    st.setString(2, c.getPassword());
		    // call executeUpdate to execute our sql update statement
		    st.executeUpdate();
		    return true;
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }
   
}

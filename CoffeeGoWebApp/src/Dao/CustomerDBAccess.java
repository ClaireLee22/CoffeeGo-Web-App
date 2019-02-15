package Dao;
import java.util.ArrayList;

import Model.Customer;
import Model.User;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**This class represents admin database in coffeeGo web app.
 * It is derived from MySOLAccess class
 */
public class CustomerDBAccess extends MySQLAccess{
	/**
	 * Constructor: create an CustomerDBAccess object w/o specified parameters
	 */
    public CustomerDBAccess() {
    	
	};
    
	/**
	 * This method is used to get customer-type user list from customer database
	 * @return userList: customer-type user list
	 */
    public ArrayList<User> getList() {
		ArrayList<User> userList = new ArrayList<>();
		//SQL SELECT query. 
	    String query = "SELECT username, password FROM CoffeeGoDB.customers";

	    
	    try {
		    // create the java statement
		    Statement st = getConnection().createStatement();
		   
		    // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
		  
		    // iterate through the java resultset
		    while (rs.next()) {
			    String  username = rs.getString("username");
			    String  password = rs.getString("password");
			    Customer customer = new Customer(username, password);
			    userList.add(customer);
		    }
		    st.close();
		    return userList;
	    } catch(SQLException e) {
	    	return null;
	    }
	}
	
    /**
	 * This method is used to allow new customer to create a new account 
	 * @param c: Customer objects 
	 * @return boolean: if register is allowed return true. Otherwise, return false.
	 */
    public boolean registerCustomer(Customer c) {
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
	 * This method is used to get a specified customer information
	 * @param username: username
	 * @param password: password
	 * @return c: Customer object
	 */
    public Customer getCustomer(String username, String password) {
		//SQL SELECT query. 
	    String sql = "SELECT username, firstName, lastName, address, city, state, zipcode, country, password " +
	    		     "FROM CoffeeGoDB.customers " +
	    		     "WHERE username = ? AND password = ? ";
	    try (PreparedStatement st = getConnection().prepareStatement(sql)) {
    		// set the preparedstatement parameters
	    	st.setString(1, username);
	    	st.setString(2, password);
    		ResultSet rs = st.executeQuery();
    		if (rs.next()) {
    	    	String  firstName = rs.getString("firstName");
    	    	String  lastName = rs.getString("lastName");
    	    	String  address = rs.getString("address");
    	    	String  city = rs.getString("city");
    	    	String  state = rs.getString("state");
    	    	String  zipcode = rs.getString("zipcode");
    	    	String  country = rs.getString("country");
    		    Customer c = new Customer(firstName, lastName, address, city, state, zipcode, country, username, password);
    		    rs.close();
    		    return c;
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
   	 * This method is used to update customer's password if reset is triggered.
   	 * @param username: username
   	 * @param newPassword: new password
   	 * @return boolean: if update is procceed, return true. Otherwise, return false.
   	 */
    public boolean updatePassword(String username, String newPassword) {
    	String sql = 
			"UPDATE CoffeeGoDB.customers " +
    	    "SET password = ? " + 
	        "WHERE username = ? "; 
    	try ( PreparedStatement st = getConnection().prepareStatement(sql);) {
    		// set the preparedstatement parameters
		    st.setString(2, username);
		    st.setString(1, newPassword);
		    // call executeUpdate to execute our sql update statement
		    st.executeUpdate();
		    return true;
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }
    
    /**
   	 * This method allows customers to edit thier account as log in
   	 * @param c: Customer object
   	 * @return boolean: if update is procceed, return true. Otherwise, return false.
   	 */
    public boolean updateAccount(Customer c) {
    	String sql = 
			"UPDATE CoffeeGoDB.customers " +
    	    "SET firstName = ?, lastName = ?, address = ?, city = ?, state = ?, zipcode = ?, country = ? " + 
	        "WHERE username = ? AND password = ? "; 
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
}

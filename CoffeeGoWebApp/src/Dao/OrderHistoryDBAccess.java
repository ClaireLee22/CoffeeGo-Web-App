package Dao;

import Model.OrderRecord;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class represents transaction database in coffeeGo web app.
 * It is derived from MySOLAccess class
 */
public class OrderHistoryDBAccess extends MySQLAccess{
	/**
	 * Constructor: create an CustomerDBAccess object w/o specified parameters
	 */
    public OrderHistoryDBAccess() {
    	
	};
    
	/**
	 * This method is used to add new order information into transaction databse
	 * @param o: OrderRecord object
	 * @return boolean: if new order information is added to transaction database, return true. Otherwise, return false.
	 */
    public boolean addOrder(OrderRecord o) {
    	String sql = 
    			"INSERT INTO CoffeeGoDB.transaction (firstname, lastname, confirmationID, items, grandPrice, date) " +
    	        "VALUES (?,?,?,?,?,?)";
    	try ( PreparedStatement st = getConnection().prepareStatement(sql);) {
    		// set the preparedstatement parameters
		    st.setString(1, o.getFirstName());
		    st.setString(2, o.getLastName());
		    st.setString(3, o.getConfirmationID());
		    st.setString(4, o.getStringItems());
		    st.setString(5, o.getGrandPrice());
		    st.setString(6, o.getStringDate());
		   
		    // call executeUpdate to execute our sql update statement
		    st.executeUpdate();
		    return true;
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }
}

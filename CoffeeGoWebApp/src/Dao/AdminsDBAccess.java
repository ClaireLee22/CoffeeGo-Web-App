package Dao;
import java.util.ArrayList;

import Model.Admin;
import Model.User;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class represents admin database in coffeeGo web app.
 * It is derived from MySOLAccess class
 */
public class AdminsDBAccess extends MySQLAccess{
	
	/**
	 * Constructor: create an AdminDBAccess object w/o specified parameters
	 */
    public AdminsDBAccess() {
    	
	};
    
	/**
	 * This method is used to get admin-type user list from  admin database
	 * @return userList: admin-type user list
	 */
    public ArrayList<User> getList() {
		ArrayList<User> userList = new ArrayList<>();
		//SQL SELECT query. 
	    String query = "SELECT username, password FROM CoffeeGoDB.admins";
	    
	    
	    try {
		    // create the java statement
		    Statement st = getConnection().createStatement();
		   
		    // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
		  
		    // iterate through the java resultset
		    while (rs.next()) {
			    String  username = rs.getString("username");
			    String  password = rs.getString("password");
			    Admin admin = new Admin(username, password);
			    userList.add(admin);
		    }
		    st.close();
		    return userList;
	    } catch(SQLException e) {
	    	return null;
	    }
	}
    
    /**
	 * This method is used to update admin password in database if reset is triggered
	 * @param un: username
	 * @param npwd: new password
	 * @return boolean: if update is procceed, return true. Otherwise, return false.
	 */
    public boolean updatePassword(String un, String npwd) {
    	String sql = 
			"UPDATE CoffeeGoDB.admins " +
    	    "SET password = ? " + 
	        "WHERE username = ? "; 
    	try ( PreparedStatement st = getConnection().prepareStatement(sql);) {
    		// set the preparedstatement parameters
		    st.setString(2, un);
		    st.setString(1, npwd);
		    // call executeUpdate to execute our sql update statement
		    st.executeUpdate();
		    return true;
		  
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }

}

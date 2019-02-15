package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Dao.AdminsDBAccess;
import Dao.CustomerDBAccess; 

/***
 * This class is used to validte whethier if the user's username and password are in our database
 * It implements the Serializable interface 
 */

public class ValidateUser implements Serializable { 
  
	private static final long serialVersionUID = 1L;
	private String username;
    private String password; 
    private ArrayList<User> userList;
  
    /**
	 * Constructor: create an ValidateUser object w specified username, password and userType
	 * @param username: username
	 * @param password: password
	 * @param userType: user type 1: customer 2: admin
	 */
    public ValidateUser(String username, String password, int userType) {
    	this.username = username;
    	this.password = password;
    	//1: Customer 2: Admins
    	switch(userType) {
    	case 1:
    		CustomerDBAccess dao1 = new CustomerDBAccess();
    		dao1.getConnection();
    		userList = dao1.getList();
    		break;
    		
    	case 2:
    		AdminsDBAccess dao2 = new AdminsDBAccess();
    		dao2.getConnection();
    		userList = dao2.getList();
    		break;
    	}
    }

    /**
	 * This methond is used to validate a user 
	 * @return boolean: if the user's username and password match one of users in database, return true. Otherwise, return false
	 */
    public boolean validate() { 
    	for(User u: userList) {
    		if (username.equals(u.getUserName()) && password.equals((u.getPassword()))) {
    			return true;
    	    }
    	}
		return false;
    }
    
} 
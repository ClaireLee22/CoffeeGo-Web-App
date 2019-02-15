package Model;
import java.util.ArrayList;

import Dao.AdminsDBAccess;
import Dao.CustomerDBAccess;

/**
 * This class represents the to reset the password for CoffeeGo memberships or admins forget their password
 */
public class ResetPwd {
	private String username;
	private String newPassword;
	private String confirmPassword;
	private int userType; // 1: customer 2:admin
	
	/**
	 * Constructor: create an RestPwd object w specified username, new password, confirmed new passowrd, userType
	 * @param un: username
	 * @param npwd: new password
	 * @param cpwd: confirmed new password
	 * @param ut: userType (1: Customer 2: Admin)
	 */
	public ResetPwd(String un, String npwd, String cpwd, int ut) {
		username = un;
		newPassword = npwd;
		confirmPassword = cpwd;
		userType = ut;
	}
	
	
	/**
	 * This method is used to check if the log-in user is in our database
	 * If the user is in database, return true, otherwise, return false.
	 * @return boolean
	 */
	private boolean IsAlreadyRegister() {
		ArrayList<User> userList = new ArrayList<>();
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
		
		for(User u: userList) {
    		if (username.equals(u.getUserName())) {
    			return true;
    	    }
    	}
		return false;
	}

   /**
   * This method is used to check if the new password is the same as the confirmed new password
   * If they are the sane, return true, otherwise, return false.
   * @return boolean
   */
   private boolean confirmPwd() {
	   if(newPassword.equals(confirmPassword)) {
		   return true;
	   }
	   return false;
   }
   
   /**
	 * This method is used to check if the user is allowed to reset password
	 * If the user is already in database and new password equals the confirmed password, return true, otherwise, return false.
	 * @return boolean
	 */
   public boolean IsAllowToRetPwd() {
	   boolean isRegsterCustomer = IsAlreadyRegister();
	   boolean isSamePwd = confirmPwd();
	   
	   if (isRegsterCustomer) {
		   if(isSamePwd) {
			   return true;
		   } 
	   }
	   return false;
   }
}
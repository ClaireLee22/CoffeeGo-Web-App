package Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDBAccess;
import Model.ResetPwd;

/**
 * This class represents the controller for customer reset password process
 * It is derived from HttpServelet Class and  override doPost method
 */
public class CusResetPwdController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This methond is to get the parameters from customer reset password submission form, use the parameters
	 * to validate if the user allow to reset password. 
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
       
		//read form field
		String un=request.getParameter("username");
		String npwd=request.getParameter("newPassword");
		String cpwd=request.getParameter("password");
		
		ResetPwd r = new ResetPwd(un, npwd, cpwd, 1);
		if(r.IsAllowToRetPwd())
		{   
			CustomerDBAccess dao = new CustomerDBAccess();
			dao.updatePassword(un, npwd);
			response.sendRedirect("home.html");
			return;
		}
		else
		{   
		    response.sendRedirect("ResetPwd.html");
			return;
		}
   
    }
	
}

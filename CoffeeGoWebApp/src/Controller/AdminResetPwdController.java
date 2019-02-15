package Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AdminsDBAccess;
import Model.ResetPwd;


/**
 * This class represents the controller for admin reset password process
 * It is derived from HttpServelet Class and  override doPost method
 */
public class AdminResetPwdController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This methond is to get the parameters from admin reset password submission form, use the parameters
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
		
		ResetPwd r = new ResetPwd(un, npwd, cpwd, 2);
		if(r.IsAllowToRetPwd())
		{   
			AdminsDBAccess dao = new AdminsDBAccess();
			dao.updatePassword(un, npwd);
			response.sendRedirect("AdminModeHome.html");
			return;
		}
		else
		{   
			request.setAttribute("reset", "fail");
			request.getRequestDispatcher("AdminResetPwd.html").forward(request, response);
			return;
		}
   
    }
	
}

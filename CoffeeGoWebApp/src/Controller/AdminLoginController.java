package Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ValidateUser;


/**
 * This class represents the controller for admin log in process
 * It is derived from HttpServelet Class and  override doPost method
 */
public class AdminLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This methond is to get the parameters from admin log in submission form on admin log in page, use the parameters
	 * to validate user. If the parameter matches the user in database, allow the admin log in. Otherwise, 
	 * display login error page.
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
       
		//read form field
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		ValidateUser vd = new ValidateUser(un, pw, 2);
		if(vd.validate())
		{   
			response.sendRedirect("AdminModeHome.html");
			return;
		}
		else
		{  
		    response.sendRedirect("AdminLogInError.html");
			return;
		}
   
    }
	
}

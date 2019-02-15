package Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ValidateUser;

/**
 * This class represents the controller for customer log in process
 * It is derived from HttpServelet Class and  override doPost method
 */
public class CusLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This methond is to get the parameters from customer log in submission form on customer log in page, use the parameters
	 * to validate user. If the parameter matches the user in database, allow the customer log in. Otherwise, 
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
	
		
		ValidateUser vd = new ValidateUser(un, pw, 1);
		if(vd.validate())
		{   
			
			HttpSession session = request.getSession(); //Creating a session
			session.setAttribute("userMode", "Customer");
		    request.setAttribute("username", un); //setting session attribute
			request.setAttribute("password", pw);
			request.getRequestDispatcher("CusMyAccount.jsp").forward(request, response);
			return;
		}
		else
		{   
		    response.sendRedirect("logInError.html");
			return;
		}
   
    }
	
}

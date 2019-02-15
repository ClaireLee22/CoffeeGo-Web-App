package Controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDBAccess;
import Model.Customer;


/**
 * This class represents the controller for customer edit their own account process
 * It is derived from HttpServelet Class and  override doPost method
 */
public class EditMyAccountController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This methond is to get the parameters from "save change" button in customers account, use the parameters
	 * to update customer information in customer database. 
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		
		//read form field
		String fn=request.getParameter("firstName");
		String ln=request.getParameter("lastName");
		String a=request.getParameter("address");
		String c=request.getParameter("city");
		String s=request.getParameter("state");
		String z=request.getParameter("zipcode");
		String ct=request.getParameter("country");
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		Customer customer= new Customer(fn, ln, a, c, s, z, ct, un, pw);
		
	
		CustomerDBAccess dao = new CustomerDBAccess();
		dao.updateAccount(customer);
		
		request.setAttribute("username", customer.getUserName());
		request.setAttribute("password", customer.getPassword());
		request.getRequestDispatcher("CusMyAccount.jsp").forward(request, response);
    }
}

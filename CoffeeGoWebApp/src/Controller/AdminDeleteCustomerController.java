package Controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDBManage;
import Model.Customer;


/**
 * This class represents the controller for delete customer process by admin
 * It is derived from HttpServelet Class and  override doPost method
 */
public class AdminDeleteCustomerController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This methond is to get the parameters from "delete" button on delete customer page, use the parameters
	 * to create the Customer object and then delete it in customer database.
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		String un =request.getParameter("username");
		
		CustomerDBManage dao = new CustomerDBManage();
		Customer c =dao.getCustomer(un);
		dao.deleteCustomer(c);
        response.sendRedirect(response.encodeRedirectURL("AdminDeleteCustomer.jsp"));
    }
}

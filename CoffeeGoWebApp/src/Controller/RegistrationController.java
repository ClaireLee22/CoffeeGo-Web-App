package Controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDBAccess;
import Model.Customer;



public class RegistrationController extends HttpServlet {
	/**
	 * This class represents the controller for customer register process
	 * It is derived from HttpServelet Class and  override doPost method
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * This methond is to get the parameters from sign uo form, use the parameters
	 * to create the Customer object and then add the new customer information in customer database. 
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //Copying all the input parameters in to local variables
		 String firstName = request.getParameter("firstName");
		 String lastName = request.getParameter("lastName");
		 String address = request.getParameter("address");
		 String city = request.getParameter("city");
		 String state = request.getParameter("state");
		 String zipcode = request.getParameter("zipcode");
		 String country = request.getParameter("country");
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		 Customer c = new Customer(firstName, lastName, address, city, state, zipcode, country, username, password);
		 
		//The core Logic of the Registration application is present here. We are going to insert user data in to the database
		 CustomerDBAccess dao = new CustomerDBAccess();
		 boolean userRegister = dao.registerCustomer(c);
		 
		 
		 if(userRegister)   //On success, display a message to user on Home page
		 {
		 request.setAttribute("username", username);
		 request.setAttribute("password", password);
		 
		 request.getRequestDispatcher("CusMyAccount.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		
		 request.getRequestDispatcher("SignUp.html").forward(request, response);
		 }
		}
	

}

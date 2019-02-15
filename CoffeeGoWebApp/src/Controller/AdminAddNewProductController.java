package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDBAccess;
import Model.Product;

/**
 * This class represents the controller for add new product process by admin
 * It is derived from HttpServelet Class and  override doPost method
 */
public class AdminAddNewProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * This methond is to get the parameters from add new product submission form, use the parameters
	 * to create the Product object and then add it to product database.
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
       
		// First get the shoppingItem values from the request.
		String pc =request.getParameter("productCode");
		String pcl =request.getParameter("productCatalog");
		String n =request.getParameter("name");
		String d =request.getParameter("description");
		double price =Double.parseDouble(request.getParameter("price"));
		int oq = Integer.parseInt(request.getParameter("inventory"));
		String img =request.getParameter("imagesrc");
		Product p = new Product(pc,pcl,n,d,price,oq,img);
		
		// Add tp database
		ProductDBAccess dao = new ProductDBAccess();
		dao.addProduct(p);
		
        response.sendRedirect(response.encodeRedirectURL("AdminModeHome.html"));
    }
}

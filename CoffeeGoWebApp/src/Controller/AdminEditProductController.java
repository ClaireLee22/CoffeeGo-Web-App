package Controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDBAccess;
import Model.Product;

/**
 * This class represents the controller for eidt product process by admin
 * It is derived from HttpServelet Class and  override doPost method
 */
public class AdminEditProductController extends HttpServlet {

	/**
	 * This methond is to get the parameters from "save" button on edit product page, use the parameters
	 * to create the Product object and then update its new inforamtion in product database.
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		String pc =request.getParameter("productCode");
		String pcl =request.getParameter("productCatalog");
		String n =request.getParameter("name");
		String d =request.getParameter("description");
		double price =Double.parseDouble(request.getParameter("price"));
		int oq = Integer.parseInt(request.getParameter("inventory"));
		String img =request.getParameter("image");
		Product p = new Product(pc,pcl,n,d,price,oq,img);
	
		ProductDBAccess dao = new ProductDBAccess();
		dao.updateProduct(p);
        response.sendRedirect(response.encodeRedirectURL("AdminEditProduct.jsp"));
    }
}


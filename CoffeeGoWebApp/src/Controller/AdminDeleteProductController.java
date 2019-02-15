package Controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDBAccess;
import Model.Product;

/**
 * This class represents the controller for delete product process by admin
 * It is derived from HttpServelet Class and  override doPost method
 */
public class AdminDeleteProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This methond is to get the parameters from "delete" button on delete product page, use the parameters
	 * to create the Product object and then delete it in product database.
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		String pc =request.getParameter("productCode");
		
		ProductDBAccess dao = new ProductDBAccess();
		Product p =dao.getProduct(pc);
		dao.deleteProduct(p);
        response.sendRedirect(response.encodeRedirectURL("AdminDeleteProduct.jsp"));
    }
}

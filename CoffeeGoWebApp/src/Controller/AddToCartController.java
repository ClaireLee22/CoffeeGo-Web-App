package Controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ProductDBAccess;
import Model.Product;
import Model.ShoppingCart;
import Model.ShoppingCartItem;

/**
 * This class represents the controller for add items to shopping cart process
 * It is derived from HttpServelet Class and  override doPost method
 */
public class AddToCartController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This methond is to get the parameters from "add to shopping cart" button, use the parameters
	 * to create the shoppingCartItem object and then add the object to cart.
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
       
		// First get the shoppingItem values from the request.
		String pc =request.getParameter("productCode");
		int oq = Integer.parseInt(request.getParameter("orderQuantity"));
		ProductDBAccess dao = new ProductDBAccess();
		Product p= dao.getProduct(pc);
        
		// Now create an item to add to the cart.
		String productCode = p.getProductCode();
		String productName = p.getName();
		double price = p.getPrice();
		String image = p.getImagesrc();
		ShoppingCartItem item = new ShoppingCartItem(productCode, productName, price, oq, image);
		

        HttpSession session = request.getSession();
        
        // Get the cart.
        ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
        
        // If there is no shopping cart, create one.
        if (cart == null)
        {
            cart = new ShoppingCart();
            session.setAttribute("ShoppingCart", cart);
        }

        cart.addItem(item);
        response.sendRedirect(response.encodeRedirectURL("DisplayShoppingCart.jsp"));
    }
}

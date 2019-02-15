package Controller;
import java.io.IOException;

import Model.ShoppingCart;
import Model.ShoppingCartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class represents the controller for customer change items order qantity process
 * It is derived from HttpServelet Class and  override doPost method
 */
public class ChangeOrderQuantityController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This methond is to get the parameters from order qantity change input, use the parameters
	 * to find the shoppingCartItem and then update the order quantity.
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
       
		// First get the shoppingItem values from the request.
		String pc =request.getParameter("productCode");
		int oq = Integer.parseInt(request.getParameter("orderQuantity"));
		
        HttpSession session = request.getSession();
        
        // Get the cart.
        ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
        
        // If there is no shopping cart, create one.
        if (cart == null)
        {
            cart = new ShoppingCart();
            session.setAttribute("ShoppingCart", cart);
        }
        
        for(ShoppingCartItem item: cart.getShoppingItems()) {
        	if(item.getProductCode().equals(pc)) {
        		 item.setOrderQuantity(oq);
        		 break;
        	}
        }
        response.sendRedirect(response.encodeRedirectURL("DisplayShoppingCart.jsp"));
    }
}

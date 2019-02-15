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
 * This class represents the controller for remove items from shopping cart process
 * It is derived from HttpServelet Class and  override doPost method
 */
public class RemoveItemController extends HttpServlet {

	private static final long serialVersionUID = 1L;
   
	/**
	 * This methond is to get the parameters from "remove" button in shopping cart page, use the parameters
	 * to find the shoppingCartItem object and then delete the object in shopping cart.
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
       
		// First get the shoppingItem values from the request.
		String pc =request.getParameter("productCode");
   
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
        		 cart.removeItem(item);
        		 break;
        	}
        }
        response.sendRedirect(response.encodeRedirectURL("DisplayShoppingCart.jsp"));
    }
}

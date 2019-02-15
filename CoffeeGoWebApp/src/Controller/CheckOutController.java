package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import Model.Shipping;
import Model.Billing;
import Model.ShoppingCartException;
import Model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * This class represents the controller for checkout process
 * It is derived from HttpServelet Class and  override doPost method
 */
public class CheckOutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This methond is to get the parameters from checkout billing and shipping form, use the parameters
	 * to form order confirmation to complete the order
	 * @param request: request from web server
	 * @param response: response from the corresponsing serbelet
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
       
		// First, get the billing values.
        Billing billing = new Billing();

        billing.setNameOnCard(request.getParameter("nameOnCard"));
        billing.setCreditCardNumber(request.getParameter("creditCardNumber"));
        billing.setCreditCardExpMonth(request.getParameter("creditCardExpMonth"));
        billing.setCreditCardExpYear(request.getParameter("CreditCardExpYear"));
        billing.setCreditCardNumber(request.getParameter("creditCardNumber"));
        billing.setCVV(request.getParameter("cvv"));
		
		
		// Next get the shipping values from the request.
        Shipping shipping = new Shipping();
        
        shipping.setFirstName(request.getParameter("firstName"));
        shipping.setLastName(request.getParameter("lastName"));
        shipping.setAddress(request.getParameter("address"));
        shipping.setCity(request.getParameter("city"));
        shipping.setState(request.getParameter("state"));
        shipping.setZipcode(request.getParameter("zipcode"));
        shipping.setCountry(request.getParameter("country"));
        shipping.setEmail(request.getParameter("email"));

        
        HttpSession session = request.getSession();

        // Get the cart.
        ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");

        // If there is no shopping cart, create one (this should really be an error).
        if (cart == null)
        {
            cart = new ShoppingCart();
            session.setAttribute("ShoppingCart", cart);
        }

        try
        {
            String confirmation = cart.completeOrder(shipping, billing);
            request.setAttribute("firstName",request.getParameter("firstName"));
            request.setAttribute("lastName",request.getParameter("lastName"));
            request.getRequestDispatcher(response.encodeRedirectURL("OrderConfirmation.jsp"+
                    "?confirmationNumber="+URLEncoder.encode(confirmation, "UTF-8"))).forward(request, response);
           
        }
        catch (ShoppingCartException exc)
        {
            PrintWriter out = response.getWriter();

            out.println("<html><body><h1>Error</h1>");
            out.println("The following error occurred while "+"processing your order:");
            out.println("<pre>");
            out.println(exc.getMessage());
            out.println("</pre>");
            out.println("</body></html>");
            return;
        }
    }
}

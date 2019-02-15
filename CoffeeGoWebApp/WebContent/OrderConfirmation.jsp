<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.text.NumberFormat"%>
<%@ page import="Model.ShoppingCart, Model.ShoppingCartItem, Dao.OrderHistoryDBAccess, Model.OrderRecord" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<style>
	table {
	    border-collapse: collapse;
	    width: 60%;
	}
	
	td, th {
	    border: 1px solid black;
	    text-align: left;
	    padding: 8px;
	}
	
	p {
		font-size: 20px;
	}
	</style>
	</head>
	<body>
		<h1>CoffeeGo Order Confirmation</h1>
		<p>
		Thank you for your order. Your order confirmation number is:
		<strong><%=request.getParameter("confirmationNumber")%></strong>
<%
		OrderRecord o = new OrderRecord();
		o.setFirstName(request.getParameter("firstName"));
		o.setLastName(request.getParameter("lastName"));
		o.setConfirmationID(request.getParameter("confirmationNumber"));

       
%>
		</p>

		<hr style="border:3px solid #f1f1f1">
		
		<table>
			  <tr>
			    <th>Product Code</th>
			    <th>Product</th>
			    <th>Price</th>
			    <th>Quantity</th>
			  </tr>
		
<%		
		//Get the cart.
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		//Get the items from the cart.
		ArrayList<ShoppingCartItem> items = new ArrayList<>();
		items = cart.getShoppingItems();
   		o.setItems(items);
		for (ShoppingCartItem s: items) {	
%>	      
			  <tr>
			    <th><%=s.getProductCode()%></th>
			    <th><%=s.getProductName()%></th>
			    <th><%=s.getPrice()%></th>
			    <th><%=s.getOrderQuantity()%></th>
			  </tr>	
<%
		}
%>		

		</table>
		<div>
		    <p>Shipping fee: $5.99</p>
		    <p>Tax: <%=cart.getTax()%></p>
		    <p>Grand Total: <%=cart.getGrandTotal()%></p>
<%
		o.setGrandPrice(cart.getGrandTotal());
		Date date = new Date();
        o.setDate(date);
		OrderHistoryDBAccess dao= new OrderHistoryDBAccess();
		dao.addOrder(o);
		cart.clearShoppingCart();
%>
		 </div>
		<p> Please use this number when calling/email to check on your order.</p>
		
		<button onclick="myFunction()">Print order confirmation</button>
		
		<script>
		function myFunction() {
		    window.print();
		}
		</script>
		<a href= "home.html"><input type="submit" value="HOME"></a>
		
	</body>
	
		
</html>
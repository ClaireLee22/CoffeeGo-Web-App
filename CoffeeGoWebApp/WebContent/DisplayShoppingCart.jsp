<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.Locale"%>
<%@ page import ="java.text.NumberFormat"%>

<%@ page import="Model.ShoppingCart, Model.ShoppingCartItem" %>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CoffeeGO Online Store</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
  </head>


  <body>
    <!-- navbar-->
    <nav class="navbar navbar-inverse navbar-light navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="home.html">CoffeeGo Web Store</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="home.html">Home</a></li>
            <li><a href="shop_catalog.html">Shop</a></li>
            <li><a href="Contact_page.html">Contact</a></li>
            <li><a href="LogInMode.html">LogIn</a></li>
            <li><a href="SignUp.html">SignUp</a></li>
            <li id="cart"><a href="DisplayShoppingCart.jsp">Shopping Cart</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- End of navbar-->

    <!-- Main content of the shoppingCart page-->
    <div class="shppingCart">
        <h2>Shopping Cart</h2>
 <%
    // Get the current shopping cart from the user's session.
    ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");

    // If the user doesn't have a shopping cart yet, create one.
    if (cart == null)
    {
        cart = new ShoppingCart();
        session.setAttribute("ShoppingCart", cart);
    }
    // Get the items from the cart.
    ArrayList<ShoppingCartItem> items = new ArrayList<>();
    items = cart.getShoppingItems();
    

    // If there are no items, tell the user that the cart is empty.
    if (items.size() == 0)
    {
        out.println("<h3>Your shopping cart is empty.</h3>");
    }
    else
    { 
%>
 <%-- Display the header for the shopping cart table --%>
	        <hr style="border:3px solid #f1f1f1">
	    	<div class="row">
	    		<div class="col-md-2">
	    			<p class="colname">Product Image</p>
	    		</div>
	    		<div class="col-md-2">
	    			<p class="colname">Product Code</p>
	    		</div>
	            <div class="col-md-2">
	    			<p class="colname">Product</p>
	    		</div>
	    		<div class="col-md-2">
	    			<p class="colname">Price</p>
	    		</div>
	    		<div class="col-md-2">
	    			<p class="colname">Qantity</p>
	    		</div>
	    		<div class="col-md-2">
	    		</div>
	    	</div>
    	
    	
<%
        for (ShoppingCartItem s: items)
        {
%>  
			<div class="row">
	    		<div class="col-md-2">
	    			<img class="icon_image" src="Image/<%=s.getImage()%>" alt="product image">
	    		</div>
	    		<div class="col-md-2">
	               <span style="color:black"><%=s.getProductCode()%></span>
	    		</div>
	            <div class="col-md-2">
	    			<span style="color:black"><%=s.getProductName()%></span>
	    		</div>
	    		<div class="col-md-2">
	    			<span>$<%=s.getPrice()%></span>
	    		</div>
	    		<div class="col-md-2">
	    			<form action= "ChangeOrderQuantityController" method="post">
		    			<input type="number" name="orderQuantity" value ="<%=s.getOrderQuantity()%>" min="1" style="width:50px">
		    			<input type="hidden" name="productCode" value="<%=s.getProductCode()%>">
		    			<input type="submit" value="submit" style="background-color:#27A967">
	    			</form>	
	    		</div>
	    		<div class="col-md-2">
	    			<form action="RemoveItemController" method="post">
		    			<input type="hidden" name="productCode" value="<%=s.getProductCode()%>">
						<input type="submit" class="btn" value="Remove" style="background-color:red">	
					</form>
	    		</div>
	    	</div>
    		<hr style="border:3px solid #f1f1f1">
<%
       }
    }
%>
	
		 <div>
	    	<div class="row">
	    		<div class="col-md-6">
	    		</div>
	    		<div class="col-md-2">
	               <p class="colname">Subtotal</p>
	    		</div>
	            <div class="col-md-2">

<%            
        // Get a currency formatter for showing the price.
        Locale locale = new Locale("en", "US"); 
		NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
	             
		double subtotal = 0;
		for (ShoppingCartItem s: items) {
			subtotal += s.getPrice()* s.getOrderQuantity();
		}
		           
        String stringSubtotal = currency.format(subtotal);
	            
%>	    

	    			<span style="color:black"><%=stringSubtotal%></span>
	    		</div>
	    		<div class="col-md-2">
	    			<span style="color:black"></span>
	    		</div>
	    	</div>
	    	
	    	<div class="row">
	    		<div class="col-md-6">
	    		</div>
	    		<div class="col-md-2">
	                <p class="colname">Tax(7.5%)</p>
	    		</div>
	            <div class="col-md-2">
	            	<span style="color:black"><%=cart.getTax()%></span>
	    		</div>
	    		<div class="col-md-2">
	    			<span style="color:black"></span>
	    		</div>
	    	</div>
	    	
	    	<div class="row">
	    		<div class="col-md-6">
	    		</div>
	    		<div class="col-md-2">	
	    		   <p class="colname">Shipping</p>
	    		</div>
	            <div class="col-md-2">
	    			<span style="color:black">$5.99</span>
	    		</div>
	    		<div class="col-md-2">
	    			<span style="color:black"></span>
	    		</div>
	    	</div>
	    	<hr style="border:3px solid #f1f1f1">
	    	
	    	<div class="row">
	    		<div class="col-md-6">
	    		</div>
	    		<div class="col-md-2">
	    		   <p class="colname">Ground Total</p>
	    		</div>
	            <div class="col-md-2">            	            
					<span style="color:black"><%=cart.getGrandTotal()%></span>
	    		</div>
	    		<div class="col-md-2">
	    			<span style="color:black"></span>
	    		</div>
	    	</div>
	    	<hr style="border:3px solid #f1f1f1">
	    	<div class="row">
	    		<div class="col-md-8">
	    		</div>
	    		<div class="col-md-2">	
	    		  <a href="CheckOut.html"><button class="btn">Checkout</button></a>
	    		</div>
	            <div class="col-md-2">
   			    </div>
   			</div>
   		</div>
    </div>
    <!--End of Main content of the main content-->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Copyright information -->
    <footer>​© 2018 by CoffeeGo</footer>
  </body>
</html>
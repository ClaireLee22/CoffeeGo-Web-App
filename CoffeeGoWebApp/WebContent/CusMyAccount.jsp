<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import="Model.Customer, Dao.CustomerDBAccess"%>


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
    
    <style>
	table {
	    border-collapse: collapse;
	    width: 95%;
	    color: black;
	    font-size: 80%;
	}
	
	td, th {
	    border: 1px solid black;
	    text-align: left;
	    padding: 8px;
	}
	
	h2 {
		font-size: 20px;
		color:black;
	}
	
	input[type=text] {
	    padding: 10px 0;
	    box-sizing: border-box;
	    color: gray;
	}
	</style>
    
    
    
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
            <li id="CusAccount"><a href="CusMyAccount.jsp">My Account</a></li>
            <li><a href="DisplayShoppingCart.jsp">Shopping Cart</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- End of navbar-->
    
	<body>
		 <!-- Main content -->
		 <div>
		  <h2>Username: <%= request.getParameter("username") %></h2>
	      <h2>Welcome Back!</h2>
<%		        			
				CustomerDBAccess dao = new CustomerDBAccess();
				String un = request.getParameter("username");
				String pw = request.getParameter("password");
				Customer c = dao.getCustomer(un, pw);				
%>		     	
				<form action="EditMyAccountController" method="post">
					<table>
					  <tr>
					    <th>First Name</th>
					    <th>Last Name</th>
					    <th>Address</th>
					    <th>City</th>
					    <th>State</th>
					    <th>Zipcode</th>
					    <th>Country</th>
					  </tr>
						
					  <tr>
					    <th><%=c.getFirstName()%>
						 	<input type="text" value="<%=c.getFirstName()%>" name="firstName">
						</th>
					    <th><%=c.getLastName()%>
					    	<input type="text" value="<%=c.getLastName()%>" name="lastName">
						</th>
						<th><%=c.getAddress()%>
							<input type="text" value="<%=c.getAddress()%>" name="address">
						</th>
						<th><%=c.getCity()%>
							<input type="text" value="<%=c.getCity()%>" name="city">
						</th>
						<th><%=c.getState()%>
							<input type="text" value="<%=c.getState()%>" name="state">
						</th>
						<th><%=c.getZipcode()%>
							<input type="text" value="<%=c.getZipcode()%>" name="zipcode">
						<th><%=c.getCountry()%>
					    	<input type="text" value="<%=c.getCountry()%>" name="country">
						</th>
					 </tr>	
				   </table>
				    <input type="hidden" name="username" value="<%=c.getUserName()%>">
				    <input type="hidden" name="password" value="<%=c.getPassword()%>">
					<input type="submit" class="btn" value="Save change" style="background-color:green">
				</form>
				<div>
					<a href="home.html"><button type="submit" class="btn btn-default">Home</button></a>
				</div>

	   </div>
	  
    <!--End of Main content -->
	</body>
	
		
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import="Model.Product, Dao.ProductDBAccess"%>


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
	    color:black;
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
          <a class="navbar-brand" href="AdminModeHome.html">CoffeeGo Web Store</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="AdminModeHome.html">Home(Admin Mode)</a></li>
            <li id="EditProduct"><a href="AdminEditProduct.jsp">Edit Product</a></li>
            <li><a href="AdminAddProduct.html">Add Product</a></li>
            <li><a href="AdminDeleteProduct.jsp">Delete Product</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- End of navbar-->

	
	<!-- Main content -->
	<div>
	    <h2>Edit Product Database</h2>
<%	
		ArrayList<Product> products = new ArrayList<>();
		ProductDBAccess dao = new ProductDBAccess();
		products = dao.getProductList();
		for (Product p: products) 
		{	
%>			  	
		<form action="AdminEditProductController" method="post">
			<table>
			  <tr>
			    <th>Product Code</th>
			    <th>Product Catalog</th>
			    <th>Name</th>
			    <th>Description</th>
			    <th>Price</th>
			    <th>Inventory</th>
			    <th>Imgae Src</th>
			    <th></th>
			  </tr>
					
			  <tr>
			    <th><%=p.getProductCode()%></th>
			    <th><%=p.getProductCatalog()%>
				 	<input type="text" value="<%=p.getProductCatalog()%>" name="productCatalog">
				</th>
			    <th><%=p.getName()%>
			    	<input type="text" value="<%=p.getName()%>" name="name" size="30">
				</th>
			    <th><%=p.getDescription()%>
			    	<input type="text" value="<%=p.getDescription()%>" name="description" size="60">
			    </th>
			    <th>$<%=p.getPrice()%>
			    	<input type="text" value="<%=p.getPrice()%>" name="price" size="10">
			    </th>
			    <th><%=p.getInventory()%>
			    	<input type="text" value="<%=p.getInventory()%>" name="inventory" size="10">
			    </th>
			    <th><%=p.getImagesrc()%>
			    	<input type="text" value="<%=p.getImagesrc()%>" name="image">
			    </th>
			    <th>
				    <input type="hidden" name="productCode" value="<%=p.getProductCode()%>">
					<input type="submit" class="btn" value="Save Change" style="background-color:green">
			    </th>
			  </tr>	
			</table>
		</form>
<% 
	
		}
		
%>		
				
	   </div>
    <!--End of Main content -->
	</body>
	
		
</html>
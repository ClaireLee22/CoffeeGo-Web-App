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
	    width: 90%;
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
            <li><a href="AdminEditProduct.jsp">Edit Product</a></li>
            <li><a href="AdminAddProduct.html">Add Product</a></li>
            <li id="DeleteProduct"><a href="AdminDeleteProduct.jsp">Delete Product</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- End of navbar-->
    
  
	<body>
		 <!-- Main content -->
		 <div>
	      <h2>Product List</h2>
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
			
<%		
			ArrayList<Product> products = new ArrayList<>();
			ProductDBAccess dao = new ProductDBAccess();
			products = dao.getProductList();
	
			for (Product p: products) {			
%>		     
			
			  <tr>
			    <th><%=p.getProductCode()%></th>
			    <th><%=p.getProductCatalog()%></th>
			    <th><%=p.getName()%></th>
			    <th><%=p.getDescription()%></th>
			    <th>$<%=p.getPrice()%></th>
			    <th><%=p.getInventory()%></th>
			    <th><%=p.getImagesrc()%></th>
			    <th>
			    <form action="AdminDeleteProductController" method="post">
				    <input type="hidden" name="productCode" value="<%=p.getProductCode()%>">
					<input type="submit" class="btn" value="Delete" style="background-color:red">
				</form>
			    </th>
			  </tr>	
			 
<%
			}
%>		
		
			</table>	
	   </div>
    <!--End of Main content -->
	</body>
	
		
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>


	<%-- <h1>Product Form</h1>
	<form:form action="saveProduct" modelAttribute="product"
		enctype="multipart/form-data">

		<table>
			<tr>
				<td><form:hidden path="pid" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="pname" /></td>
				<td><form:errors path="pname" /></td>
			</tr>

			<tr>
				<td>Category :</td>
				<td><form:input path="catid" /></td> 
				<td><form:select path="category.cname" items="${categorylist }"></form:select></td>
				
			</tr>
			<tr>
				<td>Supplier</td>
				<td><form:input path="suppid" /></td>
				<td><form:select path="supplier.sname" items="${supplierlist }"></form:select></td>
				
			</tr>

			<tr>
				<td>price</td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" /></td>
			</tr>

			<tr>
				<td>stock</td>
				<td><form:input path="stock" /></td>
				<td><form:errors path="stock" /></td>
			</tr>

			<tr>
				<td>desc</td>
				<td><form:textarea path="description" /></td>
				<td><form:errors path="description" /></td>
			</tr>
			<tr>
				<td>Product Image</td>
				<td><form:input type="file" path="pimage" /></td>
			</tr>

			

			<tr>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
 --%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <div class="container">
  <h2>Product Form</h2>
  <form:form action="saveProduct" modelAttribute="product" enctype="multipart/form-data">
    <div class="form-group">
      <label for="email">Product Name:</label>
      <form:input path="pname" class="form-control" id="email" placeholder="Enter Name" />
    </div>
    
    <div class="form-group">
      <label for="pwd">Price:</label>
      <form:input path="price" class="form-control" id="pwd" placeholder="Enter Price" />
    </div>
    
    <div class="form-group">
      <label for="pwd">Stock:</label>
      <form:input path="stock" class="form-control" id="pwd" placeholder="Enter Stock" />
    </div>
    
    <div class="form-group">
      <label for="pwd">Category:</label>
      <div class="select-style">
      	<form:select path="category.cname" class="form-control" id="pwd" items="${categorylist }" />
      </div>
    </div>
    
    <div class="form-group">
      <label for="pwd">Supplier:</label>
      <form:select path="supplier.sname" class="form-control" id="pwd" items="${supplierlist }" />
    </div>
    
    
     <div class="form-group">
      <label for="pwd">Description:</label>
      <form:input path="description" class="form-control" id="pwd" placeholder="Enter Description" />
    </div>
    
    
    
    <div class="form-group">
      <label for="image">Price:</label>
      
      	<form:input type="file" path="pimage" class="form-control" id="image"  />
      
    </div>
     
    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>
<table align="center">
		<tr bgcolor="pink">
			<td>Product ID</td>
			<td>Product Name</td>
			<td>Category ID</td>
			<td>Supplier ID</td>
			<td>Price</td>
			<td>Stock</td>
			<td>Operation</td>
		</tr>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<c:forEach items="${products}" var="prod">
			<tr bgcolor="cyan">
				<td>${prod.pid}</td>
				<td>${prod.pname}</td>
				<td>${prod.catid}</td>
				<td>${prod.suppid}</td>
				<td>${prod.price}</td>
				<td>${prod.stock}</td>
				<td><a href="<c:url value="deleteProduct/${prod.pid}"/>">Delete</a>
					<a href="<c:url value="updateProduct/${prod.pid}"/>">Update</a>
				</td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>
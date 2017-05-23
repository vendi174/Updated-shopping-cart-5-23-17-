<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<url:url value="all/register" var="url"></url:url>
<form:form action="all/register" modelAttribute="customer" method="post" >
	<div class="form-group">
		<label for="">Enter Username</label>
		<form:input path="users.username"></form:input>
		<form:errors path="users.username"></form:errors>
	</div>
	
	<div class="form-group">
		<label for="">Enter Password</label>
		<form:input path="users.password"></form:input>
		<form:errors path="users.password" cssStyle:"color=red"></form:errors>
	</div>
	
	<div class="form-group">
		<label for="">Enter Streetname </label>
		<form:input path="billingAddress.streetname"></form:input>
		<form:errors path="billingAddress.streetname"></form:errors>     <!-- name should object not class -->
	</div>
	
	<div class="form-group">
		<label for="">Enter Apartmentn number</label>
		<form:input path="billingAddress.apartmentnumber"></form:input>
		<form:errors path="billingAddress.apartmentnumber"></form:errors>
	</div>
	
	<div class="form-group">
		<label for="">Enter city</label>
		<form:input path="billingAddress.city"></form:input>
		<form:errors path="billingAddress.city"></form:errors>
	</div>
	
	
	<div class="form-group">
		<label for="">Enter city</label>
		<form:input path="billingAddress.state"></form:input>
		<form:errors path="billingAddress.state"></form:errors>
	</div>
	
	<div class="form-group">
		<label for="">Enter zipcode</label>
		<form:input path="billingAddress.zipcode"></form:input>
		<form:errors path="billingAddress.zipcode"></form:errors>
	</div>
	
	<div class="form-group">
		<label for="">Enter city</label>
		<form:input path="billingAddress.city"></form:input>
		<form:errors path="billingAddress.city"></form:errors>
	</div>
	
	<div class="form-group">
		<label for="">Enter city</label>
		<form:input path="billingAddress.city"></form:input>
		<form:errors path="billingAddress.city"></form:errors>
	</div>
	
	<div class="form-group">
		<label for="">Enter city</label>
		<form:input path="billingAddress.city"></form:input>
		<form:errors path="billingAddress.city"></form:errors>
	</div>
	
	<input type="submit" value="Register">
	
</form:form>
</body>
</html>
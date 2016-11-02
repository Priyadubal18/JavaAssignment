<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<h1> New Product Data </h1>
<form:form method="post" action ="/MVCWeb2/addproduct">
<form:label path="productid">Product Id</form:label> <form:input path="productid"/>
<form:label path="pname">Product Name</form:label> <form:input path="pname"/>
<form:label path="price">Product Price</form:label> <form:input path="price"/>
<input type="submit" value="Submit!!">
</form:form>
</body>
</html>
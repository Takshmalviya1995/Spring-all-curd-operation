<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update Product</h2>
<form:form action="editprod" method="post" modelAttribute="product">
		
		<form:input type="hidden" path="prodid" id="prodid"/>
		<pre>
				
 				<form:errors path="prodname" class="error"/>
				Product name      : <form:input path="prodname"/>
 				<form:errors path="proddesc" class="error"/>
				Product Desc      : <form:input path="proddesc"/>
 				<form:errors path="prodprice" class="error"/>
				Product Price     : <form:input path="prodprice"/>
				<form:errors path="prodqty" class="error"/>
				Product Quantity  : <form:input path="prodqty"/>
				
				<%-- <form:input path="ProdImage" id="ProdImage" type="file" /> --%>
							 <input type="submit" value="update"/>
							 
							 <a href="product">click here Product List</a>
							 
							 
		</pre>
</form:form>
		    
		    
</body>
</html>
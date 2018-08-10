<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">			
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script> 
	$(document).ready(function() {
    $('#example').DataTable( {
        "pagingType": "full_numbers"
    } );
} );
</script>
</head>
<body>

<form:form action="product.do" method="post" modelAttribute="prodMap">
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
							 <input type="submit" value="Submit"/>
							 <br>
							 <a href="logout.do">Logout</a>
							 
							 
		</pre>
</form:form>
<hr>
<table id="example" border="1" align="centre">
	<thead>
	<tr>
		<td><B>Product Id</td>
		<td><B>Product Name</td>
		<td><B>Product Description</td>
		<td><B>Product Price</td>
		<td><B>Product Quantity</td>
	</tr>
	</thead>
	<tbody>
	<c:choose>
	<c:when test="${empty prodList}">
		No. Such Record Found..!!
	</c:when>
	<c:otherwise>
	<c:forEach items="${prodList}" var="prod">
		<tr>
			<td><c:out value="${prod.prodid}"/></td>
			<td><c:out value="${prod.prodname}"/></td>
			<td><c:out value="${prod.proddesc}"/></td>
			<td><c:out value="${prod.prodprice}"/></td>
			<td><c:out value="${prod.prodqty}"/></td>
		</tr>
	</c:forEach>
	</c:otherwise>
	</c:choose>
	</tbody>
		<tfoot>
			<tr>
		<td><B>Product Id</td>
		<td><B>Product Name</td>
		<td><B>Product Description</td>
		<td><B>Product Price</td>
		<td><B>Product Quantity</td>
			</tr>
	</tfoot>
</table>
</body>
</html>
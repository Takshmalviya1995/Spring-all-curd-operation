<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
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

<hr>
<table id="example" border="1" align="centre">
	<thead>
	<tr>
		<td><B>Employee Id</td>
		<td><B>Employee First Name</td>
		<td><B>Employee Last Name</td>
		<td><B>Employee Dept</td>
		<td><B>Employee Email</td>
		<td><B>Employee Address</td>
		<td><B>Employee Mobile</td>
		<td><B>Edit</td>
		<td><B>Delete</td>
	</tr>
	</thead>
	<tbody>
	<c:choose>
	<c:when test="${empty empList}">
		No. Such Record Found..!!
	</c:when>
	<c:otherwise>
	<c:forEach items="${empList}" var="emp">
		<tr>
			<td><c:out value="${emp.id}"/></td>
			<td><c:out value="${emp.firstName}"/></td>
			<td><c:out value="${emp.lastName}"/></td>
			<td><c:out value="${emp.dept}"/></td>
			<td><c:out value="${emp.email}"/></td>
			<td><c:out value="${emp.address}"/></td>
			<td><c:out value="${emp.mobile}"/></td>
			<td><a href="<c:url value='/edit-${emp.id}'/>">edit</a></</td>
			<td><a href="<c:url value='/delete-${emp.id}'/>">delete</a></</td>
		</tr>
	</c:forEach>
	</c:otherwise>
	</c:choose>
	</tbody>
		<tfoot>
			<tr>
		<td><B>Employee Id</td>
		<td><B>Employee First Name</td>
		<td><B>Employee Last Name</td>
		<td><B>Employee Dept</td>
		<td><B>Employee Email</td>
		<td><B>Employee Address</td>
		<td><B>Employee Mobile</td>
		<td><B>Edit</td>
		<td><B>Delete</td>
			</tr>
	</tfoot>
	
</table>
<a href="registration">Add Employee</a>
</body>
</html>
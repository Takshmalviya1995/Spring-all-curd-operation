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

	<h2>Registration Form</h2>
 
	<form:form modelAttribute="employee" action="registration1" method="post">
		<%-- <form:input type="hidden" path="id" id="id"/> --%>
		<table>
			<tr>
				<td><label for="firstName">FirstName: </label> </td>
				<td><form:input path="firstName" id="firstName"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		    <tr>
				<td><label for="lastName">LastName: </label> </td>
				<td><form:input path="lastName" id="lastName"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		     <tr>
				<td><label for="dept">Department: </label> </td>
				<td><form:input path="dept" id="dept"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		    <tr>
				<td><label for="email">Email: </label> </td>
				<td><form:input path="email" id="email"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		     <tr>
				<td><label for="mobile">Mobile No: </label> </td>
				<td><form:input path="mobile" id="mobile"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		    <tr>
				<td><label for="address">Address: </label> </td>
				<td><form:input path="address" id="address"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
	    
			
		    </table>
		    	<input type="submit" value="Register"/>
		    	<a href="list">click here for List</a>
		    </form:form>
		    
		    
</body>
</html>
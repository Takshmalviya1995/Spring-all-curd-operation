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

	<h2>Update Form</h2>
  
	<form:form modelAttribute="user" action="editsave" method="post"> 
		<form:input type="hidden" path="id" id="id"/> 
		<table>
			<tr>
				<td><label for="firstname">FirstName: </label> </td>
				<td><form:input path="firstname" id="firstname"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		    <tr>
				<td><label for="lastname">LastName: </label> </td>
				<td><form:input path="lastname" id="lastname"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		    <tr>
				<td><label for="email">Email: </label> </td>
				<td><form:input path="email" id="email"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		    <tr>
				<td><label for="password">Password: </label> </td>
				<td><form:input path="password" id="password"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		     <tr>
				<td><label for="mobileno">Mobile No: </label> </td>
				<td><form:input path="mobileno" id="mobileno"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		    </table>
		    	<input type="submit" value="Register"/>
		    	<a href="list">click here for List</a>
		    </form:form>
		    
		    
</body>
</html>
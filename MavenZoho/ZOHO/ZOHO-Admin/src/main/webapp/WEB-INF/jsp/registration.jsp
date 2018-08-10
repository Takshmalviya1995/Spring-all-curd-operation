<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Welcome ! Taksh</h1>
  <form:form method="post" action="userRegistration.do" modelAttribute="userreg">
  <pre><%-- 
  					  <form:errors path="firstname"/>
  First Name		: <form:input path="firstname"/>
  					  <form:errors path="lastname"/>
  Last Name			: <form:input path="lastname"/>
  					  <form:errors path="email"/>
  Enter Email		: <form:input path="email"/>
  					  <form:errors path="password"/>
  Enter Password	: <form:password path="password"/>
  					  <form:errors path="mobileno"/>
  Enter Mobile no	: <form:input path="mobileno"/>
  					  <input type="submit" value="Submit"/> --%>
  					  
   						
Language : <a href="?language=en">English</a>|<a href="?language=hi">Hindi</a>|<a href="?language=ch">Chinese</a>  
  						
   						<form:errors path="firstname"/>
  <spring:message code="label.firstname"/>		: <form:input path="firstname"/>
  
  					  <form:errors path="lastname"/>
  <spring:message code="label.lastname"/>		: <form:input path="lastname"/>
   
  					  <form:errors path="email"/>
  <spring:message code="label.emailid"/>		: <form:input path="email"/>
   
  					  <form:errors path="password"/>
  <spring:message code="label.password"/>		: <form:password path="password"/>
   
  					  <form:errors path="mobileno"/>
  <spring:message code="label.mobile"/>		: <form:input path="mobileno"/>
  					  <input type="submit" value="Submit"/>
  </pre>
  </form:form>
</body>
</html>
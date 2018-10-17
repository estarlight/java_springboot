<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>

	<style>
	body {
		margin: auto;
		text-align: center;
	}
	</style>
	
</head>
<body>

	<h1>New License</h1>


	<form:form action="/licenses/new" method="post" modelAttribute="license">
	
	<p>
	<form:label path="person">Person:</form:label>
	<form:select path="person">
	<c:forEach items="${personList}" var="p">
    	<option value="${p.id }">${p.firstName } ${p.lastName } </option>
    </c:forEach>
	</form:select>
	</p>
	
	<p>
        <form:label path="state">State:</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    
    	<p>
        <form:label path="expiration_date">Expiration Date:</form:label>
        <form:errors path="expiration_date"/>
        <form:input type="date" path="expiration_date"/>
    </p>
    
     <input type="submit" value="Create"/>
	
	
	</form:form>

</body>
</html>
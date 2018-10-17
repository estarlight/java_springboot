<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
</head>
<body>

		<h1><c:out value="${category.name }" /></h1>
	
	<h3>Categories:</h3>
	<ul>
	 <c:forEach items="${products}" var="p">
	 	<li><c:out value="${p.name }" /></li>
    </c:forEach>
    </ul>
    
    <form:form action="/categories/${category.id }" method="post" modelAttribute="category">
	
		<p>
		<form:label path="products">Add Category:</form:label>
		<form:select path="products">
		<c:forEach items="${nonproducts}" var="non">
	    	<option value="${non.id }">${non.name } </option>
	    </c:forEach>
		</form:select>
		</p>
		
		<input type="submit" value="Add">
		
	</form:form>

</body>
</html>
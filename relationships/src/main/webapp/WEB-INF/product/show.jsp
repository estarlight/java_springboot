<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
</head>
<body>

	<h1><c:out value="${product.name }" /></h1>
	
	<h3>Categories:</h3>
	<ul>
	 <c:forEach items="${categories}" var="cat">
	 	<li><c:out value="${cat.name }" /></li>
    </c:forEach>
    </ul>
    
    <form:form action="/products/${product.id }" method="post" modelAttribute="product">
	
		<p>
		<form:label path="categories">Add Category:</form:label>
		<form:select path="categories">
		<c:forEach items="${noncategories}" var="non">
	    	<option value="${non.id }">${non.name } </option>
	    </c:forEach>
		</form:select>
		</p>
		
		<input type="submit" value="Add">
		
	</form:form>
	

</body>
</html>
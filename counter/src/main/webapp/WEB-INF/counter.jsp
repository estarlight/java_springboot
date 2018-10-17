<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter Page</title>
</head>
<body>

	<h3>You have visited http://localhost/8080 <c:out value="${ count }"/> times.</h3>
	
	
	<h3><a href="/">Test another visit?</a></h3>
	
	<div>
	<form action="/clear" method="post">
	<input type="submit" value="Clear Count">
	</form>
	</div>

</body>
</html>
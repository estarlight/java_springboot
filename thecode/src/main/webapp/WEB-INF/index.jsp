<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>The Code</title>
</head>
<body>
	<div id="container">
	
	<p class="error"><c:out value="${ error }" /></p>
	<h1>What is the code?</h1>
	<form action="/codetest" method="post">
		<div><input type="text" name="code"></div>
		<div><input type="submit" value="Try Code"></div>
	</form>
	
	</div>

</body>
</html>
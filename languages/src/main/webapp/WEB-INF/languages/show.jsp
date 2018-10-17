<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${language.name }"/></title>
</head>
<body>
	<div>
	<p><a href="/languages">Dashboard</a></p>
	</div>

	<div>
	<p><c:out value="${language.name }"/></p>
	<p><c:out value="${language.creator }"/></p>
	<p><c:out value="${language.currentVersion }"/></p>
	
	
	</div>
	
	<div>
		<p><a href="/languages/<c:out value="${language.id }"/>/edit">Edit</a></p>
		<p><a href="/languages/<c:out value="${language.id }"/>/delete">Delete</a></p>
	
	</div>

</body>
</html>
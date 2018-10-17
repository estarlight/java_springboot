<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>

<p>Your Name: <c:out value="${ name }" /> </p>
<p>Dojo Location: <c:out value="${ location }" /> </p>
<p>Favorite Language: <c:out value="${ language }" /> </p>
<p>Comment: <c:out value="${ comment }" /> </p>

</body>
</html>
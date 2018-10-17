<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date Page</title>


<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/app.js"></script>

</head>
<body>

<div class="blue">
<h1><c:out value="${ day }" />, the <c:out value="${ date }" /> of <c:out value="${ month }" />, <c:out value="${ year }" />  </h1>
</div>


 <script>datePage();</script>

</body>
</html>
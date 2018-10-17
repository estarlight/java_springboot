<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Page</title>
</head>
<body>

	<h1><c:out value="${ dojo.name }" /> Location Ninjas</h1>
	
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${ninjas }" var="n">
				<tr>
					<td>${n.firstName }</td>
					<td>${n.lastName }</td>
					<td>${n.age }</td>	
				</tr>
			</c:forEach>
		</tbody>
	
	</table>

</body>
</html>
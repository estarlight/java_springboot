<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions Dashboard</title>
</head>

<body>

	<h1>Questions Dashboard</h1>
	
	<table>
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${ questions }" var="q">
			
			<tr>
				<td><a href="/questions/${q.id }">${q.question }</a></td>
				<c:forEach items="${ q.tags }" var="t">
					<td>
					${t.subject}
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
		</tbody>
	
	</table>
	
	<h4><a href="/questions/new"><New Question/a></h4>

</body>
</html>
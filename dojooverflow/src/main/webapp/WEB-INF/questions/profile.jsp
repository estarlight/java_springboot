<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Profile</title>
	<style>
		
		.inline {
		display:inline-block;
		margin: 30px;
		padding: 10px;
		vertical-align: middle;
		}
		
		.box {
			border: 1px black solid;
			display: inline-block;
			padding: 3px;
		}
	</style>
</head>

<body>
	<h1><c:out value="${question.question }" /></h1>
	
	<h3 class="inline">Tags:</h3>
	<c:forEach items="${question.tags }" var="tag">
		<h3 class="box"><c:out value="${tag.subject }" /></h3>
	</c:forEach>
	
	
	<div>
	<table class = "inline">
		<thead>
			<tr>
				<th>Answers</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${question.answers}" var="a">
				<tr>
					<td>"${a.answer }"</td>
				</tr>
			
			</c:forEach>
		</tbody>
	
	</table>
	
	
	<div class="inline">
		<h3>Add your answer:</h3>
		
		<form:form action="/questions/${question.id}" method="post" modelAttribute="answers">
			<p>
		        <form:label path="answer">Answer:</form:label>
		        <form:errors path="answer"/>
		        <form:textarea path="answer"/>
	    	</p>
	    	
	    	<input type="submit" value="Answer it!">
		
		</form:form>
	
	</div>
	</div>

</body>
</html>
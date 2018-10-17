<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify! Dashboard</title>

	<style>
		#container {
			margin: auto;
			text-align: center;
		}
		
		table {
			margin: auto;
			text-align: center;
		}
		
		.header p, .header a {
			display: inline-block;
			margin: 10px;
		}
		
		form {
		display: inline-block;
		}
	
	</style>
</head>
<body>
<div id="container">

	<div class="header">
		<p><a href="/songs/new">Add New</a></p>
		<p><a href="/search/topTen">Top Songs</a></p>
		<p>
			<form action="/search" method="post">
			<input type="text" placeholder="Search..">
			<input type="submit" value="Search">
			</form>
		</p>
	
	</div>
	
	
	<div>
	
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Artist</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			
			</thead>
		
			<tbody>
				<c:forEach items="${songs}" var="song">
				<tr>
					<td><a href="/songs/${song.id }"><c:out value="${song.name }" /></a></td>
					<td><c:out value="${song.artist }" /></td>
					<td><c:out value="${song.rating }" /></td>
					<td>
					<form:form action="delete/${song.id }" method="post">
					<input type="hidden" name="_method" value="delete">
					<button>Delete</button>
					</form:form>
					</td>
				</tr>
				</c:forEach>
			
			</tbody>
		
		
		</table>
	
	
	
	
	</div>












</div>

</body>
</html>
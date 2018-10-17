<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Song</title>
</head>
<body>

	<form:form action="/songs/new" method="post" modelAttribute="song">
	    <p>
	        <form:label path="title">Title</form:label>
	        <form:errors path="title"/>
	        <form:input path="title"/>
	    </p>
	    <p>
	        <form:label path="artist">Artist</form:label>
	        <form:errors path="artist"/>     
	        <form:input path="artist"/>
	    </p> 
	    <p>
	        <form:label path="rating">Rating</form:label>
	        <form:errors path="rating"/>
	        <form:select path="rating">
			<form:option value="NONE" label="--- Select ---"/>
			<form:option value="1" label="1"/>
			<form:option value="2" label="2"/>
			<form:option value="3" label="3"/>
			<form:option value="4" label="4"/>
			<form:option value="5" label="5"/>
			<form:option value="6" label="6"/>
			<form:option value="7" label="7"/>
			<form:option value="8" label="8"/>
			<form:option value="9" label="9"/>
			<form:option value="10" label="10"/>
			</form:select>
	    </p>
	       
	    <input type="submit" value="Add Song"/>
	</form:form>

</body>
</html>
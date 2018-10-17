<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <h1>Number 1</h1>

<table class="table">
    <thead>
        <th>Country Name</th>
        <th>Language</th>
        <th>Percentage</th>
    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
        </tr>
        </c:forEach>
    </tbody>
</table> --%>

<!-- <h1>Number 2</h1> -->

<%-- <table class="table">
    <thead>
        <th>Country Name</th>
        <th>Number of Cities</th>

    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0]}</td>
  			<td>${row[1]}</td> 
        </tr>
        </c:forEach>
    </tbody>
</table> --%>

<%-- <h1>Number 3</h1>

<table class="table">
    <thead>
        <th>City Name</th>
        <th>Population</th>

    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0]}</td>
  			<td>${row[1]}</td> 
        </tr>
        </c:forEach>
    </tbody>
</table> --%>

<%-- <h1>Number 4</h1>

<table class="table">
    <thead>
        <th>Language</th>
        <th>Country</th>
        <th>Percentage</th>

    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0]}</td>
  			<td>${row[1]}</td> 
  			<td>${row[2]}</td>
        </tr>
        </c:forEach>
    </tbody>
</table> --%>

<h1>Number 5</h1>

<table class="table">
    <thead>
        <th>Region</th>
        <th>Number of Countries</th>
  

    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0]}</td>
  			<td>${row[1]}</td> 

        </tr>
        </c:forEach>
    </tbody>
</table>





</body>
</html>
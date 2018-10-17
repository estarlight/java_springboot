<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>


<body>
	<div class="container">

	<div>
    <button type="button" class="btn btn-primary block">
            Your Gold: <span class="badge badge-light"> <c:out value="${ gold }" /> </span>
            <span class="sr-only">gold</span>
            </button>
	</div>

    <div class = "box">
        <h1>Farm</h1>
        <p>Earns 10-20 golds</p>

        <form action="/process" method='post'>
            <input type = "hidden" name="building" value="farm">

            <input type="submit" class="btn btn-primary" value ="Find Gold!">
        </form>

    </div>
        
    <div class = "box">
        <h1>Cave</h1>
        <p>Earns 5-10 golds</p>

        <form action="/process" name="cave" method='post'>
            <input type = "hidden" name="building" value="cave">

            <input type="submit" class="btn btn-primary" value="Find Gold!">
        </form>
        
    </div>
        

    <div class = "box">
        <h1>House</h1>
        <p>Earns 2-5 golds</p>

        <form action="process" name="house" method='post'>
            <input type = "hidden" name="building" value="house">
        
            <input type="submit" class="btn btn-primary" value ="Find Gold!">
        </form>
    
    </div>

    <div class = "box">
        <h1>Casino</h1>
        <p>Earns/takes 0-50 golds</p>

        <form action="/process" name="casino" method='post'>
            <input type = "hidden" name="building" value="casino">

            <input type="submit" class="btn btn-primary" value ="Find Gold!">
    </form>
        
    </div>

    <div>
        <h1>Activities</h1>
    <div class="activity_box">
    <p><c:out value="${activities }" /></p>
      
   <%--  <c:forEach var="a" items="${activities}">
    	<p><c:out value="${a}"/></p>
	</c:forEach> --%>
      

    </div>

</div>

</body>
</html>
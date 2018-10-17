<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<meta charset="UTF-8">
	<title>Dojo Survey</title>
</head>

<body>
<div id="container">
	
	<form action ="/process" method="post">
		<p>Your Name: <input type="text" name="name"></p>
		<p>Dojo Location: <select name="location">
			  <option value="San Jose">San Jose</option>
			  <option value="Burbank">Burbank</option>
			  <option value="Chicago">Chicago</option>
			  <option value="Seattle">Seattle</option>
			</select></p>
			<p>Favorite Language: <select name="language">
			  <option value="Python">Python</option>
			  <option value="Java">Java</option>
			  <option value="Ruby">Ruby</option>
			  <option value="MEAN">MEAN</option>
			</select></p>
			<p>Comment (optional): <textarea name="comment"></textarea></p>
			<input type="submit" value="Submit">
	
	</form>

</div>
</body>
</html>
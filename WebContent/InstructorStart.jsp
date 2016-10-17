<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Semester Selection</title>
</head>
<body><center>
<br><br><br><br><br><br>
	<h4>Select a semester</h4>
	<form action="InstructorServlet" method="get">
		<label for="semester">Rating</label> <select name="id"
			id="id">
			<option selected="selected">Fall2016</option>
			<option>Spring2016</option>
		</select>
		<br>
		<button id="submit" type="submit" value="Submit">
			<font color="blue">Go</font>
		</button>
	</form>
	</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.Harrisonclass"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Instructor View</title>
</head>
<body>

	<form action="InstructorServlet?action=StudentRoster" method="post">
		<button id="submit" type="submit" value="Submit">
			<font color="blue">View Student Student Roster</font>
		</button>
	</form>
	

	<c:forEach var="lecture" items="${lectures}">
		<table class="table table-bordered table-striped table-hover"
			id="myTable">
			<thead>
				<tr>
					<b>
						<th>Class No.</th>
						<th>Classroom</th>
						<th>Semester</th>
						<th>Course Name</th>
						<th>Status</th>
					</b>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${lecture.classid}" /></td>
					<td><c:out value="${lecture.classroom}" /></td>
					<td><c:out value="${lecture.semester}" /></td>
					<td><c:out value="${lecture.harrisoncourse.coursename}" /></td>
					<td><c:out value="${lecture.harrisoncourse.status}" /></td>
				</tr>
			</tbody>
		</table>
	</c:forEach>
</body>
</html>
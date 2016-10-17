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
<jsp:include page="Header.jsp"></jsp:include>
<body>
<c:forEach var="lecture" items="${lectures}">
		<table class="table table-bordered table-striped table-hover"
			id="myTable">
			<thead>
				<tr>
					<b>
						<th> Class No. </th>
						<th> Classroom </th>
						<th>  Semester </th>
						<th> CourseName </th>
						<th> Status </th>
					</b>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${lecture.classid}" /></td>
					<td><c:out value="${lecture.classroom}" /></td>
					<td><c:out value="${lecture.semester}" /></td>
					<td><c:out value="${lecture.harrisoncourse.coursename}" /></td>
					<td><c:out value="${lecture.status}" /></td>
				</tr>
			</tbody>
		</table>
	</c:forEach>
	<form action="InstructorServlet?action=StudentRoster" method="post">
		<button id="submit" type="submit" value="Submit">
			<font color="blue">Student Roster</font>
		</button>
	</form>

	<form action="InstructorServlet?action=ViewCourses" method="post">
		<button id="submit" type="submit" value="Submit">
			<font color="blue">View Courses</font>
		</button>
	</form>
	<form action="InstructorServlet?action=ViewGrades" method="post">
		<button id="submit" type="submit" value="Submit">
			<font color="blue">Student Grades</font>
		</button>
	</form>
		<form action="InstructorServlet?action=Email" method="post">
		<button id="submit" type="submit" value="Submit">
			<font color="blue">Email My Courses</font>
		</button>
	</form>
	
</body>
</html>
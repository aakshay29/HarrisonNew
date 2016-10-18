<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.Harrisonstudent"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Roster</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

	<c:forEach var="studentenrollment" items="${studentenrollments}">
		<form action="InstructorServlet?action=AssignGrade" method="post">

			<table class="table table-bordered table-striped table-hover"
				id="myTable">
				<thead>
					<tr>
						<b>
							<th>Student Name</th>
							<th>Class</th>
							<th>Status</th>
							<th>Grade</th>
						</b>
					</tr>
				</thead>
				<tbody>
					<tr>

						<td><c:out
								value="${studentenrollment.harrisonstudent.harrisonuser.name}" /></td>
						<td><c:out value="${studentenrollment.harrisonclass.classid}" /></td>
						<td><c:out value="${studentenrollment.status}" /></td>
						<td><input id="Grade" name="Grade" type="text"
							value="${studentenrollment.grade}" /></td>
						<td><input id="StudentId" name="StudentId" type="hidden"
							value="${studentenrollment.harrisonstudent.studentid}" />
							<input id="Classid" name="Classid" type="hidden"
							value="${studentenrollment.harrisonclass.classid}" />
							<button id="submit" type="submit" value="Submit">
								<font color="blue">Update Grade</font>
							</button></td>
					</tr>
				</tbody>
			</table>

		</form>
	</c:forEach>

</body>
</html>
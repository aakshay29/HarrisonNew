<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>
	<form action ="StudentRoster.jsp" method ="post">
	
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>CourseID</th>
						<th>CourseName</th>
							<th>CourseDescription</th>

					<c:forEach var="en" items="${enroll}">
					<tr>
						<td><c:out value="${en.studentid}" /></td>
						<td><c:out value="${en.grade}" /></td>
						

					</tr>
				</c:forEach>
				
		</thead>
	</table>
	<center>
	<input type="Submit" name="Back" value="Back">
	</center>
	</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
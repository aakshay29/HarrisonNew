<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Your Classes</th>	
					<th>Your Schedule</th>
					<th>Semester</th>
					
				
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lecture" items="${lectures}">
					<tr>
						
						<td><c:out value="${lecture.classroom}" /></td>
						<td><c:out value="${lecture.schedule}" /></td>
						
						<td> <form action="InstructorServlet" method="post"> 
							<input type="submit" name="StudentRoster" value="StudentRoster"> 
							<input type="submit" name="action" value="StudentRoster"> 
							 
							 </form> </td>
						<td><form action="DeleteServlet" method="post">
						
							</form></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

</center>
	

</body>
</html>
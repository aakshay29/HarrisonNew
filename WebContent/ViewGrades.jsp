<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.Harrisonclass"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>

<form action ="InstructorView.jsp" method ="post">
<table class="table table-bordered">
    <thead>
        <tr><th>StudentID</th><th>Grade</th></tr>
    </thead>
    <tbody>
    <c:forEach var="en" items="${enrollments}">
        <tr>
        <td><c:out value="${en.status}"/></td>
        <td><c:out value="${en.grade}"/></td>
        
        
       
        </tr>
    </c:forEach>
    </tbody>
    </table>
  <input type="Submit" name="Back" value="Back">
</form>
	
</body>
<jsp:include page="Footer.jsp"></jsp:include>
</html>
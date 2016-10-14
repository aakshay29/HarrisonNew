<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<!-- banner -->
  <div class="courses_banner">
  	<div class="container">
  		<h3>Login</h3>
  		
  		<p class="description">
        Order Transcripts
        </p>
        
        <div class="breadcrumb1">
            <ul>
                <li class="icon6"><a href="HomeStudent.jsp">Home</a></li>
                <li class="current-page">Transcripts</li>
                
              </ul>
        </div>
  	</div>
  </div>
    <!-- //banner -->
    
    
    <c:forEach var="enrollmentlist" items="${enrollmentlist}">
    <table>
    <tr>

	<td><c:out value="${enrollmentlist.harrisonclass.harrisoncourse.name}"/><td>
	<td><c:out value="${enrollmentlist.harrisonclass.classroom}"/><td>
	<td><c:out value="${enrollmentlist.harrisonclass.schedule}"/><td>
	<td><c:out value="${enrollmentlist.status}"/><td>
	<td><c:out value="${enrollmentlist.grade}"/><td>
	
	 </td>
	 </tr>
	 </table>
	</c:forEach> 
</body>
</html>
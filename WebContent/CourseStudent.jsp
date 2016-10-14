<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="model.Harrisonuser"%>
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
  		<h3>Course Page</h3>
  			<%
  			Harrisonuser user = (Harrisonuser) session.getAttribute("user");
								
			%>	
				 		
  		<p class="description">
    	 Hi! <%= user.getName()%>, You can now view all your courses and enroll in new courses
        </p>
        <div class="breadcrumb1">
            <ul>
                <li class="icon6"><a href="index.html">Home</a></li>
                <li class="current-page">Login</li>
   </ul>
        </div>
  	</div>
  </div>
 <!-- banner close-->               
                
 <!-- view all classes -->
 

 
     <form action ="HomeServlet" method="post">
 
 	<c:forEach var="enrollmentlist" items="${enrollmentlist}">
    <table>
    <tr>
	
	<td><input type ="hidden" name ="classid" id="classid" value="${enrollmentlist.harrisonclass.classid}" /></td>
	<td><c:out value="${enrollmentlist.harrisonclass.harrisoncourse.name}"/></td>
	<td><c:out value="${enrollmentlist.harrisonclass.harrisoncourse.description}"/></td>
	<td><c:out value="${enrollmentlist.harrisonclass.classroom}"/></td>
	<td><c:out value="${enrollmentlist.harrisonclass.schedule}"/></td>
	<td><c:out value="${enrollmentlist.harrisonclass.harrisoncourse.available}"/></td>
	
	 <td><input type="submit" value="Enroll" id="enroll" name="enroll"/> </td>
	 </tr>
	 </table>
	</c:forEach> 
			
	</form>    
  
           
</body>
</html>
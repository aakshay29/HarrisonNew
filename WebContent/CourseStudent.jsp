%@ page language="java" contentType="text/html; charset=UTF-8"
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
 

 

     <table>
 	<c:forEach var="classList" items="${classList}">
   
   <tr>  
   
   <td>Class Name</td>
   <td>Description</td>
   <td>Class Room</td>
   <td>Schedule</td>
   <td>Available</td>
   
   </tr>


	<td><c:out value="${harrisonclass.harrisoncourse.name}"/></td>
	<td><c:out value="${classList.harrisonclass.harrisoncourse.description}"/></td>
	<td><c:out value="${classList.harrisonclass.classroom}"/></td>
	<td><c:out value="${classList.harrisonclass.schedule}"/></td>
	<td><c:out value="${classList.harrisonclass.harrisoncourse.available}"/></td>
	 
	 <td> 
	 <form action ="HomeServlet" method="post">
	 <input type ="hidden" name ="classid" id="classid" value="${enrollmentlist.harrisonclass.classid}" />
	<input type="hidden" value="enroll"  name="action"/>
	<input type="submit" value="enroll" id="submit" />
	 </form>
	 
	 </td>

	</tr>
	</c:forEach> 
		 </table>	
  
  
           
</body>
</html>
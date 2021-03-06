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
<script>	
function transcript() {

		document.getElementById('email').style.visibility = 'visible'
		document.getElementById('address').style.visibility = 'visible'
		$('#send').show();
	}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include> 
 

 <!-- banner -->
  <div class="courses_banner">
  	<div class="container">
  		<h3>Student Home Page</h3>
  			<%
  				Harrisonuser user = (Harrisonuser) session.getAttribute("user");						
			%>				 		
  		<p class="description">
        Welcome <%= user.getName()%> 
        View current classes, drop classes or view and buy transcripts
        </p>
        <div class="breadcrumb1">
            <ul>
                <li class="icon6"><a href="index.html">Home</a></li>
                <li class="current-page">Login</li>
            </ul>
        </div>
  	</div>
  </div>
    <!-- //banner -->
 
  
    <table class="table table-bordered table-striped table-hover">
        <thead>
        <tr><th>Course Name</th><th>Classroom</th><th>Schedule</th><th>Status</th><th>Grade</th></tr>
    </thead>

    <tr>

   
 
 	<c:forEach var="enrollmentlist" items="${enrollmentlist}"> <tr>
	<td><c:out value="${enrollmentlist.harrisonclass.harrisoncourse.coursename}"/></td>
	<td><c:out value="${enrollmentlist.harrisonclass.classroom}"/></td>
	<td><c:out value="${enrollmentlist.harrisonclass.schedule}"/></td>
	<td><c:out value="${enrollmentlist.status}"/></td>
	<td><c:out value="${enrollmentlist.grade}"/></td>
	  
	 <td>
	 
	 <form action ="HomeServlet" method="post">
	 <input type ="hidden" name ="enrollmentid" id="enrollmentid" value="${enrollmentlist.enrollmentid}">
	<input type="hidden" value="drop"  name="action"/>
	<input type="submit" value="drop" id="submit" />
	 </form>
	 </td> </tr>
	
	</c:forEach> 
				 
	
	
	 </table>
	 


	
	 <jsp:include page="Chat.jsp"></jsp:include>
	
	 <!-- //Buying transcripts -->
	
	<form action="HomeServlet" method="post">
		<h4>Order transcripts: </h4>
    	<input type="text"  class="required form-control" placeholder="Email *" name="emailAddress">
    	<input type="hidden" name="action" value="Transcript">
    	<input id="submit" type="submit" value="Register"/>
	</form>	
	
 <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
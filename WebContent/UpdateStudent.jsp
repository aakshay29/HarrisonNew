<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.Harrisoninstructor"%>
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
  		<h3>Register</h3>
  		<p class="description">
          Update Student
        </p>
        <div class="breadcrumb1">
            <ul>
                <li class="icon6"><a href="index.html">Home</a></li>
                <li class="current-page">Update Student</li>
            </ul>
        </div>
  	</div>
  </div>
    <!-- //banner -->



          <br><br><br>
                
                	<%
					                	
                	model.Harrisonuser user = (model.Harrisonuser) session.getAttribute("user");
								
					%>	                
               
               
               <input type="text"  class="required form-control" placeholder="Name *" name="name" id="name" value="<%= user.getName()%>">
                    
               <input type="text"  class="required form-control" placeholder="Email *" name="email" id="email" value="<%= user.getEmail()%>">               
                     
              <input type=text" class="required form-control" placeholder="Password *" name="password" id="password" value="<%= user.getPassword()%>">
                            
              <input type="text"  class="required form-control" placeholder="major" name="department" id="major" value="<%= user.getHarrisonstudents().get(0).getMajor()%>">
        
              <input type="text"  class="required form-control" placeholder="year" name="year" id="year" value="<%= user.getHarrisonstudents().get(0).getYearofentry()%>">


<jsp:include page="Footer.jsp"></jsp:include>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<!-- banner -->
  <div class="courses_banner">
  	<div class="container">
  		<h3>Login</h3>
  		<p class="description">
         Login to view your schedule, enroll into classes and more
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


	<div class="courses_box1">
	   <div class="container">
	   	 
	   	  <form class="login"  action ="LoginServlet" method="post">
	    	<p class="lead">Welcome Back!</p>
		    <div class="form-group">
			    <input autocomplete="off" type="text" name="email" id="email" class="required form-control" placeholder="Email">
		    </div>
		    <div class="form-group">
			    <input autocomplete="off" type="password" class="password required form-control" placeholder="Password" name="password" name="id">
		    </div>
		    
		    <br> <input type="submit" value="Submit" id="submit" />
	        <p>Don't have an account yet? <a href="register.jsp" title="Sign Up">Sign Up</a></p>
		 </form>
	   </div>
	</div>
	
	
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
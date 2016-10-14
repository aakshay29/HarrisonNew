<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<script>

function verifyPassword() {
	var pass1 = document.getElementById("password").value;
	var pass2 = document.getElementById("password2").value;
	if (pass1 != pass2) {
		alert("Passwords Do not match");
		document.getElementById("password").style.borderColor = "#E34234";
		document.getElementById("password2").style.borderColor = "#E34234";
		return false;
	}
	return true;
}


function checkUser() {
    if (document.getElementById('student').checked) {
    	document.getElementById('name').style.visibility = 'visible'
    	document.getElementById('email').style.visibility = 'visible'
    	document.getElementById('password').style.visibility = 'visible'
    	document.getElementById('password2').style.visibility = 'visible'
        document.getElementById('major').style.visibility = 'visible'
        document.getElementById('year').style.visibility = 'visible';
    	
    	document.getElementById('officenumber').style.visibility = 'hidden'
		document.getElementById('department').style.visibility = 'hidden'
			$('#register').show();
    
    } 
    else {

			document.getElementById('name').style.visibility = 'visible'
			document.getElementById('email').style.visibility = 'visible'
			document.getElementById('password').style.visibility = 'visible'
			document.getElementById('password2').style.visibility = 'visible'
			document.getElementById('officenumber').style.visibility = 'visible'
			document.getElementById('department').style.visibility = 'visible'
		
			document.getElementById('major').style.visibility = 'hidden'
			document.getElementById('year').style.visibility = 'hidden';
			$('#register').show();	
    }
	}
</script>


</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<!-- banner -->
  <div class="courses_banner">
  	<div class="container">
  		<h3>Register</h3>
  		<p class="description">
             Fill in your details to Sign Up
        </p>
        <div class="breadcrumb1">
            <ul>
                <li class="icon6"><a href="index.html">Home</a></li>
                <li class="current-page">Register</li>
            </ul>
        </div>
  	</div>
  </div>
    <!-- //banner -->
    
    	<div class="courses_box1">
	   <div class="container">
	   	  <form class="login" action="RegisterServlet" method="post" onsubmit="return verifyPassword()">
                <p class="lead">Register New Account</p>
       
          <p>Already have an account? <a href="Login.jsp">Sign In</a></p>
          <br><br>
  
			      Instructor <input type="radio" onclick="javascript:checkUser();" name="check" id="instructor"/>
       			  Student <input type="radio" onclick="javascript:checkUser();" name="check" id="student"/>
       
       
       
               <br><br><br>
                <div id="name" class="form-group" style="visibility:hidden" >
                    <input type="text"  class="required form-control" placeholder="Name *" name="name" id="name" value="">
                </div>
              
                <div id="email" class="form-group" style="visibility:hidden">
                    <input type="text"  class="required form-control" placeholder="Email *" name="email" id="email" value="">
                </div>
              
                <div id="password" class="form-group" style="visibility:hidden">
                    <input type="password" class="required form-control" placeholder="Password *" name="password" id="password" value="">
                </div>
              
                <div id="password2" class="form-group" style="visibility:hidden">
                    <input type="password" class="required form-control" placeholder="Confirm Password *" name="password2" id="password2" value="">
                </div>
                
                <div id="major" class="form-group" style="visibility:hidden">
                    <input type="text"  class="required form-control" placeholder="Major *" name="major" value="" id="major">
                </div>
                
                <div id="year" class="form-group" style="visibility:hidden"> 
                    <input type="text"  class="required form-control" placeholder="Year of Entry" name="year" id="year" value="">
                </div>
             
             	  <div id="department" class="form-group" style="visibility:hidden"> 
                    <input type="text"  class="required form-control" placeholder="Department" name="department" id="department" value="">
                </div>
                
                 <div id="officenumber" class="form-group" style="visibility:hidden"> 
                    <input type="text"  class="required form-control" placeholder="1 to 10 only" name="officenumber" id="officenumber" value="">
                </div>
            
                <div class="form-group">
              	
              	 <button id="register" type="submit" value="Submit" style="display: none;">
				Register
		  		</button>
                </div>
            
            
            
                  </form>
	   </div>
	</div>
    
    <jsp:include page="Footer.jsp"></jsp:include>
    
</body>
</html>
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
  	
       	document.getElementById('option').style.visibility = 'visible'    
    } 

	function checkOption() 
	{
		if (document.getElementById('emailoption').checked) {
			document.getElementById('email').style.visibility = 'visible'
			document.getElementById('address').style.visibility = 'hidden'
			$('#send').show();

		}
		else if (document.getElementById('physicaloption').checked){
			document.getElementById('address').style.visibility = 'visible'
			document.getElementById('email').style.visibility = 'hidden'
			$('#send').show();

		}
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
	
	<div>
	<input type="submit" value="Buy A Transcript" id="transcript" name="transcript" onclick="javascript:transcript();"/>
	</div>
	
	<div id="options" style="visibility:hidden" >
	 Email <input type="radio" onclick="javascript:checkOption();" name="check" id="emailoption"/>
     Physical Copy <input type="radio" onclick="javascript:checkOption();" name="check" id="physicaloption"/>
	</div>
	
	 <div id="email" class="form-group" style="visibility:hidden">
     <input type="text"  class="required form-control" placeholder="Email *" name="email" id="email" value="">
     </div>
	
	<div id="address" class="form-group" style="visibility:hidden">
     <input type="text"  class="required form-control" placeholder="address *" name=address id="address" value="">
     </div>
	 <button id="send" type="submit" value="Submit" style="display: none;">
				Register
		  		</button>
	
 <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
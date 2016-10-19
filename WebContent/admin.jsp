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
function addcourse()
{

	document.getElementById('coursename').style.visibility = 'visible'
	document.getElementById('coursedescription').style.visibility = 'visible'
	document.getElementById('numberofcredits').style.visibility = 'visible'
	document.getElementById('subjectcode').style.visibility = 'visible'
	document.getElementById('available').style.visibility = 'visible'

	$('#submit').show();
}

function update()
{
	document.getElementById('usertable').style.visibility = 'visible'
}


</script>



</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<!-- banner -->
  <div class="courses_banner">
  	<div class="container">
  		<h3>Admin Page</h3>
  		<p class="description">
         Login to view your schedule, enroll into classes and more
        </p>
        <div class="breadcrumb1">
            <ul>
                <li class="icon6"><a href="Home.jsp">Home</a></li>
                <li class="current-page">Admin</li>
            </ul>
        </div>
  	</div>
  </div>
    <!-- //banner -->



	<table>


		<tr>
			<td>Class Name</td>
			<td>Description</td>
			<td>Available</td>
		</tr>

		<c:forEach var="classList" items="${classList}">
			<tr>
				<td><c:out value="${classList.harrisoncourse.coursename}" /></td>
				<td><c:out
						value="${classList.harrisoncourse.coursedescription}" /></td>
				<td><c:out value="${classList.harrisoncourse.available}" /></td>


				<td>

					<form action="DeleteCourse" method="post">

						<input type="hidden" name="classid" id="classid"
							value="${classList.classid}" /> <input type="hidden"
							value="delete" name="action" /> <input type="submit" value="delete"
							id="delete" name="action" />

					</form>

				</td>
			</tr>

		</c:forEach>
	</table>




	<!-- //Adding courses -->
	 <center>
	 <div>
	 <input type="submit" value="Add Courses" id="addcourse" name="addcourse" onclick="javascript:addcourse();"/>
	 </div>
	
		
	 <div id="coursename" class="form-group" style="visibility:hidden">
     <input type="coursename"  class="required form-control" placeholder="Course Name *" name="coursename" id="coursename" value="">
     </div>
	
	 <div id="coursedescription" class="form-group" style="visibility:hidden">
     <input type="text"  class="required form-control" placeholder="course description *" name="coursedescription" id="coursedescription" value="">
     </div>
     
     <div id="numberofcredits" class="form-group" style="visibility:hidden">
     <input type="text"  class="required form-control" placeholder="number of credits *" name="numberofcredits" id="numberofcredits" value="">
     </div>
     
      <div id="subjectcode" class="form-group" style="visibility:hidden">
     <input type="text"  class="required form-control" placeholder="subjectcode *" name="subjectcode" id="subjectcode" value="">
     </div>
     
      <div id="available" class="form-group" style="visibility:hidden">
     <input type="text"  class="required form-control" placeholder="available  *" name="available" id="available" value="">
     </div>
     
     <form action ="AddNewCourse" method="post">
     
	 <button id="submit" type="submit" value="Submit" style="display: none;"> Submit </button>
    
    </form>

	<!-- // Ended Adding courses -->


	<!-- //Updating -->
		<div>
			<input type="submit" value="Update User" id="update" name="update"
				onclick="javascript:update();" />
		</div>
		
		<div id="usertable" class="form-group" style="visibility:hidden">

		<table>
		<tr>
					<td>User id</td>
					<td>Name</td>
					<td>Email</td>
					<td>Password</td>
					<td>Role</td>
		</tr>

		<c:forEach var="userList" items="${userList}">
			<tr>
				<td><c:out value="${userList.userid}" /></td>
				<td><c:out value="${userList.name}" /></td>
				<td><c:out value="${userList.email}" /></td>
				<td><c:out value="${userList.password}" /></td>
				<td><c:out value="${userList.role}" /></td>
	
				<td>
					<form action="UpdateServlet" method="post">

						<input type="hidden" name="userid" id="userid" value="${userList.userid}" /> 
						<input type="hidden" value="update" name="action" />
						<input type="submit" value="update" id="update" name="action" />

					</form>

				</td>
				
					<td>
					<form action="AdminServlet" method="post">

						<input type="hidden" name="userid" id="userid" value="${userList.userid}" /> 
						<input type="hidden" value="SwitchRole" name="action" />
						<input type="submit" value="SwitchRole" id="SwitchRole" name="action" />

					</form>

				</td>
			</tr>

		</c:forEach>
	</table>
	</div>

	<!-- //End Update-->



	</center>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
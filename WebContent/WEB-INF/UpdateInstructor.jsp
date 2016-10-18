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

          <br><br><br>
                
                	<%
					                	
                	model.Harrisonuser user = (model.Harrisonuser) session.getAttribute("user");
								
					%>	                
               
               
               <input type="text"  class="required form-control" placeholder="Name *" name="name" id="name" value="<%= user.getName()%>">
                    
               <input type="text"  class="required form-control" placeholder="Email *" name="email" id="email" value="<%= user.getEmail()%>">               
                     
              <input type="password" class="required form-control" placeholder="Password *" name="password" id="password" value="<%= user.getPassword()%>">
                            
              <input type="text"  class="required form-control" placeholder="Department" name="department" id="department" value="<%= user.getHarrisoninstructors().get(0).getDepartment()%>">
        
              <input type="text"  class="required form-control" placeholder="1 to 10 only" name="officenumber" id="officenumber" value="<%= user.getHarrisoninstructors().get(0).getOfficenumber()%>">





</body>
</html>
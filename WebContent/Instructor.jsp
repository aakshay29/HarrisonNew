<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Image</th>	
					<th>Product</th>
					<th>ProductDetail</th>
					<th>ProductPrice</th>
					<th>Add to cart</th>
					<th>Proceed</th>
				
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="prods" items="${prods}">
					<tr>
						<td><img src="<c:out value="${prods.image}"/>" height="200" width="250" alt=""/> </td>
						<td><c:out value="${prods.productname}" /></td>
						<td><c:out value="${prods.productdetails}" /></td>
						<td><c:out value="${prods.productprice}" />  </td> 
						<td> <form action="CartServlet" method="post"> 
							<input type="hidden" name="Productid" value="<c:out value="${prods.productid}"/>"> 
							<input type="hidden" name="action" value="Add">
							 <input type="submit" value="Add"> 
							 </form> </td>
						<td><form action="DeleteServlet" method="post">
							<input type="submit" name="Checkout" value="Checkout">
							<input type="hidden" name="action" value="Checkout">
							</form></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

</center>
	

</body>
</html>
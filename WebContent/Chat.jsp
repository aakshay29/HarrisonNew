<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat Box</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(document).ready(function() {
		$('#submit').click(function(event) {
			var responsetext = $('#response').val();
			$.get('StudentChatServlet', {
				response : responsetext
			}, function(responseText) {
				$('#message').text(responseText);
			});
		});
	});
</script>
</head>
<body>
<div id="chat">
<table align="center">
<tr><th>
	<h3>Chat with us</h3>

	<form id="form1" name="form1" action="StudentChatServlet" method="get">
		<div id="message">Would you like to ask a question?</div>
		  </br><input type="text" id="response"
			name="response" /><br /> <br/><input type="button" id="submit"
			value="submit" />
	</form>
	<p />

</th>
</tr>
</table>
</div>
</body>
</html>
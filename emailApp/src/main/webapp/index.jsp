<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hiiiiiiii</h2>
	
	<form action="sendEmail">
	<pre>
		To Address:<input type="text" name="to">
		Subject:<input type="text" name="subject">
		Message:<input type="text" name="message">
		<input type="submit" value="send">
	</pre>	
	</form>
	<h2>${response}</h2>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.LoginApp.service.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>
	<h3>Login Successful</h3>
	
<%-- 	<%
		User user = (User) request.getAttribute("user");
	%> --%>
	
	<jsp:useBean id="user" class="com.LoginApp.service.User" scope="request"></jsp:useBean>
	
<%-- 	Hello <%= user.getUserName() %>!
 --%>	
	Hello <jsp:getProperty property="userName" name="user"/>!	
	
</body>
</html>
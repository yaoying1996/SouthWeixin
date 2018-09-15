<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("id") %>
	<form action="/Daily/callBack" method="post">
		<input type="text" name="account">
		<input type="text" name="password">
		<input type="hidden" name="openid" value="${openid}" >
		<input type="submit" value="登录并绑定">
	</form>
</body>
</html>
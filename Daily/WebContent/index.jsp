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
	<a href="/Daily/login">微信授权</a>
	 <%
		
		Cookie[] cookie = request.getCookies();
		
		String user = new String();
		
		if ( cookie != null ) {
		
		for (int i = 0; i < cookie.length; i++) {
		
		Cookie myCookie = cookie[i];
	
		user = myCookie.getValue();
	
		}
		
		}
		
		out.println("user = " + user);

%>
</body>
</html>
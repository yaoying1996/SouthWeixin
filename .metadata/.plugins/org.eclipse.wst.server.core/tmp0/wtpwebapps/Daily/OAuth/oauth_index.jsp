<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../_head.html"%>
<title></title>
</head>
<body>
	<div class="weui-msg">
		<div class="weui-msg__icon-area"><i class="weui-icon-success weui-icon_msg"></i></div>
	      <div class="weui-msg__text-area">
	        <h2 class="weui-msg__title">登录注册授权</h2>
	        <p class="weui-msg__desc">该网页由南方传媒开发，点击确认将获得你的公开信息(昵称、头像等)</p>
	      </div>
     <div class='demos-content-padded'>
      <a href="javascript:;" class="weui-btn weui-btn_primary" onClick="oauth()">确定</a>
      
     </div>
	</div>
<%@ include file="../_foot.html"%>
<script >
 function oauth(){
	//window.location.href="../login.jsp";
	 document.location = '<%=request.getContextPath()%>/login.do';
}
 
</script>
</body>
</html>
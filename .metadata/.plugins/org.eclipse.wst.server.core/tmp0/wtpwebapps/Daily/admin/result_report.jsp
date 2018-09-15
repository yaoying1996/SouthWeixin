<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">

<meta name="description"
	content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">

<link rel="stylesheet" href="../jQuery_WeUI/lib/weui.min.css">
<link rel="stylesheet" href="../jQuery_WeUI/css/jquery-weui.css">
<link rel="stylesheet" href="../assets/css/demos.css">
<link rel="stylesheet" href="../assets/jquery-ui.css">


</head>
<body ontouchstart>
<%
String company=request.getParameter("company");
String stage=request.getParameter("stage");
String userName=request.getParameter("userName");
String progress=request.getParameter("progress");
String point=request.getParameter("point");
String advice=request.getParameter("advice");
if(userName==null||company==null||advice==null||stage==null||progress==null||point==null){
	/* alert(time==""); */
	company="";
	stage="";
	userName="";
	progress="";
	point="";
	advice="";
}
%>
		<header class='demos-header'>
			<h1 class="demos-title">报表详情</h1>
		</header>

		<from id="form2">
			<div class="weui-cells weui-cells_form">
		
	        <div class="weui-cells weui-cells_form">
		     <div class="weui-cell">
		       <div class="weui-cell__hd"><label for="name" class="weui-label">客户公司</label></div>
		       <div class="weui-cell__bd">
		         <input class="weui-input" name="company" id="company" type="text" readonly="readonly" value="<%=company%>" required="required" >
		       </div>
		       
		     </div>
		     
		  </div>
		  
			<div class="weui-cells weui-cells_form"	>
			     <div class="weui-cell" >
			       <div class="weui-cell__hd"><label for="name" class="weui-label">业务员</label></div>
			       <div class="weui-cell__bd">
			         <input class="weui-input" name="userName" id="userName" type="text" readonly="readonly" value="<%=userName%>">
			       </div>
			       
			       	
			     </div> 
			     
			</div>
			
			<div class="weui-cells weui-cells_form"	>
			     <div class="weui-cell" >
			       <div class="weui-cell__hd"><label for="name" class="weui-label">阶段</label></div>
			       <div class="weui-cell__bd">
			         <input class="weui-input" name="stage" id="stage" type="text" readonly="readonly" value="<%=stage%>">
			       </div>
			       
			       	
			     </div> 
			     
			</div>
			
		</div>
		<div class="weui-cells__title"><font size="4" color="black">进展</font></div>
	    <div class="weui-cells weui-cells_form">
	      <div class="weui-cell">
	        <div class="weui-cell__bd">
	          <textarea readonly class="weui-textarea" name="progress" id="progress"   rows="3" required="required"><%=progress %></textarea>
	         
	        </div>
	      </div>
	    </div>
	    <div class="weui-cells__title"><font size="4" color="black">关键点、难点、及所需支持</font></div>
	    <div class="weui-cells weui-cells_form">
	      <div class="weui-cell">
	        <div class="weui-cell__bd">
	          <textarea readonly class="weui-textarea" name="point" id="point"  rows="3"  required="required"><%=point %></textarea>
	          
	        </div>
	      </div>
	    </div>
	    <div class="weui-cells__title"><font size="4" color="black">意见</font></div>
	    <div class="weui-cells weui-cells_form">
	      <div class="weui-cell">
	        <div class="weui-cell__bd">
	          <textarea readonly class="weui-textarea" name="advice" id="advice"  rows="3"  required="required"><%=advice %></textarea>
	        
	        </div>
	      </div>
	    </div>
	   
		<br>
<br>
			
			</from>
			
			
			
		<!-- </div> -->
	<script src="../jQuery_WeUI/lib/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/jquery-ui.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/jquery.cookie.js"></script>
	<script src="../jQuery_WeUI/lib/fastclick.js"></script>
	<script>
	  $(function() {
	    FastClick.attach(document.body);
	    
	    //$('#contacts').prop('selectedIndex', 0);
	   
	    });
	    
	   
	</script>
	<script src="../jQuery_WeUI/js/jquery-weui.js"></script>

</body>
</html>
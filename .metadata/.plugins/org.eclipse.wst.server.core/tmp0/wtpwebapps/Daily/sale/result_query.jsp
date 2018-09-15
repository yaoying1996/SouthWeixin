<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<!-- <title>我的日报</title> -->
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
<!-- <link rel="stylesheet" href="../assets/jquery.autocomplete.css"> -->

</head>
<body ontouchstart>
<%
String time = request.getParameter("time");
String company=request.getParameter("company");
String contacts=request.getParameter("contacts");
String stage=request.getParameter("stage");
String budget = request.getParameter("budget");
String intention=request.getParameter("intention");
String discount=request.getParameter("discount");
String progress=request.getParameter("progress");
String point=request.getParameter("point");
String advice=request.getParameter("advice");
if(time==null||contacts==null||company==null||advice==null||stage==null||budget==null||intention==null||discount==null||progress==null||point==null){
	/* alert(time==""); */
	time="";
	company="";
	stage="";
	budget="";
	intention="";
	discount="";
	progress="";
	point="";
	advice="";
	contacts="";
}
%>
		<header class='demos-header'>
			<h1 class="demos-title">我的日报</h1>
		</header>

		<from id="form2">
			<div class="weui-cells weui-cells_form">
		
				<div class="weui-cells weui-cells_form"	>
			     <div class="weui-cell" >
			       <div class="weui-cell__hd"><label for="name" class="weui-label">时间</label></div>
			       <div class="weui-cell__bd">
			         <input class="weui-input" name="time" id="time" type="text" readonly="readonly" value="<%=time%>">
			       </div>
			       
			       	
			     </div> 
			     
			</div>
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
			       <div class="weui-cell__hd"><label for="name" class="weui-label">联系人</label></div>
			       <div class="weui-cell__bd">
			         <input class="weui-input" name="contacts" id="contacts" type="text" readonly="readonly" value="<%=contacts%>">
			       </div>
			       
			       	
			     </div> 
			     
			</div>
			
			<div class="weui-cells weui-cells_form"	>
			     <div class="weui-cell" >
			       <div class="weui-cell__hd"><label for="name" class="weui-label">进展阶段</label></div>
			       <div class="weui-cell__bd">
			         <input class="weui-input" name="stage" id="stage" type="text" readonly="readonly" value="<%=stage%>">
			       </div>
			       
			       	
			     </div> 
			     
			</div>
			<div class="weui-cell weui-cells_form">
				<div class="weui-cell__hd">
					<label class="weui-label">项目预算</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="budget" id="budget" type="text" readonly="readonly" value="<%=budget %>" required="required" >
				</div>
			</div>
			
			<div class="weui-cell weui-cells_form">
				<div class="weui-cell__hd">
					<label class="weui-label">意向屏点</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="intention" id="intention" type="text" readonly="readonly" value="<%=intention %>"required="required">
				</div>
			</div>
			
			<div class="weui-cell weui-cells_form">
				<div class="weui-cell__hd">
					<label class="weui-label">折扣</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="discount" id="discount" type="text" readonly="readonly" value="<%=discount %>" required="required" >
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
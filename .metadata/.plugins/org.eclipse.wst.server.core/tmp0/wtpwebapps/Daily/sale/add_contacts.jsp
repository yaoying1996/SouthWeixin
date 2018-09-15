<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">

<link rel="stylesheet" href="<%=request.getContextPath() %>/jQuery_WeUI/lib/weui.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/jQuery_WeUI/css/jquery-weui.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/demos.css">
<title></title>
</head>
<body ontouchstart>
	
<%
    //接收URL传递来的参数
    String company = request.getParameter("company");
%>
    <header class='demos-header'>
      <h1 class="demos-title">添加联系人</h1>
    </header>
    <form id="form1">
  
      <div class="weui-cells weui-cells_form">
	     <div class="weui-cell">
	       <div class="weui-cell__hd"><label for="name" class="weui-label">联系人</label></div>
	       <div class="weui-cell__bd">
	         <input class="weui-input" id="contacts_name" name="contacts_name" type="text" placeholder="请输入真实姓名" value="" required="required" >
	       </div>
	     </div>
	  </div>
	  
	  <div class="weui-cells weui-cells_form" >
	     <div class="weui-cell">
	       <div class="weui-cell__hd"><label for="name" class="weui-label">公司名称</label></div>
	       <div class="weui-cell__bd">
	         <input class="weui-input" id="company_name" name="company_name" type="text" readonly="readonly" value="<%=company%>" required="required" >
	       </div>
	     </div>
	  </div>
	  
	  <div class="weui-cells weui-cells_form">
	     <div class="weui-cell">
	       <div class="weui-cell__hd"><label for="name" class="weui-label">联系部门</label></div>
	       <div class="weui-cell__bd">
	         <input class="weui-input" id="department" name="department" type="text" placeholder="请输入所属部门" value="" required="required" >
	       </div>
	     </div>
	  </div>
	  
	  <div class="weui-cells weui-cells_form">
	     <div class="weui-cell">
	       <div class="weui-cell__hd"><label for="name" class="weui-label">职务</label></div>
	       <div class="weui-cell__bd">
	         <input class="weui-input" id="post" name="post" type="text" placeholder="请输入担任职务" value="" required="required" >
	       </div>
	     </div>
	  </div>
	  <div class="weui-cells weui-cells_form">
	     <div class="weui-cell">
	       <div class="weui-cell__hd"><label for="name" class="weui-label">手机号</label></div>
	       <div class="weui-cell__bd">
	         <input class="weui-input" id="tel" name="tel" type="tel" placeholder="请输入手机号" required="required" >
	       </div>
	     </div>
	  </div>
     
    <div class="weui-btn-area">
      <a class="weui-btn weui-btn_primary" href="javascript:" id="showTooltips" >添加</a>
      </div>
    </form>
    
    


  
<script src="<%=request.getContextPath() %>/jQuery_WeUI/lib/jquery-2.1.4.js"></script>
<script src="<%=request.getContextPath() %>/jQuery_WeUI/lib/fastclick.js"></script>
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script>
<script src="<%=request.getContextPath() %>/jQuery_WeUI/js/jquery-weui.js"></script>

    <script type="text/javascript">
    
  	  //验证是否有字段为空
	  function validateForm() {
		  	var contacts_name=$('#contacts_name').val();
	    	var department=$('#department').val();
	    	var post=$('#post').val();
	        var tel = $('#tel').val();
	        if(contacts_name==""||department==""||post==""){
	        	/* alert(time==""); */
	        	$.toptip('任何字段都不能为空！');
	        	return  false;
	        	
	        }
	        if(!tel || !/1[3|4|5|7|8]\d{9}/.test(tel)){
	        	$.toptip('请输入正确的手机号');
	        	return  false;
	        }
	      // 在键盘按下并释放及提交后验证提交表单
	      return true;
		}
      $("#showTooltips").click(function() {
    	/* var contacts_name=$('#contacts_name').val();
    	var department=$('#department').val();
    	var post=$('#post').val();
        var tel = $('#tel').val(); */
        if(!validateForm()){
        	return "";
        }else{
        	$.ajax({
      		     url: '<%=request.getContextPath()%>/contacts.do',
      		     data:$("#form1").serialize(), 
      		     type: "post",
      		     dataType : "json",
      		  })
      		  .done(function( data ) {
      			 //alert(data);
      		     if(data==true){
      		    	
      		    	window.history.go(-1);
      		    	 
      		     }else  if(data==false){
      		    	 //alert("已经注册！请勿重复");
      		    	window.location.href="<%=request.getContextPath() %>/common/error.jsp";
      		    	//window.location.href="OAuth/error.jsp";
      		     }
      		  })
      		  .fail(function( xhr, status, errorThrown ) {
      		    //alert( "Sorry, there was a problem!" );
      		    console.log( "Error: " + errorThrown );
      		    console.log( "Status: " + status );
      		    console.dir( xhr );
      		  })
        }
        
        /* alert("+++");
         window.history.back(-1); */
      });
    
    </script>
  </body>
</html>
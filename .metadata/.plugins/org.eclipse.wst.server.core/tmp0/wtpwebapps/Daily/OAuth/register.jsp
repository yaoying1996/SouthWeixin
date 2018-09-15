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


    <header class='demos-header'>
      <h1 class="demos-title">注册用户</h1>
      <div align="center" style="color:red">
      <p>温馨提示：如注册过，则直接登录即可，</p>
      <p>取消关注又重新关注则需要再次注册</p>
      </div>
    </header>
    <form id="form1">
    
      <div class="weui-cells weui-cells_form">
	     <div class="weui-cell">
	       <div class="weui-cell__hd"><label for="name" class="weui-label">姓名</label></div>
	       <div class="weui-cell__bd">
	         <input class="weui-input" id="realName" name="realName" type="text" placeholder="请输入真实姓名" value="" required="required" >
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
     
     <div class="weui-cells weui-cells_form">
	     <div class="weui-cell">
	       <div class="weui-cell__hd"><label for="name" class="weui-label">邮箱</label></div>
	       <div class="weui-cell__bd">
	         <input class="weui-input" id="email" name="email" type="text" placeholder="请输入邮箱地址" value="" required="required" >
	       </div>
	     </div>
	  </div>
	  
       <div class="weui-cells weui-cell_select">
		     <div class="weui-cell">
		       <div class="weui-cell__hd"><label for="name" class="weui-label">角色</label></div>
		       <div class="weui-cell__bd">
		         <select class="weui-select" name="role" id="role" required="required">
					<option value="1" selected = "selected" >业务员</option>
					<option value="2">总经理</option>
					<option value="3">管理员</option>
				</select>
		       </div>
		     </div>
			</div>
	 <div class="weui-cells weui-cells_form">
      <div class="weui-cell">
        <div class="weui-cell__hd"><label for="name" class="weui-label">部门</label></div>
        <div class="weui-cell__bd">
          <input class="weui-input" id="department" type="text"  name="department" value="">
        </div> 
      </div>
      </div>
    
     <input type="hidden" name="openid" value="${openid}" >
	 
	<!-- 用户注册过cookie失效就登录   -->
	<div class="weui-btn-area">
      <a class="weui-btn weui-btn_primary" href="javascript:" onClick="login()" >登录</a>
      </div>
    <div class="weui-btn-area">
      <a class="weui-btn weui-btn_primary" href="javascript:" id="showTooltips" >注册</a>
      </div>
    </form>
    
    

 <%
 	String openid=(String)request.getAttribute("openid");
    /* System.out.println("+++"+openid); */
	Cookie cookie2 = new Cookie("openid",openid);
	cookie2.setMaxAge(356*24*60*60);
	cookie2.setPath("/");
	response.addCookie(cookie2);
	%>
  
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
		  	var flag=true;
		    var department=$('#department').val();
		    var email=$('#email').val();
		  	var realName=$('#realName').val();
	        if(department==""||realName==""||email==""){
	        	/* alert(time==""); */
	        	$.toptip('任何字段都不能为空！');
	        	flag= false;
	        }
	      // 在键盘按下并释放及提交后验证提交表单
	      return flag;
		}
    $("#department").picker({
        title: "请选择所在部门",
        cols: [
          {
            textAlign: 'center',
            values: ['公司领导','行政中心', '数据中心', '财务部', '市场部', '商务部', '渠道部', '销售支持中心', '大客户中心', '销售一部（深圳）', '销售二部', '销售三部', '销售四部','销售五部']
          }
        ],
        onChange: function(p, v, dv) {
          console.log(p, v, dv);
        },
        onClose: function(p, v, d) {
          console.log("close");
        }
      });
    function login(){
    	 if(!validateForm()){
   		  return "";
   	  }
    	$.toast("登录成功");
    	WeixinJSBridge.call('closeWindow');
    }
      
      $("#showTooltips").click(function() {
    	  if(!validateForm()){
       		  return "";
       	  }
    	  var tel=$('#tel').val();
    	  
        if(!tel || !/1[3|4|5|7|8]\d{9}/.test(tel)){
        	$.toptip('请输入手机号');
        } else {
 
        	 $.ajax({
       		     url: '<%=request.getContextPath()%>/login.do',
       		     data:$("#form1").serialize(), 
       		     type: "post",
       		    dataType : "json",
       		  })
       		  .done(function( data ) {
       			 //alert(data);
       		     if(data==true){
       		    	$.toast("注册成功");
       		    	WeixinJSBridge.call('closeWindow');
       		    	<%-- //window.location.href="<%=request.getContextPath() %>/common/success.jsp"; --%>
       		    	 
       		     }else  if(data==false){
       		    	 //alert("已经注册！请勿重复");
       		    	$.toast("用户已注册，请登录", "cancel");
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
      });
    
    </script>
  </body>
</html>
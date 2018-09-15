<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../_head.html"%>
<title></title>
</head>
<body ontouchstart>


    <header class='demos-header'>
      <h1 class="demos-title">个人信息</h1>
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
	  
     <div class="weui-cells weui-cells_form">
	     <div class="weui-cell">
	       <div class="weui-cell__hd"><label for="name" class="weui-label">角色</label></div>
	       <div class="weui-cell__bd">
	         <input readonly="readonly" class="weui-input" id="role" type="role" name="role" required="required" >
	       </div>
	     </div>
	  </div>
	 
	 <div class="weui-cells weui-cells_form">
      <div class="weui-cell">
        <div class="weui-cell__hd"><label for="name" class="weui-label">部门</label></div>
        <div class="weui-cell__bd">
          <input class="weui-input" id="department"  type="text"  name="department" value="">
        </div> 
      </div>
      </div>
   	 
 </form>
    <div class="weui-btn-area">
      <a class="weui-btn weui-btn_primary" href="javascript:" id="showTooltips">修改</a>
    </div>
    
      <%@ include file="../_foot.html"%>

  

    <script type="text/javascript">
    
      $(function(){
    	init();
      });
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
  
      $("#showTooltips").click(function() {
    	  if(!validateForm()){
    		  return "";
    	  }
    	  var realName = $('#realName').val();
    	  var role = $('#role').val();
    	  var department = $('#department').val();
    	  var email=$('#email').val();
        var tel = $('#tel').val();
        if(!tel || !/1[3|4|5|7|8]\d{9}/.test(tel)){
        	$.toptip('请输入手机号');
        } else{
        	$.ajax({
        		url:'<%=request.getContextPath()%>/user.do',
        		dataType:'json',
        		type:'Post',
        		data:{"realName":realName,"role":role,"department":department,"tel":tel,"email":email}
        	})
        	.done(function(data){
        		//alert("+++++");
        		if(data==true){
        			$.toast("修改成功");
        			WeixinJSBridge.call('closeWindow');
        		}else if(data==false){
        			$.toast("修改失败", "cancel");
        		}
        	})
        	.fail(function(xhr,status,errorThrown){
        		console.log("Error:"+errorThrown);
        		console.log("Status:"+status);
        		console.log(xhr);
        	})
        	
        }
      });
      
      function init(){
  
    	  $.ajax({
  		    url: '<%=request.getContextPath()%>/user.do',
  		    type: "get",
  		    dataType : "json",
  		  })
  		  .done(function( data ) {
  			 
  		     var tel=data.tel;
  		     var department=data.department;
  		     var name=data.realName;
  		     var roleName=data.role;
  		     var email=data.email;
  		     document.getElementById('tel').value=tel;
  		   document.getElementById('department').value=department;
  		  document.getElementById('realName').value=name;
  		  document.getElementById('role').value=roleName+"（不可更改）";
  		document.getElementById('email').value=email;
  		     
  		  })
  		  .fail(function( xhr, status, errorThrown ) {
  		    //alert( "Sorry, there was a problem!" );
  		    console.log( "Error: " + errorThrown );
  		    console.log( "Status: " + status );
  		    console.dir( xhr );
  		  })
  	
      }
    </script>
  </body>
</html>
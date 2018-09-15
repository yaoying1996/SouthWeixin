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
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label for="" class="weui-label">时间</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="time" id="time" type="datetime-local" value="<%=time%>"
						placeholder="">
				</div>
			</div>
	        <div class="weui-cells weui-cells_form">
		     <div class="weui-cell">
		       <div class="weui-cell__hd"><label for="name" class="weui-label">客户公司</label></div>
		       <div class="weui-cell__bd">
		         <input class="weui-input" name="company" id="company" type="text" placeholder="请输入客户公司"value="<%=company%>" required="required" >
		       </div>
		       <div class="weui-cell__ft">
		          <button class="weui-vcode-btn" onClick="queryContacts()">获取联系人</button>
		        </div>
		     </div>
		     
		  </div>
			<div class="weui-cells weui-cells_form"	>
			     <div class="weui-cell" >
			       <div class="weui-cell__hd"><label for="name" class="weui-label">联系人</label></div>
			       <div class="weui-cell__bd">
			         <input class="weui-input" name="contacts" id="contacts" type="text" value="<%=contacts%>">
			       </div>
			       <img src="../assets/images/add.png" onClick="addContacts()">
			       	
			     </div> 
			     
			</div>
			
			<!-- 
			<div class="button_sp_area" align="center">
		       <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary">新增联系人</a>
		       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		       <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_default">刷新联系人</a>
		    </div> -->
		    
		    <div class="weui-cells weui-cell_select">
			     <div class="weui-cell">
			       <div class="weui-cell__hd"><label for="name" class="weui-label">进展阶段</label></div>
			       <div class="weui-cell__bd">
			         <select class="weui-select" name="stage" id="stage" value="<%=stage%>"required="required">
						<option value="接触阶段">接触阶段</option>
						<option value="方案阶段">方案阶段</option>
						<option value="待签合同阶段">待签合同阶段</option>
						<option value="回款阶段">回款阶段</option>
					</select>
			       </div>
			     </div>
			</div>
			
			<div class="weui-cell weui-cells_form">
				<div class="weui-cell__hd">
					<label class="weui-label">项目预算</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="budget" id="budget" type="text" value="<%=budget %>" required="required" placeholder="若无项目预算直接填写无">
				</div>
			</div>
			
			<div class="weui-cell weui-cells_form">
				<div class="weui-cell__hd">
					<label class="weui-label">意向屏点</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="intention" id="intention" type="text" value="<%=intention %>"required="required" placeholder="请输入意向屏点">
				</div>
			</div>
			
			<div class="weui-cell weui-cells_form">
				<div class="weui-cell__hd">
					<label class="weui-label">折扣</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="discount" id="discount" type="text" value="<%=discount %>" required="required" placeholder="请输入折扣">
				</div>
			</div>
		</div>
		<div class="weui-cells__title"><font size="4" color="black">进展</font></div>
	    <div class="weui-cells weui-cells_form">
	      <div class="weui-cell">
	        <div class="weui-cell__bd">
	          <textarea class="weui-textarea" name="progress" id="progress" placeholder="请输入文本"  rows="3" required="required"><%=progress %></textarea>
	          <div class="weui-textarea-counter"><span class="count">0</span>/500</div>
	        </div>
	      </div>
	    </div>
	    <div class="weui-cells__title"><font size="4" color="black">关键点、难点、及所需支持</font></div>
	    <div class="weui-cells weui-cells_form">
	      <div class="weui-cell">
	        <div class="weui-cell__bd">
	          <textarea class="weui-textarea" name="point" id="point" placeholder="请输入文本" rows="3"  required="required"><%=point %></textarea>
	          <div class="weui-textarea-counter"><span class="count">0</span>/500</div>
	        </div>
	      </div>
	    </div>
	    
	    <div class="weui-cells weui-cells_form" style="display:none">
	      <div class="weui-cell">
	        <div class="weui-cell__bd">
	          <textarea class="weui-textarea" name="advice" id="advice" ><%=advice %></textarea>
	          
	        </div>
	      </div>
	    </div>
		<br>

			<div class="weui-btn-area">
				<a class="weui-btn weui-btn_primary" href="javascript:"
					id="showTooltips">确定</a>
			</div>
			</from>
			<br>
			<br>
			
		<!-- </div> -->
	<script src="../jQuery_WeUI/lib/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/jquery-ui.js"></script>
	<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/assets/jquery.autocomplete.min.js"></script>  --%>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/jquery.cookie.js"></script>
	<script src="../jQuery_WeUI/lib/fastclick.js"></script>
	<script>
	  $(function() {
	    FastClick.attach(document.body);
	    
	    //$('#contacts').prop('selectedIndex', 0);
	    var max = 500;
	    $('.weui-textarea').on('input', function(){
	       var text = $(this).val();
	       var len = text.length;
	       $('.count').text(len);
	       if(len > max){
	         $(this).closest('.weui_cell').addClass('weui_cell_warn');
	       }
	       else{
	         $(this).closest('.weui_cell').removeClass('weui_cell_warn');
	       }
	    });
	    
	   <%--  $("#company").autocomplete(
				  {
		  source: function( request, response ) {
			  alert(request.term);
		      $.ajax({
		      	  type:"post",
		          url: '<%=request.getContextPath()%>/common.do',
		          dataType: "json",
		          data:{
		        	  
		              company_name: request.term
		          },
		          success: function( data ) {
		        	  //alert(data);
		              response( $.map( data, function( item ) {
		                  return {   //lable为下拉列表显示数据源。value为选中放入到文本框的值，这种方式可以自定义显示
		                  	  lable:item,    
		                      value: item
		                  }
		              }));
		          }.focus(function () {
		              $(this).autocomplete("search");
		          }).autocomplete("company")._renderItem = function (ul, item) {
		              return $("<li>")
		                  .append("<div>" + item + "</div>")
		                  .appendTo(ul);
		          }
		      });
		  },
		  minLength: 1
		  /* select: function( event, ui ) { //移动键盘上下键，自动将下拉列表的数据放入到文本框，不过不写这个配置也是可以的，默认就行，具体这个还不知道是做什么
		      $("#userName").val(ui.item.userName);
		  } */
		  }); --%>
	  });

	  //验证是否有字段为空
	  function validateForm() {
		  	var flag=true;
		    var time=$('#time').val();
		  	var company=$('#company').val();
		  	var contacts=$('#contacts').val();
		  	//var select
	        var stage = $('#stage').val();
	        var budget=$('#budget').val();
	        var intention=$('#intention').val();
	        var discount=$('#discount').val();
	        var progress=$('#progress').val();
	        var point=$('#point').val();
	        if(time==""||company==""||contacts==""||stage==""||budget==""||intention==""||discount==""||progress==""||point==""){
	        	/* alert(time==""); */
	        	$.toptip('任何字段都不能为空！');
	        	flag= false;
	        }
	      // 在键盘按下并释放及提交后验证提交表单
	      return flag;
		}
	   
	  //验证cookie是否过期
	  function validateCookie(){
		 var cookie=$.cookie('openid');
		 if(cookie==null){
		    	window.location.href="<%=request.getContextPath() %>/OAuth/oauth_index.jsp";
		    }
	  }
	  
	  //存储当前变量
	  function storage_parameter(){
		    var time=$('#time').val();
		  	var company=$('#company').val();
		  	var contacts=$('#contacts').val();
		  	//var select
	        var stage = $('#stage').val();
	        var budget=$('#budget').val();
	        var intention=$('#intention').val();
	        var discount=$('#discount').val();
	        var progress=$('#progress').val();
	        var point=$('#point').val();
	        var advice=$('#advice').val();
	       
	        var url="http://daily.s1.natapp.cc/Daily/sale/my_daily.jsp?time="+time+
	        		"&company="+company+"&stage="+stage+"&contacts="+contacts+"&budget="+budget+"&intention="+intention+
	        		"&discount="+discount+"&progress="+progress+"&point="+point+"&advice="+advice;
	        return url;
	  }
	  //根据公司查询联系人
	  function queryContacts(){
		  //location.reload(true)  ;
		 /*  var url=storage_parameter();
		  alert(url);
		  window.location.href=url; */
		  //window.location.reload();
		  //initContacts("");
		  var company_name=$('#company').val();
		  if(company_name=="")
		  { 
			  $.toptip('客户公司不能为空！');
			  return "";
			  }
		  $.ajax({
    		     url: '<%=request.getContextPath()%>/writeDaily.do',
    		     data:{"company_name":company_name}, 
    		     type: "get",
    		     dataType : "text",
    		  })
    		  .done(function( data ) {
    			 // alert(data);
    			 document.getElementById('contacts').value=data;
    			 var items=data.split(",");
    			 if(items==""){
    				 $.toast("查询客户公司无相关联系人", "text");
    			 }else {
    				 initContacts(items); 
    			 }
    		  })
    		  .fail(function( xhr, status, errorThrown ) {
    		    //alert( "Sorry, there was a problem!" );
    		    console.log( "Error: " + errorThrown );
    		    console.log( "Status: " + status );
    		    console.dir( xhr );
    		  })
	  }
	  
	  //根据客户公司初始化联系人
	  function initContacts(items){
		  //alert(items);
		  $("#contacts").select({
		    title: "选择联系人",
		    items: items,
		    multi: true,
		    min: 0,
		    max: 10,
		    onChange: function(d) {
		      console.log(this, d);
		    },
		    onClose: function() {
		    	//解决select赋值只能渲染一次的问题
		    	var url=storage_parameter();
				//alert(url);
				window.location.href=url; 
		    },
		    onOpen: function() {
		      console.log("open");
		    },
			  });
	  }
	  function addContacts(){
		  var company=$('#company').val();
		  if(company==""){$.toptip('请输入客户公司');return "";}
		  window.location.href = "<%=request.getContextPath() %>/sale/add_contacts.jsp?company="+company;
	  }
	  $("#showTooltips").click(function() {
		 if(validateForm()==false){
			  return "";
		  } 
		  //cookie验证(验证openid是否存在)
		   validateCookie();
		  
		    var time=$('#time').val();
		  	var company=$('#company').val();
		  	var contacts=$('#contacts').val();
		  	//var select
	        var stage = $('#stage').val();
	        var budget=$('#budget').val();
	        var intention=$('#intention').val();
	        var discount=$('#discount').val();
	        var progress=$('#progress').val();
	        var point=$('#point').val();
	        var advice=$('#advice').val();
	        /* var sex=$('#sex input[name="radio1"]:checked').val(); */
        	 $.ajax({
       		     url: '<%=request.getContextPath()%>/writeDaily.do',
       		     data:{"time":time,"company":company,"contacts":contacts,"stage":stage,
       		    	     "budget":budget,"intention":intention,"discount":discount,"progress":progress,"point":point,"advice":advice}, 
       		     type: "post",
       		     dataType : "json",
       		  })
       		  .done(function( data ) {
       			 //alert(data);
       		     if(data==true){
       		    	
       		    	$.toast("提交成功");
       		    	WeixinJSBridge.call('closeWindow');
       		     }else  if(data==false){
       		    	 //alert("已经注册！请勿重复");
       		    	 $.toast("提交失败", "cancel");
       		    	//window.location.href="<%=request.getContextPath() %>/common/error.jsp";
       		    	//window.location.href="OAuth/error.jsp";
       		     }
       		  })
       		  .fail(function( xhr, status, errorThrown ) {
       		    //alert( "Sorry, there was a problem!" );
       		    console.log( "Error: " + errorThrown );
       		    console.log( "Status: " + status );
       		    console.dir( xhr );
       		  })
	        
	      }); 
	</script>
	<script src="../jQuery_WeUI/js/jquery-weui.js"></script>


	<script>
	/*刷新
	$('.weui-tab__bd-item').pullToRefresh().on('pull-to-refresh', function (done) {
	    var self = this
	    setTimeout(function() {
	      $(self).pullToRefreshDone();
	    }, 2000)
	  }) */
	

	</script>
</body>
</html>
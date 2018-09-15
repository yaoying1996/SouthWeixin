<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<title>意见填写</title>
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
					<input class="weui-input" name="time" id="time" type="datetime-local" value="" readonly="readonly"
						placeholder="">
				</div>
			</div>
	        <div class="weui-cells weui-cells_form">
		     <div class="weui-cell">
		       <div class="weui-cell__hd"><label for="name" class="weui-label">客户公司</label></div>
		       <div class="weui-cell__bd">
		         <input class="weui-input" name="company" id="company" type="text" value="" required="required" readonly="readonly">
		       </div>
		       <!-- <div class="weui-cell__ft">
		          <button class="weui-vcode-btn" onClick="queryContacts()">获取联系人</button>
		        </div> -->
		     </div>
		     
		  </div>
			<div class="weui-cells weui-cells_form"	>
			     <div class="weui-cell" >
			       <div class="weui-cell__hd"><label for="name" class="weui-label">联系人</label></div>
			       <div class="weui-cell__bd">
			         <input class="weui-input" name="contacts" id="contacts" type="text" value="" readonly="readonly">
			       </div>
			       
			       	
			     </div> 
			     
			</div>
			
			<!-- 
			<div class="button_sp_area" align="center">
		       <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary">新增联系人</a>
		       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		       <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_default">刷新联系人</a>
		    </div> -->
		    
		    <div class="weui-cells weui-cells_form">
		     <div class="weui-cell">
		       <div class="weui-cell__hd"><label for="name" class="weui-label">进展阶段</label></div>
		       <div class="weui-cell__bd">
		         <input class="weui-input" name="stage" id="stage" type="text" value="" required="required" readonly="readonly">
		       </div>
		       <!-- <div class="weui-cell__ft">
		          <button class="weui-vcode-btn" onClick="queryContacts()">获取联系人</button>
		        </div> -->
		     </div>
			
			<div class="weui-cell weui-cells_form">
				<div class="weui-cell__hd">
					<label class="weui-label">项目预算</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" readonly="readonly" name="budget" id="budget" type="text" value="" required="required" >
				</div>
			</div>
			
			<div class="weui-cell weui-cells_form">
				<div class="weui-cell__hd">
					<label class="weui-label">意向屏点</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" readonly="readonly" name="intention" id="intention" type="text" value=""required="required">
				</div>
			</div>
			
			<div class="weui-cell weui-cells_form">
				<div class="weui-cell__hd">
					<label class="weui-label">折扣</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" readonly="readonly" name="discount" id="discount" type="text" value="" required="required" >
				</div>
			</div>
		</div>
		<div class="weui-cells__title"><font size="4" color="black">进展</font></div>
	    <div class="weui-cells weui-cells_form">
	      <div class="weui-cell">
	        <div class="weui-cell__bd">
	          <textarea readonly class="weui-textarea"  name="progress" id="progress"   rows="3" required="required"></textarea>
	          
	        </div>
	      </div>
	    </div>
	    <div class="weui-cells__title"><font size="4" color="black">关键点、难点、及所需支持</font></div>
	    <div class="weui-cells weui-cells_form">
	      <div class="weui-cell">
	        <div class="weui-cell__bd">
	          <textarea readonly class="weui-textarea"  name="point" id="point"  rows="3"  required="required"></textarea>
	          
	        </div>
	      </div>
	    </div>
	    
	    <div class="weui-cells__title"><font size="4" color="black">意见</font></div>
	    <div class="weui-cells weui-cells_form">
	      <div class="weui-cell">
	        <div class="weui-cell__bd">
	          <textarea  class="weui-textarea"  name="advice" id="advice"  rows="3"  required="required"></textarea>
	          <div class="weui-textarea-counter"><span class="count">0</span>/500</div>
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
	    
	  
	  });

	   
	  //验证cookie是否过期
	  function validateCookie(){
		 var cookie=$.cookie('openid');
		 if(cookie==null){
		    	window.location.href="<%=request.getContextPath() %>/OAuth/oauth_index.jsp";
		    }
	  }
	  
	
	  $("#showTooltips").click(function() {
		  //cookie验证(验证openid是否存在)
		   validateCookie();
		  
	        var advice=$('#advice').val();
	        if(advice==""){
	        	$.toptip('意见不能为空！');
	        	return "";
	        }
	        /* var sex=$('#sex input[name="radio1"]:checked').val(); */
        	 $.ajax({
       		     url: '<%=request.getContextPath()%>/writeAdvice.do',
       		     data:{"advice":advice}, 
       		     type: "post",
       		     dataType : "json",
       		  })
       		  .done(function( data ) {
       			 //alert(data);
       		     if(data==true){
       		    	
       		    	window.location.href="<%=request.getContextPath() %>/common/success.jsp";
       		    	 
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
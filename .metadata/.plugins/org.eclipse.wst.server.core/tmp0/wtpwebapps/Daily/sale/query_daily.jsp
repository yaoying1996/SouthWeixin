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
<title>我的日报</title>
</head>
<body ontouchstart>


    <header class='demos-header'>
      <!-- <h1 class="demos-title">我的报表</h1> -->
      <div align="center" style="color:red">
      <p>温馨提示：查询成功后，若需要继续查询，</p>
      <p>请先清空当前页面</p>
      </div>
      
    </header>
    <form id="form1">
    
	   <div class="weui-cells weui-cells_form">
      <div class="weui-cell">
        <div class="weui-cell__hd"><label for="date" class="weui-label">起始日期</label></div>
        <div class="weui-cell__bd">
          <input class="weui-input" style="height:40px" id="date1" name="start" type="text">
        </div>
      </div>
    
   
      <div class="weui-cell">
        <div class="weui-cell__hd"><label for="date" class="weui-label">截止日期</label></div>
        <div class="weui-cell__bd">
          <input class="weui-input" style="height:40px" id="date2" name="end" type="text">
        </div>
      </div>
      </div>
      <div class="weui-cells weui-cell_select">
			     <div class="weui-cell">
			       <div class="weui-cell__hd"><label for="name" class="weui-label">客户</label></div>
			       <div class="weui-cell__bd">
			         <select class="weui-select" name="company" id="company" value="" required="required">
					</select>
			       </div>
			     </div>
	</div>
	
	<div class="weui-cells weui-cell_select">
			     <div class="weui-cell">
			       <div class="weui-cell__hd"><label for="name" class="weui-label">进展阶段</label></div>
			       <div class="weui-cell__bd">
			         <select class="weui-select" name="stage" id="stage"  value="" required="required">
			        	 <option value=""></option>
						<option value="接触阶段">接触阶段</option>
						<option value="方案阶段">方案阶段</option>
						<option value="待签合同阶段">待签合同阶段</option>
						<option value="回款阶段">回款阶段</option>
					</select>
			       </div>
			     </div>
			</div>
			
  
	
	<div align="center">
	<a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary" id="showTooltips">查询</a>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary" onClick="refresh()">清空</a>
	</div>
        
        
     
    <!-- <div class="weui-btn-area">
      <a class="weui-btn weui-btn_primary" href="javascript:" id="showTooltips" >清空</a>
      </div>
      <div class="weui-btn-area">
      <a class="weui-btn weui-btn_primary" href="javascript:" onClick="refresh()">清空</a>
      </div> -->
    </form>
    <br>
    
   
        <div class="weui-cells" id="add">
         </div>

    

 
  
<script src="<%=request.getContextPath() %>/jQuery_WeUI/lib/jquery-2.1.4.js"></script>
<script src="<%=request.getContextPath() %>/jQuery_WeUI/lib/fastclick.js"></script>
<script src="<%=request.getContextPath() %>/jQuery_WeUI/js/jquery-weui.js"></script>
<script>
  $(function() {
	//$.toast("温馨提示：查询成功后，若需要继续查询，请先清空当前页面", "text");
    FastClick.attach(document.body);
    initCompany();
  });

</script>

    <script type="text/javascript">
    
    $("#date1").calendar({
        onChange: function (p, values, displayValues) {
          console.log(values, displayValues);
        }
      });
    $("#date2").calendar({
        onChange: function (p, values, displayValues) {
          console.log(values, displayValues);
        }
      });
   //监听ajax成功返回 动态加载元素
    $("#add").on('click','weui-cell weui-cell_access"',function(){
   	 	alert('ok')
   });
    $("#add").on('click','weui-cell__bd weui-cell_primary',function(){
   	 	alert('ok')
   });
    $("#add").on('click','cellsp',function(){
   	 	alert('ok')
   });
    $("#add").on('click','weui-cell__ft',function(){
   	 	alert('ok')
   });
 
    	
   function refresh(){
	   window.location.reload();
   }
    
   function initCompany(){
	   $.ajax({
		    url: '<%=request.getContextPath()%>/initManager.do',
		    type: "post",
		    dataType : "json",
		  })
		  .done(function( data ) {
			  $("#company").append('<option value=""></option>');
		      for(var i = 0; i < data.length; i++) {
		      
		         //添加或者修改用户时让其选择角色框
		         $("#company").append('<option value="' + data[i] + '">' + data[i] +  '</option>');
               
		      }
		     
		  })
		  .fail(function( xhr, status, errorThrown ) {
		    alert( "Sorry, there was a problem!" );
		    console.log( "Error: " + errorThrown );
		    console.log( "Status: " + status );
		    console.dir( xhr );
		  })
   }
   
   function validate(){
		 
	   var start = $('#date1').val();
       var end=$('#date2').val();
       if((start==""&&end!="")||(start!=""&&end=="")){
       	$.toptip('请选择正确的日报查询时间');
       	return false;
       } 
       var company=$('#company').val();
       var stage=$('#stage').val();
       
       if(company==""&&stage==""&&start==""&&end==""){
    	   $.toptip('请输入查询条件');
          	return false;
       }
       return true;
     
   }
   
      $("#showTooltips").click(function() {
		
    	//cookie验证(验证openid是否存在)
		//  alert(validateCookie());
    	  if(!validate()){
    		  return "";
    	  }
        
  	
      
      	 $.ajax({
     		     url: '<%=request.getContextPath()%>/querydaily.do',
     		     data:$("#form1").serialize(), 
     		     type: "post",
     		     dataType : "json",
    
     		  })
     		  .done(function( data ) {
     			//alert(data);
     			if(data==false){
     				
     				window.location.href="<%=request.getContextPath()%>/OAuth/oauth_index.jsp";
     				
     			}else if(data==true){
     		    	
     				 $.toast("查询时间段无日报", "text");
     				 
     		     }else  {
     		    	for(var i=0;i<data.length;i++){
     		    		/* alert(i);
     		    		alert(data[i].company_name); */
     		    	    var time=data[i].create_time;
     				  	var company=data[i].company_name;
     				  	var contacts=data[i].contacts_name;
     			        var stage = data[i].stage;
     			        var budget=data[i].budget;
     			        var intention=data[i].intention;
     			        var discount=data[i].discount;
     			        var progress=data[i].progress;
     			        var point=data[i].point;
     			        var advice=data[i].advice;
     			        
     		    		var url="result_query.jsp?time="+time+
  	        		"&company="+company+"&stage="+stage+"&contacts="+contacts+"&budget="+budget+"&intention="+intention+
  	        		"&discount="+discount+"&progress="+progress+"&point="+point+"&advice="+advice;
     		    		
     		    		$('#add').append('<a class="weui-cell weui-cell_access" href="'+url+'">'
     		    		+'<div class="weui-cell__bd weui-cell_primary"><p class="cellsp">'
     		    		+'日报时间：'+time+'</p></div> <span class="weui-cell__ft"></span></a>');
     		    	
     		    	} 
     		    
     		    	
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
  </body>
</html>
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.30
 * Generated at: 2018-08-30 15:43:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class report_005fmanage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\">\r\n");
      out.write("\r\n");
      out.write("<meta name=\"description\" content=\"Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.\r\n");
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/jQuery_WeUI/lib/weui.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/jQuery_WeUI/css/jquery-weui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/assets/css/demos.css\">\r\n");
      out.write("<title>报表查询</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body ontouchstart>\r\n");
      out.write("\r\n");
      out.write("    <header class='demos-header'>\r\n");
      out.write("      <div align=\"center\" style=\"color:red\">\r\n");
      out.write("      <p>温馨提示：查询成功后，往下滑查看查询结果。</p>\r\n");
      out.write("      <p>若需要继续查询，请先清空当前页面</p>\r\n");
      out.write("       <p>(默认查询时间为一周,导出excel发送到个人邮箱中)</p>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("    </header>\r\n");
      out.write("    \r\n");
      out.write("    <form id=\"form1\">\r\n");
      out.write("   \t\r\n");
      out.write("\t   <div class=\"weui-cells weui-cells_form\">\r\n");
      out.write("      <div class=\"weui-cell\">\r\n");
      out.write("        <div class=\"weui-cell__hd\"><label for=\"date\" class=\"weui-label\">起始日期</label></div>\r\n");
      out.write("        <div class=\"weui-cell__bd\">\r\n");
      out.write("          <input class=\"weui-input\" value=\"\" style=\"height:40px\" id=\"date1\" name=\"start\" type=\"text\">\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("      <div class=\"weui-cell\">\r\n");
      out.write("        <div class=\"weui-cell__hd\"><label for=\"date\" class=\"weui-label\">截止日期</label></div>\r\n");
      out.write("        <div class=\"weui-cell__bd\">\r\n");
      out.write("          <input class=\"weui-input\" id=\"date2\" style=\"height:40px\"name=\"end\" value=\"\" type=\"text\">\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"weui-cells weui-cell_select\">\r\n");
      out.write("\t\t\t     <div class=\"weui-cell\">\r\n");
      out.write("\t\t\t       <div class=\"weui-cell__hd\"><label for=\"name\" class=\"weui-label\">客户</label></div>\r\n");
      out.write("\t\t\t       <div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t\t         <select class=\"weui-select\" name=\"company\" id=\"company\" value=\"\" required=\"required\">\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t       </div>\r\n");
      out.write("\t\t\t     </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write(" \r\n");
      out.write("\t \r\n");
      out.write("\t <div class=\"weui-cells weui-cell_select\">\r\n");
      out.write("\t\t\t     <div class=\"weui-cell\">\r\n");
      out.write("\t\t\t       <div class=\"weui-cell__hd\"><label for=\"name\" class=\"weui-label\">业务员</label></div>\r\n");
      out.write("\t\t\t       <div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t\t         <select class=\"weui-select\" name=\"sale\" id=\"sale\" value=\"\" required=\"required\">\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t       </div>\r\n");
      out.write("\t\t\t     </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("    <div class=\"weui-cells weui-cells_form\" >\r\n");
      out.write("      <div class=\"weui-cell\" style=\"height:40px\">\r\n");
      out.write("        <div class=\"weui-cell__hd\"><label for=\"name\" class=\"weui-label\">部门</label></div>\r\n");
      out.write("        <div class=\"weui-cell__bd\">\r\n");
      out.write("          <input class=\"weui-input\" id=\"department\" type=\"text\"  name=\"department\" value=\"\">\r\n");
      out.write("        </div> \r\n");
      out.write("      </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t<a href=\"javascript:;\" class=\"weui-btn weui-btn_mini weui-btn_primary\" id=\"showTooltips\">查询</a>\r\n");
      out.write("      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("       <a href=\"javascript:;\" class=\"weui-btn weui-btn_mini weui-btn_primary\" onClick=\"excel()\">导出</a>\r\n");
      out.write("        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        <a href=\"javascript:;\" class=\"weui-btn weui-btn_mini weui-btn_primary\" onClick=\"refresh()\">清空</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("    <br>\r\n");
      out.write(" \r\n");
      out.write("        <div class=\"weui-cells\" id=\"add\">\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/jQuery_WeUI/lib/jquery-2.1.4.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/jQuery_WeUI/lib/fastclick.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/jQuery_WeUI/js/jquery-weui.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("  $(function() {\r\n");
      out.write("\t//$.toast(\"温馨提示：查询成功后，若需要继续查询，请先清空当前页面\", \"text\");\r\n");
      out.write("    FastClick.attach(document.body);\r\n");
      out.write("    initCompany();\r\n");
      out.write("    initSale();\r\n");
      out.write("  \r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    \r\n");
      out.write("    var queryData=\"\";\r\n");
      out.write("    var query=\"\";\r\n");
      out.write("    $(\"#date1\").calendar({\r\n");
      out.write("        onChange: function (p, values, displayValues) {\r\n");
      out.write("          console.log(values, displayValues);\r\n");
      out.write("        }\r\n");
      out.write("      });\r\n");
      out.write("    $(\"#date2\").calendar({\r\n");
      out.write("        onChange: function (p, values, displayValues) {\r\n");
      out.write("          console.log(values, displayValues);\r\n");
      out.write("        }\r\n");
      out.write("      });\r\n");
      out.write("    //初始化所有部门\r\n");
      out.write("    $(\"#department\").picker({\r\n");
      out.write("        title: \"请选择查找的部门\",\r\n");
      out.write("        cols: [\r\n");
      out.write("          {\r\n");
      out.write("            textAlign: 'center',\r\n");
      out.write("            values: ['公司领导','行政中心', '数据中心', '财务部', '市场部', '商务部', '渠道部', '销售支持中心', '大客户中心', '销售一部（深圳）', '销售二部', '销售三部', '销售四部','销售五部']\r\n");
      out.write("          }\r\n");
      out.write("        ],\r\n");
      out.write("        onChange: function(p, v, dv) {\r\n");
      out.write("          console.log(p, v, dv);\r\n");
      out.write("        },\r\n");
      out.write("        onClose: function(p, v, d) {\r\n");
      out.write("          console.log(\"close\");\r\n");
      out.write("        }\r\n");
      out.write("      });\r\n");
      out.write("   //监听ajax成功返回 动态加载元素\r\n");
      out.write("    $(\"#add\").on('click','weui-cell weui-cell_access\"',function(){\r\n");
      out.write("   \t \talert('ok')\r\n");
      out.write("   });\r\n");
      out.write("    $(\"#add\").on('click','weui-cell__bd weui-cell_primary',function(){\r\n");
      out.write("   \t \talert('ok')\r\n");
      out.write("   });\r\n");
      out.write("    $(\"#add\").on('click','cellsp',function(){\r\n");
      out.write("   \t \talert('ok')\r\n");
      out.write("   });\r\n");
      out.write("    $(\"#add\").on('click','weui-cell__ft',function(){\r\n");
      out.write("   \t \talert('ok')\r\n");
      out.write("   });\r\n");
      out.write("  //初始化客户信息\r\n");
      out.write("   function initCompany(){\r\n");
      out.write("\t   $.ajax({\r\n");
      out.write("\t\t    url: '");
      out.print(request.getContextPath());
      out.write("/initManager.do',\r\n");
      out.write("\t\t    type: \"post\",\r\n");
      out.write("\t\t    dataType : \"json\",\r\n");
      out.write("\t\t  })\r\n");
      out.write("\t\t  .done(function( data ) {\r\n");
      out.write("\t\t\t  $(\"#company\").append('<option value=\"\"></option>');\r\n");
      out.write("\t\t      for(var i = 0; i < data.length; i++) {\r\n");
      out.write("\t\t      \r\n");
      out.write("\t\t         //添加或者修改用户时让其选择角色框\r\n");
      out.write("\t\t         $(\"#company\").append('<option value=\"' + data[i] + '\">' + data[i] +  '</option>');\r\n");
      out.write("               \r\n");
      out.write("\t\t      }\r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t  })\r\n");
      out.write("\t\t  .fail(function( xhr, status, errorThrown ) {\r\n");
      out.write("\t\t    alert( \"Sorry, there was a problem!\" );\r\n");
      out.write("\t\t    console.log( \"Error: \" + errorThrown );\r\n");
      out.write("\t\t    console.log( \"Status: \" + status );\r\n");
      out.write("\t\t    console.dir( xhr );\r\n");
      out.write("\t\t  })\r\n");
      out.write("   }\r\n");
      out.write("   //初始化业务员姓名\r\n");
      out.write("   function initSale(){\r\n");
      out.write("\t   $.ajax({\r\n");
      out.write("\t\t    url: '");
      out.print(request.getContextPath());
      out.write("/initManager.do',\r\n");
      out.write("\t\t    type: \"get\",\r\n");
      out.write("\t\t    dataType : \"json\",\r\n");
      out.write("\t\t  })\r\n");
      out.write("\t\t  .done(function( data ) {\r\n");
      out.write("\t\t\t  $(\"#sale\").append('<option value=\"\"></option>');\r\n");
      out.write("\t\t      for(var i = 0; i < data.length; i++) {\r\n");
      out.write("\t\t      \r\n");
      out.write("\t\t         //添加或者修改用户时让其选择角色框\r\n");
      out.write("\t\t         $(\"#sale\").append('<option value=\"' + data[i] + '\">' + data[i] +  '</option>');\r\n");
      out.write("              \r\n");
      out.write("\t\t      }\r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t  })\r\n");
      out.write("\t\t  .fail(function( xhr, status, errorThrown ) {\r\n");
      out.write("\t\t    alert( \"Sorry, there was a problem!\" );\r\n");
      out.write("\t\t    console.log( \"Error: \" + errorThrown );\r\n");
      out.write("\t\t    console.log( \"Status: \" + status );\r\n");
      out.write("\t\t    console.dir( xhr );\r\n");
      out.write("\t\t  })\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   function refresh(){\r\n");
      out.write("\t   window.location.reload();\r\n");
      out.write("\t  \r\n");
      out.write("   }\r\n");
      out.write("   function excel(){\r\n");
      out.write("\t   \r\n");
      out.write("\t   if(queryData==\"\"){\r\n");
      out.write("\t\t\t $.toast(\"无报表可导出\", \"text\");\r\n");
      out.write("\t\t\t return \"\";\r\n");
      out.write("\t   }\r\n");
      out.write("\t   var str=JSON.stringify(queryData);\r\n");
      out.write("\t  // alert(str);\r\n");
      out.write("\t\t $.ajax({\r\n");
      out.write("  \t\t     url: '");
      out.print(request.getContextPath());
      out.write("/excel.do',\r\n");
      out.write("  \t\t     type: \"post\",\r\n");
      out.write("  \t\t     dataType : \"json\",\r\n");
      out.write("\t\t\t data:{\"queryData\":str,\"query\":query}\r\n");
      out.write("  \t\t  })\r\n");
      out.write("  \t\t  .done(function( data ) {\r\n");
      out.write("  \t\t\tif(data==true){\r\n");
      out.write("  \t\t\t\t$.toast(\"导出成功\");\r\n");
      out.write("  \t\t\t}else{\r\n");
      out.write("  \t\t\t\t$.toast(\"导出失败\", \"cancel\");\r\n");
      out.write("  \t\t\t}\r\n");
      out.write("  \t\t  })\r\n");
      out.write("  \t\t  .fail(function( xhr, status, errorThrown ) {\r\n");
      out.write("  \t\t    //alert( \"Sorry, there was a problem!\" );\r\n");
      out.write("  \t\t    console.log( \"Error: \" + errorThrown );\r\n");
      out.write("  \t\t    console.log( \"Status: \" + status );\r\n");
      out.write("  \t\t    console.dir( xhr );\r\n");
      out.write("  \t\t  })\r\n");
      out.write("   }\r\n");
      out.write("   //验证cookie是否过期\r\n");
      out.write("\t  function validateCookie(){\r\n");
      out.write("\t\t var cookie=$.cookie('openid');\r\n");
      out.write("\t\t if(cookie==null){\r\n");
      out.write("\t\t    \twindow.location.href=\"");
      out.print(request.getContextPath() );
      out.write("/OAuth/oauth_index.jsp\";\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t   }\r\n");
      out.write("    function validate(){\r\n");
      out.write("\t \r\n");
      out.write("\t   var start = $('#date1').val();\r\n");
      out.write("       var end=$('#date2').val();\r\n");
      out.write("       if((start==\"\"&&end!=\"\")||(start!=\"\"&&end==\"\")){\r\n");
      out.write("       \t$.toptip('请选择正确的日报查询时间');\r\n");
      out.write("       \treturn false;\r\n");
      out.write("       } \r\n");
      out.write("      /*  var company=$('#company').val();\r\n");
      out.write("       var sale=$('#sale').val();\r\n");
      out.write("       var department=$('#department').val();\r\n");
      out.write("       \t  \r\n");
      out.write("       if(company==\"\"&&department==\"\"&&sale==\"\"&&start==\"\"&&end==\"\"){\r\n");
      out.write("    \t   $.toptip('请输入查询条件');\r\n");
      out.write("          \treturn false;\r\n");
      out.write("       } */\r\n");
      out.write("       return true;\r\n");
      out.write("     \r\n");
      out.write("   }\r\n");
      out.write("      $(\"#showTooltips\").click(function() {\r\n");
      out.write("    \t//检查报表的查询条件\r\n");
      out.write("    \t  if(!validate()){\r\n");
      out.write("    \t\t  return \"\";\r\n");
      out.write("    \t  }\r\n");
      out.write("        \r\n");
      out.write("       \t $.ajax({\r\n");
      out.write("      \t\t     url: '");
      out.print(request.getContextPath());
      out.write("/reportAdmin.do',\r\n");
      out.write("      \t\t     data:$(\"#form1\").serialize(), \r\n");
      out.write("      \t\t     type: \"post\",\r\n");
      out.write("      \t\t     dataType : \"json\",\r\n");
      out.write("      \t\t \t async: false\r\n");
      out.write("      \t\t  })\r\n");
      out.write("      \t\t  .done(function( data ) {\r\n");
      out.write("      \t\t\t//alert(\"++++\");\r\n");
      out.write("      \t\t\t\r\n");
      out.write("\t\t\t\tif(data==false){\r\n");
      out.write("      \t\t\t\t\r\n");
      out.write("      \t\t\t\twindow.location.href=\"");
      out.print(request.getContextPath());
      out.write("/OAuth/oauth_index.jsp\";\r\n");
      out.write("      \t\t\t\t\r\n");
      out.write("      \t\t\t}else if(data==true){\r\n");
      out.write("      \t\t\t\t\r\n");
      out.write("      \t\t\t\t $.toast(\"查询时间段无日报\", \"text\");\r\n");
      out.write("       \t\t    \t//window.location.href=\"OAuth/error.jsp\";\r\n");
      out.write("      \t\t    \t\r\n");
      out.write("      \t\t     }else {\r\n");
      out.write("      \t\t    \tvar start = $('#date1').val();\r\n");
      out.write("      \t\t        var end=$('#date2').val();\r\n");
      out.write("      \t\t        var company=$('#company').val();\r\n");
      out.write("      \t\t        var sale=$('#sale').val();\r\n");
      out.write("      \t\t        var department=$('#department').val();\r\n");
      out.write("      \t\t        query=\"查询条件为：    开始时间=\"+start+\" ,截止时间=\"+end+\" ,客户公司=\"+company+\" ,业务员=\"+sale+\" ,部门=\"+department;\r\n");
      out.write("      \t\t    \tqueryData=data;\r\n");
      out.write("      \t\t    \t for(var i=0;i<data.length;i++){\r\n");
      out.write("       \t\t    \t\t// alert(JSON.stringify(data[i]));\r\n");
      out.write("       \t\t    \t\t/* alert(i);\r\n");
      out.write("       \t\t    \t\talert(data[i].company_name); */\r\n");
      out.write("       \t\t    \t    var time=data[i].create_time;\r\n");
      out.write("       \t\t\t\t  \tvar company=data[i].company_name;\r\n");
      out.write("       \t\t\t\t  \tvar contacts=data[i].contacts_name;\r\n");
      out.write("       \t\t\t        var stage = data[i].stage;\r\n");
      out.write("       \t\t\t        var budget=data[i].budget;\r\n");
      out.write("       \t\t\t        var intention=data[i].intention;\r\n");
      out.write("       \t\t\t        var discount=data[i].discount;\r\n");
      out.write("       \t\t\t        var progress=data[i].progress;\r\n");
      out.write("       \t\t\t        var point=data[i].point;\r\n");
      out.write("       \t\t\t        var advice=data[i].advice;\r\n");
      out.write("       \t\t\t       // alert(\"++++\");\r\n");
      out.write("       \t\t\t        var user=data[i].user;\r\n");
      out.write("       \t\t\t       // alert(JSON.stringify(user));\r\n");
      out.write("       \t\t\t        var userOpenid=user.openId;\r\n");
      out.write("       \t\t\t        var userName=user.name;\r\n");
      out.write("       \t\t\t    \r\n");
      out.write("       \t\t    \t\tvar url=\"result_report.jsp?company=\"+company+\"&userName=\"+userName+\"&stage=\"+stage+\"&progress=\"+progress+\"&point=\"+point+\"&advice=\"+advice;\r\n");
      out.write("       \t\t    \t\t\r\n");
      out.write("       \t\t    \t\t$('#add').append('<a class=\"weui-cell weui-cell_access\" href=\"'+url+'\">'\r\n");
      out.write("       \t\t    \t\t+'<div class=\"weui-cell__bd weui-cell_primary\"><p class=\"cellsp\">'\r\n");
      out.write("       \t\t    \t\t+company+'  :  '+userName+'</p></div> <span class=\"weui-cell__ft\"></span></a>');\r\n");
      out.write("       \t\t    \t/* $('#add').append('<div class=\"weui-cells\">  <a class=\"weui-cell weui-cell_access\" href=\"login.jsp?id=123\"'>\r\n");
      out.write("       \t\t    \t$('#add').append('<div class=\"weui-cell__bd weui-cell_primary\"> <p class=\"cellsp\">文字标题</p> </div> <span class=\"weui-cell__ft\"></span> </a> </div>'); */\r\n");
      out.write("       \t\t    \t}  \r\n");
      out.write("      \t\t    \t\r\n");
      out.write("      \t\t     } \r\n");
      out.write("      \t\t  })\r\n");
      out.write("      \t\t  .fail(function( xhr, status, errorThrown ) {\r\n");
      out.write("      \t\t    //alert( \"Sorry, there was a problem!\" );\r\n");
      out.write("      \t\t    console.log( \"Error: \" + errorThrown );\r\n");
      out.write("      \t\t    console.log( \"Status: \" + status );\r\n");
      out.write("      \t\t    console.dir( xhr );\r\n");
      out.write("      \t\t  })\r\n");
      out.write("        \r\n");
      out.write("      });\r\n");
      out.write("        \t \r\n");
      out.write("    </script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

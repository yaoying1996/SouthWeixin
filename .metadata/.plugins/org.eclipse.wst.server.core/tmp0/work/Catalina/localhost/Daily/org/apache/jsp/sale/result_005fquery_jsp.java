/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.30
 * Generated at: 2018-08-29 15:44:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.sale;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class result_005fquery_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<head>\r\n");
      out.write("<!-- <title>我的日报</title> -->\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, user-scalable=no\">\r\n");
      out.write("\r\n");
      out.write("<meta name=\"description\"\r\n");
      out.write("\tcontent=\"Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.\r\n");
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../jQuery_WeUI/lib/weui.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../jQuery_WeUI/css/jquery-weui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../assets/css/demos.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../assets/jquery-ui.css\">\r\n");
      out.write("<!-- <link rel=\"stylesheet\" href=\"../assets/jquery.autocomplete.css\"> -->\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body ontouchstart>\r\n");

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

      out.write("\r\n");
      out.write("\t\t<header class='demos-header'>\r\n");
      out.write("\t\t\t<h1 class=\"demos-title\">我的日报</h1>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\r\n");
      out.write("\t\t<from id=\"form2\">\r\n");
      out.write("\t\t\t<div class=\"weui-cells weui-cells_form\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t<div class=\"weui-cells weui-cells_form\"\t>\r\n");
      out.write("\t\t\t     <div class=\"weui-cell\" >\r\n");
      out.write("\t\t\t       <div class=\"weui-cell__hd\"><label for=\"name\" class=\"weui-label\">时间</label></div>\r\n");
      out.write("\t\t\t       <div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t\t         <input class=\"weui-input\" name=\"time\" id=\"time\" type=\"text\" readonly=\"readonly\" value=\"");
      out.print(time);
      out.write("\">\r\n");
      out.write("\t\t\t       </div>\r\n");
      out.write("\t\t\t       \r\n");
      out.write("\t\t\t       \t\r\n");
      out.write("\t\t\t     </div> \r\n");
      out.write("\t\t\t     \r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t        <div class=\"weui-cells weui-cells_form\">\r\n");
      out.write("\t\t     <div class=\"weui-cell\">\r\n");
      out.write("\t\t       <div class=\"weui-cell__hd\"><label for=\"name\" class=\"weui-label\">客户公司</label></div>\r\n");
      out.write("\t\t       <div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t         <input class=\"weui-input\" name=\"company\" id=\"company\" type=\"text\" readonly=\"readonly\" value=\"");
      out.print(company);
      out.write("\" required=\"required\" >\r\n");
      out.write("\t\t       </div>\r\n");
      out.write("\t\t       \r\n");
      out.write("\t\t     </div>\r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t\t<div class=\"weui-cells weui-cells_form\"\t>\r\n");
      out.write("\t\t\t     <div class=\"weui-cell\" >\r\n");
      out.write("\t\t\t       <div class=\"weui-cell__hd\"><label for=\"name\" class=\"weui-label\">联系人</label></div>\r\n");
      out.write("\t\t\t       <div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t\t         <input class=\"weui-input\" name=\"contacts\" id=\"contacts\" type=\"text\" readonly=\"readonly\" value=\"");
      out.print(contacts);
      out.write("\">\r\n");
      out.write("\t\t\t       </div>\r\n");
      out.write("\t\t\t       \r\n");
      out.write("\t\t\t       \t\r\n");
      out.write("\t\t\t     </div> \r\n");
      out.write("\t\t\t     \r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"weui-cells weui-cells_form\"\t>\r\n");
      out.write("\t\t\t     <div class=\"weui-cell\" >\r\n");
      out.write("\t\t\t       <div class=\"weui-cell__hd\"><label for=\"name\" class=\"weui-label\">进展阶段</label></div>\r\n");
      out.write("\t\t\t       <div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t\t         <input class=\"weui-input\" name=\"stage\" id=\"stage\" type=\"text\" readonly=\"readonly\" value=\"");
      out.print(stage);
      out.write("\">\r\n");
      out.write("\t\t\t       </div>\r\n");
      out.write("\t\t\t       \r\n");
      out.write("\t\t\t       \t\r\n");
      out.write("\t\t\t     </div> \r\n");
      out.write("\t\t\t     \r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"weui-cell weui-cells_form\">\r\n");
      out.write("\t\t\t\t<div class=\"weui-cell__hd\">\r\n");
      out.write("\t\t\t\t\t<label class=\"weui-label\">项目预算</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t\t\t\t<input class=\"weui-input\" name=\"budget\" id=\"budget\" type=\"text\" readonly=\"readonly\" value=\"");
      out.print(budget );
      out.write("\" required=\"required\" >\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"weui-cell weui-cells_form\">\r\n");
      out.write("\t\t\t\t<div class=\"weui-cell__hd\">\r\n");
      out.write("\t\t\t\t\t<label class=\"weui-label\">意向屏点</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t\t\t\t<input class=\"weui-input\" name=\"intention\" id=\"intention\" type=\"text\" readonly=\"readonly\" value=\"");
      out.print(intention );
      out.write("\"required=\"required\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"weui-cell weui-cells_form\">\r\n");
      out.write("\t\t\t\t<div class=\"weui-cell__hd\">\r\n");
      out.write("\t\t\t\t\t<label class=\"weui-label\">折扣</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"weui-cell__bd\">\r\n");
      out.write("\t\t\t\t\t<input class=\"weui-input\" name=\"discount\" id=\"discount\" type=\"text\" readonly=\"readonly\" value=\"");
      out.print(discount );
      out.write("\" required=\"required\" >\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"weui-cells__title\"><font size=\"4\" color=\"black\">进展</font></div>\r\n");
      out.write("\t    <div class=\"weui-cells weui-cells_form\">\r\n");
      out.write("\t      <div class=\"weui-cell\">\r\n");
      out.write("\t        <div class=\"weui-cell__bd\">\r\n");
      out.write("\t          <textarea readonly class=\"weui-textarea\" name=\"progress\" id=\"progress\"   rows=\"3\" required=\"required\">");
      out.print(progress );
      out.write("</textarea>\r\n");
      out.write("\t         \r\n");
      out.write("\t        </div>\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    <div class=\"weui-cells__title\"><font size=\"4\" color=\"black\">关键点、难点、及所需支持</font></div>\r\n");
      out.write("\t    <div class=\"weui-cells weui-cells_form\">\r\n");
      out.write("\t      <div class=\"weui-cell\">\r\n");
      out.write("\t        <div class=\"weui-cell__bd\">\r\n");
      out.write("\t          <textarea readonly class=\"weui-textarea\" name=\"point\" id=\"point\"  rows=\"3\"  required=\"required\">");
      out.print(point );
      out.write("</textarea>\r\n");
      out.write("\t          \r\n");
      out.write("\t        </div>\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    <div class=\"weui-cells__title\"><font size=\"4\" color=\"black\">意见</font></div>\r\n");
      out.write("\t    <div class=\"weui-cells weui-cells_form\">\r\n");
      out.write("\t      <div class=\"weui-cell\">\r\n");
      out.write("\t        <div class=\"weui-cell__bd\">\r\n");
      out.write("\t          <textarea readonly class=\"weui-textarea\" name=\"advice\" id=\"advice\"  rows=\"3\"  required=\"required\">");
      out.print(advice );
      out.write("</textarea>\r\n");
      out.write("\t        \r\n");
      out.write("\t        </div>\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t   \r\n");
      out.write("\t\t<br>\r\n");
      out.write("<br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</from>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<!-- </div> -->\r\n");
      out.write("\t<script src=\"../jQuery_WeUI/lib/jquery-2.1.4.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/assets/jquery-ui.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/assets/jquery.cookie.js\"></script>\r\n");
      out.write("\t<script src=\"../jQuery_WeUI/lib/fastclick.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t  $(function() {\r\n");
      out.write("\t    FastClick.attach(document.body);\r\n");
      out.write("\t    \r\n");
      out.write("\t    //$('#contacts').prop('selectedIndex', 0);\r\n");
      out.write("\t   \r\n");
      out.write("\t    });\r\n");
      out.write("\t    \r\n");
      out.write("\t   \r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script src=\"../jQuery_WeUI/js/jquery-weui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.46
 * Generated at: 2017-09-13 09:03:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>学生信息管理系统主界面</title>\r\n");

	// 权限验证
	if(session.getAttribute("currentUser")==null){
		response.sendRedirect("index.jsp");
		return;
	}

      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jquery-easyui-1.3.3/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"jquery-easyui-1.3.3/themes/icon.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"jquery-easyui-1.3.3/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jquery-easyui-1.3.3/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t// 数据\r\n");
      out.write("\t\tvar treeData=[{\r\n");
      out.write("\t\t\ttext:\"根\",\r\n");
      out.write("\t\t\tchildren:[{\r\n");
      out.write("\t\t\t\ttext:\"班级信息管理\",\r\n");
      out.write("\t\t\t\tattributes:{\r\n");
      out.write("\t\t\t\t\turl:\"gradeInfoManage.jsp\"\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\ttext:\"学生信息管理\",\r\n");
      out.write("\t\t\t\tattributes:{\r\n");
      out.write("\t\t\t\t\turl:\"studentInfoManage.jsp\"\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}]\r\n");
      out.write("\t\t}];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 实例化树菜单\r\n");
      out.write("\t\t$(\"#tree\").tree({\r\n");
      out.write("\t\t\tdata:treeData,\r\n");
      out.write("\t\t\tlines:true,\r\n");
      out.write("\t\t\tonClick:function(node){\r\n");
      out.write("\t\t\t\tif(node.attributes){\r\n");
      out.write("\t\t\t\t\topenTab(node.text,node.attributes.url);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 新增Tab\r\n");
      out.write("\t\tfunction openTab(text,url){\r\n");
      out.write("\t\t\tif($(\"#tabs\").tabs('exists',text)){\r\n");
      out.write("\t\t\t\t$(\"#tabs\").tabs('select',text);\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tvar content=\"<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src=\"+url+\"></iframe>\";\r\n");
      out.write("\t\t\t\t$(\"#tabs\").tabs('add',{\r\n");
      out.write("\t\t\t\t\ttitle:text,\r\n");
      out.write("\t\t\t\t\tclosable:true,\r\n");
      out.write("\t\t\t\t\tcontent:content\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("\t<div region=\"north\" style=\"height: 80px;background-color: #E0EDFF\">\r\n");
      out.write("\t\t<div align=\"left\" style=\"width: 80%;float: left\"><img src=\"images/main.jpg\"></div>\r\n");
      out.write("\t\t<div style=\"padding-top: 50px;padding-right: 20px;\">当前用户：&nbsp;<font color=\"red\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.userName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</font></div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div region=\"center\">\r\n");
      out.write("\t\t<div class=\"easyui-tabs\" fit=\"true\" border=\"false\" id=\"tabs\">\r\n");
      out.write("\t\t\t<div title=\"首页\" >\r\n");
      out.write("\t\t\t\t<div align=\"center\" style=\"padding-top: 100px;\"><font color=\"red\" size=\"10\">欢迎使用</font></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div region=\"west\" style=\"width: 150px;\" title=\"导航菜单\" split=\"true\">\r\n");
      out.write("\t\t<ul id=\"tree\"></ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div region=\"south\" style=\"height: 25px;\" align=\"center\">版权所有<a href=\"http://www.java1234.com\">www.java1234.com</a></div>\r\n");
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

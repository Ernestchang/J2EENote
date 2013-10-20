package org.apache.jsp.WEB_002dINF.views.front;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/front/inc/head.jsp", out, false);
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"/resources/css/front/login.css\">\r\n");
      out.write("<title>账户登录</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/resources/js/front/login.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/front/inc/header.jsp", out, false);
      out.write("\r\n");
      out.write("\t<div data-role=\"content\" id=\"content\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/front/inc/sidebar.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t<div id=\"main\">\r\n");
      out.write("\t\t\t<form id=\"login\">\r\n");
      out.write("\t\t\t\t<h1>账户登陆</h1>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"username\" id=\"username\" pattern=\"[A-z0-9]{5,15}\"\r\n");
      out.write("\t\t\t\t\ttitle=\"用户名由5到15位大小写字母和数字组成\" placeholder=\"用户名\" autofocus required>\r\n");
      out.write("\t\t\t\t<input type=\"password\" name=\"password\" id=\"password\" pattern=\"[A-z0-9]{5,15}\"\r\n");
      out.write("\t\t\t\t\ttitle=\"密码由5到15位大小写字母和数字组成\" placeholder=\"密码\" required>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" data-role=\"button\" data-theme=\"a\" value=\"登陆\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/front/inc/footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

package org.apache.jsp.WEB_002dINF.views.front.inc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("\r\n");
      out.write("<div data-role=\"header\">\r\n");
      out.write("\t<div id=\"pagetop\">\r\n");
      out.write("\t\t<div id=\"sitenav\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"pageheader\">\r\n");
      out.write("\t\t\t<h1>\r\n");
      out.write("\t\t\t\t算法<span>之家</span>\r\n");
      out.write("\t\t\t</h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function() {\r\n");
      out.write("\t$(\"#searchBtn\").click(function() {\r\n");
      out.write("\t\tvar con = $(\"#con\").val();\r\n");
      out.write("\t\tif(con.length > 0) {\r\n");
      out.write("\t\t\twindow.location.href=\"/algorithm/front/find/\" + con + \"?pcid=\" + $(\"#pcid\").val() + \"&page=1\"; \r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\talert(\"请输入查寻条件\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<div style=\"width: 1000px;height: 20px;margin: 0 auto;clear: both;\">\r\n");
      out.write("\t<div style=\"float: right;margin-left: 10px;\">\r\n");
      out.write("\t<input type=\"button\" id=\"searchBtn\" data-inline=\"true\" data-mini=\"true\" data-role=\"button\" data-theme=\"a\" value=\"搜索\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"width: 200px;float: right;\">\r\n");
      out.write("\t<input type=\"hidden\" id=\"pcid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pcid }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t<input type=\"search\" data-inline=\"true\" data-mini=\"true\" id=\"con\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${con }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty loginUser}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<li>您还未登陆</li>\r\n");
        out.write("\t\t\t\t\t<li><a id=\"homeBtnNav\" href=\"/home/front\" data-role=\"button\" data-mini=\"true\"\r\n");
        out.write("\t\t\t\t\t\tdata-inline=\"true\" data-icon=\"home\">主页</a></li>\r\n");
        out.write("\t\t\t\t\t<li><a id=\"loginBtnNav\" href=\"/auth/front/login\" data-role=\"button\"\r\n");
        out.write("\t\t\t\t\t\tdata-mini=\"true\" data-inline=\"true\">登陆</a></li>\r\n");
        out.write("\t\t\t\t\t<li><a id=\"registerBtnNav\" href=\"/user/front/register\" data-role=\"button\"\r\n");
        out.write("\t\t\t\t\t\tdata-mini=\"true\" data-inline=\"true\">注册</a></li>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!empty loginUser }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<li><a id=\"homeBtnNav\" href=\"/home/front\" data-role=\"button\" data-inline=\"true\" data-mini=\"true\" data-icon=\"home\">主页</a></li>\r\n");
        out.write("\t\t\t\t\t<li><a id=\"addQuestionBtnNav\" href=\"/question/front/add\" data-role=\"button\" data-inline=\"true\" data-mini=\"true\">算法提问</a></li>\r\n");
        out.write("\t\t\t\t\t<li><a id=\"addAlgorithmBtnNav\" href=\"/algorithm/front/add\" data-role=\"button\" data-inline=\"true\" data-mini=\"true\">发布算法</a></li>\r\n");
        out.write("\t\t\t\t\t<li>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginUser.username }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</li>\r\n");
        out.write("\t\t\t\t\t<li><a id=\"logoutBtnNav\" href=\"/auth/front/logout\" data-role=\"button\" data-inline=\"true\" data-mini=\"true\">安全退出</a></li>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}

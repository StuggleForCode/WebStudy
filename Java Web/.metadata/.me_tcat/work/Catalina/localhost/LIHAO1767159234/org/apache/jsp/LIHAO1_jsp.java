package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class LIHAO1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>My JSP 'LIHAO1.jsp' starting page</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  \t<h1>潜在用户网络调查</h1>\r\n");
      out.write("    <form action=\"/LIHAO1767159234/LIHAOServlet\" method = \"post\">\r\n");
      out.write("    \t\r\n");
      out.write("    \t<div>\r\n");
      out.write("    \t\t姓名：<input type = \"text\" name = \"lhname\"/>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t\r\n");
      out.write("    \t<div>\r\n");
      out.write("    \t\tEmail：<input type = \"email\" name = \"lhemail\"/>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t<div>\r\n");
      out.write("    \t\t年纪：<input type = \"radio\" name = \"lhage\" value = \"小于18\"/>小于18\r\n");
      out.write("    \t\t<input type = \"radio\" name = \"lhage\" value = \"18-25\"/>18-25\r\n");
      out.write("    \t\t<input type = \"radio\" name = \"lhage\"  value = \"26-40\"/>26-40\r\n");
      out.write("    \t\t<input type = \"radio\" name = \"lhage\" value = \"大于40\"/>大于40\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t\r\n");
      out.write("    \t<div>\r\n");
      out.write("    \t\t编程时间：\r\n");
      out.write("    \t\t<select name = \"lhtime\">\r\n");
      out.write("    \t\t\t<option value = \"1-2年\">1-2年</option>\r\n");
      out.write("    \t\t\t<option value = \"2-3年\">2-3年</option>\r\n");
      out.write("    \t\t\t<option value = \"3-4年\">3-4年</option>\r\n");
      out.write("    \t\t\t<option value = \"4年以上\">4年以上</option>\r\n");
      out.write("    \t\t</select>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t\r\n");
      out.write("    \t<div>\r\n");
      out.write("    \t\t使用的操作系统：\r\n");
      out.write("    \t\t<select multiple=\"multiple\" size=\"5\" name=\"lhOs\">\r\n");
      out.write("\t            <option value=\"WinXP\">WinXP</option>\r\n");
      out.write("\t            <option value=\"Win2000\">Win2000</option>\r\n");
      out.write("\t            <option value=\"FreeBSO\">FreeBSO</option>\r\n");
      out.write("\t            <option value=\"MacOs\">MacOs</option>\r\n");
      out.write("\t            <option value=\"Others\">Others</option>\r\n");
      out.write("       \t\t </select>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t\r\n");
      out.write("    \t<div>\r\n");
      out.write("    \t\t使用的编程语言：\r\n");
      out.write("    \t\t<input type=\"checkbox\" name=\"lhLanguage\" value=\"C\">C\r\n");
      out.write("\t        <input type=\"checkbox\" name=\"lhLanguage\" value=\"C++\">C++\r\n");
      out.write("\t        <input type=\"checkbox\" name=\"lhLanguage\" value=\"C#\">C#\r\n");
      out.write("\t        <input type=\"checkbox\" name=\"lhLanguage\" value=\"Python\">Python\r\n");
      out.write("\t        <input type=\"checkbox\" name=\"lhLanguage\" value=\"Java\">Java\r\n");
      out.write("\t        <input type=\"checkbox\" name=\"lhLanguage\" value=\"VB\">VB\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t\r\n");
      out.write("    \t<div>\r\n");
      out.write("\t    \t 建议:\r\n");
      out.write("\t\t        <textarea name=\"lhAdvice\">\r\n");
      out.write("\t\t       \t\t 我很喜欢编程！\r\n");
      out.write("\t\t\t       \t我也很喜欢交流!\r\n");
      out.write("\t\t        </textarea>\r\n");
      out.write("\t\t\t       \t\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t\r\n");
      out.write("    \t<div><input type = \"submit\" value = \"提交\" /></div>\r\n");
      out.write("    \r\n");
      out.write("    </form>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

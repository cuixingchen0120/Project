/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.57
 * Generated at: 2014-12-11 22:21:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html >\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/round-about.css\" rel=\"stylesheet\">\r\n");
      out.write("<title>RegisterPage</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("function myFunction(){\r\n");
      out.write("\tvar a = document.getElementById(\"noob\").value;\r\n");
      out.write("\tvar b = document.getElementById(\"nooob\").value;\r\n");
      out.write("\tvar c = document.getElementById(\"hehe\").value;\r\n");
      out.write("\tvar d = document.getElementById(\"hehehe\").value;\r\n");
      out.write("\t\r\n");
      out.write("\tif(a==\"\"||b==\"\"||c==\"\"||d==\"\"){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\talert(\"Please fill in all information\")\r\n");
      out.write("\t\r\n");
      out.write("\t}else if(a!= b){\r\n");
      out.write("\t\talert(\"Two password must be equal\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- Navigation -->\r\n");
      out.write("\t<nav class=\"navbar  navbar-inverse\" role=\"navigation\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\"\r\n");
      out.write("\t\t\t\t\tdata-target=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span> \r\n");
      out.write("\t\t\t\t\t\t<span class=\"icon-bar\"></span> \r\n");
      out.write("\t\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\"\r\n");
      out.write("\t\t\t\t\thref=\"http://localhost:8080/neu.edu.cs5200/Login.jsp\">MTG</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse\"\r\n");
      out.write("\t\t\t\tid=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"http://localhost:8080/neu.edu.cs5200/Rules.jsp\">Rules</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"http://localhost:8080/neu.edu.cs5200/SearchByName.jsp\">SearchByName</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"http://localhost:8080/neu.edu.cs5200/RandomACard.jsp\">RandomACard</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"http://localhost:8080/neu.edu.cs5200/AverageRate.jsp\">Top10</a></li>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"http://localhost:8080/neu.edu.cs5200/Login.jsp\">Log\r\n");
      out.write("\t\t\t\t\t\t\tin</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a>|</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"http://localhost:8080/neu.edu.cs5200/Register.jsp\">Register</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.navbar-collapse -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.container -->\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t<h1>Register</h1>\r\n");
      out.write("\t\r\n");
      out.write("\t<form  action=\"/neu.edu.cs5200/RegisterAction\"> \r\n");
      out.write("\t\tUsername:\r\n");
      out.write("\t\t<input id=\"hehe\" name=\"username\" class=\"form-control\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tFirstName(Optional)\r\n");
      out.write("\t\t<input id=\"first\" name=\"firstname\"   class=\"form-control\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tLastName(Optional)\r\n");
      out.write("\t\t<input id=\"last\" name=\"lastname\"   class=\"form-control\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tPassword:\r\n");
      out.write("\t\t<input id=\"noob\" name=\"password\" type=\"password\"  class=\"form-control\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tRe-entered Password\r\n");
      out.write("\t\t<input id=\"nooob\" name=\"repassword\" type=\"password\"  class=\"form-control\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tEmail\r\n");
      out.write("\t\t<input id=\"hehehe\" name=\"email\" type=\"email\"  class=\"form-control\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<button class=\"btn btn-primary\" value=\"submit\" >Submit</button>\r\n");
      out.write("\t</form>\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
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
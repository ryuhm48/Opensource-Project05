/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.39
 * Generated at: 2019-06-05 10:17:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Problems;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AnswerSubmit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <meta name=\"description\" content=\"Online compiler and IDE powered by Judge0 API\">\r\n");
      out.write("  <meta name=\"keywords\" content=\"online compiler, online ide\">\r\n");
      out.write("  <meta name=\"author\" content=\"Herman Zvonimir Došilović\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("  <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\" integrity=\"sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("  <link href=\"https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <script src=\"https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Exo+2\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/codemirror.css\">\r\n");
      out.write("  <script src=\"js/codemirror.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/simple.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/clike.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/clojure.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/crystal.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/elixir.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/erlang.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/go.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/haskell.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/javascript.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/mllike.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/octave.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/pascal.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/python.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/ruby.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/rust.js\"></script>\r\n");
      out.write("  <script src=\"js/mode/shell.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/addon/dialog.css\">\r\n");
      out.write("\r\n");
      out.write("  <script src=\"js/addon/searchcursor.js\"></script>\r\n");
      out.write("  <script src=\"js/addon/search.js\"></script>\r\n");
      out.write("  <script src=\"js/addon/dialog.js\"></script>\r\n");
      out.write("  <script src=\"js/addon/matchbrackets.js\"></script>\r\n");
      out.write("  <script src=\"js/addon/closebrackets.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <script src=\"js/keymap/vim.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/ide.css\">\r\n");
      out.write("  <script src=\"js/ide1.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <title>Judge0 IDE</title>\r\n");
      out.write("  <link rel=\"shortcut icon\" href=\"./favicon.ico\" type=\"image/x-icon\">\r\n");
      out.write("  <link rel=\"icon\" href=\"./favicon.ico\" type=\"image/x-icon\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("  <nav class=\"navbar navbar-default navbar-static-top\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("      <div class=\"navbar-header\">\r\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\">\r\n");
      out.write("          Judge0 IDE\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <ul class=\"nav navbar-nav navbar-left\">\r\n");
      out.write("        <li><a id=\"apiLink\" target=\"_blank\" href=\"\"></a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("      <div class=\"navbar-form navbar-right\">\r\n");
      out.write("        <div class=\"input-group\">\r\n");
      out.write("          <div class=\"input-group-btn\">\r\n");
      out.write("            <button id=\"insertTemplateBtn\" type=\"button\" class=\"btn btn-default\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"Insert template\">\r\n");
      out.write("              <span class=\"glyphicon glyphicon-file\" aria-hidden=\"true\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("          </div>\r\n");
      out.write("          <select class=\"form-control\" id=\"selectLanguageBtn\">\r\n");
      out.write("            <option value=\"1\" mode=\"text/x-sh\">Bash (4.4)</option>\r\n");
      out.write("            <option value=\"2\" mode=\"text/x-sh\">Bash (4.0)</option>\r\n");
      out.write("            <option value=\"3\" mode=\"text/x-pascal\">Basic (fbc 1.05.0)</option>\r\n");
      out.write("            <option value=\"4\" mode=\"text/x-csrc\">C (gcc 7.2.0)</option>\r\n");
      out.write("            <option value=\"5\" mode=\"text/x-csrc\">C (gcc 6.4.0)</option>\r\n");
      out.write("            <option value=\"6\" mode=\"text/x-csrc\">C (gcc 6.3.0)</option>\r\n");
      out.write("            <option value=\"7\" mode=\"text/x-csrc\">C (gcc 5.4.0)</option>\r\n");
      out.write("            <option value=\"8\" mode=\"text/x-csrc\">C (gcc 4.9.4)</option>\r\n");
      out.write("            <option value=\"9\" mode=\"text/x-csrc\">C (gcc 4.8.5)</option>\r\n");
      out.write("            <option value=\"10\" mode=\"text/x-c++src\">C++ (g++ 7.2.0)</option>\r\n");
      out.write("            <option value=\"11\" mode=\"text/x-c++src\">C++ (g++ 6.4.0)</option>\r\n");
      out.write("            <option value=\"12\" mode=\"text/x-c++src\">C++ (g++ 6.3.0)</option>\r\n");
      out.write("            <option value=\"13\" mode=\"text/x-c++src\">C++ (g++ 5.4.0)</option>\r\n");
      out.write("            <option value=\"14\" mode=\"text/x-c++src\">C++ (g++ 4.9.4)</option>\r\n");
      out.write("            <option value=\"15\" mode=\"text/x-c++src\">C++ (g++ 4.8.5)</option>\r\n");
      out.write("            <option value=\"16\" mode=\"text/x-csharp\">C# (mono 5.4.0.167)</option>\r\n");
      out.write("            <option value=\"17\" mode=\"text/x-csharp\">C# (mono 5.2.0.224)</option>\r\n");
      out.write("            <option value=\"18\" mode=\"text/x-clojure\">Clojure (1.8.0)</option>\r\n");
      out.write("            <option value=\"19\" mode=\"text/x-crystal\">Crystal (0.23.1)</option>\r\n");
      out.write("            <option value=\"20\" mode=\"text/x-elixir\">Elixir (1.5.1)</option>\r\n");
      out.write("            <option value=\"21\" mode=\"text/x-erlang\">Erlang (OTP 20.0)</option>\r\n");
      out.write("            <option value=\"22\" mode=\"text/x-go\">Go (1.9)</option>\r\n");
      out.write("            <option value=\"23\" mode=\"text/x-haskell\">Haskell (ghc 8.2.1)</option>\r\n");
      out.write("            <option value=\"24\" mode=\"text/x-haskell\">Haskell (ghc 8.0.2)</option>\r\n");
      out.write("            <option value=\"25\" mode=\"text/plain\">Insect (5.0.0)</option>\r\n");
      out.write("            <option value=\"26\" mode=\"text/x-java\">Java (OpenJDK 9 with Eclipse OpenJ9)</option>\r\n");
      out.write("            <option value=\"27\" mode=\"text/x-java\">Java (OpenJDK 8)</option>\r\n");
      out.write("            <option value=\"28\" mode=\"text/x-java\">Java (OpenJDK 7)</option>\r\n");
      out.write("            <option value=\"29\" mode=\"text/javascript\">JavaScript (nodejs 8.5.0)</option>\r\n");
      out.write("            <option value=\"30\" mode=\"text/javascript\">JavaScript (nodejs 7.10.1)</option>\r\n");
      out.write("            <option value=\"31\" mode=\"text/x-ocaml\">OCaml (4.05.0)</option>\r\n");
      out.write("            <option value=\"32\" mode=\"text/x-octave\">Octave (4.2.0)</option>\r\n");
      out.write("            <option value=\"33\" mode=\"text/x-pascal\">Pascal (fpc 3.0.0)</option>\r\n");
      out.write("            <option value=\"34\" mode=\"text/x-python\">Python (3.6.0)</option>\r\n");
      out.write("            <option value=\"35\" mode=\"text/x-python\">Python (3.5.3)</option>\r\n");
      out.write("            <option value=\"36\" mode=\"text/x-python\">Python (2.7.9)</option>\r\n");
      out.write("            <option value=\"37\" mode=\"text/x-python\">Python (2.6.9)</option>\r\n");
      out.write("            <option value=\"38\" mode=\"text/x-ruby\">Ruby (2.4.0)</option>\r\n");
      out.write("            <option value=\"39\" mode=\"text/x-ruby\">Ruby (2.3.3)</option>\r\n");
      out.write("            <option value=\"40\" mode=\"text/x-ruby\">Ruby (2.2.6)</option>\r\n");
      out.write("            <option value=\"41\" mode=\"text/x-ruby\">Ruby (2.1.9)</option>\r\n");
      out.write("            <option value=\"42\" mode=\"text/x-rustsrc\">Rust (1.20.0)</option>\r\n");
      out.write("            <option value=\"43\" mode=\"text/plain\">Text (plain text)</option>\r\n");
      out.write("          </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        <button class=\"btn btn-success\" id=\"runBtn\" data-loading-text=\"Running...\">\r\n");
      out.write("          <span class=\"glyphicon glyphicon-play\" aria-hidden=\"true\"></span> Submit (F9)\r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"vertical-spacer\"></div>\r\n");
      out.write("        <input type=\"checkbox\" id=\"vimCheckBox\" data-toggle=\"toggle\" data-on=\"Vim Mode On\" data-off=\"Vim Mode Off\" data-onstyle=\"success\">\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("  <form name = \"getSource\" action = \"submitSource.do\" method = \"post\">\r\n");
      out.write("  \t<input type = \"text\" name = \"source\" id = \"source\" style = \"display : none;\">\r\n");
      out.write("  \t<input type = \"text\" name = \"language\" id = \"language\">\r\n");
      out.write("  </form>\r\n");
      out.write("  <div id=\"sourceEditor\"></div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row ioEditors\">\r\n");
      out.write("      <div id=\"inputEditor\" class=\"col-xs-6 col-sm-6 col-md-6 col-lg-6\"></div>\r\n");
      out.write("      <div id=\"outputEditor\" class=\"col-xs-6 col-sm-6 col-md-6 col-lg-6\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("      <div id=\"footer\" class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">\r\n");
      out.write("        <p>\r\n");
      out.write("          © 2017-2019 <a href=\"https://judge0.com\">Judge0</a>,\r\n");
      out.write("          Powered by <a href=\"https://api.judge0.com\">Judge0 API</a>,\r\n");
      out.write("          Available on <a href=\"https://github.com/judge0/ide\">GitHub</a>\r\n");
      out.write("        </p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page  import="com.problem.beans.problem, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest" %>
<%
	problem prodto = (problem)request.getAttribute("problem");
	int problemNum;
	String input;
	if(prodto != null)
	{
		if(prodto.getProblemInput()!=null)
			input = prodto.getProblemInput();
		else
			input = "";
		problemNum = prodto.getProblemNum1();
	}
	else
	{
		input = "";
		problemNum = -1;
	}
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="description" content="Online compiler and IDE powered by Judge0 API">
  <meta name="keywords" content="online compiler, online ide">
  <meta name="author" content="Herman Zvonimir Došilović">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

  <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
  <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

  <link href="https://fonts.googleapis.com/css?family=Exo+2" rel="stylesheet">

  <link rel="stylesheet" href="css/codemirror.css">
  <script src="js/codemirror.js"></script>
  <script src="js/mode/simple.js"></script>
  <script src="js/mode/clike.js"></script>
  <script src="js/mode/clojure.js"></script>
  <script src="js/mode/crystal.js"></script>
  <script src="js/mode/elixir.js"></script>
  <script src="js/mode/erlang.js"></script>
  <script src="js/mode/go.js"></script>
  <script src="js/mode/haskell.js"></script>
  <script src="js/mode/javascript.js"></script>
  <script src="js/mode/mllike.js"></script>
  <script src="js/mode/octave.js"></script>
  <script src="js/mode/pascal.js"></script>
  <script src="js/mode/python.js"></script>
  <script src="js/mode/ruby.js"></script>
  <script src="js/mode/rust.js"></script>
  <script src="js/mode/shell.js"></script>

  <link rel="stylesheet" href="css/addon/dialog.css">

  <script src="js/addon/searchcursor.js"></script>
  <script src="js/addon/search.js"></script>
  <script src="js/addon/dialog.js"></script>
  <script src="js/addon/matchbrackets.js"></script>
  <script src="js/addon/closebrackets.js"></script>

  <script src="js/keymap/vim.js"></script>

  <link rel="stylesheet" href="css/ide.css">
  <script src="js/ide.js"></script>

  <title>Judge0 IDE</title>
</head>

<body>
  <nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="https://ide.judge0.com">
          Judge0 IDE
        </a>
      </div>
      <ul class="nav navbar-nav navbar-left">
        <li><a id="apiLink" target="_blank" href=""></a></li>
      </ul>
      <div class="navbar-form navbar-right">
        <div class="input-group">
          <div class="input-group-btn">
          </div>
          <select class="form-control" id="selectLanguageBtn">
            <option value="1" mode="text/x-sh">Bash (4.4)</option>
            <option value="2" mode="text/x-sh">Bash (4.0)</option>
            <option value="3" mode="text/x-pascal">Basic (fbc 1.05.0)</option>
            <option value="4" mode="text/x-csrc">C (gcc 7.2.0)</option>
            <option value="5" mode="text/x-csrc">C (gcc 6.4.0)</option>
            <option value="6" mode="text/x-csrc">C (gcc 6.3.0)</option>
            <option value="7" mode="text/x-csrc">C (gcc 5.4.0)</option>
            <option value="8" mode="text/x-csrc">C (gcc 4.9.4)</option>
            <option value="9" mode="text/x-csrc">C (gcc 4.8.5)</option>
            <option value="10" mode="text/x-c++src">C++ (g++ 7.2.0)</option>
            <option value="11" mode="text/x-c++src">C++ (g++ 6.4.0)</option>
            <option value="12" mode="text/x-c++src">C++ (g++ 6.3.0)</option>
            <option value="13" mode="text/x-c++src">C++ (g++ 5.4.0)</option>
            <option value="14" mode="text/x-c++src">C++ (g++ 4.9.4)</option>
            <option value="15" mode="text/x-c++src">C++ (g++ 4.8.5)</option>
            <option value="16" mode="text/x-csharp">C# (mono 5.4.0.167)</option>
            <option value="17" mode="text/x-csharp">C# (mono 5.2.0.224)</option>
            <option value="18" mode="text/x-clojure">Clojure (1.8.0)</option>
            <option value="19" mode="text/x-crystal">Crystal (0.23.1)</option>
            <option value="20" mode="text/x-elixir">Elixir (1.5.1)</option>
            <option value="21" mode="text/x-erlang">Erlang (OTP 20.0)</option>
            <option value="22" mode="text/x-go">Go (1.9)</option>
            <option value="23" mode="text/x-haskell">Haskell (ghc 8.2.1)</option>
            <option value="24" mode="text/x-haskell">Haskell (ghc 8.0.2)</option>
            <option value="25" mode="text/plain">Insect (5.0.0)</option>
            <option value="26" mode="text/x-java">Java (OpenJDK 9 with Eclipse OpenJ9)</option>
            <option value="27" mode="text/x-java">Java (OpenJDK 8)</option>
            <option value="28" mode="text/x-java">Java (OpenJDK 7)</option>
            <option value="29" mode="text/javascript">JavaScript (nodejs 8.5.0)</option>
            <option value="30" mode="text/javascript">JavaScript (nodejs 7.10.1)</option>
            <option value="31" mode="text/x-ocaml">OCaml (4.05.0)</option>
            <option value="32" mode="text/x-octave">Octave (4.2.0)</option>
            <option value="33" mode="text/x-pascal">Pascal (fpc 3.0.0)</option>
            <option value="34" mode="text/x-python">Python (3.6.0)</option>
            <option value="35" mode="text/x-python">Python (3.5.3)</option>
            <option value="36" mode="text/x-python">Python (2.7.9)</option>
            <option value="37" mode="text/x-python">Python (2.6.9)</option>
            <option value="38" mode="text/x-ruby">Ruby (2.4.0)</option>
            <option value="39" mode="text/x-ruby">Ruby (2.3.3)</option>
            <option value="40" mode="text/x-ruby">Ruby (2.2.6)</option>
            <option value="41" mode="text/x-ruby">Ruby (2.1.9)</option>
            <option value="42" mode="text/x-rustsrc">Rust (1.20.0)</option>
            <option value="43" mode="text/plain">Text (plain text)</option>
          </select>
        </div>
        <button class="btn btn-success" id="runBtn" data-loading-text="Submitting...">
          <span class="glyphicon glyphicon-play" aria-hidden="true"></span> Submit (F9)
        </button>
        <div class="vertical-spacer"></div>
        <input type="checkbox" id="vimCheckBox" data-toggle="toggle" data-on="Vim Mode On" data-off="Vim Mode Off" data-onstyle="success">
      </div>
    </div>
  </nav>
  	<input type = "text" id = "problemNum" value = "<%= problemNum %>">
  <form action = "answercheck.do" id = "checkAnswer" method = "post">
  	<input type = "text" id = "problemNum1">
  	<input type = "text" id = "sourceOutput">
  	<input type = "text" id = "source">
  	<input type = "text" id = "answerLanguage">
  	<input type = "text" id = "writerName">
  </form>

  <div id="sourceEditor"></div>
	<input type = "text" id = "input" value = "<%= input %>" style = "display : none;">
  <div class="container-fluid">
    <div class="row labels">
    </div>
    <div class="row ioEditors" style = "display : none;">
      <div id="inputEditor" class="col-xs-6 col-sm-6 col-md-6 col-lg-6"></div>
      <div id="outputEditor" class="col-xs-6 col-sm-6 col-md-6 col-lg-6"></div>
    </div>

    <div class="row">
      <div id="footer" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
        <p>
          © 2017-2019 <a href="https://judge0.com">Judge0</a>,
          Powered by <a href="https://api.judge0.com">Judge0 API</a>,
          Available on <a href="https://github.com/judge0/ide">GitHub</a>
        </p>
      </div>
    </div>
  </div>
</body>
</html>

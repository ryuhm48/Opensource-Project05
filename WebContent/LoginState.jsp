<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
 <html>
<head>
<title>게시판</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

	<div style="text-align:right">
		사용자ID : ${id} <input type=button class="btn btn-info" value="로그아웃" OnClick="window.location='logout.do'">
		
	    <nav class="navbar navbar-default">
	    <div class="navbar-header">
	     <button type="button" class="navbar-toggle collapsed" 
	      data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
	      aria-expaned="false">
	       <span class="icon-bar"></span>
	       <span class="icon-bar"></span>
	       <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="index.jsp"><img class=	"logo" src="image/logo.jpeg"></a>
	    </div>
	    <div class="collapse navbar-collapse" id="#bs-example-navbar-collapse-1">
	     <ul class="nav navbar-nav">
	      <li><a href="index.jsp">메인</a></li>
	      <li><a href="bbs.jsp">게시판</a></li>
	     </ul>
	      
	     <ul class="nav navbar-nav navbar-right">
	      <li class="dropdown">
	       <a href="#" class="dropdown-toggle"
	        data-toggle="dropdown" role="button" aria-haspopup="true"
	        aria-expanded="false">접속하기<span class="caret"></span></a>
	       <ul class="dropdown-menu">
	        <li class="active" OnClick="window.location='logout.do'">로그아웃</a></li>

	       </ul>
	      </li>
	     </ul>
	    </div> 
	   </nav>
	   
	   
	   <!-- 애니매이션 담당 JQUERY -->
	   <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
	   <!-- 부트스트랩 JS  -->
	   <script src="js/bootstrap.js"></script>


</body>
</html>
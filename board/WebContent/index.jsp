<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.login.beans.UserBean"%>
<!DOCTYPE html>
<html>
<head>
    
<meta charset="UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width" initial-scale="1">
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="css/bootstrap.min.css">

    <title>Document</title>
    
    <%
    UserBean user = new UserBean();
    user = (UserBean)session.getAttribute("loginUser");
    %>
</head>

<body>
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
      <li><a href="list.do?kind=${1}">게시판</a></li>
     </ul>
      
     <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
       <a href="#" class="dropdown-toggle"
        data-toggle="dropdown" role="button" aria-haspopup="true"
        aria-expanded="false">접속하기<span class="caret"></span></a>
       <ul class="dropdown-menu">
        <li class="active"><a href="LoginForm.jsp">로그인</a></li>
        <li><a href="UserJoin.jsp">회원가입</a></li>
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
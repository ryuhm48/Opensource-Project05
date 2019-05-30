<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>로그인</title>
<script type="text/javascript">
function login(){
	document.form.submit();
}

function cancel(){
	document.form.reset();
}	
</script>
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
</div>
<div class="collapse navbar-collapse" id="#bs-example-navbar-collapse-1">
 <ul class="nav navbar-nav">
  <li><a href="index.jsp">메인</a></li>
  <li><a href="list.jsp">게시판</a></li>
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
<form action="login.do" method="post" name="form">
	<table class="table table-striped table-bordered table-hover">
		<caption style="text-align:center">GROUP STUDY</caption>
		<tr>
			<th>ID</th> 
			<th><input type="text" name="id" /></th>
		</tr>
		<tr>
			<th>PW</th>
			<th><input type="password" name="password" /></th>
		</tr>
		<tr>
			<th></th>
			<th>
				<input type="button" class="btn btn-primary" value="로그인" onClick="login()" />
				<input type="button" class="btn btn-secondary" value="취소" onClick="cancel()" />
				<input type="button" class="btn btn-success" value="회원가입" onClick="window.location='UserJoin.jsp'" />
			</th>
		</tr>
	</table>
</form>
</body>
</html>
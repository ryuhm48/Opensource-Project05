<%@page import="com.login.beans.UserBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="Resources/assets/css/main.css" />
<title>Insert title here</title>
</head>
<body>
<%
String userId = null;
if(session.getAttribute("userId") != null){
userId = (String) session.getAttribute("userId");
}
%>

<div id ="page-wrapper">

	<section id= "header">
		<div class="container">
			<h1 id="Logo"><a href="index.jsp">GROUP STUDY WEB PAGE</a></h1>
			<p> 사용자들끼리 문제를 공유하고 피드백을 공유하고자 만든 사이트 </p>
			<nav id="nav">
				<ul>
					<li><a class="icon fa-home" href="LoginState.jsp"><span>메인</span></a></li>
					<li>
						<a href="#" class="icon fa-bar-chart-o"><span>게시판</span></a>
						<ul>
							<li><a href="#">공지사항</a></li>
							<li><a href="#">자유 게시판</a></li>
							<li><a href="#">자료실</a></li>
						</ul>
					</li>
				
					<li><a class="icon fa-cog" href="#"><span>문제풀이</span></a>
						<ul>
							<li><a href="#">문제풀이</a></li>
							<li><a href="#">문제 피드백</a></li>
						</ul>
					</li>
			
					<li><a class="icon fa-question" href="qna.jsp"><span>Q&A</span></a>
					</li>
					<%
					if(userId == null) {
					%>
					<li class="nav navbar-nav navbar-right">
					<a class="icon fa-bars" href="#"><span>접속하기</span></a>
						<ul class="dropdown-menu">
							<li class="active"><a href="LoginForm.jsp">로그인</a></li>
							<li><a href="UserJoin.jsp">회원가입</a></li>
						</ul>
					</li>
					<%
					}else {
					%>
					<li class="nav navbar-nav navbar-right">
				       <a class="icon fa-bars" href="#"><span>회원관리</span><a>
				       	<ul class="dropdown-menu">
				       		<li class="active" OnClick="window.location='UserUpdateForm.jsp'">회원정보 수정</a></li>
				        </ul>
				    </li>    
					<div style="text-align:right">
					사용자ID : ${userId} <input type=button class="btn btn-info" value="로그아웃" OnClick="window.location='logout.do'">
					</div>
				</ul>
				<%
					}
					%>
			</nav>
		</div>

		
		</section>


<section id="main">
<div class="container">

<form action="userupdate.do" method="post" name="form">
<table class="table table-striped table-bordered table-hover">
	<caption style="text-align:center">회원정보 수정 비밀번호 확인</caption>
	<tr>
		<th>PW</th>
		<th><input type="password" class="form-control" name="pwd" id="inputPassword" placeholder="Password" name="password"></th>
	</tr>
	<tr>
		<th></th>
		<th>
			<input type="submit" class="btn btn-primary" id ="allCheck" value="확인">
			<input type="button" class="btn btn-secondary" value="다시입력" onClick="window.location='UserUpdateForm.jsp'">
			
		</th>
	</tr>
</table>
</form>
</div>
</section>

			<!-- Footer -->
			<section id="footer">
				<div class="container">

				<div id="copyright" class="container">
					<ul class="links">
						<li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
					</ul>
				</div>
			</section>
		
	</div>






<!-- 애니매이션 담당 JQUERY -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
<!-- 부트스트랩 JS  -->
<script src="Resources/assets/js/jquery.min.js"></script>
<script src="Resources/assets/js/jquery.dropotron.min.js"></script>
<script src="Resources/assets/js/browser.min.js"></script>
<script src="Resources/assets/js/breakpoints.min.js"></script>
<script src="Resources/assets/js/util.js"></script>
<script src="Resources/assets/js/main.js"></script>


</body>
</html>

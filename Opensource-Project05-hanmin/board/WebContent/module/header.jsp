<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="../Resources/assets/css/main.css" />
<title>Insert title here</title>
</head>
<body>

<section id= "header">

<div class="container">
	<h1 id="Logo"><a href="../index.jsp">GROUP STUDY WEB PAGE</a></h1>
	<p> 사용자들끼리 문제를 공유하고 피드백을 공유하고자 만든 사이트 </p>
	<nav id="nav">
					<ul>
						<li><a class="icon fa-home" href="../index.jsp"><span>메인</span></a></li>
						<li>
							<a href="#" class="icon fa-bar-chart-o"><span>게시판</span></a>
							<ul>
								<li><a href="list.do?kind=${2}">공지사항</a></li>
								<li><a href="list.do?kind=${1}">자유 게시판</a></li>
								<li><a href="list.do?kind=${5}">스터디 게시판</a></li>
								<li><a href="list.do?kind=${3}">자료실</a></li>
							</ul>
						</li>
					
						<li><a class="icon fa-cog" href="#"><span>문제풀이</span></a>
							<ul>
								<li><a href="#">문제풀이</a></li>
								<li><a href="#">문제 피드백</a></li>
							</ul>
						</li>
				
						<li><a class="icon fa-question" href="list.do?kind=${4}"><span>Q&A</span></a>
						</li>
					
						<li class="nav navbar-nav navbar-right">
						<a class="icon fa-bars" href="#"><span>접속하기</span></a>
							<ul class="dropdown-menu">
								<li class="active"><a href="../LoginForm.jsp">로그인</a></li>
								<li><a href="../UserJoin.jsp">회원가입</a></li>
							</ul>
						</li>
					</ul>
				</nav>
</div>
</section>

<!-- 애니매이션 담당 JQUERY -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
<!-- 부트스트랩 JS  -->
	<script src="../Resources/assets/js/jquery.min.js"></script>
	<script src="../Resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="../Resources/assets/js/browser.min.js"></script>
	<script src="../Resources/assets/js/breakpoints.min.js"></script>
	<script src="../Resources/assets/js/util.js"></script>
	<script src="../Resources/assets/js/main.js"></script>
</body>
</body>
</html>
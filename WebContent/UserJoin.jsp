<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="Resources/assets/css/main.css" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="bootstrap-4.1.3-dist/js/bootstrap.js"></script>
<title>회원가입</title>
</head>
<body>

<div id ="page-wrapper">

<section id= "header">
	<div class="container">
		<h1 id="Logo"><a href="index.jsp">GROUP STUDY WEB PAGE</a></h1>
		<p> 사용자들끼리 문제를 공유하고 피드백을 공유하고자 만든 사이트 </p>
		<nav id="nav">
			<ul>
				<li><a class="icon fa-home" href="index.jsp"><span>메인</span></a></li>
				<li>
					<a href="#" class="icon fa-bar-chart-o"><span>게시판</span></a>
					<ul>
						<li><a href="#">공지사항</a></li>
						<li><a href="#">자유 게시판</a></li>
						<li><a href="#">스터디 게시판</a></li>
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
			
				<li class="nav navbar-nav navbar-right">
				<a class="icon fa-bars" href="#"><span>접속하기</span></a>
					<ul class="dropdown-menu">
						<li><a href="LoginForm.jsp">로그인</a></li>
						<li><a href="UserJoin.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
	</section>
	<section id="main">
		<div class ="container">

		<hr>
		
		<center>
		<section>
		<form method ="post" action ="join.do">
			<h2 style="margin-top: 50px; text-align: center">회원가입</h2>
			<br>
			<br>
			<table width="50%" class="form-group"
				style="margin-left: auto; margin-right: auto;">
				<tr>
					<td colspan="2">
						<div class="form-group">
							<input type="text" class="form-control" id="inputId" name = "userId"
								placeholder="ID">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="form-group">
							<input type="password" class="form-control" id="inputPassword" name = "pwd"
								placeholder="Password">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="form-group">
							<input type="password" class="form-control" id="inputRePassword"
								placeholder="Password-Repeat">
						</div>
					</td>

				</tr>
				<tr>
					<td colspan="2">
						<div class="form-group">
							<input type="text" class="form-control" id="inputName" name = "name"
								placeholder="홍길동">
						</div>
					</td>
				</tr>
				<tr>
					<td><span id="pwCheck"></span></td>
				</tr>
				
				<tr>
					<td colspan="2" style="text-align: center;">
						<div class="btn-group" data-toggle="buttons">
							<label> 
							<input type="radio" name="gender" value="남" checked> 남
							</label> 
							<label> 
							<input type="radio"	name="gender" value="여"> 여
							</label>
						</div>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<div class="form-group">
							<input type="email" class="form-control" id="inputEmail" name = "email"
								placeholder="aaa@.com">
						</div>
					</td>
				</tr>
				<tr>
					<td style="text-align: right"><input type="submit"
						class="btn btn-success" id="allCheck" value="회원가입"></td>
					<td><input type="button" class="btn btn-secondary" value="로그인" OnClick="window.location='LoginForm.jsp'"></td>
				</tr>

			</table>

		</form>
	</section>
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
</body>

<script>
$("#inputRePassword").keyup(function() {
    if ($("#inputPassword").val() == $("#inputRePassword").val()) {
        $("#pwCheck").text("비밀번호가 일치합니다");

    } else {
        $("#pwCheck").text("비밀번호가 다릅니다");

    }
});
$("#allCheck").click(function() {
    if ($("#inputId").val() == "") {
        alert("아이디를 입력하세요.");
        return false;
    }
    if ($("#inputPassword").val() == ""){
        alert("비밀번호를 입력하세요.");
    return false;
    }
    if ($("#inputPassword").val() != $("#inputRePassword").val()) {
        alert("비밀번호확인을 다시하세요.");
        return false;
    }
    if ($("#inputEmail").val() == "") {
        alert("이메일을 넣으세요.");
        return false;
    }
});
</script>
</html>
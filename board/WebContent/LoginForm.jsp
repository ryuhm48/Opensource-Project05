<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 뷰포트 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="Resources/assets/css/main.css" />

<title>로그인</title>
<body>

	<div id="page-wrapper">

		<section id="main">
			<div class="container">
				<form action="login.do" method="post" name="form">
					<table class="table table-striped table-bordered table-hover">
						<caption style="text-align: center">GROUP STUDY</caption>
						<tr>
							<th>ID</th>
							<th><input type="text" class="form-control" name="id"
								id="inputId" name="id" placeholder="ID"></th>
						</tr>
						<tr>
							<th>PW</th>
							<th><input type="password" class="form-control" name="password"
								id="inputPassword" placeholder="Password" name="pwd"></th>
						</tr>
						<tr>
							<th></th>
							<th><input type="submit" class="btn btn-primary"
								id="allCheck" value="로그인"> <input type="button"
								class="btn btn-secondary" value="취소"
								onClick="window.location='LoginForm.jsp'"> <input
								type="button" class="btn btn-success" value="회원가입"
								onClick="window.location='UserJoin.jsp'"></th>
						</tr>
					</table>
				</form>
			</div>
		</section>

	</div>
</body>
	<%@ include file="plugin_js.jsp" %>


<script>
	$("#allCheck").click(function() {
		if ($("#inputId").val() == "") {
			alert("아이디를 입력하세요.");
			return false;
		}
		if ($("#inputPassword").val() == "") {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		document.form.submit();
	});
</script>
</html>
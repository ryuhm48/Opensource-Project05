<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script> 
function writeCheck()
{
var form = document.writeform;

if( form.userId.value!="Success" )
{
alert( "ID가 입력이 안되었습니다." );
form.id.focus();
return;
}
if( !form.pwd.value )
{
alert( "Password가 입력이 안되었습니다." );
form.password.focus();
return;
}
if( !form.name.value )
{
alert( "이름이 입력이 안되었습니다." );
form.name.focus();
return;
}
if( !form.email.value )
{
alert( "이메일이 입력이 안되었습니다." );
form.email.focus();
return;
}

form.submit();
}
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>회원가입</title>
</head>
<body>

	<header>
	<a href="index.jsp"><img class="logo" style="float: left" src="image/logo.jpeg"></a>
	<a class="btn btn-primary" style="float: right" href="index.jsp">메인</a>
	<a class="btn btn-default" style="float: right" href="UserJoin.jsp">회원가입</a>
	<a class="btn btn-primary" style="float: right" href="LoginForm.jsp">로그인</a>

	</header>
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
						<label class="btn btn-secondary active"> <input
							type="radio" name="gender" value="남" autocomplete="off" checked>
							남
						</label> <label class="btn btn-secondary"> <input type="radio"
							name="gender" autocomplete="off" value="여"> 여
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
					class="btn btn-success" id="allCheck" value="Success" OnClick="javascript:writeCheck();"></td>
				<td><input type="button" class="btn btn-secondary" value="돌아가기" OnClick="window.location='LoginForm.jsp'"></td>
			</tr>

		</table>

	</form>
</section>
</body>

</html>
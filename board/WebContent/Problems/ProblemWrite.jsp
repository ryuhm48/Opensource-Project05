<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
int x = (int)request.getAttribute("studyNum");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = text/html; charset="UTF-8">
<title>문제 작성</title>
</head>
<body>
	<h1>문제 작성 화면</h1>
	
	<form action = "problemwrite.do" method = "post">
		<input type = "text" name = "problemNum1" style = "display : none;" value = "<%=x%>"><br/>
		<input type = "text" name = "studyNum" style = "display : none;" value = "1"><br/>
		<input type = "text" name = "problemNum2" style = "display : none;" value = "1"><br/>
		문제 제목<input type = "text" name = "problemName"><br/>
		<input type = "text" name = "problemLanguage" style = "display : none;" value = "C"><br/>
		<input type = "text" name = "writerName" style = "display : none;" value = "${id}"><br/>
		문제 내용<br/><textarea name = "problemContent" rows="15" cols="80"></textarea><br/><br/>
		예제입력(필수 아님)<br/><textarea name = "problemInputEx" rows="15" cols="30"></textarea><br/><br/>
		예제출력(필수 아님)<br/><textarea name = "problemOutputEx" rows="15" cols="30"></textarea><br/><br/>
		문제입력(필수 아님)<br/><textarea name = "problemInput" rows="15" cols="30"></textarea><br/><br/>
		문제출력(필수 아님)<br/><textarea name = "problemOutput" rows="15" cols="30"></textarea><br/><br/>
		<input type = "submit" value = "게시"></br>
	</form>
	
	<p><a href="problemlist.do">목록 보기</a></p>
	
</body>
</html>
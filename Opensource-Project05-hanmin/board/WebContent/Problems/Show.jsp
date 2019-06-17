<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page  import="com.problem.beans.problem, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest" %>
<%
	problem prodto = (problem)request.getAttribute("problem");
	//UserDTO userdto = (UserDTO)request.getAttribute("user"); 유저 정보를 받는다.
	int problemNum;
	int studyNum;
	String problemName;
	String problemContent;
	String problemInputEx;
	String problemOutputEx;
	if(prodto != null)
	{
		if(prodto.getProblemName()!=null)
			problemName = prodto.getProblemName();
		else
			problemName = "";
		if(prodto.getProblemContent()!=null)
			problemContent = prodto.getProblemContent();
		else
			problemContent = "";
		if(prodto.getProblemInputEx()!=null)
			problemInputEx = prodto.getProblemInputEx();
		else
			problemInputEx = "";
		if(prodto.getProblemOutputEx()!=null)
			problemOutputEx = prodto.getProblemOutputEx();
		else
			problemOutputEx = "";
		problemNum = prodto.getProblemNum1();
		studyNum = prodto.getStudyNum();
	}
	else
	{
		studyNum = -1;
		problemName = "";
		problemContent = "";
		problemNum = 0;
		problemInputEx = "";
		problemOutputEx = "";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = text/html; charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<script>
			var a = "";
			a = "<%= problemName %>";
			document.write(""+ a);
		</script>
	</h2></br>
	<div><pre><%= problemContent %></pre></div>
	<div><pre><%= problemInputEx %></pre></div>
	<div><pre><%= problemOutputEx %></div>
	<form action = "Delete.do" method = "post"><!-- 문제를 삭제하기 위한 form -->
		<input type = "text" name = "problemNum1" id = "problemNum1" style = "display : none" value = "<%= problemNum %>">
		<!-- 유저 정보를 받는 보이지 않는 input태그를 생성한다. -->
		<input type = "button" value = "삭제하기"><!-- 누르면 유저가 작성자인지 판별 후, 아니라면 작성자만이 문제를 삭제할 수 있다는 메시지 출력, 작성자면 삭제, 출력 화면으로 이동 -->
	</form>
	<form action = "answer.do" method = "post">
		<input type = "text" name = "problemNum" id = "problemNum" style = "display : none" value = "<%= problemNum %>">
		<input type = "submit" value = "문제 풀기">
	</form>
	<form action = "problemlist.do" method = "post">
		<input type = "text" name = "studyNum" id = "studyNum" style = "display : none" value = "<%= studyNum %>">
		<input type = "submit" value = "목록으로 돌아가기">
	</form>
</body>
</html>
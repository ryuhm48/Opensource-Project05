<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page  import="com.problem.beans.problem, java.util.ArrayList, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest" %>
<%
	ArrayList<problem> list = (ArrayList)request.getAttribute("list");
	int studyNum = 1;
	if(list!=null)
	{
		int a = list.size();
		if(a > 0)
			studyNum = list.get(0).getStudyNum();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = text/html; charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>문제 목록 보기</h1>
	
	<table border="1" id = "tt">
		<tr>
			<td colspan = "5">
				<form action = "search.do" method = "post">
					<select name = "searchName" size = "1">
						<option value = "author">작성자</option>
						<option value = "title">글제목</option>
					</select>
					<input type = "text" name = "searchValue">
					<input type = "submit" value = "찾기">
				</form>
			</td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<%
				if(list != null)
				{
					int a = list.size();
					if(a > 0)
					{	
						studyNum = (list.get(0)).getStudyNum();
						for(problem dto : list)
						{	
							out.println("<tr>");
							out.println("<td style = 'display : none'>"+dto.getProblemNum1()+"</td>");
							out.println("<td>"+dto.getProblemNum2()+"</td>");
							out.println("<td><a onclick = 'doAnswer(this);'>"+dto.getProblemName()+"</a></td>");
							out.println("<td>"+dto.getWriterName()+"</td>");
							out.println("<td>"+dto.getProblemDate()+"</td>");
							out.println("</tr>");
						}
					}
				}
			%>
	</table>
	<form action = "problemcontent.do" method = "post">
		<input type = "text" name = "problemNum" id = "problemNum" style = "display : none">
	</form>
	<script>
		function doAnswer(a){
			var c = a.parentNode.parentNode.children[0].innerText;
			var f = document.getElementById("problemNum");
			f.value ="" + c;
			f.parentNode.submit();
		}
	</script>
	<form action = "problemwriteform.do" id = "write" method = "get">
		<input type = "text" name = "studyNum" value = "<%= studyNum %>" style = "display : none">
	</form>
	<a onclick = "document.getElementById('write').submit();">글쓰기</a>
</body>
</html>
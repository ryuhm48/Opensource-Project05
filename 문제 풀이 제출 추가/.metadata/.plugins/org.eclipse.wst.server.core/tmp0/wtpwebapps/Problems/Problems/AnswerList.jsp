<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page  import="Problem.AnswerDTO, Problem.ProblemDAO, java.util.ArrayList, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest" %>
<%
	ArrayList<AnswerDTO> list = (ArrayList)request.getAttribute("list");
	int studyNum = (int)request.getAttribute("studyNum");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = text/html; charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>답안 목록 보기</h1>
	
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
			<td>사용 언어</td>
			<td>작성자</td>
			<td>정답 여부</td>
		</tr>
		<%
			if(list != null)
			{
				int a = list.size();
				if(a > 0)
				{
					for(AnswerDTO dto : list)
					{	
						out.println("<tr><center>");
						out.println("<td>"+dto.getProblemNum1()+"</td>");
						out.println("<td style = 'display : none'>"+dto.getAnswerCode()+"</td>");
						out.println("<td>"+dto.getAnswerLanguage()+"</td>");
						out.println("<td>"+dto.getWriterName()+"</td>");
						out.println("<td>");
						if(dto.getProblemCorrection())
							out.println("정답"+"</td>");
						else
							out.println("오답"+"</td>");
						out.println("</center></tr>");
					}
				}
			}
		%>
	</table>
	<form action = "list.do">
		<input type = "studyNum" value = "<%= studyNum %>" style = "display : none;">
		<input type = "submit" value = "문제 목록으로">
	</form>
</body>
</html>
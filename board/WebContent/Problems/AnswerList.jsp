<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page  import="com.answer.beans.answer, java.util.ArrayList, javax.servlet.http.HttpServlet, javax.servlet.http.HttpServletRequest" %>
<%
	ArrayList<answer> list = (ArrayList)request.getAttribute("list");
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
						for(answer dto : list)
						{	
							out.println("<tr>");
							out.println("<td style = 'display : none'>"+dto.getProblemNum1()+"</td>");
							out.println("<td style = 'display : none'>"+dto.getAnswerCode()+"</td>");
							out.println("<td>"+dto.getWriterName()+"</td>");
							out.println("<td><a onclick = 'doAnswer(this);'>"+dto.getAnswerLanguage()+"</a></td>");
							out.println("<td>"+dto.getWriterName()+"</td>");
							out.println("<td>"+dto.getProblemCorrection()+"</td>");
							out.println("</tr>");
						}
					}
				}
			%>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
 <html>
<head>
<title>게시판</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<div style="text-align:right">
	사용자ID : ${id} <input type=button class="btn btn-info" value="로그아웃" OnClick="window.location='logout.do'">
	</div>
	<c:forEach items="${studyList}" var="study">
	<table class="table table-striped table-bordered table-hover" style="text-align:center">
		<caption style="text-align:center">스터디 그룹</caption>
		<tr>
			<td>스터디명</td>
			<td style="text-align:left">${study.name}</td>			
		</tr>
		<tr>
			
			<td>관리자</td>
			<td style="text-align:left">${study.administor}</td>						
		</tr>
		<tr>
			<td>소개</td>
			<td style="text-align:left">${study.inform}</td>						
		</tr>
		<tr>
			<td>멤버</td>
			<td style="text-align:left"><a href="studymemberlist.do?num=${study.num}">
			보러가기</a></td>					
		</tr>
		
		
	</table>
	<div style="text-align:right">
		<input type=button class="btn btn-danger" value="문제풀기" OnClick="window.location='delete.do?num=${study.num}&kind=${5}'">
		<input type=button class="btn btn-warning" value="탈퇴하기" OnClick="window.location='modifyform.do?num=${study.num}&kind=${5}'">			
		<input type=button class="btn btn-secondary" value="돌아가기" OnClick="window.location='list.do?kind=${5}'">
	</div>
	</c:forEach>		
</body>
</html>
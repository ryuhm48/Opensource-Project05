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
	<table class="table table-striped table-bordered table-hover">
		<caption style="text-align:center">게시판</caption>
		<tr>
			<th style="text-align:center">번호</th>
			<th style="text-align:center">스터디명</th>
			<th style="text-align:center">관리자</th>
			<th style="text-align:center">소개</th>
		</tr>
			
			<c:forEach items="${studyList}" var="study">
		<tr>
			<th style="text-align:center">${study.num}</th>
			<th style="text-align:left"><a href="content.do?num=${study.num}&kind=${2 }">
			${study.name}</a></th>
			<th style="text-align:center">${study.administor}</th>
			<th style="text-align:center">${study.inform}</th>			
		</tr>
		</c:forEach>
		</table>				
			<div style="text-align:right">
				<input type=button class="btn btn-success" value="작성하기" OnClick="window.location='personalstudywriteform.jsp'">
			</div>
			<div style="text-align:right">
				<input type=button class="btn btn-success" value="리스트 이동" OnClick="window.location='list.do?num=$kind=${1 }'">
			</div>
			<div id="searchForm" style="text-align:center">
				<form>
					<select name="opt">
						<option value="0">제목</option>
						<option value="1">내용</option>
						<option value="2">작성자</option>
					</select>
					<input type="text" size="20" name="condition"/>
					<input class="btn btn-secondary" type="submit" value="검색"/>
				</form>
			</div>
</body>
</html>
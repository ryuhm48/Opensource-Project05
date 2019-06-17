<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style>
.section {
	width: 1280px;
	margin-left: auto;
	margin-right: auto;
	margin: 70px auto;
}

.header {
	text-align: center;
	margin-bottom: 40px;
}

.footer {
	text-align: center;
	margin-bottom: -50px;
}

.article {
	float: right;
	margin-bottom: 20px;
}
</style>
<body>


<div class="container" style="text-align:right">
	사용자ID : ${id} <input type=button class="btn btn-info" value="로그아웃" OnClick="window.location='logout.do'">
</div>

<section class="section w3-container">
	<header class="header">
	<h2>공지사항</h2>
	</header>
	<!-- 관리자일때만 글쓰기 -->
	<article class="article">
		<c:if test="${userdb.admin==3 }">
				<a class="w3-button w3-light-gray w3-border-0 w3-round"
					href="addNotice.jsp">글쓰기</a>
		</c:if>
	</article>
	<table class="list w3-table-all w3-striped w3-centered">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>조회수</th>
	</tr>
		
		<c:forEach items="${articleList}" var="article">
	<tr>
		<th style="text-align:center">${article.num}</th>
		<th style="text-align:left"><a href="content.do?num=${article.num}">
		${article.subject}</a></th>
		<th style="text-align:center">${article.id}</th>
		<th style="text-align:center">${article.boarddate}</th>
		<th style="text-align:center">${article.score}</th>			
	</tr>
	</c:forEach>
	</table>				
	<div style="text-align:right">
	<input type="button" class="btn btn-success" value="작성하기" OnClick="window.location='addNotice.jsp'">
</div>
<div">
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
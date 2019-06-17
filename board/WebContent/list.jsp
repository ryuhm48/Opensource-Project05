<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>게시판</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>
</head>

<body>
	
	<section class="section w3-container">
		<header class="header">
			<h2>자유게시판</h2>
		</header>
		<article class="article">
			<a class="w3-button w3-light-gray w3-border-0 w3-round"
				href="writeform.jsp">글쓰기</a>
		</article>
		<table class="list w3-table-all w3-striped w3-centered">
			<colgroup>
				<col style="width: 5%">
				<col style="width: 40%">
				<col style="width: 10%">
				<col style="width: 10%">
				<col style="width: 5%">
				<col style="width: 5%">
			</colgroup>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

			<c:forEach items="${articleList}" var="article">
				<tr>
					<th style="text-align: center">${article.num}</th>
					<th style="text-align: left"><a
						href="content.do?num=${article.num}"> ${article.subject}</a></th>
					<th style="text-align: center">${article.id}</th>
					<th style="text-align: center">${article.boarddate}</th>
					<th style="text-align: center">${article.score}</th>
				</tr>
			</c:forEach>

		</table>
		<br> <br>
	</section>
	<div id="searchForm" style="text-align: center">
		<form>
			<select name="opt">
				<option value="0">제목</option>
				<option value="1">내용</option>
				<option value="2">작성자</option>
			</select> <input type="text" size="20" name="condition" /> <input
				class="btn btn-secondary" type="submit" value="검색" />
		</form>
	</div>
</body>
</html>
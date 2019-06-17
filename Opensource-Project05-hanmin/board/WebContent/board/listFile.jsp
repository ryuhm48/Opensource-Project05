<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
function doDisplay(num){
    var con = document.getElementById(num);
    if(con.style.display=='none'){
        con.style.display = '';
        
    }else{
        con.style.display = 'none';
    }
}

</script>
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
	margin-bottom: -100px;
}

.article {
	float: right;
	margin-bottom: 20px;
}
</style>
</head>
<c:choose>
	<c:when test="${ber==''}">
		<body>
	</c:when>
	<c:otherwise>
		<body onload="javascript:doDisplay(${ber})">
	</c:otherwise>
</c:choose>
<div style="text-align:right">
		사용자ID : ${id} <input type=button class="btn btn-info" value="로그아웃" OnClick="window.location='logout.do'">
</div>
<section class="section w3-container">
		<header class="header">
			<h2>자료실</h2>
		</header>
		<article class="article">
			<a class="w3-button w3-light-gray w3-border-0 w3-round"
				href="fileWrite.jsp">글쓰기</a>
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
					<th style="text-align:center">${article.num}</th>
					<th style="text-align:left"><a href="content.do?num=${article.num}">
					${article.subject}</a></th>
					<th style="text-align:center">${article.id}</th>
					<th style="text-align:center">${article.boarddate}</th>
					<th style="text-align:center">${article.score}</th>			
				</tr>
				</c:forEach>
					
			</tbody>
		</table>
		<br> <br>
</section>

</body>
</html>
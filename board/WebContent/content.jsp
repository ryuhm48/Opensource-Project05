<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${freeBoard.title }</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
var httpRequest = null;

// httpRequest 객체 생성
function getXMLHttpRequest(){
    var httpRequest = null;

    if(window.ActiveXObject){
        try{
            httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
        } catch(e) {
            try{
                httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e2) { httpRequest = null; }
        }
    }
    else if(window.XMLHttpRequest){
        httpRequest = new window.XMLHttpRequest();
    }
    return httpRequest;    
}

	function deleteReply(num)
	{
		var param="num=" + num;

        httpRequest = getXMLHttpRequest();
        httpRequest.onreadystatechange = checkFunc;
        httpRequest.open("POST", "delete.do", true);    
        httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=UTF-8'); 
        httpRequest.send(param);
    }
	
    function checkFunc(){
        if(httpRequest.readyState == 4){
            // 결과값을 가져온다.
            var resultText = httpRequest.responseText;
            if(resultText == 1){ 
                document.location.reload(); // 상세보기 창 새로고침
            }
        }
    }
</script>


</head>

<body>
		
	<c:forEach items="${articleList}" var="article">
	<section class="section w3-container">

		<header class="header">
		
			<h1>${article.subject }</h1>
		
		</header>
		<div align="center">
			<table class="w3-table w3-bordered w3-border">
				<tr>
				
					<th class="w3-light-gray">번호</th>
					<td>${article.num }</td>
						
				</tr>
				<tr>
					<th class="w3-light-gray">작성자</th>
					<td>${article.id }</td>
				</tr>
				<tr>
					<th class="w3-light-gray">작성일</th>
					<td>${article.boarddate}</td>
				</tr>
				<tr>
					<th class="w3-light-gray">조회수</th>
					<td>${article.score}</td>
				</tr>
				<tr>
					<th class="w3-light-gray">내용</th>
					<td><textarea cols="70" rows="15" readonly>${article.content}</textarea>
					</td>
				</tr>
			</table>
		</div>
		<br>
		<footer class="footer">
			<c:if test="${id == article.id}">
				<input type="button"
					class="w3-button w3-light-gray w3-border-0 w3-round" value="수정"
					onclick="location.href='modifyform.do?num=${article.num}&kind=${1}'">

				<input type="button"
					class="w3-button w3-light-gray w3-border-0 w3-round" value="삭제"
					onclick="location.href='delete.do?num=${article.num}&kind=${1}'">
			</c:if>
			<input type="button"
				class="w3-button w3-light-gray w3-border-0 w3-round" value="게시글 리스트"
				onclick="location.href='list.do?kind=${1}'">
			<input type="button"
				class="w3-button w3-light-gray w3-border-0 w3-round" value="글쓰기"
				onclick="window.location='writeform.jsp'">
		</footer>
		
	</section>
	</c:forEach>

	
</body>
</html>


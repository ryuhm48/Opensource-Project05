<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
        httpRequest.open("POST", "delete.co", true);    
        httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=EUC-KR'); 
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
	<div style="text-align: right">
		사용자ID : ${id} <input type=button class="btn btn-info" value="로그아웃"
			OnClick="window.location='logout.do'">
	</div>

	<c:forEach items="${articleList}" var="article">
		<table class="table table-striped table-bordered table-hover"
			style="text-align: center">
			<caption style="text-align: center">게시판</caption>
			<tr>
				<td>제목</td>
				<td style="text-align: left">${article.subject}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td style="text-align: left">${article.id}</td>
			</tr>
			<tr>
				<td>작성일자</td>
				<td style="text-align: left">${article.boarddate}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td style="text-align: left">${article.score}</td>
			</tr>
			<tr>
				<td>email</td>
				<td style="text-align: left">${article.email}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td style="text-align: left">${article.content}</td>
			</tr>

		</table>
		<div style="text-align: right">
			<input type=button class="btn btn-danger" value="삭제하기"
				OnClick="window.location='delete.do?num=${article.num}&kind=${1}'">
			<input type=button class="btn btn-warning" value="수정하기"
				OnClick="window.location='modifyform.do?num=${article.num}&kind=${1}'">
			<input type=button class="btn btn-secondary" value="돌아가기"
				OnClick="window.location='list.do?kind=${1}'">
		</div>
		<form action="reply.do" method="post">
			<input type="hidden" name="num" value="${article.num}">
			<textarea name="reply" cols="40" rows="8"></textarea>
			<input type="submit" value="등록">
		</form>
	</c:forEach>
	<!-- 댓글 -->
	
	<table border="1" width="200">
		<c:forEach items="${replyList}" var="reply">
			<tr>
				<td>${reply.text}<a href="#"
					onclick="deleteReply(${reply.num})">[삭제]</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>
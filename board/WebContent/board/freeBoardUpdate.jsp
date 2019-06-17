<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글수정 페이지</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>게시글 수정</h1>
<form action="BoardServlet" method="post" name="frm">
	<input type="hidden" name="command" value="free_board_update"/>
	<input type="hidden" name="num" value="${freeBoard.num }"/>
	<table>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${freeBoard.title }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="70" rows="15" name="content">${freeBoard.content }</textarea></td>
		</tr>
	</table>
	<br>
	<br>					
	<input type="submit" value="수정" onclick="return boardCheck()"/>
	<input type="reset" value="다시작성" />
	<input type="button" value="목록보기" onclick="location.href='BoardServlet?command=free_board_list'"/>
</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제 확인페이지</title>
<link rel="stylesheet" type="text/css" href="css/board.css"> 
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<div align="center">
	<h1>해당 게시물을 정말로 삭제하시겠습니까?</h1>
	<input type="button" value="예" 
	onclick="location.href='BoardServlet?command=free_board_delete_form&num='${param.num }''">
	<input type="button" value="아니오" 
	onclick="location.href='BoardServlet?free_board_view&num='${param.num }''">
	</div>

</body>
</html>
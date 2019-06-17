<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <script> 
		function writeCheck()
		  {
		   var form = document.writeform;
		   
		  if( !form.subject.value )
		   {
		    alert( "제목을 적어주세요" );
		    form.subject.focus();
		    return;
		   }
		 
		  if( !form.content.value )
		   {
		    alert( "내용을 적어주세요" );
		    form.content.focus();
		    return;
		   }  
		 
		  form.submit();
		  }
 	</script>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>
	<title>BOARD 테이블 레코드 삽입</title>
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
<body>

<h1>게시글 수정</h1>
<form action="/board/modify.do" method="get">
	<input type="hidden" name="command" value="free_board_update"/>
	<input type="hidden" name="num" value="${article.num }"/>
	<input type="hidden" name="kind" value="${kind}">
	<table>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${article.subject }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="70" rows="15" name="content">${article.content }</textarea></td>
		</tr>
	</table>
	<br>
	<br>					
	<input type="submit" value="수정" onclick="javascript:writeCheck();"/>
	<input type="reset" value="다시작성" />
	<input type="button" value="목록보기" onclick="window.location='content.do?num=${article.num}&kind=${2}'"/>
</form>
</div>
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <script> 
		function writeCheck()
		  {
		   var form = document.writeform;
		   
		  if( !form.name.value )
		   {
		    alert( "이름을 적어주세요" );
		    form.subject.focus();
		    return;
		   }
		 
		  if( !form.inform.value )
		   {
		    alert( "정보를 적어주세요" );
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
	<title>BOARD2 테이블 레코드 삽입</title>
</head>
<body>

	<form action ="/board/modify.do" method="get">
		<c:forEach items="${studyList}" var="study">
			<input type="hidden" name="num" value="${study.num}">
			<input type="hidden" name="kind" value=5>
		
			<table class="table table-striped table-bordered table-hover" style="text-align:center">
				<caption style="text-align:center">스터디 수정</caption>		
				<tr>
					<td>제목</td>
					<td style="text-align:left"><input type="text" name="name" value="${study.name}"></td>
				</tr>
				<tr>	
					<td>작성자</td>
					<td style="text-align:left">${study.administor}</td>
				</tr><!-- 멤버구현해야댐 -->
				<tr>	
					<td>내용</td>
					<td style="text-align:left"><textarea name="inform" rows="10" placeholder="내용을 입력하세요" form="inform">${study.inform}</textarea></td>
				</tr>	
				<tr>
					<td></td>
					<td style="text-align:right">
						<input type=submit class="btn btn-warning" value="수정" Onclick="javascript:writeCheck();">
						<input type=button class="btn btn-secondary" value="취소" OnClick="window.location='content.do?num=${study.num}&kind=${5}'">
					</td>
				</tr>	
			</table>
		</c:forEach>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <script> 

function writeCheck()
  {
   var form = document.writeform;
   
  if( !form.name.value )
   {
    alert( "스터디명을 적어주세요" );
    
    form.name.focus();
    return;
   }
 
  if( !form.inform.value )
   {
    alert( "소개를 적어주세요" );
    form.inform.focus();
    return;
   }  
 	alert(form.name.value+form.inform.value);
  form.submit();
  }
 </script>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>BOARD 테이블 레코드 삽입</title>
</head>
<body>
	
	<form id="inform" action ="/board/write.do" method="post">
		<input type="hidden" name="kind" value="${5}">
		<table style="text-align:center" class="table table-striped table-bordered table-hover">
			<caption style="text-align:center">게시판 작성</caption>
			<tr >
				<th>스터디명</th>
				<th style="text-align:left"><input type="text" name="name"></th>
			</tr>
			<tr>
				<th>관리자</th>
				<th style="text-align:left">${id} </th>
			</tr>
			<tr>	
				<th>내용</th>
				<th style="text-align:left"><textarea name="inform" rows="10" placeholder="내용을 입력하세요" form="inform"></textarea></th>
			</tr>	
			<tr>
				<th></th>
				<th style="text-align:right">		
					<input type=submit class="btn btn-success" value="등록" Onclick="javascript:writeCheck();">
					<input type=button class="btn btn-secondary" value="취소" OnClick="window.location='list.do?kind=${5}'">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>
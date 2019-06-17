<%@ page language="java" contentType="text/html; charset=UTF-8"
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
</head>

<body>
	<table class="table table-striped table-bordered table-hover">
		<caption style="text-align: center">스터디신청현황</caption>
		<tr>
			<th style="text-align: center">유저 ID</th>
			<th style="text-align: center">승인</th>
			<th style="text-align: center">거부</th>
		</tr>

		<c:forEach items="${userstudyList}" var="userstudy">
			<tr>
				<th style="text-align: center">${userstudy.userid}</th>
				<th style="text-align: left"><a
					href="studyjoinaccept.do?num=${userstudy.num}&userid=${userstudy.userid }">
						승인</a></th>
				<th style="text-align: left"><a
					href="studyjoinrefuse.do?num=${userstudy.num}&userid=${userstudy.userid }">
						거절</a></th>
			</tr>
		</c:forEach>
	</table>
	<div style="text-align: right">
		<input type=button class="btn btn-success" value="작성하기"
			OnClick="window.location='personalstudywriteform.jsp'">
	</div>
	<div style="text-align: right">
		<input type=button class="btn btn-success" value="리스트 이동"
			OnClick="window.location='list.do?num=$kind=${1 }'">
	</div>
	<div id="searchForm" style="text-align: center">
		<form>
			<select name="opt">
				<option value="0">스터디명</option>
				<option value="1">관리자</option>
				<option value="2">작성자?</option>
			</select> <input type="text" size="20" name="condition" /> <input
				class="btn btn-secondary" type="submit" value="검색" />
		</form>
	</div>
</body>
</html>
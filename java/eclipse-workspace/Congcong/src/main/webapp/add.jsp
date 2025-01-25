<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dbdao.BoardDao"%>
<%@page import="dbdto.BoardDto"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>🍚콩콩밥밥</title>
</head>
<body>
	<h2>글쓰기</h2>
	<form action="add_alert.jsp" method="get">
	<table>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="bo_name"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="bo_title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="60" name="bo_content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="입력">
				<input type="button" value="취소" onclick="location.href='Index.jsp'">
		</tr>
	</table>
	</form>
</body>
</html>
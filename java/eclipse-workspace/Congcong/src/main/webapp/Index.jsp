<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dbdao.BoardDao"%>
<%@page import="dbdto.BoardDto"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>🍚콩콩밥밥</title>
	<style>
		table {
			width: 100%;
		}
		th, td {
		border:solid 1px #000;
		}
	</style>
</head>
<body>
		<h1> 콩🫘 심은 데 콩 나고 밥🍚 먹으면 밥심 난다! </h1>
		
	<%
		BoardDao boardDao = new BoardDao();
		List<BoardDto> boardList = boardDao.list();
	%>

	<h1> 글 목록 </h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<%
			        for(BoardDto boardDto : boardList) {
			    %>
			    <tr>
			        	<td> <%=boardDto.getBo_no()%> </td>
			        	<td>
			        		
			        		<%=boardDto.getBo_name()%>
			        		
			        	</td>
			        	<td> <%=boardDto.getBo_title()%> </td>
			        	<td> <%=boardDto.getBo_date()%> </td>
			    </tr>
			    <%
			        }
				%>
			</tr>
		</tbody>
	</table>
	
	<div>
		<a href="add.jsp">게시글 작성</a>
	</div>
</body>
</html>
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

	<h1> 게시글 목록 </h1>
	<table>
	<colgroup>
		<col style="width: 10%;"/>
		<col style="width: 60%;"/>
		<col style="width: 15%;"/>
		<col style="width: 15%;"/>
	</colgroup>
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
			        		<a href="detail.jsp?bo_no=<%=boardDto.getBo_no()%>">
			        		<%=boardDto.getBo_title()%>
			        		</a>
			        		
			        	</td>
			        	<td> <%=boardDto.getBo_name()%> </td>
			        	<td> <%=boardDto.getBo_date()%> </td>
			    </tr>
			    <%
			        }
				%>
			</tr>
			<tr>
	        	<td colspan="6" align="right">
	        		<a href="add.jsp"><button>글쓰기</button></a>
	        		<%-- <button onclick="location.href='add.jsp'">글쓰기</button>으로도 구현 가능--%>
	        	</td>
	        </tr>
		</tbody>
	</table>
</body>
</html>
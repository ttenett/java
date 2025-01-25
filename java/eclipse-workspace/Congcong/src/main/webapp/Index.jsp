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
</head>
<body>
		<h1> 콩🫘 심은 데 콩 나고 밥🍚 먹으면 밥심 난다! </h1>
		
<%
	BoardDao boarddao = new BoardDao();
	List<BoardDto> boardList = boarddao.list();
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
			        for(Member member : memberList) {
			    %>
			    <tr>
			        	<td> <%=member.getMemberType()%> </td>
			        	<td>
			        		<a href="detail.jsp?memberType=<%=member.getMemberType() %>&userId=<%=member.getUserId()%>">
			        		<%=member.getUserId()%>
			        		</a>
			        	</td>
			        	<td> <%=member.getPassword()%> </td>
			        	<td> <%=member.getName()%> </td>
			    </tr>
			    <%
			        }
				%>
			</tr>
		</tbody>
	</table>
	
	<div>
		<a href="add.jsp">회원 추가</a>
	</div>
</body>
</html>
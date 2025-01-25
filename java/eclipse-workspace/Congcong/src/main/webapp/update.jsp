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
<%
	int bo_no = Integer.parseInt(request.getParameter("bo_no"));
	
	BoardDao dao = new BoardDao();
	BoardDto dto = dao.detail(bo_no);
%>
	<form>
		<tr>
			<th>작성자</th>
	        <td><%=boardDto.getBo_name()%></td>
		</tr>
	</form>

</body>
</html>
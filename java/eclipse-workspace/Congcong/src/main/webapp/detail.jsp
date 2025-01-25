<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dbdao.BoardDao"%>
<%@page import="dbdto.BoardDto"%>
<%
    // URL에서 bo_no 파라미터를 가져오기
    int bo_no = Integer.parseInt(request.getParameter("bo_no"));

    // DAO를 통해 데이터베이스에서 게시글 정보 가져오기
    BoardDao boardDao = new BoardDao();
    BoardDto boardDto = boardDao.detail(bo_no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>🍚콩콩밥밥</title>
<style>
		table {
			width: 80%;
		}
		th, td {
		border:solid 1px #000;
		}
	</style>
</head>
<body>
	<h3> 게시글 </h3>
	<table>
	        <tr>
	            <th>번호</th>
	            <td><%=boardDto.getBo_no()%></td>
	        </tr>
	        <tr>
	            <th>제목</th>
	            <td><%=boardDto.getBo_title()%></td>
	        </tr>
	        <tr>
	            <th>작성자</th>
	            <td><%=boardDto.getBo_name()%></td>
	        </tr>
	        <tr>
	            <th>날짜</th>
	            <td><%=boardDto.getBo_date()%></td>
	        </tr>
	        <tr>
	            <th>내용</th>
	            <td><textarea rows="10" cols="85" readonly="readonly"><%=boardDto.getBo_content()%></textarea></td>
	        </tr>
	        <tr>
	        	<td colspan="2">
	        		<button>
	        			<a href="update.jsp?bo_no=<%=boardDto.getBo_no()%>">수정</a>
	        		</button>
	        		<button>삭제</button>
	        		<button onclick="location.href='Index.jsp'">목록으로 돌아가기</button>
	        	</td>
	        </tr>
	</table>
</body>
</html>
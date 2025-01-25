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
	String bo_name = request.getParameter("bo_name");
	String bo_title = request.getParameter("bo_title");
	String bo_content = request.getParameter("bo_content");
	
	BoardDto dto = new BoardDto();
	dto.setBo_name(bo_name);
	dto.setBo_title(bo_title);
	dto.setBo_content(bo_content);
	
	BoardDao dao = new BoardDao();
	int res = dao.add(dto);
	

%>

<% 
    if (res > 0) {
%>
    <script>
        alert("게시글이 등록되었습니다.");
        location.href = "index.jsp";
    </script>
<% 
    } else {
%>
    <script>
        alert("게시글 등록에 실패하였습니다.");
        history.back();
    </script>
<% 
    }
%>

</body>
</html>
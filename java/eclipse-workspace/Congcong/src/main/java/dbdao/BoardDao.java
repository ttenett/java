package dbdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbdto.BoardDto;

public class BoardDao {
	
	// 게시글 전체 리스트
	public List<BoardDto> list() {
		
		List<BoardDto> boardList = new ArrayList<>();
		
        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "tenet";
        
     // 드라이버 로드
    	try {
                Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
        }
    	
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        // 커넥션 객체 생성
        try {
        	connection = DriverManager.getConnection(url, dbUserId, dbPassword);
        	
        	String sql = " SELECT bo_no, bo_name, bo_title, bo_date "
        			+ " FROM board ";
        	
        	// statement 객체 생성
        	preparedStatement = connection.prepareStatement(sql);
        	//preparedStatement.setString(1, bo_no);
        	
        	// 쿼리 실행
        	rs = preparedStatement.executeQuery();
        	
        	// 결과 수행
        	while (rs.next()) {
        		int boNo = rs.getInt("bo_no");
        		String boName = rs.getString("bo_name");
        		String boTitle = rs.getString("bo_name");
        		Date boDate = rs.getDate("bo_date");
        		
        		BoardDto boardDto = new BoardDto();
        		boardDto.setBo_no(boNo);
        		boardDto.setBo_name(boName);
        		boardDto.setBo_title(boTitle);
        		boardDto.setBo_date(boDate);
        		
        		boardList.add(boardDto);
        		
        		System.out.println(boNo + ", " + boName + ", " + boTitle + ", " + boDate);
        	}
        	
        } catch (SQLException e ) {
        	throw new RuntimeException(e);
        	
        } finally {
        	
        	// 객체 연결 해제
        	try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.isClosed();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        	
        }
		return boardList;
        
	}
	
//	// 게시글 선택
//	public BoardDto selectOne(int bo_no) {
//		
//	}
//	
//	// 게시글 생성
//	public int insert(BoardDto dto) {
//		
//	}
//	
//	// 게시글 수정
//	public int update(BoardDto dto) {
//		
//	}
//	
//	// 게시글 삭제
//	public int delete(int bo_no) {
//		
//	}
//	
}
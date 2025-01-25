package dbdao;

import dbdto.BoardDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	// 게시글 전체 리스트
	public List<BoardDao> list() {
		
		List<BoardDao> boardList = new ArrayList<>();
		
        String url = "jdbc:mariadb://192.168.219.104:3306/testdb1";
        String dbUserId = "user";
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
//        List<BoardDto> res = new ArrayList<BoardDto>();
        
        // 커넥션 객체 생성
        try {
        	connection = DriverManager.getConnection(url, dbUserId, dbPassword);
        	
        	String sql = " SELECT * FROM BOARD ";
        	
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
        		String boContent = rs.getString("bo_title");
        		Date boDate = rs.getDate("bo_date");
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
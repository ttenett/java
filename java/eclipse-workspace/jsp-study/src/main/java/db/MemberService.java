package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberService {

    public List<Member> list() {
    	
    	List<Member> memberList = new ArrayList<>();
        // db 접속시 필요한 5개 정보.
        // 1. ip(domain) 2. port, 3. 계정 4. password 5.인스턴스

        String url = "jdbc:mariadb://192.168.219.104:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "tenet";

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // email, kakao, facebook 등 로그인 방식등으로 값이 바뀔 수 있음.
        String memberTypeValue = "email";

        // 2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " select member_type, user_id, password, name " +
                    " from member " +
                    " where member_type = ? ";

            // 3. 프리페어 스테이트먼트 객체 생성, 밸류 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue);

            // 4. 프리페어 스테이트먼트에 대해 execute 쿼리 실행(excuteQuery)
            rs = preparedStatement.executeQuery();

            // 5. 결과 수행
            while (rs.next()) {
                // rs.getString으로 컬럼에 값을 지정해주고, 값을 가져올수있다.
                // 위에 sql 구문으로 선택한 컬럼만 가져올 수 있음.
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_Id");
                String password = rs.getString("password");
                String name = rs.getString("name");
                
                // Member 생성, 값 채우기
                Member member = new Member();
                member.setMemberType(memberTypeValue);
                member.setUserId(userId);
                member.setPassword(password);
                member.setName(name);
                
                memberList.add(member);

                System.out.println(memberType + ", " + userId + ", " + password + ", " + name);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {

            // 6. 객체 연결 해제(close)
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
        
        return memberList;
    }


    public Member detail(String memberType, String userId) {
    	
    	Member member = null; // 값이없는데 리턴할 수는 없으니.

        String url = "jdbc:mariadb://192.168.219.104:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "tenet";

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // 2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " "
            		+ " select m.member_type, m.user_id, m.password, m.name "
            		+ "		, md.mobile_no"
            		+ "		, md.marketing_yn"
            		+ "		, md.register_date"
                    + "	from member m "
            		+ "		left join member_detail md on md.member_type = m.member_type and m.user_id = md.user_id"
                    + " where m.member_type = ? and m.user_id = ? "
            		;

            // 3. 프리페어 스테이트먼트 객체 생성, 밸류 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberType);
            preparedStatement.setString(2, userId);

            // 4. 프리페어 스테이트먼트에 대해 execute 쿼리 실행(excuteQuery)
            rs = preparedStatement.executeQuery();

            // 5. 결과 수행
            
            // detail-> 단건의 데이터만 가져오므로 while문이 아니라 if문임
            // member가 생성되는 시점임.
            if (rs.next()) {
            	member = new Member(); // 여기서 생성하고 값을 할당. 여기에 걸리지 않으면 회원은 null 처리
                // Member 생성, 값 채우기
                member.setMemberType(rs.getString("member_type"));
                member.setUserId(rs.getString("user_Id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setMobileNo(rs.getString("mobile_no"));
                member.setMarketingYn(rs.getBoolean("marketing_yn"));
                member.setRegisterDate(rs.getDate("register_date"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {

            // 6. 객체 연결 해제(close)
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
        
        return member;
    }

    // Insert 보다는 회원가입
    /**
     * 회원 가입 함수
     * @param member 회원 정보
     */
    public void register(Member member) {
        String url = "jdbc:mariadb://192.168.219.104:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "tenet";

        // 1. 드라이버 로드 - 동일
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // 2. 커넥션 객체 생성 - 쿼리가 다름.
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 사실 values는 값 그대로 받아오면 안되고, 입력값을 받기 때문에 변경되는 값이어야 함.
            String sql = " insert into member (member_type, user_id, password, name) " +
                    " values (?, ?, ?, ?) ";

            // 3. 프리페어 스테이트먼트 객체 생성, 밸류 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());
            preparedStatement.setString(3, member.getPassword());
            preparedStatement.setString(4, member.getName());

            // 4. 프리페어 스테이트먼트에 대해 execute업데이트 실행(excuteUpdate)
            int affected = preparedStatement.executeUpdate();

            // 5. 잘 반영되었는지 확인
            if (affected > 0) {
                System.out.println(" 저장 성공 ");
            } else {
                System.out.println(" 저장 실패 ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {

            // 6. 객체 연결 해제(close)
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
    }

    public void dbUpdate() {
        String url = "jdbc:mariadb://192.168.219.104:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "tenet";

        // 1. 드라이버 로드 - 동일
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        String memberTypeValue = "email";
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "9999";

        // 2. 커넥션 객체 생성 - 쿼리가 다름.
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 사실 values는 값 그대로 받아오면 안되고, 입력값을 받기 때문에 변경되는 값이어야 함.
            String sql = " UPDATE member " +
                    " SET password = ? " +
                    " WHERE member_type = ? AND user_id = ? ";

            // 3. 프리페어 스테이트먼트 객체 생성, 밸류 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passwordValue);
            preparedStatement.setString(2, memberTypeValue);
            preparedStatement.setString(3, userIdValue);


            // 4. 프리페어 스테이트먼트에 대해 execute업데이트 실행(excuteUpdate)
            int affected = preparedStatement.executeUpdate();

            // 5. 잘 반영되었는지 확인
            if (affected > 0) {
                System.out.println(" 수정 성공 ");
            } else {
                System.out.println(" 수정 실패 ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {

            // 6. 객체 연결 해제(close)
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
    }

    // delete 보다는 회원 탈퇴

    /**
     * 회원 탈퇴 함수
     */
    public void withdraw(Member member) {
        String url = "jdbc:mariadb://192.168.219.104:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "tenet";

        // 1. 드라이버 로드 - 동일
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // 2. 커넥션 객체 생성 - 쿼리가 다름.
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 사실 values는 값 그대로 받아오면 안되고, 입력값을 받기 때문에 변경되는 값이어야 함.
            String sql = " DELETE FROM member " +
                    " WHERE member_type = ? AND user_id = ? ";

            // 3. 프리페어 스테이트먼트 객체 생성, 밸류 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());


            // 4. 프리페어 스테이트먼트에 대해 execute업데이트 실행(excuteUpdate)
            int affected = preparedStatement.executeUpdate();

            // 5. 잘 반영되었는지 확인
            if (affected > 0) {
                System.out.println(" 삭제 성공 ");
            } else {
                System.out.println(" 삭제 실패 ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {

            // 6. 객체 연결 해제(close)
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
    }
}




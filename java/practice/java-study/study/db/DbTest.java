package study.db;

import java.sql.*;

public class DbTest {

    public void dbSelect() {
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
    }

    public void dbInsert(Member member) {
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
                    " values (?, ?, ?, ?); ";

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

    public void dbDelete() {
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

        // 2. 커넥션 객체 생성 - 쿼리가 다름.
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 사실 values는 값 그대로 받아오면 안되고, 입력값을 받기 때문에 변경되는 값이어야 함.
            String sql = " DELETE FROM member " +
                    " WHERE member_type = ? AND user_id = ? ";

            // 3. 프리페어 스테이트먼트 객체 생성, 밸류 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue);
            preparedStatement.setString(2, userIdValue);


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




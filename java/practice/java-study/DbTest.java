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

    public static void main(String[] args) {

        // dbInsert의 메소드는 static이 아님. 인스턴스 메서드라 static main에서 실행할 수 없다.
        // dbInsert();
        // 그럼 어떻게? dbInsert를 static으로 바꾸던가, DbTest의 클래스를 인서트
        DbTest dbTest = new DbTest();
        dbTest.dbSelect();
        // 자기 자신을 실행. 이 방법도 불편하다면? DbTestMain을 만듬.
        // DbTestMain에서는 실행 코드만 남겨두고, DbTest에는 Main함수를 지우면 됨.


    }
}

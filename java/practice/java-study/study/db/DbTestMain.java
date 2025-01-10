package study.db;

public class DbTestMain {

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

package study.db;

import java.util.Scanner;

public class DbTestMain {

    public static void main(String[] args) {

        DbTest dbTest = new DbTest();
        //dbTest.dbSelect();
        //dbTest.dbInsert();
        //dbTest.dbUpdate();
        //dbTest.dbDelete();

        Scanner scanner = new Scanner(System.in);

        String memberType = "email";

        System.out.println("아이디 입력:>>>");
        String userId = scanner.next();
        System.out.println("비밀번호 입력:>>>");
        String password = scanner.next();
        System.out.println("이름 입력:>>>");
        String name = scanner.next();


        // 위 데이터를 아래 파라미터로 넘겨서 값들을 저장하고 싶다. ->  function이니까 매개변수로 받으면 되겠지?
        dbTest.dbInsert(memberType, userId, password, name);


    }
}

package db;

import java.util.Scanner;

public class DbTestMain {

	public static void main(String[] args) {

        MemberService memberService = new MemberService();
        // memberService.dbSelect();
	}

	public static void _main(String[] args) {

		MemberService memberService = new MemberService();
		// dbTest.dbSelect();
		// dbTest.dbInsert();
		// dbTest.dbUpdate();
		// dbTest.dbDelete();

		Scanner scanner = new Scanner(System.in);

		String memberType = "email";

		System.out.println("탈퇴할 회원 아이디를 입력해 주세요.");
		System.out.println("아이디 입력:>>>");
		String userId = scanner.next();
		/*
		 * System.out.println("비밀번호 입력:>>>"); String password = scanner.next();
		 * System.out.println("이름 입력:>>>"); String name = scanner.next();
		 */

		// 멤버 클래스 별도로 만든 후 코드작성
		Member member = new Member();
		member.setMemberType(memberType);
		member.setUserId(userId);
		// member.setPassword(password);
		// member.setName(name);

		// 위 데이터를 아래 파라미터로 넘겨서 값들을 저장하고 싶다. -> function이니까 매개변수로 받으면 되겠지?
		// dbTest.Insert의 매개변수도 Member member로 넣어줌
		// 값들을 입력받은 후 호출할 내용은 register > 회원을 가입시켜주는 메서드
		// memberService.register(member);

		memberService.withdraw(member);

	}
}

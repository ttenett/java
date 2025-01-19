package code2;

import java.util.List;

public class MemberTest {

    public static void main(String[] args) {

        Member member = new Member();

        MemberService memberService = new MemberService();

        // 회원가입
        boolean result = memberService.register(member);

        // 회원탈퇴
        boolean result2 = memberService.withdraw(member);

        //회원목록
        List<Member> memberList = memberService.getList();

    }


}

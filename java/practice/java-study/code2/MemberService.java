package code2;

import java.util.List;

public class MemberService {

    /**
     * 회원 가입
     * @param member 회원정보
     * @return 성공여부
     */
    public boolean register(Member member) {
        // 회원 정보가 전달이 되어야 하므로, 레지스터의 파라미터는 멤버가 됨.
        // 회원가입을 시키고(DB저장), 잘 되었으면 true 리턴
        return true;
    }

    /**
     * 회원 탈퇴
     * @param member 회원정보
     * @return 성공여부
     */
    public boolean withdraw(Member member) {
        return true;
    }

    /**
     * 회원 목록
     * @return 회원정보 목록
     */
    public List<Member> getList() {

        return null;
    }
}

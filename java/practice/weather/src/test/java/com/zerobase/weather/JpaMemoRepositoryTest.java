package com.zerobase.weather;

import com.zerobase.weather.domain.Memo;
import com.zerobase.weather.repository.JpaMemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
// db에 수정사항 만들지 않게 테스트용으로 만들어주는
@Transactional
public class JpaMemoRepositoryTest {

    @Autowired // jpa불러옴
    JpaMemoRepository jpaMemoRepository;

//    @Test
//    void insertMemoTest() {
//        // given
//        Memo newMemo = new Memo("this is jpa memo");
//
//        // when
//        jpaMemoRepository.save(newMemo);
//
//        // then
//        // jpa메모리포지토리에서 findall 반환, 리스트 메모 반환
//        List<Memo> memoList = jpaMemoRepository.findAll();
//        assertTrue(memoList.size() > 0);
//        //assertTrue(!memoList.isEmpty());
//    }
}

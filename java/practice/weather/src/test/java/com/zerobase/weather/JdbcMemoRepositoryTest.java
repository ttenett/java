package com.zerobase.weather;

import com.zerobase.weather.domain.Memo;
import com.zerobase.weather.repository.JdbcMemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// 어노테이션을 통해 테스트라고 말해줘야 함.
@SpringBootTest
// db test를 할 때 많이 사용되는 어노테이션
// 테스트코드 때문에 db안의 데이터들이 변경되면 안됨. 그것을 막기 위한 어노테이션.
@Transactional
public class JdbcMemoRepositoryTest {

    @Autowired
    // 아래 객체를 가져오게 됨.
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo newMemo = new Memo(2, "insertMemoTest");

        //when
        // 저장하기 위한 함수
        jdbcMemoRepository.save(newMemo);

        // then -1번 id를 확인했을때 담겨있을것이다
        Optional<Memo> result = jdbcMemoRepository.findById(2);
        // assertTrue(result.get().getText() == "this is new memo~");
        assertEquals(result.get().getText(), "insertMemoTest");
    }

    @Test
    void findAllMemoTest () {

        // given
        List<Memo> memoList =  jdbcMemoRepository.findAll();
        //when
        System.out.println(memoList);
        //then
        assertNotNull(memoList);
    }


}

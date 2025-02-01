package com.zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherApplicationTests {

	@Test
	// test 어노테이션을 붙이면 메소드 하나당 직접 테스트를 돌릴 수 있게 됨. 주석처리하면 없어짐.
	void equalTest() {
		// junit 라이브러리의 assertEquals 함수를 불러옴. 다른함수 가져오면 동작방식이 다름
		assertEquals(1, 1);
	}

	@Test
	void nullTest() {
		assertNull(null);
	}

	@Test
	void trueTest() {
		assertTrue(1==1);
	}

}

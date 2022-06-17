package org.hdcd;

import java.time.LocalDateTime;

import org.hdcd.domain.Board_lom;
import org.hdcd.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LombokTests {

	/*
	 * @Test public void testNoArgsConstructor() { Board_lom board = new
	 * Board_lom(); System.out.println(board);
	 * 
	 * Board board1 = new Board(); System.out.println(board1); }
	 */

	/*
	 * @Test public void testRequiredArgsConstructor() { Board_lom board = new
	 * Board_lom("테스트 제목"); System.out.println(board); System.out.println(board);
	 * board.setTitle("게시판제목"); System.out.println(board.getTitle()); }
	 */

	@Test
	public void testToString() {
		Member member = new Member();
		System.out.println(member);
	}

	@Test
	public void testBoardBuilder() {
		Board_lom board = Board_lom.builder().boardNo(1).title("title1").content("content1").writer("writer1")
				.regDate(LocalDateTime.now()).build();
		System.out.println(board);
	}
}

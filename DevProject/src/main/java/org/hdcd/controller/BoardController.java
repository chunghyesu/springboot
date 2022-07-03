package org.hdcd.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.hdcd.domain.Board;
import org.hdcd.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {

	@Autowired
	private BoardService service;

//	@GetMapping("/register")
//	public void registerForm(Board board, Model model) throws Exception {
//		log.info("registerForm");
//	}

	@PostMapping
	public ResponseEntity<Board> register(@Validated @RequestBody Board board) throws Exception {
		log.info("register");

		service.register(board);

		log.info("register board.getBoardNo() = " + board.getBoardNo());

		return new ResponseEntity<>(board, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Board>> list() throws Exception {
		log.info("list");

		return new ResponseEntity<>(service.list(), HttpStatus.OK);
	}

	@GetMapping("/read")
	public void read(int boardNo, Model model) throws Exception {
		log.info("read");

		model.addAttribute(service.read(boardNo));

	}

	@PostMapping("/remove")
	public String remove(int boardNo, Model model) throws Exception {
		service.remove(boardNo);

		model.addAttribute("msg", "삭제가 완료되었습니다.");

		return "board/success";
	}

	@GetMapping("/modify")
	public void modifyForm(int boardNo, Model model) throws Exception {
		log.info("modifyForm");

		model.addAttribute(service.read(boardNo));
	}

	@PostMapping("/modify")
	public String modify(Board board, Model model) throws Exception {
		log.info("modify");
		service.modify(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");

		return "board/success";
	}

//	@GetMapping
//	public ResponseEntity<List<Board>> list() {
//		log.info("list");
//
//		List<Board> boardList = new ArrayList<>();
//
//		Board board = new Board();
//
//		board.setBoardNo(1);
//		board.setTitle("향수");
//		board.setContent("넓은 벌 동쪽 끝으로");
//		board.setWriter("hongkd");
//		board.setRegDate(LocalDateTime.now());
//
//		boardList.add(board);
//
//		board = new Board();
//
//		board.setBoardNo(2);
//		board.setTitle("첫 마음");
//		board.setContent("날마다 새로우며 깊어지고 넓어진다");
//		board.setWriter("hongkd");
//		board.setRegDate(LocalDateTime.now());
//
//		boardList.add(board);
//
//		ResponseEntity<List<Board>> entity = new ResponseEntity<>(boardList, HttpStatus.OK);
//
//		return entity;
//	}

//	@PostMapping
//	public ResponseEntity<String> register(@RequestBody Board board) {
//		log.info("register");
//
//		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
//
//		return entity;
//	}

	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) {
		log.info("read");

		Board board = new Board();

		board.setBoardNo(1);
		board.setTitle("향수");
		board.setContent("넓은 벌 동쪽 끝으로");
		board.setWriter("hongkd");
		board.setRegDate(LocalDateTime.now());

		ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.OK);

		return entity;
	}

	@DeleteMapping("/{boardNo}")
	public ResponseEntity<Void> remove(@PathVariable("boardNo") long boardNo) throws Exception {
		log.info("remove");

		service.remove(boardNo);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{boardNo}")
	public ResponseEntity<Board> modify(@PathVariable("boardNo") long boardNo, @Validated @RequestBody Board board)
			throws Exception {
		log.info("modify");

		board.setBoardNo(boardNo);
		service.modify(board);

		return new ResponseEntity<>(board, HttpStatus.OK);
	}

	@PatchMapping("/{boardNo}")
	public ResponseEntity<String> modifyByPatch(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modifyByPatch");

		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

		return entity;
	}
}

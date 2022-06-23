package org.hdcd.controller;

import java.util.List;

import org.hdcd.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class MemberController {

	@PostMapping(path = "", produces = "text/plain;charset=utf-8")
	public ResponseEntity<String> register(@Validated @RequestBody Member member, BindingResult result) {
		log.info("register");

		log.info("result.hasErrors() = " + result.hasErrors());

		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();

			log.info("allErrors.size() = " + allErrors.size());
			log.info("globalErrors.size() = " + globalErrors.size());
			log.info("fieldErrors.size() = " + fieldErrors.size());

			for (int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				log.info("allError = " + objectError);
			}

			for (int i = 0; i < globalErrors.size(); i++) {
				ObjectError objectError = globalErrors.get(i);
				log.info("allError = " + objectError);
			}

			ResponseEntity<String> entity = new ResponseEntity<String>(result.toString(), HttpStatus.BAD_REQUEST);

			return entity;
		}

		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getUserName() = " + member.getUserName());
		log.info("member.getEmail() = " + member.getEmail());
		log.info("member.getGender() = " + member.getGender());

		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		return entity;
	}

	@PostMapping(path = "/upload", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> upload(MultipartFile file) throws Exception {
		String originalFilename = file.getOriginalFilename();

		log.info("originalName: " + originalFilename);

		ResponseEntity<String> entity = new ResponseEntity<String>("UPLOAD SUCCESS" + originalFilename, HttpStatus.OK);

		return entity;
	}

	@GetMapping("/register/{userId}")
	public ResponseEntity<String> resiger01(@PathVariable("userId") String userId) {
		log.info("register01 : userId = " + userId);

		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;

	}

	@PostMapping("register01")
	public ResponseEntity<String> register01(@RequestBody Member member) {
		log.info("register01");

		log.info("userId = " + member.getUserId());
		log.info("password = " + member.getPassword());

		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		return entity;
	}

	@PostMapping("/register01/{userId}")
	public ResponseEntity<String> register0101(@PathVariable("userId") String userId, @RequestBody Member member) {
		log.info("register0101");

		log.info("userId + " + userId);
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());

		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		return entity;
	}

	@PostMapping("/register02")
	public ResponseEntity<String> register02(@RequestBody List<Member> memberList) {
		log.info("register02");

		for (Member member : memberList) {
			log.info("userId = " + member.getUserId());
			log.info("password = " + member.getPassword());
		}

		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		return entity;
	}

	@PostMapping("/register/{userId}/{password}")
	public ResponseEntity<String> register02(@PathVariable("userId") String userId,
			@PathVariable("password") String password) {
		log.info("register02 userId = " + userId + ", password = " + password);

		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

//	@PostMapping("/register03")
//	public ResponseEntity<String> register03(String userId) {
//		log.info("register03 userId = " + userId);
//
//		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//
//		return entity;
//	}

//	@PostMapping("/register03")
//	public ResponseEntity<String> register03(@RequestBody Member member) {
//		log.info("register03");
//
//		log.info("userId = " + member.getUserId());
//		log.info("password = " + member.getPassword());
//
//		Address address = member.getAddress();
//
//		if (address != null) {
//			log.info("address.getPostCode() = " + address.getPostCode());
//			log.info("address.getLocation() = " + address.getLocation());
//		} else {
//			log.info("address == null");
//		}
//
//		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//
//		return entity;
//	}

//	@PostMapping("/register04")
//	public ResponseEntity<String> register04(@RequestParam("userId") String userId,
//			@RequestParam("password") String password) {
//		log.info("register04");
//
//		log.info("userId = " + userId);
//		log.info("password = " + password);
//
//		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		return entity;
//	}

//	@PostMapping("/register04")
//	public ResponseEntity<String> register04(@RequestBody Member member) {
//		log.info("register04");
//
//		log.info("userId = " + member.getUserId());
//		log.info("password = " + member.getPassword());
//
//		List<Card> cardList = member.getCardList();
//
//		if (cardList != null) {
//			log.info("cardList.size() = " + cardList.size());
//
//			for (int i = 0; i < cardList.size(); i++) {
//				Card card = cardList.get(i);
//				log.info("card.getNo = " + card.getNo());
//				log.info("card.getValidMonth() = " + card.getValidMonth());
//			}
//		} else {
//			log.info("cardList == null");
//
//		}
//
//		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		return entity;
//	}
}

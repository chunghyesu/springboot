package org.hdcd.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/")
	public String home(Locale locale, Model model) {
		log.info("Welcome home! the client locale is" + locale + ".");

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h시 m분 s초");
		// Date date = new Date();
		// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
		// DateFormat.LONG, locale);

		String formattedDate = now.format(formatter);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

}

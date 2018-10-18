package kr.co.joda.myboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.joda.myboard.service.BoardService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private static final Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
	
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Model model) {
		logger.info("list");
		model.addAttribute("list", boardService.getList());
		
	}
}

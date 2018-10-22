package kr.co.joda.myboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.joda.myboard.domain.BoardVO;
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

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		logger.info("register : " + board);
		boardService.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		logger.info("/get....................");
		model.addAttribute("board", boardService.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		logger.info("/modify...................");
		
		if(boardService.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		logger.info("remove.................." + bno);
		
		if(boardService.delete(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
		
	}
	
	
}






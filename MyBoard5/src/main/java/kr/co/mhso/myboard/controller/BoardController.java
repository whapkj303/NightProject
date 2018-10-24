package kr.co.mhso.myboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.mhso.myboard.domain.BoardVO;
import kr.co.mhso.myboard.domain.Criteria;
import kr.co.mhso.myboard.domain.PageDTO;
import kr.co.mhso.myboard.service.BoardService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		logger.info("list");
		model.addAttribute("list", boardService.getList(cri));
		
		int total = boardService.getTotal(cri);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
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
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, 
					Model model,
					@ModelAttribute("cri") Criteria cri) {
		logger.info("/get....................");
		model.addAttribute("board", boardService.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr,
								@ModelAttribute("cri") Criteria cri) {
		logger.info("/modify...................");
		
		if(boardService.modify(board)) {
			rttr.addFlashAttribute("result", "success"); //소모성 데이터
		}
		
		rttr.addAttribute("pageNum",cri.getPageNum()); // 파라미터 형태. 여러번 사용
		rttr.addAttribute("amount",cri.getAmount());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, 
			RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) {
		
		logger.info("remove.................." + bno);
		
		if(boardService.delete(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum",cri.getPageNum()); // 파라미터 형태. 여러번 사용
		rttr.addAttribute("amount",cri.getAmount());
		
		return "redirect:/board/list";
		
	}
	
	
}






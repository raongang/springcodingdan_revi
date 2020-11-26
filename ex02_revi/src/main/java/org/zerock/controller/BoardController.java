package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	// spring 4.3 이상에서 자동 처리 - 단일 파라미터를 받는 생성자의 경우에는 필요한 파라미터를 자동으로 주입 가능.
	private BoardService service;
	
	/*
	@GetMapping("/list")
	public void list(Model model) {
		
		// flashAttribute 값 확인 테스트를 위해 추가.
		if(model.asMap().get("result")!=null) {
			log.info("model result value : " + model.asMap().get("result"));
		}else {
			log.info("model.asMap().get('result') is null");
		}
		
		log.info("list...");
		model.addAttribute("list", service.getList());
	}*/
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list : " + cri);
		
		model.addAttribute("pageMaker", new PageDTO(cri,2752512));
		model.addAttribute("list", service.getList(cri));
	}
	
	//등록 FORM
	@GetMapping("/register")
	public void register() {
		log.info("register get");
	}
	
	//등록 POST 
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register board : " + board);
		service.register(board);
		
		/*
			■ RedirectAttibutes와 flash attribute
		        - flash attribute는 POST 요청에 맞춰 저장되고 다음 GET요청에서 사용됨.
		        - flashAttribute는 GET요청에서 자동으로 model에 저장됨. 
		 */
		rttr.addFlashAttribute("result",board.getBno());
		
		// redirect -> 내부적으로 response.sendRedirect()를 처리해줌.
		return "redirect:/board/list";		
	}
	
	// 게시물 하나 상세 조회 ( 리턴값이 void이므로 호출하는 url과 동일한 jsp 호출 )

	@GetMapping( {"/get","/modify"} )
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		log.info("/get or /modify...");
		
		model.addAttribute("board", service.get(bno));
	}
	
	//수정
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify board : " + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	/* 삭제 
	 *    form 으로 해서 데이터가 다 넘어오지만 Vo가 아닌 RequestParam으로 특정 값만 받을수도 있음.
	 */
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		log.info("remove bno : " + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	
}

package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list...");
		model.addAttribute("list", service.getList());
	}
	
}

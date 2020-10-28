package com.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.domain.SampleDTO;
import com.zerock.domain.SampleDTOList;
import com.zerock.domain.TodoDTO;

@Controller
@RequestMapping("/sample/*")
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("")
	public void basic() {
		logger.info("basic..............");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		logger.info("basic get only get..............");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		logger.info("" + dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex01(@RequestParam("name") String name, @RequestParam("age") int age) {
		logger.info("name : " + name);
		logger.info("age : " + age);
		return "ex02";
	}

	//리스트
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		logger.info("ids : " + ids);
		return "ex02List";
	}
	
	//배열처리
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		logger.info("array ids : " + Arrays.toString(ids));
		return "ex02Array";
	}
	
	//객체리스트 처리
	// http://localhost:8080/sample/ex02Bean?list[0].name=aaa&list[2].name=bbb 실행시 The valid characters are defined in RFC 7230 and RFC 3986 error 발생
	//http://localhost:8080/sample/ex02Bean?list%5b0%5d.name=aaa&list%5b2%5d.name=bbb 같은 형식으로 처리.
	//자바스크립트이면 encodeURIComponent()로 처리.
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		logger.info("list dtos : " + list);
		return "ex02Bean";
	}
	
	/**	
	   WebDataBinder - 스프링을 베이스로 한 웹 애플리케이션에서 데이터 바인딩을 구현한 오브젝트
	   StringTrimmerEditor Class - 웹어플에서 입력란에 아무것도 입력하지 않고 요청할 경우 getParameter를 하면 null이 아닌 공백이 들어온다. 
	   이를 방지하기 위해서 사용함
	   StringTrimmerEditor 오브젝트는 String 오브젝트의 trim메소드의 결과로 변환해주는 PropertyEditor이지만,
	   생성자에 true를 넣으면 공백을 null로 변환해주므로 매우 유용
	 */
	
	// 문자열의 날찌를 Date형으로 변환
	// DTO에 @DateTimeFormat 사용시 InitBinder 변환부분 대체 가능.
	/*
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		logger.info("Init Binder enter!!");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat,false));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}*/
	
	//http://localhost:8080/sample/ex03?title=test&dueDate=2018-01-01
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		logger.info("todo : " + todo);
		return "ex03";
		
	}
	
	
}

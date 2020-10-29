package com.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

/**
 * 
 * @author raongang
 *   예외처리
 *    - @ExceptionHandler 와 @ControllerAdvice를 이용한 처리
 *    - @ResponseEntity를 이용하는 예외 메시지 구성
 *    
 *    
 *    @ExceptionHandler (지역)
 *       - Controller, RestController에만 적용가능하다. (@Service같은 빈에서는 안됨.)

  
 *    @ControllerAdvice
 *       - 모든 @Controller에 적용(전역) 
 *       - 해당 객체가 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시하는 용도
 *    
 */

@ControllerAdvice
//@RestControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	
	//일반적인 예외처리
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.info("Exception.... " + ex.getMessage());
		model.addAttribute("exception",ex);
		log.error(model);
		return "error_page";
	}
	
	// 404 Error 예외처리 - web.xml에도 DispatcherServlet 에 param설정을 해야한다.
	// 모든 request이 DispatcherServlet를 통해서 처리되기 때문에..   
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handler404(NoHandlerFoundException e) {
		return "custom404";
	}
	
}

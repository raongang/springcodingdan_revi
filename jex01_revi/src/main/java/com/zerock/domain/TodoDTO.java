package com.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
	● @InitBinder
	- WebDataBinder 바인딩 적용 대상 - @RequestParam parameter, @CookieValue parameter, @RequestHeader parameter, @PathVariable Parameter, @ModelAttribute parameter
	- @InitBinder 메소드에 WebDataBinder에 추가한 커스컴 프로퍼티 에디터는 메소드가 있는 컨트롤러 클래스 안에서만 동작.
	
	● WebBindingInitializer
	- application 전반에 걸쳐서 한번에 WebDataBinder 바인딩을 적용하고 싶을 경우.
	- WebBindingInitializer Interface를 구현한다.
	
	● 프로토타입 빈 프로퍼티 에디터
	 - PropertyEditor는 싱글톤으로 등록 불가

 */

@Data
public class TodoDTO {
	private String title;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date dueDate;
}

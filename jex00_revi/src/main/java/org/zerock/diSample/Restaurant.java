package org.zerock.diSample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
// lombok의 setter, 생성자, toString 자동 생성위해 사용.
@Data
public class Restaurant {

	/**
	 *  DI 의존
	 * 
	 *   @Setter -> 컴파일시 자동으로 setChef() 생성
	 *   onMethod_   -> setChef()에 @Autowried를 추가하도록 함. 
	 */
	@Setter(onMethod_ = {@Autowired})
	private Chef chef;
}

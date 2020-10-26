package org.zerock.diSample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;



@Component
@ToString
@Getter

public class SampleHotel {

	private Chef chef;

	//생성자주입
	public SampleHotel(Chef chef) {
		super();
		this.chef = chef;
	}
	
	/* @AllArgsConstructor를 붙이면 생성자를 아래와 같이 사용 가능 
	 *  -> instance 변수로 선언된 모든 것을 파라미터로 받는 생성자를 작성
	 * */
	//private Chef chef;
}

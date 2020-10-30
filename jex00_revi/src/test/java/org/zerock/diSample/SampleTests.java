package org.zerock.diSample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;
import org.zerock.diSample.Restaurant;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/*
	Junit 4.10 이상 사용.
	spring-test dependency 해야함.
	@ContextConfiguration(locations= {"classpath:/META-INF/spring/root-context.xml"})
	@Log4j -> lombok을 이용해 로그를 기록하는 Logger를 변수로 생성.
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class SampleTests {

	@Setter(onMethod_ = { @Autowired } )
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		
		//NULL이 아니어야 테스트 성공
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("---------------------------------------");
		log.info(restaurant.getChef());
		
	}
}

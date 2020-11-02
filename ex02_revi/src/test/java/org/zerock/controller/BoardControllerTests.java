package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)

/**
	 @WebAppConfiguration
	   - 웹 컨텍스트 테스트 활성화
	   - SpringJUnit4ClassRunner 가 애플리케이션 컨텍스트로(기본값인 비웹용 ApplicationContext가 아니라) WebApplicationContext를 생성하도록 선언한다.
	
	● WebApplicationContext 
			- Spring application에서 가장 많이 사용되는 application context , application context를 확장한 interface
			- 웹어플리케이션에서 만들어지는 스프링 IoC 컨테이너는 WebApplicationContext 인터페이스를 구현한 것.  
*/

@WebAppConfiguration
@ContextConfiguration( {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"} )
@Log4j
public class BoardControllerTests {

	@Autowired
	BoardController boardController;
	
	
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
       this.mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();     // test를 위한 MockMvc 객체 생성. boardController 1개만 주입.
      //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();  // test를 위한 MockMvc 객체 생성. 스프링이 로드한 WebApplicationContext의 인스턴스로 작동
      
	}
	
	@Test
	public void testList() throws Exception{
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")) 
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test")    //controller의 /test URI를 get방식으로 호출
                .param("number1", "1")  // 파라미터 number1에 1 입력
                .param("number2", "1")) // 파라미터 number2에 1입력
                .andDo(print())                      // 결과를 print. MockMvcBuilders의 alwaysDo(print())로 대체 가능
                .andExpect(status().isOk());           // 호출 결과값이 OK가 나오면 정상처리
    }
    
    @Test
    public void testRegister() throws Exception{
    	
    	String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
    			.param("title", "테스트 새글 제목")
    			.param("content", "테스트 새글 내용")
    			.param("writer", "user00")
    			).andReturn().getModelAndView().getViewName();
    			
    	log.info("resultPage : " + resultPage);
    }
    
    @Test
    public void testGet() throws Exception{
    	log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
    			.param("bno", "2"))
    			.andReturn()
    			.getModelAndView()
    			.getModelMap()
    			);
    }
    
    @Test
    public void testModify() throws Exception{
    	
    	Object resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
    			.param("bno", "2")
    			.param("title", "테스트 수정 제목")
    			.param("content", "테스트 수정 내용")
    			.param("writer", "user11")
    			).andReturn().getFlashMap().get("result");
    			
    	log.info("Flash Attribute(result) Value  : " + resultPage);
    }
    
    @Test
    public void testRemove() throws Exception{
    	
    	//삭제된 DB에서 게시글 번호 확인 필요.
    	
    	String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "2")).andReturn().getModelAndView().getViewName();
    	log.info("testRemove result Page : " + resultPage);
    }
	
}

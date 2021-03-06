package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	//Paging Calculation Math.ceil 은 소수점 이하 올림처리함.
	@Test
	public void show() {
		int endPage = (int)Math.ceil(2/10.0)*10;
		int startPage = endPage - 9;
		
		System.out.println("startPage >> " + startPage);
		System.out.println("endPage >> " + endPage);
	}
	
	@Test
	public void testGetList() {
		
		//list forEach문
		List<BoardVO> list = service.getList(new Criteria(2,10));
		for(BoardVO board :list) {
			System.out.println(board);
		}
		
		/*   lamda를 사용한 list foreach문 
		 *   service.getList(new Criteria(2,10)).forEach(board->log.info(board));
		 */
	}
	
	@Test
	public void testExist() {
		log.info(service);
		//null이 아니어야 테스트 성공
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBno());
		
	}
	/*
	@Test
	public void testGetList() {
		service.getList().forEach(board->log.info(board));
	}*/

	@Test
	public void testGet() {
		log.info(service.get(2L));
	}
	
	@Test
	public void testDelete() {
		
		//게시물 번호를 존재 여부를 확인하고 테스트 해야 함.
		log.info("REMOVE RESULT : " +  service.remove(3L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(2L);
		
		if(board==null) return;
		
		board.setTitle("제목을 수정합니다.");
		log.info("MODIFY RESULT : " +  service.modify(board));
	}
	
}

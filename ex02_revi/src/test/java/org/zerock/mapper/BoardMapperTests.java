package org.zerock.mapper;

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
public class BoardMapperTests {

	@Setter(onMethod_ = {@Autowired})
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		log.info(boardMapper.getClass().getName());
		//log.info(boardMapper.getList());
		boardMapper.getList().forEach(board->log.info(board));
	}
	
	/*
	@Test
	public void testGetListXML() {
		log.info("===============================");
		log.info("boardMapper getListXML");
		log.info(boardMapper.getListXML());
	}*/
	
 
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		boardMapper.insert(board);
		// Lombok이 만들어주는 toString()을 이용해서 출력함.
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select Key");
		board.setContent("새로 작성하는 내용 select Key");
		board.setWriter("newbie");
		
		boardMapper.insertSelectKey(board);
		log.info(board);
	}
	
	@Test
	public void testRead() {
		log.info("testRead Start...");
		BoardVO board = boardMapper.read(23L);
		log.info(board);
	}
	
	@Test
	public void tetstDelete() {
		log.info("testDelete Start...");
		log.info("DELETE COUNT : " +boardMapper.delete(23L));
	}	
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		//실행전 존재하는 번호인지 확인.
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user000");
		
		int count = boardMapper.update(board);
		log.info("UPDATE COUNT : " + count);
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	
	@Test
	public void testPaging2() {
		Criteria cri = new Criteria(3,10);
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
	
	
}

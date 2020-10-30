package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {org.zerock.config.RootConfig.class})
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
}

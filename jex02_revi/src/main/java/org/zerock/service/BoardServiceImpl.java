package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//필드값은 포함한 모든 생성자를 자동으로 생성해준다. - lombok
@AllArgsConstructor 
public class BoardServiceImpl implements BoardService{

	// spring 4.3 이상에서 자동 처리 - 단일 파라미터를 받는 생성자의 경우에는 필요한 파라미터를 자동으로 주입 가능.
	private BoardMapper mapper;
	
	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}
	
	/*
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	*/
	
	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("register 실행전 board 데이터 :  " + board);
		mapper.insertSelectKey(board);
	}
	
	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		log.info("get read.... ");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		
		log.info("modeify BoardVO  : " + board);
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		log.info("remove BoardVO  : " + bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		System.out.println("getList 서비스 실행");
		return mapper.getList();
	}
}

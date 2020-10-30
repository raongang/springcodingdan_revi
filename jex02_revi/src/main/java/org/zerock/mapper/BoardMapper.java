package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

/* 	
 	SqlSession을 사용하여 XML을 이용하는 mapper 대신, mapper interface 사용.
	@Select - myBatis Annotation.
	MyBatis-Spring에서 Mapper interface를 이용해서 실제 SQL처리가 되는 class를 자동 생성
	
	root-context.xml에서 <mybatis-spring:scan 을 작성해야 한다. 
*/

public interface BoardMapper {
	
	/*  	
	 *  xml 처리 방식.
	 *  
	 *  MyBatis는 Mapper 인터페이스와 XML을 인터페이스의 이름과 namespace 속 성값을 가지고 판단합니다. 
	 * 위와 같이 org.zerock.mapper.BoardMapper 인터페이스 가 존재하고，XML의〈mapper namespace=”org.zerock.mapper.BoardMapper'〉와 같이 동일한 이름이 존재하면, 
	 * 이를 병합해서 처리합니다. 따라서 위의 경우 메서드 선언 은 인터페이스에 존재하고 SQL에 대한 처리는 XML을 이용하는 방식이라고 볼 수 있습니다.
	 * 
	 */
	
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	
	//@Select("select * from tbl_board where bno >0")
	//public List<BoardVO> getListXML();
	
}

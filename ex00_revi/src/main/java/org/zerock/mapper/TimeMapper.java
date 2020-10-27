package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	/* 	XML을 이용하는 mapper 대신, mapper interface 사용.
		@Select - myBatis Annotation.
		MyBatis-Spring에서 Mapper interface를 이용해서 실제 SQL처리가 되는 class를 자동 생성 */
	
	@Select("select sysdate from dual")
	public String getTime();
	
	//xml 처리 방식.
	public String getTime2();
	
}

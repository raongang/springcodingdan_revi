package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	// XML을 이용하는 mapper 대신, mapper interface 사용.
	// @Select - myBatis Annotation.
	@Select("select sysdate from dual")
	public String getTime();
	
	//xml 처리 방식.
	public String getTime2();
	
}

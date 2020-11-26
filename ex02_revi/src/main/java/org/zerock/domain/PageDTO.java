package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {


	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	//total - 전체 데이터수.
	public PageDTO(Criteria cri, int total) {
		
		this.total = total;
		this.cri = cri;
		
		// * 10을 한 이후에는 페이지를 10개씩 보여준다고 가정한다.
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0)) * 10;
		
		this.startPage = endPage - 9;
		int realEnd = (int)(Math.ceil((total*1.0) / cri.getAmount()));
		
		System.out.println("startPage >> " + startPage + " endPage >> " + endPage + " realEnd >> " + realEnd);
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		System.out.println("this.prev >> " + this.prev);
		System.out.println("this.next >> " + this.next);
	}
	
	
	
}

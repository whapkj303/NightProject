package kr.co.mhso.myboard.domain;

import lombok.Getter;
import lombok.ToString;

//DTO : Data Transfer Object
// 클라이언트가 서버에게 보내주는 파라미터를 담을 클래스

// VO : Value Object
// 서버가 클라이언트에게 보여줄 데이터 (attribute)

@Getter
@ToString
public class PageDTO {
	
	private int startPage;	//계산된 시작 페이지
	private int endPage;	//계산된 끝 페이지
	private boolean prev, next;	// 이전, 다음 버튼 표시 여부
	
	private int total;			//총 데이터 개수
	private Criteria cri;		// 현재 페이지 번호와 표시할 개수
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		//현재 보여주는 페이지의 마지막 페이지 번호 구하기
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		// 방어 코드
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
	}
	
	
	
}






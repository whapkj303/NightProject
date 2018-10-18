package kr.co.joda.myboard.service;



import java.util.List;

import kr.co.joda.myboard.domain.BoardVO;

//Service단 : Business 계층 -> 실제 사용자의 요구사항을 반영한다.
// 실제 프로그램처럼 만드는 계층(WEB, DB와 전혀무관)
public interface BoardService {
	
	// mapper의 메소드를 호출할 수 있도록 해야 한다.
	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean delete(Long bno);
	
	public List<BoardVO> getList();
	
}

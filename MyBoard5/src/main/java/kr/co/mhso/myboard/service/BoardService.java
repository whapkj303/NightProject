package kr.co.mhso.myboard.service;

import java.util.List;

import kr.co.mhso.myboard.domain.BoardVO;
import kr.co.mhso.myboard.domain.Criteria;

// Service단 : Business 계층 -> 실제 사용자의 요구사항을 반영한다.
//  실제 프로그램 처럼 만드는 계층 (Web, DB와 전혀 무관)
public interface BoardService {
	
	// mapper의 메소드를 호출 할 수 있도록 해야 한다.
	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean delete(Long bno);
	
	//public List<BoardVO> getList();
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
	
}

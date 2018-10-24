package kr.co.mhso.myboard.mapper;

import java.util.List;

import kr.co.mhso.myboard.domain.BoardVO;
import kr.co.mhso.myboard.domain.Criteria;

public interface BoardMapper {
	
	// 게시글 리스트 불러오기. bno에 조건을 걸은 이유는 페이징 처리 시 PK 사용을 유도함
	// @Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	// 실제 삽입만 처리되고 생성된 bno를 알 필요가 없는 경우.
	public void insert(BoardVO board);
	
	// 삽입 처리를 하고 생성된 bno를 알아야 하는 경우.
	public void insertSelectKey(BoardVO board);
	
	// 게시글 읽기 (조회)
	public BoardVO read(Long bno);
	
	// 게시글 삭제
	// 리턴값이 1인 이유 : 게시글 삭제가 되었을 때 정상적으로 삭제가 되면
	// 1 이상의 값을 가지도록 함 -> 지워진 게시글의 개수
	public int delete(Long bno);
	
	// 게시글 수정
	public int modify(BoardVO board);
	
	// 페이징 처리 ( 몇 페이지의 게시글을 몇개 만큼 보여주겠다 )
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}





package kr.co.mhso.myboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mhso.myboard.domain.BoardVO;
import kr.co.mhso.myboard.domain.Criteria;
import kr.co.mhso.myboard.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor //모든 의존 객체를 생성자로 받겠다. - lombok의 기능
public class BoardServiceImpl implements BoardService {
	
	// Spring 4.3 버전 미만에서는 @Autowired 를 붙여 줘야 함
	// @Autowired -> 4.3 버전 미만일 시 붙여줄 것
	// @Setter(onMethod_=@Autowired) @AllArgsConstructor 어노테이션 안쓸 때
	private BoardMapper mapper;
	
	private void printLog(String method) {
		System.out.println("=======================");
		System.out.println(method+"...............");
		System.out.println("=======================");
	}

	@Override
	public void register(BoardVO board) {
		printLog("register");
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		printLog("get");
		return mapper.read(bno);
	}

	// 수정이나 삭제가 된 게시물이 있으면 true리턴, 아니면 false 리턴
	@Override
	public boolean modify(BoardVO board) {
		printLog("modify");
		return mapper.modify(board) == 1;
	}

	@Override
	public boolean delete(Long bno) {
		printLog("delete");
		return mapper.delete(bno) == 1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		printLog("getList");
//		return mapper.getList();
//	}
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		printLog("getList with criteria");
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		printLog("get Total Count");
		
		return mapper.getTotalCount(cri);
	}

}

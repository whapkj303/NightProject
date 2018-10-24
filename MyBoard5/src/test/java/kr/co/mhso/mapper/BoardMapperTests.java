package kr.co.mhso.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.mhso.myboard.domain.BoardVO;
import kr.co.mhso.myboard.domain.Criteria;
import kr.co.mhso.myboard.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board));
//	}
	
//	@Test
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 제목");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("newbie");
//		
//		mapper.insert(board);
//		
//		log.info(board);
//	}
	
//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글 Select Key");
//		board.setContent("새로 작성하는 내용 Select Key");
//		board.setWriter("newbie");
//		
//		mapper.insertSelectKey(board);
//		
//		log.info(board);
//				
//	}
	
//	@Test
//	public void testRead() {
//		//존재하는 게시물 번호로 테스트하기
//		BoardVO board = mapper.read(21L);
//		log.info(board);
//	}
	
//	@Test
//	public void testDelete() {
//		int deleteCount = mapper.delete(22L);
//		log.info("DELETE COUNT : " + deleteCount);
//	}
	
//	@Test
//	public void testModify() {
//		BoardVO board = new BoardVO();
//		board.setBno(6L);
//		board.setTitle("수정된 제목 test");
//		board.setContent("수정된 내용 test");
//		board.setWriter("user01");
//		
//		int modifyCount = mapper.modify(board);
//		
//		log.info("UPDATE COUNT : " + modifyCount);
//	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setAmount(10);
		cri.setPageNum(2);
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board->log.info(board));
	}
	
}









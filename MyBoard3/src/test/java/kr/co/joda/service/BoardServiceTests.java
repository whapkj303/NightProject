package kr.co.joda.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.joda.myboard.domain.BoardVO;
import kr.co.joda.myboard.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	public BoardService service;
	
/*	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}*/
	
/*	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 - service");
		board.setContent("새로 작성하는 내용 - service");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("등록한 게시글의 번호 :"+ board.getBno());
	}*/
	
	/*@Test
	public void getTest() {
		log.info(service.get(23L));
	}*/
	
	@Test
	public void deleteTest() {
		log.info("삭제 결과:" + service.delete(3L));
	}
	
	/*@Test
	public void getListTest() {
		service.getList().forEach(board -> log.info(board));
	}*/
	
	/*@Test
	public void modifyTest() {
		BoardVO modifyBoard = service.get(2L);
		if(modifyBoard == null) {
			return;
		}
		modifyBoard.setTitle("서비스 테스트에 의해 수정된 글");
		
		boolean isModified = service.modify(modifyBoard);
		
		log.info("modify result : " + isModified);
	}*/
}

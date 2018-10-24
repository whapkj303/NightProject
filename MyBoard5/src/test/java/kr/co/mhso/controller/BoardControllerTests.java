package kr.co.mhso.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration	// 컨트롤러를 테스트 하기 위한 어노테이션
@ContextConfiguration(
			{
				"file:src/main/webapp/WEB-INF/spring/root-context.xml",
				"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
			}
		)
public class BoardControllerTests {

	// 임시 테스트용 서버(MockUp Server) 만들기
	@Setter(onMethod_=@Autowired)
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		//@Before는 테스트가 수행 되기 전에 실행되는 메소드
		// 테스트를 수행할 목업 서버 만들어내기
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
//	@Test
//	public void testList() throws Exception {
//		log.info(
//				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//				.andReturn()
//				.getModelAndView()
//				.getModelMap()
//				);
//	}
	
//	@Test
//	public void testRegister() throws Exception {
//		
//		String resultPage = mockMvc.perform(
//				MockMvcRequestBuilders.post("/board/register")
//				.param("title", "테스트 새글 제목")
//				.param("content", "테스트 새글 내용")
//				.param("writer", "user00")
//				).andReturn().getModelAndView().getViewName();
//		
//		log.info("결과 페이지 : " + resultPage);
//		
//	}
	
//	@Test
//	public void testGet() throws Exception {
//		log.info(
//				mockMvc.perform(MockMvcRequestBuilders
//						.get("/board/get")  
//						.param("bno", "24"))
//					.andReturn()
//					.getModelAndView().getModelMap());
//	}
	
//	@Test
//	public void testModify() throws Exception{
//		log.info("modify 테스트");
//		String resultPage = mockMvc
//				.perform(MockMvcRequestBuilders.post("/board/modify")
//						.param("bno", "24")
//						.param("title", "수정된 테스트 새글 제목")
//						.param("content", "수정된 테스트 새글 내용")
//						.param("writer", "user00"))
//				.andReturn().getModelAndView().getViewName();
//		log.info("결과 페이지 : " + resultPage);
//	}
	
//	@Test
//	public void testRemove() throws Exception{
//		log.info("remove 테스트");
//		
//		String resultPage = mockMvc
//				.perform(MockMvcRequestBuilders.post("/board/remove")
//						.param("bno", "5"))
//				.andReturn().getModelAndView().getViewName();
//		    
//		log.info(resultPage);
//	}
	
	@Test
	public void testListPaging() throws Exception{
		log.info(
				mockMvc.perform(
					MockMvcRequestBuilders.get("/board/list")
					.param("pageNum", "2")
					.param("amount", "10"))
				.andReturn().getModelAndView().getModelMap());
	}
	
}











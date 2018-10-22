package kr.co.joda.Controller;

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
@WebAppConfiguration
@ContextConfiguration(
			{
				"file:src/main/webapp/WEB-INF/spring/root-context.xml",
				"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
			}
		)
public class BoardControllerTests {
	// 임시 테스트용 서버 (MockUp Server) 만들기
	@Setter(onMethod_ =@Autowired)
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		// @Before 는 테스트가 수행되기 전에 실행되는 메소드
		// 테스트를 수행할 목업 서버 만들어 내기
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testList() throws Exception{
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
	}
	
}

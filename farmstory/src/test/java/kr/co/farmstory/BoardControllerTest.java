package kr.co.farmstory;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.farmstory.controller.BoardController;
import kr.co.farmstory.service.UserService;
import kr.co.farmstory.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml"})
public class BoardControllerTest {
	
	@Inject
	private BoardController controller;
	
	@Test
	public void list() {
		
		BoardVO vo = new BoardVO();
		
	}

	
}

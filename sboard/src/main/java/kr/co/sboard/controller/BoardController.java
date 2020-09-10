package kr.co.sboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.sboard.service.BoardService;
import kr.co.sboard.vo.BoardVO;
import kr.co.sboard.vo.FileVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public String list(Model model, String pg) {
		
		int start = service.getLimitStart(pg);
		int total = service.selectCountBoard();
		int pageEnd = service.getPageEnd(total);
		int count = service.getListCount(total, start);
		int currentPage = service.currentPage(pg);
		
		int groupCurrent = (int)Math.ceil(currentPage/10.0);
		int groupStart = (groupCurrent - 1)*10 +1;
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > pageEnd) {
			groupEnd = pageEnd;
		}
		
		List<BoardVO> articles = service.selectBoards(start);
		
		model.addAttribute("articles", articles);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPg", pg);
		model.addAttribute("count", count);
		model.addAttribute("groupStart", groupStart);
		model.addAttribute("groupEnd", groupEnd);
		
		return "/list";
	}
	@GetMapping("/write")
	public String write() {
		
		return "/write";
	}
	@PostMapping("/write")
	public String write(BoardVO vo, HttpServletRequest req) {
		
		
		vo.setRegip(req.getRemoteAddr());
		
		//파일업로드 
		MultipartFile file = vo.getFname(); //vo에서도 타입 바꿔줘야함
		
		if(file.isEmpty()) {
			vo.setFile(0);
		}else {
			vo.setFile(1);
		}
		
		//insert 한다음에 글번호를 return 받아야함	
		int seq = service.insertBoard(vo);
		FileVO fvo = service.fileUpload(req, file, seq);
		//검사
		if(fvo !=null) {
			service.insertFile(fvo);
		}
		return "redirect:/list";
	}
	
	@GetMapping("/view")
	public String view() {
		return "/view";
	}
	@GetMapping("/modify")
	public String modify() {
		return "/modify";
	}
	
}

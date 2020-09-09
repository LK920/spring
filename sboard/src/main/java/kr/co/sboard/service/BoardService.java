package kr.co.sboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.BoardDAO;
import kr.co.sboard.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
	}
	
	public void selectBoard() {}
	public List<BoardVO> selectBoards(int start) {
		return dao.selectBoards(start);
	}
	public void updateBoard() {}
	public void deleteBoard() {}
	public void modifyBoard() {}
	
	//limit start ���
	public int getLimitStart(String pg) {
		if(pg == null) {
			return 0;
		}else {
			int page = Integer.parseInt(pg);
			return (page - 1) * 10;
		}
		
	}
	//��ü �Խù� ����
	public int selectCountBoard() {
		return dao.selectCountBoard();
	}
	//������ ��ȣ ���
	public int getPageEnd(int total) {
		int pageEnd = 0;
		
		if(total % 10 == 0) {
			pageEnd = total / 10;
		}else {
			pageEnd = (total / 10) + 1;
		}
		return pageEnd;
	}
	//list count ���
	public int getListCount(int total, int start) {
		return (total - start) + 1;
	}
	
	//group�� ����� page ���
	public int currentPage(String pg) {
		int currentPage = 1;
		if(pg == null) {
			currentPage =1;
			 
		}else {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	

}

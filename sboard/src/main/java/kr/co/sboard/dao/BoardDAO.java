package kr.co.sboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.BoardVO;
import kr.co.sboard.vo.FileVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insertBoard(BoardVO vo) {
		//insert 수행후 해당 테이블 행의 seq를 vo객체 seq멤버에 저장
		mybatis.insert("mapper.board.INSERT_BOARD", vo);
		return vo.getSeq();
	}
	public void insertFile(FileVO fvo) {
		mybatis.insert("mapper.board.INSERT_FILE", fvo);
	}
	
	public BoardVO selectBoard(int seq) {
		return mybatis.selectOne("mapper.board.SELECT_BOARD", seq);
	}
	
	public List<BoardVO> selectBoards(int start) {
		return mybatis.selectList("mapper.board.SELECT_BOARDS", start);
	}
	public void updateBoard() {}
	public void deleteBoard() {}
	public void modifyBoard() {}
	
	public int selectCountBoard() {
		return mybatis.selectOne("mapper.board.SELECT_COUNT_BOARD");
	}
}

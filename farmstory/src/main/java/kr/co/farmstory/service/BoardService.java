package kr.co.farmstory.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.farmstory.dao.BoardDAO;
import kr.co.farmstory.vo.BoardVO;
import kr.co.farmstory.vo.FileVO;

@Service
public class BoardService {
	
	@Inject
	private BoardDAO dao;
	
	public List<BoardVO> selectBoards(int start, String cate) {
		return dao.selectBoards(start, cate);
	}
	public List<BoardVO> selectLatest(String cate) {
		 return dao.selectLatest(cate);
	}
	
	//limit start 계산
		public int getLimitStart(String pg) {
			if(pg == null) {
				return 0;
			}else {
				int page = Integer.parseInt(pg);
				return (page - 1) * 10;
				
			}
			
		}
		//전체 게시물 갯수
		public int selectCountBoard(String cate) {
			return dao.selectCountBoard(cate);
		}
		//페이지 번호 계산
		public int getPageEnd(int total) {
			int pageEnd = 0;
			
			if(total % 10 == 0) {
				pageEnd = total / 10;
			}else {
				pageEnd = (total / 10) + 1;
			}
			return pageEnd;
		}
		//list count 계산
		public int getListCount(int total, int start) {
			return (total - start) + 1;
		}
		
		//파일 업로드
		public FileVO fileUpload(HttpServletRequest req, MultipartFile file, int seq) {
			
			//시스템 경로
			String path = req.getSession().getServletContext().getRealPath("/resources/files/");
			
			if(!file.isEmpty()) {
				
				//파일 첨부 했을때
				String oName = file.getOriginalFilename(); //파일 원래 명
				String ext = oName.substring(oName.lastIndexOf(".")); //확장자
				
				//고유파일명 생성
				String uName = UUID.randomUUID().toString()+ext;
				
				//파일 저장
				try {
					file.transferTo(new File(path+uName));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				FileVO vo = new FileVO();
				vo.setParent(seq);
				vo.setOldName(oName);
				vo.setNewName(uName);
				
				return vo;
				
			}else {
				//파일 첨부 안했을때
				return null;
			}
			
		}
		//파일 다운로드
		public void fileDownload() {}

}


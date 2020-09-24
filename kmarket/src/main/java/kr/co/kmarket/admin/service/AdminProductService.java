package kr.co.kmarket.admin.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket.admin.dao.AdminProductDAO;
import kr.co.kmarket.admin.persistence.AdminProductsRepo;
import kr.co.kmarket.vo.ProductsVo;

@Service
public class AdminProductService {
	@Autowired
	private AdminProductDAO dao;
	
	@Autowired
	private AdminProductsRepo repo;
	
	public void insertProduct(ProductsVo vo) {
		repo.save(vo);
	} 
	public ProductsVo selectProduct() {
		return dao.selectProduct();
	}
	public List<ProductsVo> selectProducts(int start){
		return dao.selectProducts(start);
	}
	
	public List<ProductsVo>  selectProductsBySearch(int start, String opt, String keyword){
		return dao.selectProductsBySearch(start, opt, keyword);
	}
	public int selectCountProductsBySearch(String opt, String keyword) {
		return dao.selectCountProductsBySearch(opt, keyword);
	}
	
	public void updateProduct() {
		dao.updateProduct();
	}
	public void deleteProduct() {
		dao.deleteProduct();
	}
	
	
		// Limit start 계산
		public int getLimitStart(String pg) {
			if(pg == null) {
				return 0;
			}else {
				int page = Integer.parseInt(pg);
				return (page - 1) * 10;			
			}
		}
		
		// 전체 게시물 갯수
		public int selectCountProducts(){
			return dao.selectCountProducts();
		}
		
		// 페이지 번호 계산
		public int getPageEnd(int total) {
			
			int pageEnd = 0;
			
			if(total % 10 == 0) {
				pageEnd = total / 10;
			}else {
				pageEnd = (total / 10) + 1;
			}
			return pageEnd;
		}
		
		// list count 계산
		public int getListCount(int total, int start) {
			return (total - start) + 1;
		}
		//group page 계산
		public int currentPage(String pg) {
			int currentPage = 1;
			if(pg == null) {
				currentPage =1;
				 
			}else {
				currentPage = Integer.parseInt(pg);
			}
			return currentPage;
		}
		
	//사용자 정의 속성에서 경로 설정
		
	@Value("${upload.path}")
	private String uploadPath;
	
	public ProductsVo uploadThumb(ProductsVo vo) {
		//썸네일 업로드
		//우선 경로 구하기(고정 경로를 넣어주기)
		String path = new File(uploadPath).getAbsolutePath();
		
		//배열의 반복문
		MultipartFile[] files = {vo.getFile1(),vo.getFile2(),vo.getFile3(),vo.getFile4()};
		
		for(int i =0 ; i<4 ; i++) {
			MultipartFile file = files[i];
			
			if(!file.isEmpty()) {
				//이름과 확장자 분리
				String name = file.getOriginalFilename();
				String ext = name.substring(name.lastIndexOf("."));
				//이름을 암호화 	//고유파일명 생성
				String uName = UUID.randomUUID().toString()+ext;
				String fullpath = path+"/"+vo.getCate1()+"/"+vo.getCate2()+"/";
								
				try {
					Path root = Paths.get(fullpath);
					Files.createDirectories(root);
					
					file.transferTo(new File(fullpath+uName));
					
					if(i==0) vo.setThumb1(uName);
					if(i==1) vo.setThumb2(uName);
					if(i==2) vo.setThumb3(uName);
					if(i==3) vo.setDetail(uName);
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return vo;
	}
}

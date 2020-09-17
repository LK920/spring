package kr.co.ch12.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ch12.vo.UserVo;

	//T : table이 선언된 uservo를 넣음
	// ID : table이 선언된 uservo에서 테이블의 prime key 값으로 선언된 값의 타입을 설정해준다.
	// 기본 crud 가 자동으로 상속되기에 작성할 필요 없음

@Repository
public interface UserRepo extends JpaRepository<UserVo, String>{
	
	//쿼리 메서드 정의
	//select * from `USER3` order by age asc;
	public List<UserVo> findUserVoByOrderByAgeAsc();
	
	//select * from `USER3` order by age desc;
	public List<UserVo> findUserVoByOrderByAgeDesc();
	
}

package kr.co.kmarket.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "km_terms")
public class TermsVo {
	//데이터베이스에 pk 가 없어서 id 선언을 seq에 임의로 해줌 이때 seq도 데이터 베이스엔 없음
	//id 선언후 데이터 베이스 보면 seq가 생겨있음
	
	@Id
	private int seq;
	private String terms;
	private String privacy;
	private String location;
	private String finance;
	private String fax;
}

package kr.co.kmarket.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCartVo {
	private int seq;
	private String uid;
	private int code;
	private String name;
	private String option;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int delivery;
	private int total;
	private String rdate;
	
	//추가 필드
	private String thumb1;
	private String cate1;
	private String cate2;
}

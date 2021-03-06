package kr.co.livingmarket.vo;

import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Setter
@Entity
@Table(name = "lm_member")
public class MemberVo {
	
	private int type;
	@Id
	private String uid;
	private String pass;
	private String name;
	private int gender;
	private String hp;
	private String email;
	private int point;
	private int grade;
	private String zip;
	private String addr1;
	private String addr2;
	private String birth;
	private String recUid;
	private String company;
	private String ceo;
	private String bizRegNum;
	private String commRepNum;
	private String tel;
	private String manager;
	private String managerHp;
	private String fax;
	private String ip;
	private String leaveDate;
	private String rdate;
	private int etc1;
	private int etc2;
	private String etc3;
	private String etc4;
	private String etc5;
}

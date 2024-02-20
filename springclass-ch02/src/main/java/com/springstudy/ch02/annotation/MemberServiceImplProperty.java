package com.springstudy.ch02.annotation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.ch02.dao.MemberDAO;
import com.springstudy.ch02.domain.Member;
import com.springstudy.ch02.service.MemberService;

// MemberDAOImpl 라고 쓰면 강한결합이 되므로 MemberDAO 타입을 이용해서 DB를 읽어와 처리
@Service("memserProper")
public class MemberServiceImplProperty implements MemberService {

	// MemberDAO 타입을 주입
	private MemberDAO memberDAO;
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
//	//생성자는 class랑 이름이 같음!
//	public MemberServiceImplProperty(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
	
	@Override
	public ArrayList<Member> getMemberList() {
		// 비즈니스 로직 - 페이징
		return memberDAO.getMemberList();
	}

}
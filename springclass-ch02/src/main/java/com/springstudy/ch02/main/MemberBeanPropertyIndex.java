package com.springstudy.ch02.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.springstudy.ch02.domain.Member;
import com.springstudy.ch02.service.MemberService;

public class MemberBeanPropertyIndex {

	public static void main(String[] args) {
		// DI 컨테이너 - ApplicationContext를 구현한 class
		// 대표로 GenericXmlApplicationContext
		GenericXmlApplicationContext ac = new GenericXmlApplicationContext("classpath:config/MemberBeanPropertyContext.xml");
		
		// dependency lookup
		MemberService service = (MemberService) ac.getBean("memberService");
		// or MemberService service = ac.getBean("memberService", MemberService.class);
		
		List<Member> mList = service.getMemberList();
		
		System.out.println("### 회원 리스트(프로퍼티 주입) ###");
		for(Member m : mList) {
			System.out.println(m);
		}
		
	}

}

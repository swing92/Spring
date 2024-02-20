package com.springstudy.ch02.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.springstudy.ch02.domain.Member;
import com.springstudy.ch02.service.MemberService;

public class MemberBeanConstructorIndex {

	public static void main(String[] args) {
		// DI 컨테이너 - ApplicationContext를 구현한 class
		// 대표로 GenericXmlApplicationContext
		GenericXmlApplicationContext ac = new GenericXmlApplicationContext("classpath:config/MemberBeanConstructorContext.xml");
		
		// dependency lookup
		MemberService service = (MemberService) ac.getBean("memberService");
		// or MemberService service = ac.getBean("memberService", MemberService.class);
		
		List<Member> mList = service.getMemberList();
		for(Member m : mList) {
			System.out.println(m);
		}
		
	}

}

package com.springstudy.ch02.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.springstudy.ch02.domain.Member;
import com.springstudy.ch02.service.MemberService;

public class AnnotationConstructorIndex {

	public static void main(String[] args) {
		// DI 컨테이너 - ApplicationContext를 구현한 class
		// 대표로 GenericXmlApplicationContext
		GenericXmlApplicationContext ac = new GenericXmlApplicationContext("classpath:config/AnnotationConstructorContext.xml");
		
		// dependency lookup
//		MemberService service = (MemberService) ac.getBean("memberServiceImplConstructor");
		// or MemberService service = ac.getBean(MemberService.class);
		
		// Annotation pakage의 MemberServiceImplConstructor에서 @Service("memser")해주면
		 MemberService service = (MemberService) ac.getBean("memserProper");
		
		List<Member> mList = service.getMemberList();
		System.out.println("### Annotation Property ###");
		for(Member m : mList) {
			System.out.println(m);
		}
		
	}

}
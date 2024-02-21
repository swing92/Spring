package com.springstudy.ch03.declaration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectMain {

	public static void main(String[] args) {
		
		ApplicationContext ac = new GenericXmlApplicationContext("AspectContext.xml");
		
		MessageBeanAspectJAnnotation bean1 = ac.getBean("messageBean", MessageBeanAspectJAnnotation.class);
		System.out.println("### messageBean ###");
		bean1.messageDisplay();
		bean1.messageDisplay("손윤제");
		bean1.messageHello();
		
//		System.out.println();
//		System.out.println();
//		
//		MessageBeanAnnotation bean2 = ac.getBean("messageAnnotation", MessageBeanAnnotation.class);
//		System.out.println("### messageAnnotation ###");
//		bean2.messageDisplay();
//		bean2.messageDisplay("심나래");
//		bean2.messageHello();
		
		
	}

}

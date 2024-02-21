package com.springstudy.ch03.declaration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


// Aspect(어드바이스, 포인트컷이 정의되는 클래스)
@Component	// annotation 사용가능
@Aspect	// advice, pointcut 사용가능
public class MessageAspect {
	private final static Log logger = LogFactory.getLog(MessageAspect.class);
	
	
	// Aspect 안에서 포인트컷도 메서드로 정의(포인트컷 지정식)
	@Pointcut("execution(* com.springstudy.ch03.declaration..*Display(String)) && args(name)")
	public void argPointcut(String name) {}
	
	@Pointcut("bean(messageBean*)")
	public void beanScopePointcut() {}
	
	
	
	// Aspect 안에서 어드바이스는 메서드로 정의
	@Before("execution(* com.springstudy.ch03.declaration..*Display(String))")
	public void messageBeforeAdvice(JoinPoint joinPoint) throws Throwable{
		if(logger.isDebugEnabled()) {
			logger.debug("Before - default: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		}
	}
	
	@Before("argPointcut(name) && beanScopePointcut()")
	public void messageBeforeAdvice(JoinPoint joinPoint, String name) throws Throwable {
		if(name.equals("강감찬")) {
			logger.debug("Before - name : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "-arg : " + name);
		}
	}
	
	@Around("execution(* message*(String)) && args(name) && beanScopePointcut()")
	public Object messageAroundAdvice(ProceedingJoinPoint joinPoint, String name) throws Throwable{
		Object obj = null;
		// 앞에 뭔가를 하면 Before Advice가 됨
		if(logger.isDebugEnabled()) {
			logger.debug("Around - Before : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		}
		
		obj = joinPoint.proceed();	// AOP 대상 객체의 메서드를 호출
		
		// 뒤에 뭔가를 하면 After Advice가 됨
		if(logger.isDebugEnabled()) {
			logger.debug("Around - After : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		}
			
		return obj;
	}
}

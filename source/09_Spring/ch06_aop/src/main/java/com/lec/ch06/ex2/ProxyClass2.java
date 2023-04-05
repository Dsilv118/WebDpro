package com.lec.ch06.ex2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ProxyClass2 {
	// around advice : 핵심 기능 전후로 공통 기능 수행
//	@Pointcut("within(com.lec.ch06.ex2.*)")
//	private void aroundM() {}
//	@Around("aroundM");
	@Around("within(com.lec.ch06.ex2.*)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("--------------------------");
		String signatureName = joinPoint.getSignature().toString(); // 핵심 기능 메소드명
		System.out.println(signatureName + "가 시작되었습니다.");
		long startTime = System.currentTimeMillis(); // 시작 시점의 밀리세컨
		try {
			Object object = joinPoint.proceed(); // 핵심 기능 실행
			return object;
		} finally {
			long endTime = System.currentTimeMillis(); // 핵심 기능 수행 후 시점
			System.out.println(signatureName + "가 수행되는 경과 시간 : " + (endTime-startTime));
		}
	}
	// before advice : 핵심 기능 수행 전 공통 기능 수행
	@Before("execution(* com.lec.ch06.ex2.Student2.*())")
	public void beforeAdvice() {
		System.out.println("핵심 기능 수행하기 전 beforeAdvice() 자동 수행");
	}
	// after advice : 핵심 기능 수행 후 공통 기능 수행
	@After("bean(stude*)")
	public void afterAdvice() {
		System.out.println("핵심 기능 수행 후 afterAdvice() 자동 수행");
	}
	// afterReturning advice : 핵심 기능을 에러없이 수행 후 공통 기능 수행
	@AfterReturning("within(com.lec.ch06.ex2.Worker2)")
	public void afterReturningAdvice() {
		System.out.println("핵심 기능 에러 없이 수행 후 afterReturningAdvice() 자동 수행");
	}
	// afterThrowing advice : 핵심 기능에 예외 발생 후 공통 기능 수행
	@AfterThrowing("execution(void com.lec.ch06.ex2.Worker2.get*())")
	public void afterThrowingAdvice() {
		System.out.println("핵심 기능 에러 없이 수행 후 afterThrowingAdvice() 자동 수행");
	}
}

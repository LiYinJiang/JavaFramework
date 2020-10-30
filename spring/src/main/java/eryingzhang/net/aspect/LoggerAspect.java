package eryingzhang.net.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerAspect {
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("start log:" + joinPoint.getSignature().getName());
		Object obj = joinPoint.proceed();
		System.out.println("end log: " + joinPoint.getSignature().getName());
		return obj;
	}
}

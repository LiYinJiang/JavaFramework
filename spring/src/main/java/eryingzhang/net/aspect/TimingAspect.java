package eryingzhang.net.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimingAspect {

	@Around(value = "execution(* eryingzhang.net.service.EquipmentService.*(..))")
	public Object spend(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("start time:" + start);
		Object obj = joinPoint.proceed();
		long spend = System.currentTimeMillis() - start;
		System.out.println("end log: " + spend);
		return obj;
	}
}

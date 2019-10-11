package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//공통모듈
@Component
@Aspect
public class LoggingAdvice {
	@Before("execution(public void sample01.MessageBeanImpl.*PrintBefore())")
	public void beforeTrace() {
		System.out.println("before trace...");
	}
	
	@After("execution(public * *.*.*After(..))")
	public void afterTrace() {
		System.out.println("after trace...");
	}
	
	@Around("execution(public * *.*.*Print(..))")
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("methodName="+methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("호출 전 = "+ methodName);
		
		Object ob = joinPoint.proceed();//핵심관심사항 호출
		System.out.println("ob = "+ob);
		
		sw.stop();
		System.out.println("호출 후 = "+ methodName);
		System.out.println("처리시간 = "+sw.getTotalTimeMillis()/1000+"초");
	}
}



















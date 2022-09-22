package com.ruyuan.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 通用日志的切面类
 */
@Aspect
@Component
public class LoggingAspect implements Ordered {

	/**
	 * 定义切点
	 */
	@Pointcut("execution(public * com.ruyuan.aop.service.ProductServiceImpl.*(..))")
	public void pointcut() {
	}

	/**
	 * 前置通知
	 * 执行方法前记录入参信息
	 */
	@Before(value = "pointcut()")
	public void before(JoinPoint point) {
		System.out.println("【记录日志】before处理，目标方法为：" + point.getSignature().getName() + "，参数列表：" + Arrays.toString(point.getArgs()));
	}

	/**
	 * 后置通知
	 * 执行方法后记录出参信息
	 */
	@AfterReturning(value = "pointcut()", returning = "returnVal")
	public void afterReturning(JoinPoint point, Object returnVal) {
		System.out.println("【记录日志】afterReturning处理，目标方法为：" + point.getSignature().getName() + "，返回值为：" + returnVal);
	}

	/**
	 * after后置通知
	 */
	@After(value = "pointcut()")
	public void after(JoinPoint point) {
		System.out.println("【记录日志】after处理，目标方法为：" + point.getSignature().getName());
	}

	/**
	 * AfterThrowing后置通知
	 */
	@AfterThrowing(value = "pointcut()")
	public void AfterThrowing(JoinPoint point) {
		System.out.println("【记录日志】AfterThrowing处理，目标方法为：" + point.getSignature().getName());
	}

	/**
	 * Around通知
	 */
	@Around(value = "pointcut()")
	public Object Around(ProceedingJoinPoint point) throws Throwable {
		System.out.println("【记录日志】Around前置处理，目标方法为：" + point.getSignature().getName());
		// 继续往下执行，和mi.proceed()这行代码的作用一样，最后会调用到ReflectiveMethodInvocation.proceed()方法
		Object proceed = point.proceed();
		System.out.println("【记录日志】Around后置处理，目标方法为：" + point.getSignature().getName());
		return proceed;
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
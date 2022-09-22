package com.ruyuan.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 缓存切面类
 */
@Aspect
@Component
public class CacheAspect implements Ordered {

	/**
	 * 定义切点
	 */
	@Pointcut("execution(public * com.ruyuan.aop.service.WithoutAopV2ProductServiceImpl.*(..))")
	public void pointcut() {
	}

	/**
	 * 前置通知
	 * 执行方法前的缓存操作
	 */
	@Before(value = "pointcut()")
	public void before(JoinPoint point) {
		System.out.println("【缓存操作】准备执行方法：" + point.getSignature().getName() + "，参数列表：" + Arrays.toString(point.getArgs()));
	}

	/**
	 * 后置通知
	 * 执行方法后的缓存操作
	 */
	@AfterReturning(value = "pointcut()", returning = "returnVal")
	public void afterReturning(JoinPoint point, Object returnVal) {
		System.out.println("【缓存操作】方法执行结束：" + point.getSignature().getName() + "，返回值为：" + returnVal);
	}

	@Override
	public int getOrder() {
		return 2;
	}
}
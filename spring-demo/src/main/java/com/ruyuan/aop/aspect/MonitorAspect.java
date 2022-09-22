package com.ruyuan.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 监控打点切面类
 */
@Aspect
@Component
public class MonitorAspect implements Ordered {

	/**
	 * 定义切点
	 */
	@Pointcut("execution(public * com.ruyuan.aop.service.ProductServiceImpl.addProduct(..))")
	public void pointcut() {
	}

	/**
	 * 前置通知
	 * 执行方法前进行监控打点
	 */
	@Before(value = "pointcut()")
	public void before(JoinPoint point) {
		System.out.println("【监控打点】Before处理，目标方法为：" + point.getSignature().getName() + "，参数列表：" + Arrays.toString(point.getArgs()));
	}

	/**
	 * 后置通知
	 * 执行方法后进行监控打点
	 */
	@AfterReturning(value = "pointcut()", returning = "returnVal")
	public void afterReturning(JoinPoint point, Object returnVal) {
		System.out.println("【监控打点】afterReturning处理，目标方法为：" + point.getSignature().getName() + "，返回值为：" + returnVal);
	}

	/**
	 * after后置通知
	 */
	@After(value = "pointcut()")
	public void after(JoinPoint point) {
		System.out.println("【监控打点】after处理，目标方法为：" + point.getSignature().getName());
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
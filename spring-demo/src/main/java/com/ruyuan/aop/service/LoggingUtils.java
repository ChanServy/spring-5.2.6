package com.ruyuan.aop.service;


import java.util.Arrays;

public class LoggingUtils {
	/**
	 * 方法执行前需要记录的日志
	 */
	public static void before(String methodName,Object[] args) {
		System.out.println("【记录日志】准备执行方法：" + methodName + "，参数列表：" + Arrays.toString(args));
	}

	/**
	 * 方法执行后需要记录的日志
	 */
	public static void after(String methodName, Object returnVal) {
		System.out.println("【记录日志】方法执行结束：" + methodName + "，返回值为：" + returnVal);
	}
}

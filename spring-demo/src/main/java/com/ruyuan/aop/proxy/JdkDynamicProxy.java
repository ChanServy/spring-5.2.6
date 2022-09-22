package com.ruyuan.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * jdk动态代理
 */
public class JdkDynamicProxy implements InvocationHandler {
	/**
	 * 目标对象
	 */
	private Object target;

	public JdkDynamicProxy(Object target) {
		this.target = target;
	}

	/**
	 * 获取目标对象的代理
	 */
	public Object getProxy() {
		//创建动态代理
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),     //指定当前目标对象使用类加载器
				target.getClass().getInterfaces(),      //目标对象实现的接口的类型
				this  //设置回调程序
		);
	}

	/**
	 * 对目标对象的方法进行增强
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//1.增强逻辑，执行方法前记录入参信息
		System.out.println("【记录日志】准备执行方法：" + method.getName() + "，参数列表：" + Arrays.toString(args));

		//2.使用反射调用目标对象方法
		Object result = method.invoke(target, args);

		//3.增强逻辑，执行方法后记录出参信息
		System.out.println("【记录日志】方法执行结束：" + method.getName() + "，返回值为：" + result);

		return result;
	}

}

package com.ruyuan.container.annotation;

import com.ruyuan.container.annotation.model.Student;

public class MyIOCTest {
	public static void main(String[] args) {
		//指定要扫描的包路径
		String packagePath = "com.ruyuan.container.annotation.model";
		//创建我们自己的ApplicationContext实例
		ApplicationContext context = new ApplicationContext(packagePath);

		//根据beanName从容器中获取bean实例
		Student student = (Student) context.getBean("student");
		//调用实例的eat()方法
		student.eat();
	}
}
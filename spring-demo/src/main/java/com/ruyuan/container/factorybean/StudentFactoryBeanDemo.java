package com.ruyuan.container.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentFactoryBeanDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		Student student = (Student) ctx.getBean("student");
		Object studentFactoryBean = ctx.getBean("&student");

		System.out.println(student);
		System.out.println(studentFactoryBean);
	}

}

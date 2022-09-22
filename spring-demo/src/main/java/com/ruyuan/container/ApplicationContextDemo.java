package com.ruyuan.container;

import com.ruyuan.container.cycle.setter.Student1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class ApplicationContextDemo {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student1 student = (Student1) ctx.getBean("student1");
		Student1 student1 = (Student1) ctx.getBean("student1");
		System.out.println(student);
		System.out.println(student1);
	}

}


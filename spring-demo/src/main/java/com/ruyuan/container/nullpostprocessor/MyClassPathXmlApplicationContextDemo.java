package com.ruyuan.container.nullpostprocessor;

import com.ruyuan.container.NewClassPathXmlApplicationContext;
import com.ruyuan.container.Student;
import org.springframework.context.ApplicationContext;

@SuppressWarnings("all")
public class MyClassPathXmlApplicationContextDemo {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new MyClassPathXmlApplicationContext("applicationContext.xml");
		Student student = (Student) ctx.getBean("student");
		System.out.println(student.getName());
	}

}


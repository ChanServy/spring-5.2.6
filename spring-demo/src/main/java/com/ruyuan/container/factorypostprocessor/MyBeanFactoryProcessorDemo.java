package com.ruyuan.container.factorypostprocessor;

import com.ruyuan.container.Student;
import com.ruyuan.container.nullpostprocessor.MyClassPathXmlApplicationContext;
import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class MyBeanFactoryProcessorDemo {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student = (Student) ctx.getBean("student");
		System.out.println(student.getName());
	}

}


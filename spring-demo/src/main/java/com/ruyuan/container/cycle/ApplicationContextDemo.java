package com.ruyuan.container.cycle;

import com.ruyuan.container.cycle.constructor.Student1;
import com.ruyuan.container.cycle.setter.Student2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class ApplicationContextDemo {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Student2 student1 = (Student2) ctx.getBean("student2");
		//System.out.println(student1);
	}

}


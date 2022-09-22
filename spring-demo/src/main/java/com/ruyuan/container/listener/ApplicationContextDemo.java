package com.ruyuan.container.listener;

import com.ruyuan.container.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class ApplicationContextDemo {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctx.publishEvent(new MyEvent("myEvent"));
	}

}

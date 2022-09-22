package com.ruyuan.container;

import com.ruyuan.container.subelement.Student;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("all")
public class BeanFactoryDemo {

	public static void main(String[] args) throws Exception {
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		Student student = (Student) beanFactory.getBean("student");
		System.out.println(student);
	}

}


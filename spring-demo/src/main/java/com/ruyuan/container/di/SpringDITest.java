package com.ruyuan.container.di;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("all")
public class SpringDITest {
	public static void main(String[] args) {
		//1.student和phone均由Spring容器来负责创建
		//2.在创建student时，其内部的phone变量，由Spring通过构造方法的方式从外部注入到student中
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		Student student = (Student)beanFactory.getBean("myStudent");
		student.playGame();
	}

    /**
	 * 学生类
	 */
	public static class Student {
		/**
		 * 姓名
		 */
		private String name;
		/**
		 * 手机
		 */
		private Phone phone;

		public Student(String name, Phone phone) {
			this.name = name;
			this.phone = phone;
		}

		/**
		 * 使用手机玩游戏
		 */
		public void playGame() {
			//用手机玩游戏
			phone.playGame(name);
		}
	}
}

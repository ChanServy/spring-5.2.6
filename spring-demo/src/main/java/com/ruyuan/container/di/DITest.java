package com.ruyuan.container.di;

import java.util.Random;

public class DITest {
	public static void main(String[] args) {
		Random random = new Random();
		//随机产生一个Boolean类型的值
		boolean nextBoolean = random.nextBoolean();

		//从Iphone12和Iphone13中随机选出一个来创建phone
		//重要的是，此时是由外部来负责创建phone的，而不是由Student创建，说白了此时Student就失去了phone的控制权
		Phone phone = nextBoolean ? new Iphone12() : new Iphone13();

		//创建一个student对象，同时传入外部创建好的phone
		Student student = new Student("张三", phone);
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

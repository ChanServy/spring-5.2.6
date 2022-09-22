package com.ruyuan.container.di;


public class WithoutDITest {
	public static void main(String[] args) {
		//创建一个student对象，phone由Student自己来负责创建
		Student student = new Student("张三");
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

		public Student(String name) {
			this.name = name;
		}

		/**
		 * 使用手机玩游戏
		 */
		public void playGame() {
			//Student自己负责创建phone，此时phone的控制权在自己的手上
			//Phone phone = new Iphone12();
			//如果要从Iphone12换成Iphone13，就必须要修改这行代码才行
			Phone phone = new Iphone13();
			//用手机玩游戏
			phone.playGame(name);
		}
	}
}

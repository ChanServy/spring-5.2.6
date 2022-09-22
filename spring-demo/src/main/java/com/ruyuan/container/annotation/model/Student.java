package com.ruyuan.container.annotation.model;

import com.ruyuan.container.annotation.MyComponent;

@MyComponent(value = "test-value")
public class Student {
	private String name;
	private int age;

	public void eat() {
		System.out.println("这是Student类的eat()方法");
	}
}
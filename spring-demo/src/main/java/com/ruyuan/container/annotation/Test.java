package com.ruyuan.container.annotation;

import com.ruyuan.container.annotation.model.Student;

public class Test {
    public static void main(String[] args) {
        //获取学生类的class对象
        Class<Student> studentClass = Student.class;
        //判断学生类是否加了MyComponent注解
        if (studentClass.isAnnotationPresent(MyComponent.class)) {
            //获取学生类上的myComponent注解
            MyComponent myComponent = studentClass.getAnnotation(MyComponent.class);
            //打印myComponent的value属性
            System.out.println("studentClass加了MyComponent注解，value = " + myComponent.value() + "，这里可以做一些特殊处理，说白了就是给注解添加功能");
        }else {
            System.out.println("studentClass没有加MyComponent注解");
        }
    }
}
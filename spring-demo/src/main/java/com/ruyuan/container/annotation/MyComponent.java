package com.ruyuan.container.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 元注解@Retention表示所定义的注解什么时候有效,
 * RetentionPolicy.RUNTIME 表示在运行时有效
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyComponent {
    String value() default "";
} 
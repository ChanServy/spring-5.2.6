package com.ruyuan.container;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NewClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {


    public NewClassPathXmlApplicationContext(String... configLocations){
        super(configLocations);
    }

    @Override
    protected void initPropertySources() {
        System.out.println("重写initPropertySource方法...");
        getEnvironment().setRequiredProperties("JAVA_HOME");
    }
}
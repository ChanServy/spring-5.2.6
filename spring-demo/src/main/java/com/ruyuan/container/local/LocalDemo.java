package com.ruyuan.container.local;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.GregorianCalendar;
import java.util.Locale;

public class LocalDemo {

	public static void main(String[] args) {
		ResourceBundleMessageSource ds = new ResourceBundleMessageSource();
		ds.addBasenames("test/messages");

		Object[] params = {"jo", new GregorianCalendar().getTime()};

		String test = ds.getMessage("test", params, Locale.US);
		System.out.println(test);
	}

}

package com.ruyuan.container.annotation;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

	/**
	 * ioc容器
	 */
	private Map<String, Object> iocMap = new ConcurrentHashMap<>();

	/**
	 * 构造方法
	 */
	public ApplicationContext(String packagePath) {
		//扫描指定的包路径
		scanPackage(packagePath);
	}

	/**
	 * 通过beanName获取bean实例
	 */
	public Object getBean(String beanName) {
		return iocMap.get(beanName);
	}

	/**
	 * 扫描指定的包路径
	 */
	private void scanPackage(String packagePath) {
		//1.获取这个目录下所有的class文件
		File[] classFiles = getClassFiles(packagePath);
		//2.处理所有的class文件，为加了@MyComponent注解的类创建实例，并放入到ioc容器中
		processClassFiles(packagePath, classFiles);
	}

	/**
	 * 获取这个目录下所有的class文件
	 */
	private File[] getClassFiles(String packagePath) {
		//1.通过packagePath获取对应的file对象
		File file = getFile(packagePath);
		//2.过滤出所有的class文件
		return filterClassFiles(packagePath, file);
	}

	/**
	 * 通过packagePath获取对应的file对象
	 */
	private File getFile(String packagePath) {
		//1.将包路径中的"."替换为"/"，说白了就是替换为目录结构，比如 com.ruyuan.container.annotation.model -> com/ruyuan/container/annotation/model
		String packageDir = packagePath.replaceAll("\\.", "/");

		//2.获取这个目录在类路径中的位置
		URL url = getClass().getClassLoader().getResource(packageDir);

		//3.通过目录获取到文件对象
		return new File(url.getFile());
	}

	/**
	 * 过滤出所有的class文件
	 */
	private File[] filterClassFiles(String packagePath, File file) {
		//1.过滤出来文件下的所有class文件
		return file.listFiles(f -> {
			String fileName = f.getName();
			//2.如果是目录，那么再次扫描这个目录下的文件
			if (f.isDirectory()) {
				scanPackage(packagePath + "." + fileName);
			} else {
				//3.如果文件后缀是.class，就返回true，说白了就是过滤出所有的class文件
				if (fileName.endsWith(".class")) {
					return true;
				}
			}
			return false;
		});
	}

	/**
	 * 处理所有的class文件
	 */
	private void processClassFiles(String packagePath, File[] classFiles) {
		for (File classFile : classFiles) {
			//1.去除后缀，获取class文件名
			String className = classFile.getName().substring(0, classFile.getName().lastIndexOf("."));

			//2.拼接出来类的全限定类名fullyClassName，后边反射需要用到
			String fullyClassName = packagePath + "." + className;

			//3.将类名首字母转小写，得到beanName，beanName后边会作为ioc容器的key
			String beanName = String.valueOf(className.charAt(0)).toLowerCase() + className.substring(1);

			//4.创建实例并放入到ioc容器中
			createBean(beanName, fullyClassName);
		}
	}

	/**
	 * 创建实例并放入到ioc容器中
	 */
	private void createBean(String beanName, String fullyClassName) {
		try {
			//1.通过反射创建出class对象
			Class<?> c = Class.forName(fullyClassName);

			//2.判断这个类上是否加了MyComponent注解
			if (c.isAnnotationPresent(MyComponent.class)) {
				System.out.println("fullyClassName = " + fullyClassName + "加了@MyComponent注解，准备通过反射创建实例，并放入到iocMap中");
				//3.通过反射创建出实例
				Object instance = c.newInstance();
				//4.将实例放入到ioc容器中，ioc容器本质就是一个map
				iocMap.put(beanName, instance);
			} else {
				System.out.println("fullyClassName = " + fullyClassName + "没有加@MyComponent注解，所以不需要创建实例");
			}
		} catch (Exception e) {
			System.out.println("通过反射创建实例放入ioc时报错");
		}
	}

}
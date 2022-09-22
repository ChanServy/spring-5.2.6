package com.ruyuan.aop.proxy;

import com.ruyuan.aop.model.Product;
import com.ruyuan.aop.service.ProductService;
import com.ruyuan.aop.service.ProductServiceImpl;

import java.math.BigDecimal;

public class Test {
	public static void main(String[] args) {
		//测试使用的数据
		Integer productId = 123;
		Product product = Product.builder()
				.productId(productId)
				.productName("红烧肉")
				.productPrice(BigDecimal.valueOf(28))
				.build();

		//目标对象
		ProductService target = new ProductServiceImpl();

		//测试静态代理
		System.out.println("------------------静态代理------------------");
		//创建静态代理
		ProductServiceProxy staticProxy = new ProductServiceProxy(target);
		//调用代理方法
		staticProxy.addProduct(product);
		staticProxy.getProductById(productId);


		//测试jdk动态代理
		System.out.println("------------------jdk动态代理------------------");
		//创建jdk动态代理
		ProductService jdkDynamicProxy = (ProductService) new JdkDynamicProxy(target).getProxy();
		//调用代理方法
		jdkDynamicProxy.addProduct(product);
		jdkDynamicProxy.getProductById(productId);


		//测试cglib动态代理
		System.out.println("------------------cglib动态代理------------------");
		//创建cglib动态代理
		ProductServiceImpl cglibDynamicProxy = (ProductServiceImpl) new CglibDynamicProxy(target).getProxy();
		//调用代理方法
		cglibDynamicProxy.addProduct(product);
		cglibDynamicProxy.getProductById(productId);
	}
}

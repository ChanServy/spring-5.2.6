package com.ruyuan.aop.proxy;

import com.ruyuan.aop.model.Product;
import com.ruyuan.aop.service.ProductService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * ProductService的代理类
 */
public class ProductServiceProxy implements ProductService {

	/**
	 * 目标类
	 */
	private ProductService target;

	public ProductServiceProxy(ProductService target) {
		this.target = target;
	}

	@Override
	public void addProduct(Product product) {
		//1.执行方法前记录入参信息
		System.out.println("【记录日志】准备执行方法：addProduct，参数列表：" + product);

		//2.调用目标类完成功能
		target.addProduct(product);

		//3.执行方法后记录出参
		System.out.println("【记录日志】方法执行结束：addProduct");
	}

	@Override
	public Product getProductById(Integer productId) {
		//1.执行方法前记录入参信息
		System.out.println("【记录日志】准备执行方法：getProductById，参数列表：" + productId);

		//2.调用目标类完成功能
		Product product = target.getProductById(productId);

		//3.执行方法后记录出参
		System.out.println("【记录日志】方法执行结束：getProductById，返回值为：" + product);
		return product;
	}
}

package com.ruyuan.aop.service;

import com.ruyuan.aop.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 商品service组件
 */
@Component
public class WithoutAopProductServiceImpl implements ProductService {

	@Override
	public void addProduct(Product product) {
		//1.执行方法前记录入参信息
		System.out.println("【记录日志】准备执行方法：addProduct，参数列表：" + product);

		//2.执行方法核心逻辑
		System.out.println("开始执行添加商品的操作，product：" + product);

		//3.执行方法后记录出参
		System.out.println("【记录日志】方法执行结束：addProduct");
	}

	@Override
	public Product getProductById(Integer productId) {
		//1.执行方法前记录入参信息
		System.out.println("【记录日志】准备执行方法：getProductById，参数列表：" + productId);

		//2.执行方法核心逻辑
		System.out.println("开始执行查询商品的操作，productId：" + productId);
		Product product = Product.builder()
				.productId(productId)
				.productName("红烧肉")
				.productPrice(BigDecimal.valueOf(28))
				.build();

		//3.执行方法后记录出参
		System.out.println("【记录日志】方法执行结束：getProductById，返回值为：" + product);
		return product;
	}
}

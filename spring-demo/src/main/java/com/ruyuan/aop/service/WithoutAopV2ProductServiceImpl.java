package com.ruyuan.aop.service;

import com.ruyuan.aop.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 商品service组件
 */
@Component
public class WithoutAopV2ProductServiceImpl implements ProductService {

	@Override
	public void addProduct(Product product) {
		//1.执行方法前记录入参信息
		LoggingUtils.before("addProduct",new Object[]{product});

		//2.执行方法核心逻辑
		System.out.println("开始执行添加商品的操作，product：" + product);

		//3.执行方法后记录出参
		LoggingUtils.after("addProduct",null);
	}

	@Override
	public Product getProductById(Integer productId) {
		//1.执行方法前记录入参信息
		LoggingUtils.before("getProductById",new Object[]{productId});

		//2.执行方法核心逻辑
		System.out.println("开始执行查询商品的操作，productId：" + productId);
		Product product = Product.builder()
				.productId(productId)
				.productName("红烧肉")
				.productPrice(BigDecimal.valueOf(28))
				.build();

		//3.执行方法后记录出参
		LoggingUtils.after("getProductById",product);
		return product;
	}
}

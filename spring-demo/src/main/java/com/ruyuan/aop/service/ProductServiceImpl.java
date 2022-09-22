package com.ruyuan.aop.service;

import com.ruyuan.aop.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 商品service组件
 */
@Component
public class ProductServiceImpl implements ProductService {

	@Override
	public void addProduct(Product product) {
		//执行方法核心逻辑
		System.out.println("【执行目标方法】开始执行添加商品的操作，product：" + product);
	}

	@Override
	public Product getProductById(Integer productId) {
		//执行方法核心逻辑
		System.out.println("【执行目标方法】开始执行查询商品的操作，productId：" + productId);
		return Product.builder()
				.productId(productId)
				.productName("红烧肉")
				.productPrice(BigDecimal.valueOf(28))
				.build();
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("【执行目标方法】开始进行equals比较");
		return (this == obj);
	}
}

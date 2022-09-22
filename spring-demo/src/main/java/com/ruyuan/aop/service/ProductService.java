package com.ruyuan.aop.service;

import com.ruyuan.aop.model.Product;

/**
 * 商品接口
 */
public interface ProductService {

	/**
	 * 添加商品
	 * @param product	要添加的商品
	 */
	void addProduct(Product product);

	/**
	 * 根据productId查询指定商品
	 * @param productId	商品id
	 * @return			商品
	 */
	Product getProductById(Integer productId);

	boolean equals(Object obj);
}

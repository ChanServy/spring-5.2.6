package com.ruyuan.aop;

import com.ruyuan.aop.model.Product;
import com.ruyuan.aop.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class WithoutAopV2Test {
    public static void main(String[] args) {
        //1.创建并启动IOC容器，applicationContext.xml文件中读取配置bean配置
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.从IOC容器中获取productService对象
        ProductService productService = (ProductService) context.getBean("withoutAopV2ProductServiceImpl");

        //3.调用productService对象的方法
		Product product = Product.builder()
				.productId(123)
				.productName("红烧肉")
				.productPrice(BigDecimal.valueOf(28))
				.build();
        productService.addProduct(product);
        System.out.println("----------------------------");
        productService.getProductById(123);

    }
}

package com.example.phoneShopping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.phoneShopping.product.domain.Product;
import com.example.phoneShopping.product.dto.request.CreateProductRequest;
import com.example.phoneShopping.product.dto.request.UpdateProductRequest;
import com.example.phoneShopping.product.service.ProductService;

@SpringBootTest
public class ProductTest 
{
	@Autowired
	ProductService service;
	
	//@Test
	void create()
	{
		Product prod = new Product("a", "aa", 1, 1, 1, 1);
		CreateProductRequest req = new CreateProductRequest(prod.getProdSeq(), prod.getProdName(), prod.getProdPrice(), prod.getProdCnt(), prod.getHddSeq(), prod.getColorSeq());
		service.createProduct(req);
	}
	
	//@Test
	void create1()
	{
		Product prod = new Product("b", "bb", 2, 2, 2, 2);
		CreateProductRequest req = new CreateProductRequest(prod.getProdSeq(), prod.getProdName(), prod.getProdPrice(), prod.getProdCnt(), prod.getHddSeq(), prod.getColorSeq());
		service.createProduct(req);
		
		Product prod1 = new Product("c", "cc", 3, 3, 3, 3);
		CreateProductRequest req1 = new CreateProductRequest(prod1.getProdSeq(), prod1.getProdName(), prod1.getProdPrice(), prod1.getProdCnt(), prod1.getHddSeq(), prod1.getColorSeq());
		service.createProduct(req1);
		
		Product prod2 = new Product("d", "dd", 4, 4, 4, 4);
		CreateProductRequest req2 = new CreateProductRequest(prod2.getProdSeq(), prod2.getProdName(), prod2.getProdPrice(), prod2.getProdCnt(), prod2.getHddSeq(), prod2.getColorSeq());
		service.createProduct(req2);
	}
	
	//@Test
	void update()
	{
		UpdateProductRequest req = new UpdateProductRequest("a", "aaa", 11, 11, 11, 11);
		service.updateProduct(req);
		
		UpdateProductRequest req2 = new UpdateProductRequest("b", "bbb", 22, 22, 22, 22);
		service.updateProduct(req2);
		
		UpdateProductRequest req3 = new UpdateProductRequest("c", "ccc", 33, 33, 33, 33);
		service.updateProduct(req3);
		
		UpdateProductRequest req4 = new UpdateProductRequest("d", "ddd", 44, 44, 44, 44);
		service.updateProduct(req4);
	}
	
	
	//@Test
	void delete()
	{
		service.deleteProduct("b");
	}
	
	
	@Test
	void getAll() 
	{
		service.findAllProduct();
	}
	
	//@Test
	void getOne()
	{
		service.findByIdProduct("a");
	}
	
	
	
}

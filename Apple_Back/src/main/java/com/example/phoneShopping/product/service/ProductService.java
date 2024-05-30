package com.example.phoneShopping.product.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.product.dao.ProductDao;
import com.example.phoneShopping.product.domain.Product;
import com.example.phoneShopping.product.dto.param.CreateProductParam;
import com.example.phoneShopping.product.dto.param.UpdateProductParam;
import com.example.phoneShopping.product.dto.request.CreateProductRequest;
import com.example.phoneShopping.product.dto.request.UpdateProductRequest;
import com.example.phoneShopping.product.dto.response.CreateProductResponse;
import com.example.phoneShopping.product.dto.response.DeleteProductResponse;
import com.example.phoneShopping.product.dto.response.UpdateProductResponse;
import com.example.phoneShopping.product.exception.ProductException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService 
{
	private final ProductDao dao;
	
	// 상품 추가
	@Transactional
	public CreateProductResponse createProduct(CreateProductRequest req) 
	{
		saveProduct(req);
		return new CreateProductResponse(req.getProdSeq());
	}
	
	
	// 상품 추가 method
	private void saveProduct(CreateProductRequest req) 
	{
		CreateProductParam param = new CreateProductParam(req);
		Integer result = dao.createProduct(param);
		
		if (result == 0) 
		{
			throw new ProductException("상품 등록을 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	// 상품 상세 1개
	@Transactional
	public Product findByIdProduct(String prodSeq) 
	{
		System.out.println("findByIdProduct 동작");
		dao.findByIdProduct(prodSeq);
		
		return dao.findByIdProduct(prodSeq);
	}
	
	
	// 상품 목록
	@Transactional
	public List<Product> findAllProduct() 
	{
		System.out.println("findAllProduct 동작");
		List<Product> listProd = dao.findAllProduct();
		
		for (int i = 0 ; i < listProd.size(); i++) 
		{
			System.out.println(listProd.get(i));
		}
		
		return listProd;		
	}
	
	
	// 상품 수정
	@Transactional
	public UpdateProductResponse updateProduct(UpdateProductRequest req) 
	{
		findByIdProduct(req.getProdSeq());
		return new UpdateProductResponse(updateProductMethod(req));
	}
	
	// 상품 수정 Method
	private Integer updateProductMethod(UpdateProductRequest req) 
	{
		System.out.println("updateProduct 동작");
		UpdateProductParam param = new UpdateProductParam(req.getProdSeq(), req.getProdName(), req.getProdCnt(),
					req.getProdPrice(), req.getHddSeq(), req.getColorSeq());
		
		System.out.println(param.getProdSeq());
		
		Integer result = dao.updateProduct(param);
		
		System.out.println(result);
		
		if (result == 0) 
		{
			throw new ProductException("상품 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	// 상품 삭제
	@Transactional
	public DeleteProductResponse deleteProduct(String prod_seq) 
	{
		System.out.println("deleteProduct 동작");
		int number = dao.deleteProduct(prod_seq);
		if(number == 0)
		{
			System.out.println("삭제 실패, 정보가 존재하지 않습니다.");
		}
		return new DeleteProductResponse(number);
	}
}

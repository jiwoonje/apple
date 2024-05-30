package com.example.phoneShopping.product.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.phoneShopping.member.dto.response.DeleteInfoResponse;

import com.example.phoneShopping.product.domain.Product;
import com.example.phoneShopping.product.dto.request.CreateProductRequest;
import com.example.phoneShopping.product.dto.request.UpdateProductRequest;
import com.example.phoneShopping.product.dto.response.CreateProductResponse;
import com.example.phoneShopping.product.dto.response.DeleteProductResponse;
import com.example.phoneShopping.product.dto.response.UpdateProductResponse;
import com.example.phoneShopping.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Product Controller", description = "상품 정보 API")
@RestController
@RequestMapping("/admin/product")
@RequiredArgsConstructor
public class ProductController {

	// DI : 생성자 주입
	private final ProductService service;
	
	// 상품 추가
	@Operation(summary = "createProduct() - 상품 정보 생성 API ", 
			description = "상품 정보를 생성하는 method <br>"
					+ "관리자 계정에서만 상품을 관리 가능")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="상품 생성 완료", content={@Content(schema = @Schema(implementation = CreateProductResponse.class))}),
			@ApiResponse(responseCode = "404", description="모든 항목 입력은 필수입니다."),
			@ApiResponse(responseCode = "405", description="이미 존재하는 상품")
	})
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateProductResponse> createProduct (
			@RequestBody CreateProductRequest req) 
	{	
		System.out.println("ProductController createProduct" + new Date());
		
		return ResponseEntity.ok(service.createProduct(req));
	}
	
	
	// 상품 상세 1개
	@Operation(summary = "findByIdProduct() - 특정 상품 정보 1개 조회 API ", 
			description = "특정 상품 정보 1개만 내용을 조회하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="상품정보가 존재합니다."),
			@ApiResponse(responseCode = "404", description="존재하지 않는 정보입니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne/{prodSeq}")
	public Product findByIdProduct(
			@Parameter(name = "prodSeq", description = "특정 상품 정보 조회에 사용할 ID값", example = "19번째", required = true)
			@PathVariable(value = "prodSeq")String prodSeq) 
	{
		System.out.println("상품 정보 1개 출력");
		System.out.println(prodSeq);
		return service.findByIdProduct(prodSeq);
	}
	
	
	
	// 상품 목록
	@Operation(summary = "findAllProduct() - 상품 정보 전체 조회 API ", 
			description = "전체 상품 정보를 조회하는 method로 DB안에 저장된 product table의 모든 값을 불러온다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="findAllProduct성공"),
			@ApiResponse(responseCode = "500", description="findAllProduct실패, 정보를 불러오는데 오류가 발생했습니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Product> findAllProduct() 
	{
		System.out.println("상품 정보 전체 출력");
		return service.findAllProduct();
	}
	
	
	// 상품 수정
	@Operation(summary = "updateProduct() - 상품 정보 수정 API ", 
			description = "상품 정보를 수정하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="상품 정보 수정 완료", content={@Content(schema = @Schema(implementation = UpdateProductResponse.class))}),
			@ApiResponse(responseCode = "405", description="수정 실패, 모든 정보를 입력했는지 확인하세요")
	})
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/update/{prodSeq}")
	public ResponseEntity<UpdateProductResponse> updateProduct (
			@RequestBody UpdateProductRequest req) 
	{
		System.out.println("상품 정보 수정");
		return ResponseEntity.ok(service.updateProduct(req));
	}
	
	
	// 상품 삭제
	@Operation(summary = "deleteProduct() - 상품 정보 삭제 API ", 
			description = "상품 정보를 삭제하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="상품 정보 삭제 완료", content={@Content(schema = @Schema(implementation = DeleteInfoResponse.class))}),
			@ApiResponse(responseCode = "405", description="삭제 실패, 다시 입력해주세요")
	})
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/delete/{prodSeq}")
	public ResponseEntity<DeleteProductResponse> deleteProduct(
			@Parameter(name = "prodSeq", description = "특정 상품 정보 조회에 사용할 ID값", example = "19th", required = true)
			@PathVariable(value = "prodSeq") String prodSeq) 

	{
		System.out.println("상품 정보 제거");
		System.out.println(prodSeq);
		return ResponseEntity.ok(service.deleteProduct(prodSeq));
	}
	
}

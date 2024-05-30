package com.example.phoneShopping.cart.controller;

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

import com.example.phoneShopping.cart.domain.Cart;
import com.example.phoneShopping.cart.domain.CartProduct;
import com.example.phoneShopping.cart.dto.request.CreateCartProductRequest;
import com.example.phoneShopping.cart.dto.request.CreateCartRequest;
import com.example.phoneShopping.cart.dto.request.UpdateCartProductRequest;
import com.example.phoneShopping.cart.dto.request.UpdateCartRequest;
import com.example.phoneShopping.cart.dto.response.CreateCartProductResponse;
import com.example.phoneShopping.cart.dto.response.CreateCartResponse;
import com.example.phoneShopping.cart.dto.response.DeleteCartProductResponse;
import com.example.phoneShopping.cart.dto.response.DeleteCartResponse;
import com.example.phoneShopping.cart.dto.response.UpdateCartProductResponse;
import com.example.phoneShopping.cart.dto.response.UpdateCartResponse;
import com.example.phoneShopping.cart.service.CartService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@Tag(name = "Cart & Cart Product Controller", description = "장바구니 & 장바구니 상품 API")
@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController 
{
	private final CartService service;
	
	
	@Operation(summary = "createCart() - 장바구니 생성 API ", 
			description = "장바구니 정보를 생성하는 method <br>"
					+ "회원이 여러 상품을 한꺼번에 사려고 할 때 만들어지는 장바구니 <br>"
					+ "1인 1장바구니의 관계를 갖는다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="장바구니 생성 완료", content={@Content(schema = @Schema(implementation = CreateCartResponse.class))}),
			@ApiResponse(responseCode = "404", description="모든 항목 입력은 필수입니다."),
			@ApiResponse(responseCode = "405", description="이미 존재하는 회원정보")
	})
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateCartResponse> createCart(@RequestBody CreateCartRequest req)
	{
		System.out.println("Cart 정보 생성");
		return ResponseEntity.ok(service.createCart(req));
	}
	
	
	@Operation(summary = "findAllCart() - 카트 전체 조회 API ", 
			description = "전체 카트 정보를 조회하는 method로 DB안에 저장된 Cart table의 모든 값을 불러온다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="findAllCart성공"),
			@ApiResponse(responseCode = "500", description="findAllCart실패, 정보를 불러오는데 오류가 발생했습니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Cart> findAllCart()
	{
		System.out.println("Cart 정보 전체 출력");
		return service.findAllCart();
	}
	
	
	@Operation(summary = "findByIdCart() - 특정 장바구니 정보 1개 조회 API ", 
			description = "특정 장바구니 정보 1개만 내용을 조회하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="장바구니가 존재합니다."),
			@ApiResponse(responseCode = "404", description="존재하지 않는 정보입니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{cartSeq}")
	public Cart findByIdCart(
			@Parameter(name = "cartSeq", description = "특정 장바구니 정보 조회에 사용할 ID값", example = "5", required = true)
			@PathVariable(value = "cartSeq") int cartSeq)
	{
		System.out.println("Cart 정보 1개 출력");
		System.out.println(cartSeq);
		return service.findByIdCart(cartSeq);
	}
	
	
	@Operation(summary = "updateCart() - 장바구니 정보 수정 API ", 
			description = "장바구니 정보를 수정하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="정보 수정 완료", content={@Content(schema = @Schema(implementation = UpdateCartResponse.class))}),
			@ApiResponse(responseCode = "405", description="수정 실패, 모든 정보를 입력했는지 확인하세요")
	})
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{cartSeq}")
	public ResponseEntity<UpdateCartResponse> updateCart(@RequestBody UpdateCartRequest req)
	{
		System.out.println("Cart 정보 수정");
		return ResponseEntity.ok(service.updateCart(req));
	}
	
	
	@Operation(summary = "deleteCart() - 장바구니 정보 삭제 API ", 
			description = "장바구니 정보를 삭제하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="장바구니 정보 삭제 완료", content={@Content(schema = @Schema(implementation = DeleteCartResponse.class))}),
			@ApiResponse(responseCode = "405", description="삭제 실패, 다시 입력해주세요")
	})
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{cartSeq}")
	public ResponseEntity<DeleteCartResponse> deleteCart(
			@Parameter(name = "cartSeq", description = "장바구니 정보 조회에 사용할 ID값", example = "6", required = true)
			@PathVariable(value = "cartSeq") int cartSeq)
	{
		System.out.println("Cart 정보 제거");
		System.out.println(cartSeq);
		return ResponseEntity.ok(service.deleteCart(cartSeq));
	}
	
	
	
	
	
	
	@Operation(summary = "createCartProduct() - 장바구니 상품 생성 API ", 
			description = "장바구니에 들어갈 상품 정보를 생성하는 method <br>"
					+ "회원이 장바구니에 담을 상품 정보를 Product table과 Cart Table을 참조하여 저장한다.(=어떤 장바구니에 어떤 상품들이 담겨 있음을 나타낸다.)  <br>"
					+ "장바구니안의 상품들은는 결제 상품table로 데이터를 넘긴 후 비워진 상태여야하며, 1장바구니 N장바구니 상품의 관계를 갖는다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="장바구니 상품 생성 완료", content={@Content(schema = @Schema(implementation = CreateCartProductResponse.class))}),
			@ApiResponse(responseCode = "404", description="모든 항목 입력은 필수입니다."),
			@ApiResponse(responseCode = "405", description="이미 존재하는 상품정보")
	})
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/createCartProduct")
	public ResponseEntity<CreateCartProductResponse> createCartProduct(@RequestBody CreateCartProductRequest req)
	{
		System.out.println("CartProduct 정보 생성");
		return ResponseEntity.ok(service.createCartProduct(req));
	}
	
	
	@Operation(summary = "findAllCartProduct() - 카트 상품 전체 조회 API ", 
			description = "카트 하나에 담긴 전체 상품 정보를 조회하는 method로 DB안에 저장된 Cart Product table의 모든 값을 불러온다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="findAllCartProduct성공"),
			@ApiResponse(responseCode = "500", description="findAllCartProduct실패, 정보를 불러오는데 오류가 발생했습니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAllCartProduct")
	public List<CartProduct> findAllCartProduct()
	{
		System.out.println("CartProduct 정보 전체 출력");
		return service.findAllCartProduct();
	}
	
	
	@Operation(summary = "findByIdCartProduct() - 장바구니에 담긴 특정 상품 정보 1개 조회 API ", 
			description = "장바구니에 담긴 특정 상품 정보 1개만 내용을 조회하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="장바구니 상품이 존재합니다."),
			@ApiResponse(responseCode = "404", description="존재하지 않는 정보입니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOneCartProduct/{cartpSeq}")
	public CartProduct findByIdCartProduct(
			@Parameter(name = "cartpSeq", description = "장바구니에 담긴 상품 정보 조회에 사용할 ID값", example = "5", required = true)
			@PathVariable(value = "cartpSeq") int cartpSeq)
	{
		System.out.println("CartProduct 정보 1개 출력");
		System.out.println(cartpSeq);
		return service.findByIdCartProduct(cartpSeq);
	}
	
	
	@Operation(summary = "updateCartProduct() - 장바구니에 담긴 특정 상품 정보 수정 API ", 
			description = "장바구니에 담긴 특정 상품 정보를 수정하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="상품정보 수정 완료", content={@Content(schema = @Schema(implementation = UpdateCartProductResponse.class))}),
			@ApiResponse(responseCode = "405", description="수정 실패, 모든 정보를 입력했는지 확인하세요")
	})
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/UpdateCartProduct/{cartpSeq}")
	public ResponseEntity<UpdateCartProductResponse> updateCartProduct(@RequestBody UpdateCartProductRequest req)
	{
		System.out.println("CartProduct 정보 수정");
		return ResponseEntity.ok(service.updateCartProduct(req));
	}
	
	
	@Operation(summary = "deleteCartProduct() - 카트안에 담긴 상품 정보 삭제 API ", 
			description = "카트안에 담긴 상품 정보를 삭제하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="상품정보 삭제 완료", content={@Content(schema = @Schema(implementation = DeleteCartProductResponse.class))}),
			@ApiResponse(responseCode = "405", description="삭제 실패, 다시 입력해주세요")
	})
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/deleteCartProduct/{cartpSeq}")
	public ResponseEntity<DeleteCartProductResponse> deleteCartProduct(
			@Parameter(name = "cartpSeq", description = "장바구니에 담긴 특정 상품 정보 조회에 사용할 ID값", example = "19", required = true)
			@PathVariable(value = "cartpSeq") int cartpSeq)
	{
		System.out.println("CartProduct 정보 제거");
		System.out.println(cartpSeq);
		return ResponseEntity.ok(service.deleteCartProduct(cartpSeq));
	}
}

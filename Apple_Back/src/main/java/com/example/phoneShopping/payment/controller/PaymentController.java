package com.example.phoneShopping.payment.controller;

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


import com.example.phoneShopping.payment.domain.Payment;
import com.example.phoneShopping.payment.domain.PaymentProduct;
import com.example.phoneShopping.payment.dto.request.CreatePaymentProductRequest;
import com.example.phoneShopping.payment.dto.request.CreatePaymentRequest;
import com.example.phoneShopping.payment.dto.request.UpdatePaymentProductRequest;
import com.example.phoneShopping.payment.dto.request.UpdatePaymentRequest;
import com.example.phoneShopping.payment.dto.response.CreatePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.CreatePaymentResponse;
import com.example.phoneShopping.payment.dto.response.DeletePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.DeletePaymentResponse;
import com.example.phoneShopping.payment.dto.response.UpdatePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.UpdatePaymentResponse;
import com.example.phoneShopping.payment.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@Tag(name = "Payment & Payment Product Controller", description = "결제 & 결제 상품 API")
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController 
{
	
	private final PaymentService service;
	
	
	@Operation(summary = "createPayment() - 결제 정보 생성 API ", 
			description = "결제 정보를 생성하는 method <br>"
					+ "회원이 결제를 진행하면 생성되는 method <br>"
					+ "1인 1결제의 관계를 갖는다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="결제 정보 생성 완료", content={@Content(schema = @Schema(implementation = CreatePaymentResponse.class))}),
			@ApiResponse(responseCode = "404", description="모든 항목 입력은 필수입니다."),
			@ApiResponse(responseCode = "405", description="이미 존재하는 결제 정보")
	})
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreatePaymentResponse> createPayment(@RequestBody CreatePaymentRequest req)
	{
		System.out.println("Payment 정보 생성");
		return ResponseEntity.ok(service.createPayment(req));
	}
	
	
	@Operation(summary = "findAllPayment() - 전체 결제 정보 조회 API ", 
			description = "전체 결제 정보를 조회하는 method로 DB안에 저장된 Payment table의 모든 값을 불러온다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="findAllPayment성공"),
			@ApiResponse(responseCode = "500", description="findAllPayment실패, 정보를 불러오는데 오류가 발생했습니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Payment> findAllPayment()
	{
		System.out.println("Payment정보 전체 출력");
		return service.findAllPayment();
	}
	
	
	@Operation(summary = "findByIdPayment() - 특정 결제 정보 1개 조회 API ", 
			description = "특정 결제 정보 1개만 내용을 조회하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="결제 정보가 존재합니다."),
			@ApiResponse(responseCode = "404", description="존재하지 않는 정보입니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOnePayment/{paySeq}")
	public Payment findByIdPayment(
			@Parameter(name = "paySeq", description = "특정 결제 정보 조회에 사용할 ID값", example = "6", required = true)
			@PathVariable(value = "paySeq") int paySeq)
	{
		System.out.println("Payment 정보 1개 출력");
		System.out.println(paySeq);
		return service.findByIdPayment(paySeq);
	}
	
	
	@Operation(summary = "updatePayment() - 결제 정보 수정 API ", 
			description = "결제 정보를 수정하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="결제 정보 수정 완료", content={@Content(schema = @Schema(implementation = UpdatePaymentResponse.class))}),
			@ApiResponse(responseCode = "405", description="수정 실패, 모든 정보를 입력했는지 확인하세요")
	})
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/updatePayment/{paySeq}")
	public ResponseEntity<UpdatePaymentResponse> updatePayment(@RequestBody UpdatePaymentRequest req)
	{
		System.out.println("Payment 정보 수정");
		return ResponseEntity.ok(service.updatePayment(req));
	}
	
	
	@Operation(summary = "deletePayment() - 결제 정보 삭제 API ", 
			description = "결제 정보를 삭제하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="결제 정보 삭제 완료", content={@Content(schema = @Schema(implementation = DeletePaymentResponse.class))}),
			@ApiResponse(responseCode = "405", description="삭제 실패, 다시 입력해주세요")
	})
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/deletePayment/{paySeq}")
	public ResponseEntity<DeletePaymentResponse> deletePayment(
			@Parameter(name = "paySeq", description = "결제 정보 삭제에 사용할 ID값", example = "6", required = true)
			@PathVariable(value = "paySeq") int paySeq)
	{
		System.out.println("Payment 정보 제거");
		System.out.println(paySeq);
		return ResponseEntity.ok(service.deletePayment(paySeq));
	}
	
	
	@Operation(summary = "createPaymentProduct() - 결제 정보 상품 생성 API ", 
			description = "결제 상품 정보를 생성하는 method <br>"
					+ "회원이 결제를 진행하면 카트에 담긴 상품들의 정보를 참고하여 생성되는 method <br>"
					+ "1결제 N결제 상품의 관계를 갖는다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="결제 정보 상품 생성 완료", content={@Content(schema = @Schema(implementation = CreatePaymentProductResponse.class))}),
			@ApiResponse(responseCode = "404", description="모든 항목 입력은 필수입니다."),
			@ApiResponse(responseCode = "405", description="이미 존재하는 결제 상품 정보")
	})
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/createPaymentProduct")
	public ResponseEntity<CreatePaymentProductResponse> createPaymentProduct(@RequestBody CreatePaymentProductRequest req)
	{
		System.out.println("PaymentProduct 정보 생성");
		return ResponseEntity.ok(service.createPaymentProduct(req));
	}
	
	
	@Operation(summary = "findAllPaymentProduct() - 전체 결제 정보 상품 조회 API ", 
			description = "전체 결제 정보 상품을 조회하는 method로 DB안에 저장된 Payment Product table의 모든 값을 불러온다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="findAllPaymentProduct성공"),
			@ApiResponse(responseCode = "500", description="findAllPaymentProduct실패, 정보를 불러오는데 오류가 발생했습니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAllPaymentProduct")
	public List<PaymentProduct> findAllPaymentProduct()
	{
		System.out.println("PaymentProduct 정보 전체 출력");
		return service.findAllPaymentProduct();
	}
	
	
	@Operation(summary = "findByIdPaymentProduct() - 특정 결제 정보 상품 1개 조회 API ", 
			description = "특정 결제 정보 상품 1개만 내용을 조회하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="결제 정보 상품이 존재합니다."),
			@ApiResponse(responseCode = "404", description="존재하지 않는 정보입니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/product/{payiSeq}")
	public PaymentProduct findByIdPaymentProduct(
			@Parameter(name = "payiSeq", description = "특정 결제 정보 상품 조회에 사용할 ID값", example = "7", required = true)
			@PathVariable(value = "payiSeq") int payiSeq)
	{
		System.out.println("Payment Product 정보 1개 출력");
		System.out.println(payiSeq);
		return service.findByIdPaymentProduct(payiSeq);
	}
	
	
	@Operation(summary = "updatePaymentProduct() - 결제 상품 정보 수정 API ", 
			description = "결제 상품 정보를 수정하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="결제 상품 정보 수정 완료", content={@Content(schema = @Schema(implementation = UpdatePaymentProductResponse.class))}),
			@ApiResponse(responseCode = "405", description="수정 실패, 모든 정보를 입력했는지 확인하세요")
	})
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/product/{payiSeq}")
	public ResponseEntity<UpdatePaymentProductResponse> updatePaymentProduct(@RequestBody UpdatePaymentProductRequest req)
	{
		System.out.println("PaymentProduct 정보 수정");
		return ResponseEntity.ok(service.updatePaymentProduct(req));
	}
	
	
	@Operation(summary = "deletePaymentProduct() - 결제 상품 정보 삭제 API ", 
			description = "결제 상품 정보를 삭제하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="결제 상품 정보 삭제 완료", content={@Content(schema = @Schema(implementation = DeletePaymentProductResponse.class))}),
			@ApiResponse(responseCode = "405", description="삭제 실패, 다시 입력해주세요")
	})
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/product/{payiSeq}")
	public ResponseEntity<DeletePaymentProductResponse> deletePaymentProduct(
			@Parameter(name = "payiSeq", description = "결제 상품 정보 삭제에 사용할 ID값", example = "7", required = true)
			@PathVariable(value = "payiSeq") int payiSeq)
	{
		System.out.println("PaymentProduct 정보 제거");
		System.out.println(payiSeq);
		return ResponseEntity.ok(service.deletePaymentProduct(payiSeq));
	}

}

package com.example.phoneShopping.product.controller;

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


import com.example.phoneShopping.product.domain.Plus;
import com.example.phoneShopping.product.dto.request.CreatePlusRequest;
import com.example.phoneShopping.product.dto.request.UpdatePlusRequest;
import com.example.phoneShopping.product.dto.response.CreatePlusResponse;
import com.example.phoneShopping.product.dto.response.DeletePlusResponse;
import com.example.phoneShopping.product.dto.response.UpdatePlusResponse;
import com.example.phoneShopping.product.service.PlusService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@Tag(name = "PlusController", description = "추가 금액 API")
@RestController
@RequestMapping("/admin/plus")
@RequiredArgsConstructor
public class PlusController 
{
	private final PlusService service;
	
	
	@Operation(summary = "createPlus() - 추가 금액 정보 생성 API ", 
			description = "하드 용량에 따라 추가 금액 정보를 생성하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="추가 금액 정보 생성 완료", content={@Content(schema = @Schema(implementation = CreatePlusResponse.class))}),
			@ApiResponse(responseCode = "404", description="모든 항목 입력은 필수입니다."),
			@ApiResponse(responseCode = "405", description="이미 존재하는 추가 금액 정보")
	})
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreatePlusResponse> createPlus(@RequestBody CreatePlusRequest req)
	{
		System.out.println("Plus 정보 생성");
		return ResponseEntity.ok(service.createPlus(req));
	}
	
	
	@Operation(summary = "findAllPlus() - 추가 금액 정보 전체 조회 API ", 
			description = "전체 추가 금액 정보를 조회하는 method로 DB안에 저장된 Plus table의 모든 값을 불러온다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="findAllPlus성공"),
			@ApiResponse(responseCode = "500", description="findAllPlus실패, 정보를 불러오는데 오류가 발생했습니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Plus> findAllPlus()
	{
		System.out.println("Plus 정보 전체 출력");
		return service.findAllPlus();
	}
	
	
	@Operation(summary = "findByIdPlus() - 특정 추가 금액 정보 1개 조회 API ", 
			description = "특정 추가 금액 정보 1개만 내용을 조회하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="추가 금액 정보가 존재합니다."),
			@ApiResponse(responseCode = "404", description="존재하지 않는 정보입니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne/{plusSeq}")
	public Plus findByIdPlus(
			@Parameter(name = "plusSeq", description = "특정 추가 금액 정보 조회에 사용할 ID값", example = "3", required = true)
			@PathVariable(value = "plusSeq") int plusSeq)
	{
		System.out.println("Plus 정보 1개 출력");
		System.out.println(plusSeq);
		return service.findByIdPlus(plusSeq);
	}
	
	
	@Operation(summary = "updatePlus() - 추가 금액 정보 수정 API ", 
			description = "추가 금액 정보를 수정하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="추가 금액 수정 완료", content={@Content(schema = @Schema(implementation = UpdatePlusResponse.class))}),
			@ApiResponse(responseCode = "405", description="수정 실패, 모든 정보를 입력했는지 확인하세요")
	})
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/update/{plusSeq}")
	public ResponseEntity<UpdatePlusResponse> updatePlus(@RequestBody UpdatePlusRequest req)
	{
		System.out.println("Plus 정보 수정");
		return ResponseEntity.ok(service.updatePlus(req));
	}
	
	
	@Operation(summary = "deletePlus() - 추가 금액 정보 삭제 API ", 
			description = "추가 금액 정보를 삭제하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="추가 금액 삭제 완료", content={@Content(schema = @Schema(implementation = DeletePlusResponse.class))}),
			@ApiResponse(responseCode = "405", description="삭제 실패, 다시 입력해주세요")
	})
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/delete/{plusSeq}")
	public ResponseEntity<DeletePlusResponse> deletePlus(
			@Parameter(name = "plusSeq", description = "특정 추가 금액 정보 삭제에 사용할 ID값", example = "3", required = true)
			@PathVariable(value = "plusSeq") int plusSeq)
	{
		System.out.println("Plus 정보 제거");
		System.out.println(plusSeq);
		return ResponseEntity.ok(service.deletePlus(plusSeq));
	}
}

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

import com.example.phoneShopping.product.domain.Hdd;
import com.example.phoneShopping.product.dto.request.CreateHddRequest;
import com.example.phoneShopping.product.dto.request.UpdateHddRequest;
import com.example.phoneShopping.product.dto.response.CreateHddResponse;
import com.example.phoneShopping.product.dto.response.DeleteHddResponse;
import com.example.phoneShopping.product.dto.response.UpdateHddResponse;
import com.example.phoneShopping.product.service.HddService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@Tag(name = "HddController", description = "용량(전화기 디스크 용량) API")
@RestController
@RequestMapping("/admin/hdd")
@RequiredArgsConstructor
public class HddController 
{
	private final HddService service;
	
	
	@Operation(summary = "createHdd() - 용량 정보 생성 API ", 
			description = "용량 정보를 생성하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="용량 정보 생성 완료", content={@Content(schema = @Schema(implementation = CreateHddResponse.class))}),
			@ApiResponse(responseCode = "404", description="모든 항목 입력은 필수입니다."),
			@ApiResponse(responseCode = "405", description="이미 존재하는 주소정보")
	})
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateHddResponse> createColor(@RequestBody CreateHddRequest req)
	{
		System.out.println("Hdd 정보 생성");
		return ResponseEntity.ok(service.createHdd(req));
	}
	
	
	@Operation(summary = "findAllHdd() - 용량 정보 전체 조회 API ", 
			description = "전체 용량 정보를 조회하는 method로 DB안에 저장된 Hdd table의 모든 값을 불러온다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="findAllHdd성공"),
			@ApiResponse(responseCode = "500", description="findAllHdd실패, 정보를 불러오는데 오류가 발생했습니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Hdd> findAllHdd()
	{
		System.out.println("Hdd 정보 전체 출력");
		return service.findAllHdd();
	}
	
	
	@Operation(summary = "findByIdHdd() - 특정 용량 정보 1개 조회 API ", 
			description = "특정 용량 정보 1개만 내용을 조회하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="용량정보가 존재합니다."),
			@ApiResponse(responseCode = "404", description="존재하지 않는 정보입니다.")
	})
	@PreAuthorize("isAuthenticated()")

	@GetMapping("/getOne/{hddSeq}")
	public Hdd findByIdHdd(
			@Parameter(name = "hddSeq", description = "특정 용량 정보 조회에 사용할 ID값", example = "3", required = true)
			@PathVariable(value = "hddSeq") int hddSeq)
	{
		System.out.println("Hdd 정보 1개 출력");
		System.out.println(hddSeq);
		return service.findByIdHdd(hddSeq);
	}
	
	
	@Operation(summary = "updateHdd() - 용량 정보 수정 API ", 
			description = "용량 정보를 수정하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="용량 수정 완료", content={@Content(schema = @Schema(implementation = UpdateHddResponse.class))}),
			@ApiResponse(responseCode = "405", description="수정 실패, 모든 정보를 입력했는지 확인하세요")
	})
	@PreAuthorize("isAuthenticated()")

	@PatchMapping("/update/{hddSeq}")
	public ResponseEntity<UpdateHddResponse> updateHdd(@RequestBody UpdateHddRequest req)
	{
		System.out.println("Hdd 정보 수정");
		return ResponseEntity.ok(service.updateHdd(req));
	}
	
	
	@Operation(summary = "deleteHdd() - 용량 정보 삭제 API ", 
			description = "용량 정보를 삭제하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="Hdd 삭제 완료", content={@Content(schema = @Schema(implementation = DeleteHddResponse.class))}),
			@ApiResponse(responseCode = "405", description="삭제 실패, 다시 입력해주세요")
	})
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/delete/{hddSeq}")
	public ResponseEntity<DeleteHddResponse> deleteHdd(
			@Parameter(name = "hddSeq", description = "특정 용량 삭제에 사용할 ID값", example = "3", required = true)
			@PathVariable(value = "hddSeq") int hddSeq)
	{
		System.out.println("Hdd 정보 제거");
		System.out.println(hddSeq);
		return ResponseEntity.ok(service.deleteHdd(hddSeq));
	}
}

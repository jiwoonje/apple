package com.example.phoneShopping.member.controller;

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

import com.example.phoneShopping.member.domain.Address;
import com.example.phoneShopping.member.dto.request.CreateAddressRequest;
import com.example.phoneShopping.member.dto.request.UpdateAddressRequest;
import com.example.phoneShopping.member.dto.response.CreateAddressResponse;

import com.example.phoneShopping.member.dto.response.DeleteAddressResponse;
import com.example.phoneShopping.member.dto.response.DeleteInfoResponse;
import com.example.phoneShopping.member.dto.response.UpdateAddressResponse;

import com.example.phoneShopping.member.service.AddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "AddressController", description = "주소 정보 API")
@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController 
{
	private final AddressService service;
	
	@Operation(summary = "createAddress() - 주소 정보 생성 API ", 
			description = "주소 정보를 생성하는 method <br>"
					+ "회원이 계정 정보(id/pw)만 가진채 회원가입이 되었기에 상품을 주문하기 위해 추가 정보를 입력하기 위한 과정")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="주소 정보 생성 완료", content={@Content(schema = @Schema(implementation = CreateAddressResponse.class))}),
			@ApiResponse(responseCode = "404", description="모든 항목 입력은 필수입니다."),
			@ApiResponse(responseCode = "405", description="이미 존재하는 주소정보")
	})
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateAddressResponse> createAddress(@RequestBody CreateAddressRequest req)
	{
		System.out.println("Address 정보 생성");
		System.out.println(req.getAddrSeq());
		System.out.println(req.getAddrZip());
		System.out.println(req.getAddrDetail());
		return ResponseEntity.ok(service.createAddress(req));
	}
	
	
	@Operation(summary = "findAllAddress() - 주소 정보 전체 조회 API ", 
			description = "전체 주소 정보를 조회하는 method로 DB안에 저장된 Address table의 모든 값을 불러온다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="findAllAddress성공"),
			@ApiResponse(responseCode = "500", description="findAllAddress실패, 정보를 불러오는데 오류가 발생했습니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Address> findAllAddress()
	{
		System.out.println("Address 정보 전체 출력");
		return service.findAllAddress();
	}
	
	
	@Operation(summary = "findByIdAddress() - 특정 주소 정보 1개 조회 API ", 
			description = "특정 주소 정보 1개만 내용을 조회하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="주소정보가 존재합니다."),
			@ApiResponse(responseCode = "404", description="존재하지 않는 정보입니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{addrSeq}")
	public Address findByIdAddress(
			@Parameter(name = "addrSeq", description = "특정 주소 정보 조회에 사용할 ID값", example = "5", required = true)
			@PathVariable(value = "addrSeq") int addrSeq)
	{
		System.out.println("Address 정보 1개 출력");
		System.out.println(addrSeq);
		return service.findByIdAddress(addrSeq);
	}
	
	
	@Operation(summary = "updateAddress() - 주소 정보 수정 API ", 
			description = "주소 정보를 수정하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="주소 수정 완료", content={@Content(schema = @Schema(implementation = UpdateAddressResponse.class))}),
			@ApiResponse(responseCode = "405", description="수정 실패, 모든 정보를 입력했는지 확인하세요")
	})
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{addrSeq}")
	public ResponseEntity<UpdateAddressResponse> updateAddress(@RequestBody UpdateAddressRequest req)
	{
		System.out.println("Address 정보 수정");
		
		return ResponseEntity.ok(service.updateAddress(req));
	}
	
	
	@Operation(summary = "deleteAddress() - 주소 정보 삭제 API ", 
			description = "주소 정보를 삭제하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="주소 삭제 완료", content={@Content(schema = @Schema(implementation = DeleteInfoResponse.class))}),
			@ApiResponse(responseCode = "405", description="삭제 실패, 다시 입력해주세요")
	})
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{addrSeq}")
	public ResponseEntity<DeleteAddressResponse> delete(
			@Parameter(name = "addrSeq", description = "특정 주소 삭제에 사용할 ID값", example = "6", required = true)
			@PathVariable(value = "addrSeq") int addrSeq)
	{
		System.out.println("Address 정보 제거");
		System.out.println(addrSeq);
		return ResponseEntity.ok(service.deleteAddress(addrSeq));
	}
}

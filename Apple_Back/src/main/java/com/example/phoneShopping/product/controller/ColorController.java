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


import com.example.phoneShopping.product.domain.Color;
import com.example.phoneShopping.product.dto.request.CreateColorRequest;
import com.example.phoneShopping.product.dto.request.UpdateColorRequest;
import com.example.phoneShopping.product.dto.response.CreateColorResponse;
import com.example.phoneShopping.product.dto.response.DeleteColorResponse;
import com.example.phoneShopping.product.dto.response.UpdateColorResponse;
import com.example.phoneShopping.product.service.ColorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@Tag(name = "ColorController", description = "색깔 API")
@RestController
@RequestMapping("/admin/color")
@RequiredArgsConstructor
public class ColorController 
{
	private final ColorService service;
	
	@Operation(summary = "createColor() - 색깔 정보 생성 API ", 
			description = "색깔 정보를 생성하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="정보 생성 완료", content={@Content(schema = @Schema(implementation = CreateColorResponse.class))}),
			@ApiResponse(responseCode = "404", description="모든 항목 입력은 필수입니다."),
			@ApiResponse(responseCode = "405", description="이미 존재하는 주소정보")
	})
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateColorResponse> createColor(@RequestBody CreateColorRequest req)
	{
		System.out.println("Color 정보 생성");
		return ResponseEntity.ok(service.createColor(req));
	}
	
	
	@Operation(summary = "findAllColor() - 색깔 정보 전체 조회 API ", 
			description = "전체 색깔 정보를 조회하는 method로 DB안에 저장된 Color table의 모든 값을 불러온다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="findAllColor성공"),
			@ApiResponse(responseCode = "500", description="findAllColor실패, 정보를 불러오는데 오류가 발생했습니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Color> findAllColor()
	{
		System.out.println("Color 정보 전체 출력");
		return service.findAllColor();
	}
	
	
	@Operation(summary = "findByIdColor() - 특정 색깔 정보 1개 조회 API ", 
			description = "특정 색깔 정보 1개만 내용을 조회하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="색깔 정보가 존재합니다."),
			@ApiResponse(responseCode = "404", description="존재하지 않는 정보입니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getOne/{colorSeq}")
	public Color findByIdColor(
			@Parameter(name = "colorSeq", description = "특정 색깔 정보 조회에 사용할 ID값", example = "6", required = true)
			@PathVariable(value = "colorSeq") int colorSeq)
	{
		System.out.println("color 정보 1개 출력");
		System.out.println(colorSeq);
		return service.findByIdColor(colorSeq);
	}
	
	
	@Operation(summary = "updateColor() - 색깔 정보 수정 API ", 
			description = "색깔 정보를 수정하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="색깔 수정 완료", content={@Content(schema = @Schema(implementation = UpdateColorResponse.class))}),
			@ApiResponse(responseCode = "405", description="수정 실패, 모든 정보를 입력했는지 확인하세요")
	})
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/update/{colorSeq}")
	public ResponseEntity<UpdateColorResponse> updateColor(@RequestBody UpdateColorRequest req)

	{
		System.out.println("Color 정보 수정");
		return ResponseEntity.ok(service.updateColor(req));
	}
	
	
	@Operation(summary = "deleteColor() - 색깔 정보 삭제 API ", 
			description = "색깔 정보를 삭제하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="색깔 삭제 완료", content={@Content(schema = @Schema(implementation = DeleteColorResponse.class))}),
			@ApiResponse(responseCode = "405", description="삭제 실패, 다시 입력해주세요")
	})
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/delete/{colorSeq}")
	public ResponseEntity<DeleteColorResponse> deleteColor(
			@Parameter(name = "colorSeq", description = "특정 색깔 정보 삭제에 사용할 ID값", example = "6", required = true)
			@PathVariable(value = "colorSeq") int colorSeq)
	{
		System.out.println("Color 정보 제거");
		System.out.println(colorSeq);
		return ResponseEntity.ok(service.deleteColor(colorSeq));
	}
}

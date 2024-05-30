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

import com.example.phoneShopping.member.domain.Card;
import com.example.phoneShopping.member.dto.request.CreateCardRequest;
import com.example.phoneShopping.member.dto.request.UpdateCardRequest;
import com.example.phoneShopping.member.dto.response.CreateCardResponse;

import com.example.phoneShopping.member.dto.response.DeleteCardResponse;

import com.example.phoneShopping.member.dto.response.UpdateCardResponse;

import com.example.phoneShopping.member.service.CardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@Tag(name = "CardController", description = "카드 API")
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController 
{
	private final CardService service;
	
	@Operation(summary = "createCard() - 카드 정보 생성 API ", 
			description = "회원 개인 카드정보를 생성하는 method <br>"
					+ "회원이 계정 정보(id/pw)만 가진채 회원가입이 되었기에 상품을 주문하기 위해 추가 정보를 입력하기 위한 과정")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="회원 카드 정보 생성 완료", content={@Content(schema = @Schema(implementation = CreateCardResponse.class))}),
			@ApiResponse(responseCode = "404", description="모든 항목 입력은 필수입니다."),
			@ApiResponse(responseCode = "405", description="이미 존재하는 카드정보")
	})
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public ResponseEntity<CreateCardResponse> createCard(@RequestBody CreateCardRequest req)
	{
		System.out.println("Card 정보 생성");
		return ResponseEntity.ok(service.createCard(req));
	}
	
	
	@Operation(summary = "findAllCard() - 카드 정보 전체 조회 API ", 
			description = "전체 카드 정보를 조회하는 method로 DB안에 저장된 Card table의 모든 값을 불러온다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="findAllCard성공"),
			@ApiResponse(responseCode = "500", description="findAllCard실패, 정보를 불러오는데 오류가 발생했습니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Card> findAllCard()
	{
		System.out.println("Card 정보 전체 출력");
		return service.findAllCard();
	}
	
	
	@Operation(summary = "findByIdCard() - 특정 카드 정보 1개 조회 API ", 
			description = "특정 카드 정보 1개만 내용을 조회하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="카드정보가 존재합니다."),
			@ApiResponse(responseCode = "404", description="존재하지 않는 정보입니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{cardSeq}")
	public Card findByIdCard(
			@Parameter(name = "cardSeq", description = "특정 카드정보 조회에 사용할 ID값", example = "5", required = true)
			@PathVariable(value = "cardSeq") int cardSeq)
	{
		System.out.println("Card 정보 1개 출력");
		System.out.println(cardSeq);
		return service.findByIdCard(cardSeq);
	}
	
	
	@Operation(summary = "updateCard() - 카드 정보 수정 API ", 
			description = "카드 정보를 수정하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="카드 정보 수정 완료", content={@Content(schema = @Schema(implementation = UpdateCardResponse.class))}),
			@ApiResponse(responseCode = "405", description="수정 실패, 모든 정보를 입력했는지 확인하세요")
	})
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{cardSeq}")
	public ResponseEntity<UpdateCardResponse> updateCard(@RequestBody UpdateCardRequest req)
	{
		System.out.println("Card 정보 수정");
		return ResponseEntity.ok(service.updateCard(req));
	}
	
	
	@Operation(summary = "deleteCard() - 카드 정보 삭제 API ", 
			description = "카드 정보를 삭제하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="카드 정보 삭제 완료", content={@Content(schema = @Schema(implementation = DeleteCardResponse.class))}),
			@ApiResponse(responseCode = "405", description="수정 실패, 다시 입력해주세요")
	})
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{cardSeq}")
	public ResponseEntity<DeleteCardResponse> delete(
			@Parameter(name = "cardSeq", description = "특정 카드 삭제에 사용할 ID값", example = "6", required = true)
			@PathVariable(value = "cardSeq") int cardSeq)
	{
		System.out.println("Card 정보 제거");
		System.out.println(cardSeq);
		return ResponseEntity.ok(service.deleteCard(cardSeq));
	}
}

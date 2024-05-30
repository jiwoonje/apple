package com.example.phoneShopping.member.controller;

import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.phoneShopping.member.domain.Member;
import com.example.phoneShopping.member.dto.request.JoinRequest;
import com.example.phoneShopping.member.dto.request.LoginRequest;
import com.example.phoneShopping.member.dto.request.UpdateMemberRequest;
import com.example.phoneShopping.member.dto.response.DeleteMemberResponse;
import com.example.phoneShopping.member.dto.response.JoinResponse;
import com.example.phoneShopping.member.dto.response.LoginResponse;
import com.example.phoneShopping.member.dto.response.UpdateMemberResponse;
import com.example.phoneShopping.member.exception.MemberException;
import com.example.phoneShopping.member.service.MemberService;

@Tag(name = "MemberController", description = "계정 정보 API")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController 
{
	private final MemberService service;

	@Operation(summary = "checkIdDuplicate() - 아이디 중복체크 API ", 
			description = "회원가입 시 DB에 이미 존재하는 아이디인지 확인하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="사용 가능한 아이디입니다."),
			@ApiResponse(responseCode = "405", description="이미 존재하는 아이디입니다.")
	})
	@GetMapping
	public ResponseEntity<?> checkIdDuplicate(
			@Parameter(name = "id", description = "회원가입에 사용할 ID 값", example = "exp", required = true)
			@RequestParam("id") String id) 
	{
		System.out.println("아이디 중복 요청 성공 : " + id );
		System.out.println("UserController checkIdDuplicate " + new Date());

		HttpStatus status = service.checkIdDuplicate(id);
		return new ResponseEntity<>(status);
	}
	
	
	@Operation(summary = "join() - 회원가입 API ", 
			description = "회원가입을 진행하는 method로 Create동작을 수행한다. <br>"
					+ "아이디, 비밀번호, 비밀번호 재확인 3가지를 이용해 회원 가입을 진행하고, 중복된 아이디일 경우 생성이 되지 않는다. <br>"
					+ "회원가입이 되면, 비밀번호가 springSecurity설정으로 인해 암호화 된 값으로 저장된다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="회원가입 성공", content={@Content(schema = @Schema(implementation = JoinResponse.class))}),
			@ApiResponse(responseCode = "405", description="회원가입 실패, 이미 존재하는 아이디입니다.")
	})
	@PostMapping("/join")
	public ResponseEntity<JoinResponse> join(@Valid @RequestBody JoinRequest req) 
	{
		System.out.println("UserController join " + new Date());

		return ResponseEntity.ok(service.join(req));
	}
	
	
	@Operation(summary = "login() - 회원 로그인 API ", 
			description = "회원 로그인을 진행하는 method로 생성된 계정 정보를 이용해 로그인 동작을 처리한다.<br>"
					+ "로그인할 때, 입력된 아이디와 비밀번호가 아이디와 비밀번호가 DB에 저장된 값과 같은지 확인하는 과정을 거쳐서 진행된다.<br>"
					+ "JWT와 Spring Security설정이 적용되어 로그인시 고유한 인증정보가 생성되고 로그아웃하기 전까지 상태가 유지된다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="Login성공", content={@Content(schema = @Schema(implementation = LoginResponse.class))}),
			@ApiResponse(responseCode = "404", description="Login실패, 없는 아이디입니다.")
	})
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest req) 
	{		
		System.out.println("UserController login " + new Date());
		return ResponseEntity.ok(service.login(req));
	}


	/* 요청 DTO 검증 예외처리 핸들러 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) 
	{
		System.out.println("UserController handleMethodArgumentNotValidException " + new Date());

		BindingResult bs = e.getBindingResult();
		StringBuilder sb = new StringBuilder();
		bs.getFieldErrors().forEach(err -> 
		{
			sb.append(String.format("[%s]: %s.\n입력된 값: %s",
						err.getField(), err.getDefaultMessage(), err.getRejectedValue()));
		});
		
		return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
	}

	
	/* 사용자 관련 요청 예외처리 핸들러 */
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<?> handleUserException(MemberException e) 
	{
		System.out.println("UserController handlerUserException " + new Date());
		return new ResponseEntity<>(e.getMessage(), e.getStatus());
	}
	
	
	@Operation(summary = "findAllMember() - 계정 정보 전체 조회 API ", 
			description = "전체 계정 정보를 조회하는 method로 DB안에 저장된 member table의 모든 값을 불러온다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="findAllMember성공"),
			@ApiResponse(responseCode = "500", description="findAllMember실패, 정보를 불러오는데 오류가 발생했습니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/getAll")
	public List<Member> findAllMember()
	{
		System.out.println("회원 정보 전체 출력");
		return service.findAllMember();
	}
	
	
	@Operation(summary = "findByIdMember() - 특정 아이디 1개 조회 API ", 
			description = "특정 아이디 1개만 내용을 조회하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="아이디가 존재합니다."),
			@ApiResponse(responseCode = "404", description="존재하지 않는 아이디입니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/{memId}")
	public Member findByIdMember(
			@Parameter(name = "memId", description = "특정 회원 조회에 사용할 ID 값", example = "exp", required = true)
			@PathVariable(value = "memId") String memId)
	{
		System.out.println("회원 정보 1개 출력");
		System.out.println(memId);
		return service.findByIdMember(memId);
	}
	
	
	@Operation(summary = "updateMember() - 계정 정보 API ", 
			description = "계정 정보를 수정하는 method로 Update동작을 수행한다. <br>"
					+ "비밀번호만 수정할 수 있도록 설정한 상태로 비밀번호와 비밀번호 확인에 입력한 값이 다를 경우 오류 발생<br>"
					+ "정보가 수정되면, 비밀번호가 springSecurity설정으로 인해 암호화 된 값으로 저장된다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="정보 수정 성공", content={@Content(schema = @Schema(implementation = UpdateMemberResponse.class))}),
			@ApiResponse(responseCode = "405", description="정보 수정 실패, 입력한 비밀번호가 일치하는지 확인하세요.")
	})
	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{memId}")
	public ResponseEntity<UpdateMemberResponse> updateMember(@Valid @RequestBody UpdateMemberRequest req)
	{
		System.out.println("회원 정보 수정");
		System.out.println(req.getMemId());
		System.out.println(req.getMemPw());
		System.out.println(req.getCheckMemPw());
		
		return ResponseEntity.ok(service.updateMember(req));
	}
	
	
	@Operation(summary = "delete() - 계정 삭제 API ", 
			description = "계정을 삭제하는 method")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description="아이디가 삭제 되었습니다.", content={@Content(schema = @Schema(implementation = DeleteMemberResponse.class))}),
			@ApiResponse(responseCode = "404", description="존재하지 않는 아이디입니다.")
	})
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{memId}")
	public ResponseEntity<DeleteMemberResponse> delete(
			@Parameter(name = "memId", description = "특정 회원 삭제에 사용할 ID 값", example = "exp", required = true)
			@PathVariable(value = "memId") String memId)
	{
		System.out.println("회원 정보 제거");
		System.out.println(memId);
		return ResponseEntity.ok(service.deleteMember(memId));
	}	
}

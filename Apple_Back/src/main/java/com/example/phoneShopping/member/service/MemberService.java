package com.example.phoneShopping.member.service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.example.phoneShopping.jwt.JwtTokenUtil;
import com.example.phoneShopping.member.dao.MemberDao;
import com.example.phoneShopping.member.domain.Member;
import com.example.phoneShopping.member.dto.param.CreateMemberParam;
import com.example.phoneShopping.member.dto.param.UpdateMemberParam;
import com.example.phoneShopping.member.dto.request.JoinRequest;
import com.example.phoneShopping.member.dto.request.LoginRequest;
import com.example.phoneShopping.member.dto.request.UpdateMemberRequest;
import com.example.phoneShopping.member.dto.response.DeleteMemberResponse;
import com.example.phoneShopping.member.dto.response.JoinResponse;
import com.example.phoneShopping.member.dto.response.LoginResponse;
import com.example.phoneShopping.member.dto.response.UpdateMemberResponse;
import com.example.phoneShopping.member.exception.MemberException;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService 
{
	private final MemberDao dao;
	private final PasswordEncoder encoder;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenUtil jwtTokenUtil;
	private final UserDetailsService userDetailsService;

	public HttpStatus checkIdDuplicate(String id) 
	{				// ID 중복 체크 확인
		isExistUserId(id);
		return HttpStatus.OK;
	}

	@Transactional
	public JoinResponse join(JoinRequest req)	// 회원가입 처리 
	{
		System.out.println("join동작");
		saveMember(req);

//		authenticate(req.getMem_id(), req.getMem_pw());

		return new JoinResponse(req.getMemId());
	}

	private void saveMember(JoinRequest req)	// 회원가입 method
	{
		System.out.println("saveMember동작");
		// 아이디 중복 확인
		isExistUserId(req.getMemId());

		// 패스워드 일치 확인
		checkPwd(req.getMemPw(), req.getCheckMemPw());

		// 회원 정보 생성
		String encodedPwd = encoder.encode(req.getMemPw());
		
		CreateMemberParam param = new CreateMemberParam(req, encodedPwd);

		Integer result = dao.createMember(param);

		
		if (result == 0) 
		{
			throw new MemberException("회원 등록을 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public LoginResponse login(LoginRequest req)	// 로그인 성공 시 응답 
	{
		authenticate(req.getMemId(), req.getMemPw());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getMemId());
		final String token = jwtTokenUtil.generateToken(userDetails);

		System.out.println("인증 성공 토큰 출력 : " + token);
		System.out.println("아이디 출력 : " + req.getMemId());
			
		return new LoginResponse(token, req.getMemId());
	}

	
	private void authenticate(String id, String pwd)	// 오류 정의 - 아이디, 비밀번호 잘못 입력 
	{
		try 
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(id, pwd));
		} 
			
		catch (DisabledException e) 
		{
			throw new MemberException("인증되지 않은 아이디입니다.", HttpStatus.BAD_REQUEST);
		} 
			
		catch (BadCredentialsException e) 
		{
			throw new MemberException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}
	}

	private void isExistUserId(String id)	// 오류 정의 - 이미 존재하는 아이디 
	{
		Integer result = dao.isExistUserId(id);
		
		if (result == 1) 
		{
			throw new MemberException("이미 사용중인 아이디입니다.", HttpStatus.BAD_REQUEST);
		}
	}

	private void checkPwd(String pwd, String checkPwd)	// 오류 정의 - 비밀번호 잘 못 입력 
	{
		System.out.println("pwd ==> " + pwd);
		System.out.println("checkpwd ==> " + checkPwd);
		
		if (!pwd.equals(checkPwd)) 
		{
			System.out.println("패스워드 체크 작동됨 <======");
			throw new MemberException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Member> findAllMember()
	{
		System.out.println("findAllMember동작");
		List<Member> list = dao.findAllMember();
		
		for(int i = 0; i<dao.findAllMember().size(); i++ )
		{
			System.out.println(dao.findAllMember().get(i).getMemSeq());
			System.out.println(dao.findAllMember().get(i).getMemId());
			System.out.println(dao.findAllMember().get(i).getMemPw());
			System.out.println("\n");
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public Member findByIdMember(String memId)
	{
		System.out.println(memId);
		System.out.println("findByIdMember동작");
		System.out.println(dao.findByIdMember(memId));

//		Member member = new Member(dao.findById(mem_id).getMem_seq(), dao.findById(mem_id).getMem_id(), dao.findById(mem_id).getMem_pw());
		return dao.findByIdMember(memId);
	}
	
	@Transactional(readOnly=true)
	public Integer findByIdSeq(int memSeq)
	{
		System.out.println("mem_seq : "+ memSeq);
		System.out.println("dao.findByIdSeq(memSeq) : "+dao.findByIdSeq(memSeq));
		return dao.findByIdSeq(memSeq);
//		Member member = new Member(dao.findById(mem_id).getMem_seq(), dao.findById(mem_id).getMem_id(), dao.findById(mem_id).getMem_pw());
	}

	@Transactional(readOnly=true)
	public String findByPw(String memId)
	{
		System.out.println("memId : "+ memId);
		System.out.println("dao.findByPw(memId) : "+dao.findByPw(memId));
		return dao.findByPw(memId);
//		Member member = new Member(dao.findById(mem_id).getMem_seq(), dao.findById(mem_id).getMem_id(), dao.findById(mem_id).getMem_pw());
	}
	
	
	
	@Transactional
	public UpdateMemberResponse updateMember(UpdateMemberRequest req)
	{
		findByIdMember(req.getMemId());
		return new UpdateMemberResponse(updateMemberMethod(req));
	}	
	
	private Integer updateMemberMethod(UpdateMemberRequest req)
	{
		System.out.println("updateMemberMethod동작");


		// 패스워드 일치 확인
		checkPwd(req.getMemPw(), req.getCheckMemPw());

		// 회원 정보 생성
		String encodedPwd = encoder.encode(req.getMemPw());
		//System.out.println("pw인코딩 완료");
		UpdateMemberParam param = new UpdateMemberParam(req.getMemId(), encodedPwd, encodedPwd);
		
		Integer result = dao.updateMember(param);
		//System.out.println("수정 완료");
		System.out.println(result);
		if(result==0)
		{
			throw new MemberException("회원 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
		
	@Transactional
	public DeleteMemberResponse deleteMember(String memId)
	{
		System.out.println("deleteMember동작");
		int number = dao.deleteMember(memId);
		if(number == 0)
		{
			System.out.println("삭제 실패, 아이디가 존재하지 않습니다.");
		}
		return new DeleteMemberResponse(number);
	}
	
}

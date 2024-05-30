//package com.example.phoneShopping;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//import com.example.phoneShopping.member.domain.Member;
//
//import com.example.phoneShopping.member.service.MemberService;
//import com.example.phoneShopping.member.dto.request.JoinRequest;
//import com.example.phoneShopping.member.dto.request.UpdateMemberRequest;
//
//
//@SpringBootTest
//public class MemberTest 
//{
//	@Autowired
//	MemberService service;
//	
//	//@Test
//	void createTest()
//	{
//		Member member = new Member(1, "a", "1234");
//		JoinRequest joinRequest = new JoinRequest(member.getMemSeq(), member.getMemId(), member.getMemPw(), member.getMemPw());
//		service.join(joinRequest);
//	}
//	
//	//@Test
//	void create1()
//	{
//		Member member = new Member(2, "bb", "1234");
//		JoinRequest joinRequest = new JoinRequest(member.getMemSeq(), member.getMemId(), member.getMemPw(), member.getMemPw());
//		service.join(joinRequest);
//
//		Member member1 = new Member(3, "ccc", "1234");
//		JoinRequest joinRequest1 = new JoinRequest(member1.getMemSeq(), member1.getMemId(), member1.getMemPw(), member1.getMemPw());
//		service.join(joinRequest1);
//		
//		Member member2 = new Member(4, "dddd", "1234");
//		JoinRequest joinRequest2 = new JoinRequest(member2.getMemSeq(), member2.getMemId(), member2.getMemPw(), member2.getMemPw());
//		service.join(joinRequest2);
//	}
//	
//	//@Test
//	void update()
//	{
//		UpdateMemberRequest req = new UpdateMemberRequest(2, "bbbb", "1234", "1234");
//		service.updateMember(req);
//	}
//	
//	
//	//@Test
//	void delete()
//	{
//		service.deleteMember("ccc");
//	}
//	
//	
//	//@Test
//	void getAll() 
//	{
//		service.findAllMember();
//	}
//	
//	//@Test
//	void getOne()
//	{
//		Member m1 = service.findByIdMember("aaaa");
//		System.out.println("테스트에서 출력 : " + m1);
//				
//		Integer member = service.findByIdSeq(1);
//		System.out.println("테스트에서 출력 : " + member);
////		System.out.println("테스트에서 출력 : " + member.getMem_id());
////		System.out.println("테스트에서 출력 : " + member.getMem_pw());
////		System.out.println("테스트에서 출력 : " + member.getMem_seq());	
//		
//		String pw = service.findByPw("aaaa");
//		System.out.println("테스트에서 출력 : " + pw);
//	}
//
//}

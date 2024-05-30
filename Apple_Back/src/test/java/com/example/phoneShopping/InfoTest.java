//package com.example.phoneShopping;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.phoneShopping.member.domain.Info;
//import com.example.phoneShopping.member.dto.request.CreateInfoRequest;
//import com.example.phoneShopping.member.dto.request.UpdateInfoRequest;
//import com.example.phoneShopping.member.service.InfoService;
//
//@SpringBootTest
//public class InfoTest 
//{
//	@Autowired
//	InfoService service;
//	
//	//@Test
//	void create()
//	{
//		Info info = new Info(1, "이름", "생일", "성별", "전화번호");
//		CreateInfoRequest req = new CreateInfoRequest(info.getInfo_seq(), info.getInfo_name(), info.getInfo_birth(), info.getInfo_gender(), info.getInfo_phone());
//		service.createInfo(req);
//	}
//	
//	//@Test
//	void create1()
//	{
//		Info info = new Info(2, "이름", "생일", "성별", "전화번호");
//		CreateInfoRequest req = new CreateInfoRequest(info.getInfo_seq(), info.getInfo_name(), info.getInfo_birth(), info.getInfo_gender(), info.getInfo_phone());
//		service.createInfo(req);
//		
//		Info info1 = new Info(3, "이름", "생일", "성별", "전화번호");
//		CreateInfoRequest req1 = new CreateInfoRequest(info1.getInfo_seq(), info1.getInfo_name(), info1.getInfo_birth(), info1.getInfo_gender(), info1.getInfo_phone());
//		service.createInfo(req1);
//		
//		Info info2 = new Info(4, "이름", "생일", "성별", "전화번호");
//		CreateInfoRequest req2 = new CreateInfoRequest(info2.getInfo_seq(), info2.getInfo_name(), info2.getInfo_birth(), info2.getInfo_gender(), info2.getInfo_phone());
//		service.createInfo(req2);
//		
//	}
//	
//	//@Test
//	void update()
//	{
//		UpdateInfoRequest req = new UpdateInfoRequest(1, "aaa", "남자", "010-1111-1111", "1990-01-01");
//		UpdateInfoRequest req1 = new UpdateInfoRequest(2, "bbb", "여자", "010-2222-2222", "1991-02-02");
//		UpdateInfoRequest req2 = new UpdateInfoRequest(3, "ccc", "남자", "010-3333-3333", "1992-03-03");
//		UpdateInfoRequest req3 = new UpdateInfoRequest(4, "ddd", "여자", "010-4444-4444", "1994-04-04");
//		service.updateInfo(req);
//		service.updateInfo(req1);
//		service.updateInfo(req2);
//		service.updateInfo(req3);
//
//	}
//	
//	
//	@Test
//	void delete()
//	{
//		service.deleteInfo(4);
//	}
//	
//	
//	//@Test
//	void getAll() 
//	{
//		service.findAllInfo();
//	}
//	
//	//@Test
//	void getOne()
//	{
//		service.findByIdInfo(1);
//	}
//}

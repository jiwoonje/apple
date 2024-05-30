//package com.example.phoneShopping;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.phoneShopping.product.domain.Hdd;
//import com.example.phoneShopping.product.dto.request.CreateHddRequest;
//import com.example.phoneShopping.product.dto.request.UpdateHddRequest;
//import com.example.phoneShopping.product.service.HddService;
//
//@SpringBootTest
//public class HddTest 
//{
//	@Autowired
//	HddService service;
//	
//	//@Test
//	void create()
//	{
//		Hdd c = new Hdd(256, 1);
//		CreateHddRequest req = new CreateHddRequest(c.getCapacity(), c.getPlus_seq());
//		service.createHdd(req);
//	}
//	
//	//@Test
//	void create1()
//	{
//		Hdd c = new Hdd(256, 2);
//		CreateHddRequest req = new CreateHddRequest(c.getCapacity(), c.getPlus_seq());
//		service.createHdd(req);
//		
//		Hdd c1 = new Hdd(512, 3);
//		CreateHddRequest req1 = new CreateHddRequest(c1.getCapacity(), c1.getPlus_seq());
//		service.createHdd(req1);
//		
//		Hdd c2 = new Hdd(1024, 4);
//		CreateHddRequest req2 = new CreateHddRequest(c2.getCapacity(), c2.getPlus_seq());
//		service.createHdd(req2);
//	}
//	
//	//@Test
//	void update()
//	{
//		UpdateHddRequest req = new UpdateHddRequest(1, 512, 5);
//		service.updateHdd(req);
//		
//		UpdateHddRequest req1 = new UpdateHddRequest(2, 1024, 6);
//		service.updateHdd(req1);
//		
//		UpdateHddRequest req2 = new UpdateHddRequest(3, 2048, 7);
//		service.updateHdd(req2);
//		
//		UpdateHddRequest req3 = new UpdateHddRequest(4, 4096, 8);
//		service.updateHdd(req3);
//	}
//	
//	
//	//@Test
//	void delete()
//	{
//		service.deleteHdd(4);
//	}
//	
//	
//	//@Test
//	void getAll() 
//	{
//		service.findAllHdd();
//	}
//	
//	@Test
//	void getOne()
//	{
//		service.findByIdHdd(4);
//	}
//
//}

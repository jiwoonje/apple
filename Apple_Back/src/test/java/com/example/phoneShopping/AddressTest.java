//package com.example.phoneShopping;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.phoneShopping.member.domain.Address;
//import com.example.phoneShopping.member.dto.request.CreateAddressRequest;
//import com.example.phoneShopping.member.dto.request.UpdateAddressRequest;
//import com.example.phoneShopping.member.service.AddressService;
//
//@SpringBootTest
//public class AddressTest 
//{
//	@Autowired
//	AddressService service;
//	
//	//@Test
//	void create()
//	{
//		Address addr = new Address(1, "시군구동읍면리", "아파트, 주택");
//		CreateAddressRequest req = new CreateAddressRequest(addr.getAddr_seq(), addr.getAddr_zip(), addr.getAddr_detail());
//		service.createAddress(req);
//	}
//	
//	//@Test
//	void create1()
//	{
//		Address addr = new Address(2, "시군구동읍면리", "아파트, 주택");
//		CreateAddressRequest req = new CreateAddressRequest(addr.getAddr_seq(), addr.getAddr_zip(), addr.getAddr_detail());
//		service.createAddress(req);
//		
//		Address addr1 = new Address(3, "시군구동읍면리", "아파트, 주택");
//		CreateAddressRequest req1 = new CreateAddressRequest(addr1.getAddr_seq(), addr1.getAddr_zip(), addr1.getAddr_detail());
//		service.createAddress(req1);
//		
//		Address addr2 = new Address(4, "시군구동읍면리", "아파트, 주택");
//		CreateAddressRequest req2 = new CreateAddressRequest(addr2.getAddr_seq(), addr2.getAddr_zip(), addr2.getAddr_detail());
//		service.createAddress(req2);
//	}
//	
//	//@Test
//	void update()
//	{
//		UpdateAddressRequest req = new UpdateAddressRequest(1, "서울특별시 종로구", "경복궁");
//		service.updateAddress(req);
//		UpdateAddressRequest req1 = new UpdateAddressRequest(2, "경기도 성남시", "성남아파트");
//		service.updateAddress(req1);
//		UpdateAddressRequest req2 = new UpdateAddressRequest(3, "강원도 춘천시", "춘천아파트");
//		service.updateAddress(req2);
//		UpdateAddressRequest req3 = new UpdateAddressRequest(4, "충청남도 충주시", "충주아파트");
//		service.updateAddress(req3);
//	}
//	
//	
//	//@Test
//	void delete()
//	{
//		service.deleteAddress(4);
//	}
//	
//	
//	@Test
//	void getAll() 
//	{
//		service.findAllAddress();
//	}
//	
//	@Test
//	void getOne()
//	{
//		service.findByIdAddress(1);
//	}
//
//}

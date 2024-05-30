package com.example.phoneShopping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.phoneShopping.product.domain.Plus;
import com.example.phoneShopping.product.dto.request.CreatePlusRequest;
import com.example.phoneShopping.product.dto.request.UpdatePlusRequest;
import com.example.phoneShopping.product.service.PlusService;

@SpringBootTest
public class PlusTest 
{
	@Autowired
	PlusService service;
	
	//@Test
	void create()
	{
		Plus plus = new Plus(111);
		CreatePlusRequest req = new CreatePlusRequest(plus.getPrice());
		service.createPlus(req);
	}
	
	//@Test
	void create1()
	{
		Plus plus = new Plus(222);
		CreatePlusRequest req = new CreatePlusRequest(plus.getPrice());
		service.createPlus(req);
		
		Plus plus1 = new Plus(333);
		CreatePlusRequest req1 = new CreatePlusRequest(plus1.getPrice());
		service.createPlus(req1);
		
		Plus plus2 = new Plus(444);
		CreatePlusRequest req2 = new CreatePlusRequest(plus2.getPrice());
		service.createPlus(req2);
	}
	
	//@Test
	void update()
	{
		UpdatePlusRequest req = new UpdatePlusRequest(1, 111111);
		service.updatePlus(req);
		UpdatePlusRequest req1 = new UpdatePlusRequest(2, 222222);
		service.updatePlus(req1);
		UpdatePlusRequest req2 = new UpdatePlusRequest(3, 333333);
		service.updatePlus(req2);
		UpdatePlusRequest req3 = new UpdatePlusRequest(4, 444444);
		service.updatePlus(req3);
	}
	
	
	//@Test
	void delete()
	{
		service.deletePlus(4);
		service.deletePlus(3);
		service.deletePlus(2);
		service.deletePlus(1);
	}
	
	
	@Test
	void getAll() 
	{
		service.findAllPlus();
	}
	
	//@Test
	void getOne()
	{
		service.findByIdPlus(4);
	}
}

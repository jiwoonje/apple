package com.example.phoneShopping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.phoneShopping.product.domain.Color;
import com.example.phoneShopping.product.dto.request.CreateColorRequest;
import com.example.phoneShopping.product.dto.request.UpdateColorRequest;
import com.example.phoneShopping.product.service.ColorService;

@SpringBootTest
public class ColorTest 
{
	@Autowired
	ColorService service;
	
	//@Test
	void create()
	{
		Color c = new Color("빨강");
		CreateColorRequest req = new CreateColorRequest(c.getColor());
		service.createColor(req);
	}
	
	//@Test
	void create1()
	{
		Color c = new Color("빨강");
		CreateColorRequest req = new CreateColorRequest(c.getColor());
		service.createColor(req);
		
		Color c1 = new Color("빨강");
		CreateColorRequest req1 = new CreateColorRequest(c1.getColor());
		service.createColor(req1);
		
		Color c2 = new Color("빨강");
		CreateColorRequest req2 = new CreateColorRequest(c2.getColor());
		service.createColor(req2);
	}
	
	//@Test
	void update()
	{
		UpdateColorRequest req = new UpdateColorRequest(1, "파랑");
		service.updateColor(req);
		
		UpdateColorRequest req1 = new UpdateColorRequest(2, "주황");
		service.updateColor(req1);
		
		UpdateColorRequest req2 = new UpdateColorRequest(3, "노랑");
		service.updateColor(req2);
		
		UpdateColorRequest req3 = new UpdateColorRequest(4, "보라");
		service.updateColor(req3);

	}
	
	
	//@Test
	void delete()
	{
		service.deleteColor(4);

	}
	
	
	@Test
	void getAll() 
	{
		service.findAllColor();
	}
	
	@Test
	void getOne()
	{
		service.findByIdColor(4);
	}

}

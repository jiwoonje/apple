package com.example.phoneShopping.product.service;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.product.dao.PlusDao;
import com.example.phoneShopping.product.domain.Plus;
import com.example.phoneShopping.product.dto.param.CreatePlusParam;
import com.example.phoneShopping.product.dto.param.UpdatePlusParam;
import com.example.phoneShopping.product.dto.request.CreatePlusRequest;
import com.example.phoneShopping.product.dto.request.UpdatePlusRequest;
import com.example.phoneShopping.product.dto.response.CreatePlusResponse;
import com.example.phoneShopping.product.dto.response.DeletePlusResponse;
import com.example.phoneShopping.product.dto.response.UpdatePlusResponse;
import com.example.phoneShopping.product.exception.PlusException;

import lombok.RequiredArgsConstructor;



@Service
@Transactional
@RequiredArgsConstructor
public class PlusService 
{
	private final PlusDao dao;
	
	@Transactional
	public CreatePlusResponse createPlus(CreatePlusRequest req)
	{
		createPlusMethod(req);
		return new CreatePlusResponse(req.getPlusSeq());
	}
		
	private void createPlusMethod(CreatePlusRequest req)
	{
		System.out.println("createPlus동작");
		CreatePlusParam param = new CreatePlusParam(req.getPlusSeq(), req.getPrice());
		
		Integer result = dao.createPlus(param);
		
		if(result==0)
		{
			throw new PlusException("Plus 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Plus> findAllPlus()
	{
		System.out.println("findAllPlus동작");
		List<Plus> list = dao.findAllPlus();
		
		for(int i = 0; i < dao.findAllPlus().size(); i++)
		{
			System.out.println(dao.findAllPlus().get(i).getPlusSeq());
			System.out.println(dao.findAllPlus().get(i).getPrice());
			System.out.println("\n");
		}
		
		return list;
	}
	

	@Transactional
	public Plus findByIdPlus(int plusSeq) 
	{
		System.out.println("findByIdPlus동작");
		dao.findByIdPlus(plusSeq);
		return dao.findByIdPlus(plusSeq);
	}
	
	@Transactional
	public UpdatePlusResponse updatePlus(UpdatePlusRequest req)
	{
		findByIdPlus(req.getPlusSeq());
		return new UpdatePlusResponse(updatePlusMethod(req));
	}
	
	private Integer updatePlusMethod(UpdatePlusRequest req)
	{
		System.out.println("updatePlus동작");
				
		UpdatePlusParam param = new UpdatePlusParam(req.getPlusSeq(), req.getPrice());
		
		Integer result = dao.updatePlus(param);
		
		if(result==0)
		{
			throw new PlusException("Plus 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@Transactional
	public DeletePlusResponse deletePlus(int plusSeq)
	{
		System.out.println("deletePlus동작");
		int number = dao.deletePlus(plusSeq);

		if(number == 0)
		{
			System.out.println("삭제 실패, 정보가 존재하지 않습니다.");
		}

		return new DeletePlusResponse(number);
	}
}

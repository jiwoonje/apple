package com.example.phoneShopping.product.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.product.dao.HddDao;
import com.example.phoneShopping.product.domain.Hdd;
import com.example.phoneShopping.product.dto.param.CreateHddParam;
import com.example.phoneShopping.product.dto.param.UpdateHddParam;
import com.example.phoneShopping.product.dto.request.CreateHddRequest;
import com.example.phoneShopping.product.dto.request.UpdateHddRequest;
import com.example.phoneShopping.product.dto.response.CreateHddResponse;
import com.example.phoneShopping.product.dto.response.DeleteHddResponse;
import com.example.phoneShopping.product.dto.response.UpdateHddResponse;
import com.example.phoneShopping.product.exception.HddException;

import lombok.RequiredArgsConstructor;



@Service
@Transactional
@RequiredArgsConstructor
public class HddService 
{
	private final HddDao dao;
	
	@Transactional
	public CreateHddResponse createHdd(CreateHddRequest req)
	{
		createHddMethod(req);
		return new CreateHddResponse(req.getHddSeq());
	}
		
	private void createHddMethod(CreateHddRequest req)
	{
		System.out.println("createHdd동작");
		CreateHddParam param = new CreateHddParam(req);
		
		Integer result = dao.createHdd(param);
		
		System.out.println(result);
		
		if(result==0)
		{
			throw new HddException("Hdd 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Hdd> findAllHdd()
	{
		System.out.println("findAllHdd동작");
		List<Hdd> list = dao.findAllHdd();
		
		for(int i = 0; i < dao.findAllHdd().size(); i++)
		{
			System.out.println(dao.findAllHdd().get(i).getHddSeq());
			System.out.println(dao.findAllHdd().get(i).getCapacity());
			System.out.println(dao.findAllHdd().get(i).getPlusSeq());
			System.out.println("\n");
		}
		
		return list;
	}
	

	@Transactional(readOnly=true)
	public Hdd findByIdHdd(int hddSeq) 
	{
		System.out.println("findByIdHdd동작");
		dao.findByIdHdd(hddSeq);
		return dao.findByIdHdd(hddSeq);
	}
	
	@Transactional
	public UpdateHddResponse updateHdd(UpdateHddRequest req)
	{
		findByIdHdd(req.getHddSeq());
		return new UpdateHddResponse(updateHddMethod(req));
	}
	
	private Integer updateHddMethod(UpdateHddRequest req)
	{
		System.out.println("updateHdd동작");
				
		UpdateHddParam param = new UpdateHddParam(req.getHddSeq(), req.getCapacity(), req.getPlusSeq());
		
		Integer result = dao.updateHdd(param);
		
		if(result==0)
		{
			throw new HddException("Hdd 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@Transactional
	public DeleteHddResponse deleteHdd(int hddSeq)
	{
		System.out.println("deleteHdd동작");
		int number = dao.deleteHdd(hddSeq);
		if(number == 0)
		{
			System.out.println("삭제 실패, 정보가 존재하지 않습니다.");
		}
		return new DeleteHddResponse(number);
	}
}

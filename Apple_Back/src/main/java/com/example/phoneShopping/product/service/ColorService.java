package com.example.phoneShopping.product.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.product.dao.ColorDao;
import com.example.phoneShopping.product.domain.Color;
import com.example.phoneShopping.product.dto.param.CreateColorParam;
import com.example.phoneShopping.product.dto.param.UpdateColorParam;
import com.example.phoneShopping.product.dto.request.CreateColorRequest;
import com.example.phoneShopping.product.dto.request.UpdateColorRequest;
import com.example.phoneShopping.product.dto.response.CreateColorResponse;
import com.example.phoneShopping.product.dto.response.DeleteColorResponse;
import com.example.phoneShopping.product.dto.response.UpdateColorResponse;
import com.example.phoneShopping.product.exception.ColorException;

import lombok.RequiredArgsConstructor;



@Service
@Transactional
@RequiredArgsConstructor
public class ColorService 
{
	private final ColorDao dao;
	
	@Transactional
	public CreateColorResponse createColor(CreateColorRequest req)
	{
		createColorMethod(req);
		return new CreateColorResponse(req.getColorSeq());
	}
		
	private void createColorMethod(CreateColorRequest req)
	{
		System.out.println("createColor동작");
		CreateColorParam param = new CreateColorParam(req.getColorSeq(), req.getColor());
		
		Integer result = dao.createColor(param);
		
		if(result==0)
		{
			throw new ColorException("Color 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Color> findAllColor()
	{
		System.out.println("findAllColor동작");
		List<Color> list = dao.findAllColor();
		
		for(int i = 0; i < dao.findAllColor().size(); i++)
		{
			System.out.println(dao.findAllColor().get(i).getColorSeq());
			System.out.println(dao.findAllColor().get(i).getColor());
			System.out.println("\n");
		}
		
		return list;
	}
	
	@Transactional
	public Color findByIdColor(int color_seq) 
	{
		System.out.println("findByIdColor동작");
		dao.findByIdColor(color_seq);

		return dao.findByIdColor(color_seq);
	}
	
	@Transactional
	public UpdateColorResponse updateColor(UpdateColorRequest req)
	{
		findByIdColor(req.getColorSeq());
		return new UpdateColorResponse(updateColorMethod(req));
	}
	
	private Integer updateColorMethod(UpdateColorRequest req)
	{
		System.out.println("updateColor동작");
				
		UpdateColorParam param = new UpdateColorParam(req.getColorSeq(), req.getColor());
		
		Integer result = dao.updateColor(param);
		
		if(result==0)
		{
			throw new ColorException("Color 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@Transactional
	public DeleteColorResponse deleteColor(int color_seq)
	{
		System.out.println("deleteColor동작");
		int number = dao.deleteColor(color_seq);
		if(number == 0)
		{
			System.out.println("삭제 실패, 정보가 존재하지 않습니다.");
		}
		return new DeleteColorResponse(number);
	}
}

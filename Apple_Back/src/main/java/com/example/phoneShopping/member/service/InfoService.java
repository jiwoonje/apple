package com.example.phoneShopping.member.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.example.phoneShopping.member.dao.AddressDao;
import com.example.phoneShopping.member.dao.InfoDao;
//import com.example.phoneShopping.member.domain.Address;
import com.example.phoneShopping.member.domain.Info;
import com.example.phoneShopping.member.dto.param.CreateInfoParam;
import com.example.phoneShopping.member.dto.param.UpdateInfoParam;
import com.example.phoneShopping.member.dto.request.CreateInfoRequest;
import com.example.phoneShopping.member.dto.request.UpdateInfoRequest;
import com.example.phoneShopping.member.dto.response.CreateInfoResponse;
import com.example.phoneShopping.member.dto.response.DeleteInfoResponse;
import com.example.phoneShopping.member.dto.response.UpdateInfoResponse;
import com.example.phoneShopping.member.exception.InfoException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InfoService 
{
	private final InfoDao dao;
	//private final AddressDao a_dao;
	
	@Transactional
	public CreateInfoResponse createInfo(CreateInfoRequest req)
	{
		createInfoMethod(req);
		return new CreateInfoResponse(req.getInfoSeq());
	}
		
	private void createInfoMethod(CreateInfoRequest req)
	{
		System.out.println("createAddress동작");
		System.out.println(req.getInfoSeq());
		System.out.println(req.getInfoName());
		System.out.println(req.getInfoBirth());
		System.out.println(req.getInfoGender());
		System.out.println(req.getInfoPhone());
		
		System.out.println("\n\n");
		CreateInfoParam param = new CreateInfoParam(req);

		Integer result = dao.createInfo(param);
		
		if(result==0)
		{
			throw new InfoException("카드 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Info> findAllInfo()
	{
		System.out.println("findAllInfo동작");
		List<Info> list = dao.findAllInfo();
		for(int i = 0; i < dao.findAllInfo().size(); i++)
		{
			System.out.println(dao.findAllInfo().get(i).getInfoSeq());
			System.out.println(dao.findAllInfo().get(i).getInfoName());
			System.out.println(dao.findAllInfo().get(i).getInfoGender());
			System.out.println(dao.findAllInfo().get(i).getInfoBirth());
			System.out.println(dao.findAllInfo().get(i).getInfoPhone());
			System.out.println("\n");
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public Info findByIdInfo(int infoSeq) 
	{
		System.out.println("findByIdInfo동작");
		System.out.println(dao.findByIdInfo(infoSeq).getInfoSeq());
		System.out.println(dao.findByIdInfo(infoSeq).getInfoName());
		System.out.println(dao.findByIdInfo(infoSeq).getInfoGender());
		System.out.println(dao.findByIdInfo(infoSeq).getInfoBirth());
		System.out.println(dao.findByIdInfo(infoSeq).getInfoPhone());
		return dao.findByIdInfo(infoSeq);
	}
	
	@Transactional
	public UpdateInfoResponse updateInfo(UpdateInfoRequest req)
	{
		findByIdInfo(req.getInfoSeq());
		updateInfoMethod(req);
		return new UpdateInfoResponse(updateInfoMethod(req));
	}
	
	private Integer updateInfoMethod(UpdateInfoRequest req)
	{
		System.out.println("updateInfo동작");
				
		UpdateInfoParam param = new UpdateInfoParam(req.getInfoSeq(), req.getInfoName(), req.getInfoBirth(), req.getInfoGender(), req.getInfoPhone());
		
		Integer result = dao.updateInfo(param);
		
		if(result==0)
		{
			throw new InfoException("Info 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@Transactional
	public DeleteInfoResponse deleteInfo(int infoSeq)
	{
		System.out.println("deleteInfo동작");
		int number = dao.deleteInfo(infoSeq);
		if(number == 0)
		{
			System.out.println("삭제 실패, 정보가 존재하지 않습니다.");
		}
		return new DeleteInfoResponse(number);
	}	
}

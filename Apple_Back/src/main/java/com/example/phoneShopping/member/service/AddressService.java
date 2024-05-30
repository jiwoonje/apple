package com.example.phoneShopping.member.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.member.dao.AddressDao;
import com.example.phoneShopping.member.domain.Address;
import com.example.phoneShopping.member.dto.param.CreateAddressParam;
import com.example.phoneShopping.member.dto.param.UpdateAddressParam;
import com.example.phoneShopping.member.dto.request.CreateAddressRequest;
import com.example.phoneShopping.member.dto.request.UpdateAddressRequest;
import com.example.phoneShopping.member.dto.response.CreateAddressResponse;
import com.example.phoneShopping.member.dto.response.DeleteAddressResponse;
import com.example.phoneShopping.member.dto.response.UpdateAddressResponse;
import com.example.phoneShopping.member.exception.AddressException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressService 
{
	private final AddressDao addressDao;
	
	@Transactional
	public CreateAddressResponse createAddress(CreateAddressRequest req)
	{
		createAddressMethod(req);
		return new CreateAddressResponse(req.getAddrSeq());
	}
		
	private void createAddressMethod(CreateAddressRequest req)
	{
		System.out.println("createAddress동작");
		CreateAddressParam param = new CreateAddressParam(req);
		
		Integer result = addressDao.createAddress(param);
		if(result==0)
		{
			throw new AddressException("카드 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Address> findAllAddress()
	{
		System.out.println("findAllAddress동작");
		List<Address> list = addressDao.findAllAddress();
		
		for(int i = 0; i < addressDao.findAllAddress().size(); i++)
		{
			System.out.println(addressDao.findAllAddress().get(i).getAddrSeq());
			System.out.println(addressDao.findAllAddress().get(i).getAddrZip());
			System.out.println(addressDao.findAllAddress().get(i).getAddrDetail());
			System.out.println("\n");
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public Address findByIdAddress(int addrSeq) 
	{
		System.out.println("findByIdAddress동작");
		addressDao.findByIdAddress(addrSeq);
		System.out.println(addressDao.findByIdAddress(addrSeq).getAddrSeq());
		System.out.println(addressDao.findByIdAddress(addrSeq).getAddrZip());
		System.out.println(addressDao.findByIdAddress(addrSeq).getAddrDetail());
		Address address = new Address(addressDao.findByIdAddress(addrSeq).getAddrSeq(), addressDao.findByIdAddress(addrSeq).getAddrZip(), addressDao.findByIdAddress(addrSeq).getAddrDetail());
		return address;
	}
	
	@Transactional
	public UpdateAddressResponse updateAddress(UpdateAddressRequest req)
	{
		findByIdAddress(req.getAddrSeq());
		return new UpdateAddressResponse(updateAddressMethod(req));
	}
	
	private Integer updateAddressMethod(UpdateAddressRequest req)
	{
		System.out.println("updateAddress동작");
				
		UpdateAddressParam param = new UpdateAddressParam(req.getAddrSeq(), req.getAddrZip(), req.getAddrDetail());
		
		Integer result = addressDao.updateAddress(param);
		System.out.println(result);
		if(result==0)
		{
			throw new AddressException("카드 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@Transactional
	public DeleteAddressResponse deleteAddress(int addrSeq)
	{
		System.out.println("deleteAddress동작");
		int number = addressDao.deleteAddress(addrSeq);
		if(number == 0)
		{
			System.out.println("삭제 실패, 정보가 존재하지 않습니다.");
		}
		return new DeleteAddressResponse(number);
	}
}

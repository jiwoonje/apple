package com.example.phoneShopping.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.phoneShopping.member.domain.Address;
import com.example.phoneShopping.member.dto.param.CreateAddressParam;
import com.example.phoneShopping.member.dto.param.UpdateAddressParam;

@Mapper
@Repository
public interface AddressDao 
{
	List<Address> findAllAddress();				// Address 정보 전체 조회
	Address findByIdAddress(int addr_seq);		// id(seq)로 Address 정보 찾기(특정 1개)
	Integer createAddress(CreateAddressParam param);	// Address 정보 생성 param사용해서 Address 정보 생성
	Integer updateAddress(UpdateAddressParam param);	// Address 정보 생성 param사용해서 Address 정보 수정
	Integer deleteAddress(int addr_seq);			// Address 정보 삭제
}

package com.example.phoneShopping.member.dto.param;

import com.example.phoneShopping.member.dto.request.CreateAddressRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressParam 
{
	private int addrSeq;
	private String addrZip;
	private String addrDetail;
	
	public CreateAddressParam(CreateAddressRequest req)
	{
		this.addrZip=req.getAddrZip();
		this.addrDetail=req.getAddrDetail();
	}
}

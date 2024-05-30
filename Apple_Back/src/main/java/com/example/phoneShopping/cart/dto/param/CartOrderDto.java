package com.example.phoneShopping.cart.dto.param;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartOrderDto
{
	private int cartpSeq;
	private List<CartOrderDto> cartOrderDtoList;
}

package com.example.phoneShopping.cart.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCartProductParam 
{
	private int cartpSeq;
	private int cartSeq;
	private String prodSeq;
	private int cartpCnt;
}

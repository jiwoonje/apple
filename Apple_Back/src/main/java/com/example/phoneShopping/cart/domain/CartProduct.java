package com.example.phoneShopping.cart.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Cart Product Domain")
public class CartProduct 
{
	@Schema(description = "장바구니 상품 번호(자동 생성)")
	private int cartpSeq;
	
	@Schema(description = "장바구니 번호")
	private int cartSeq;
	
	@Schema(description = "상품 일련 번호")
	private String prodSeq;
	
	@Schema(description = "상품 갯수")
	private int cartpCnt;
	
	@Schema(description = "상품의 갯수를 증가시키는 method")
    public void addCount(int cartpCnt)
    {
        this.cartpCnt += cartpCnt;
    }

	@Schema(description = "상품의 갯수를 수정하는 method")
    public void updateCount(int cartpCnt)
    {
        this.cartpCnt = cartpCnt;
    }	
    
    public CartProduct(int cartSeq, String prodSeq, int cartpCnt)
    {
    	this.cartSeq=cartSeq;
    	this.prodSeq=prodSeq;
    	this.cartpCnt=cartpCnt;    			
    }
	
}

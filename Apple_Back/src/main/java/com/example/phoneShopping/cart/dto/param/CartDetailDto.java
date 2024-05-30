package com.example.phoneShopping.cart.dto.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDetailDto 
{
    private String cartpSeq; //장바구니 상품 아이디

    private String prodName; //상품명

    private int price; //상품 금액

    private int cnt; //수량


    public CartDetailDto(String cartpSeq, String prodName, int price, int cnt)
    {
        this.cartpSeq = cartpSeq;
        this.prodName = prodName;
        this.price = price;
        this.cnt = cnt;
    }
}

//package com.example.phoneShopping;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.phoneShopping.cart.domain.Cart;
//import com.example.phoneShopping.cart.domain.CartProduct;
//import com.example.phoneShopping.cart.dto.request.CreateCartProductRequest;
//import com.example.phoneShopping.cart.dto.request.CreateCartRequest;
//import com.example.phoneShopping.cart.dto.request.UpdateCartProductRequest;
//import com.example.phoneShopping.cart.dto.request.UpdateCartRequest;
//import com.example.phoneShopping.cart.service.CartService;
//
//
//
//@SpringBootTest
//public class CartTest 
//{
//	@Autowired
//	CartService service;
//	
//	//@Test
//	void create()
//	{
//		Cart cart = new Cart(1);
//		CreateCartRequest req = new CreateCartRequest(cart.getMemSeq());
//		service.createCart(req);
//		
//		CartProduct cartProduct = new CartProduct(1, "a", 1);
//		CreateCartProductRequest req1 = new CreateCartProductRequest(cartProduct.getCartSeq(), cartProduct.getProductSeq(), cartProduct.getCartpCnt());
//		service.createCartProduct(req1);
//	}
//	
//	
//	//@Test
//	void create1()
//	{
//		Cart cart = new Cart(4);
//		CreateCartRequest req = new CreateCartRequest(cart.getMemSeq());
//		service.createCart(req);
//		
//		
//		CartProduct cartProduct = new CartProduct(2, "b", 2);
//		CreateCartProductRequest req1 = new CreateCartProductRequest(cartProduct.getCartSeq(), cartProduct.getProductSeq(), cartProduct.getCartpCnt());
//		service.createCartProduct(req1);
//		
//		CartProduct cartProduct1 = new CartProduct(3, "c", 3);
//		CreateCartProductRequest req2 = new CreateCartProductRequest(cartProduct1.getCartSeq(), cartProduct1.getProductSeq(), cartProduct1.getCartpCnt());
//		service.createCartProduct(req2);
//		
//		CartProduct cartProduct2 = new CartProduct(4, "d", 4);
//		CreateCartProductRequest req3 = new CreateCartProductRequest(cartProduct2.getCartSeq(), cartProduct2.getProductSeq(), cartProduct2.getCartpCnt());
//		service.createCartProduct(req3);
//	}
//	
//	//@Test
//	void update()
//	{
//		UpdateCartRequest req = new UpdateCartRequest(2, 2);
//		service.updateCart(req);
//		
//		UpdateCartRequest req1 = new UpdateCartRequest(3, 3);
//		service.updateCart(req1);
//		
//		UpdateCartRequest req2 = new UpdateCartRequest(4, 4);
//		service.updateCart(req2);
//		
//		UpdateCartProductRequest req3 = new UpdateCartProductRequest(2, 22, "f", 222);
//		service.updateCartProduct(req3);
//		
//		UpdateCartProductRequest req4 = new UpdateCartProductRequest(3, 33, "g", 333);
//		service.updateCartProduct(req4);
//		
//		UpdateCartProductRequest req5 = new UpdateCartProductRequest(4, 44, "e", 444);
//		service.updateCartProduct(req5);
//	}
//	
//	
//	//@Test
//	void delete()
//	{
//		service.deleteCart(4);
//		service.deleteCartProduct(4);
//	}
//	
//	
//	//@Test
//	void getAll() 
//	{
//		service.findAllCart();
//		service.findAllCartProduct();
//	}
//	
//	@Test
//	void getOne()
//	{
//		service.findByIdCart(1);
//		service.findByIdCartProduct(1);
//	}
//}

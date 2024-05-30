//package com.example.phoneShopping;
//
//import java.time.LocalDateTime;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.phoneShopping.payment.domain.Payment;
//import com.example.phoneShopping.payment.domain.PaymentProduct;
//import com.example.phoneShopping.payment.dto.request.CreatePaymentProductRequest;
//import com.example.phoneShopping.payment.dto.request.CreatePaymentRequest;
//import com.example.phoneShopping.payment.dto.request.UpdatePaymentProductRequest;
//import com.example.phoneShopping.payment.dto.request.UpdatePaymentRequest;
//import com.example.phoneShopping.payment.service.PaymentService;
//
//
//@SpringBootTest
//public class PaymentTest 
//{
//	@Autowired
//	PaymentService service;
//	
//	//@Test
//	void create()
//	{
//		Payment payment = new Payment(1, LocalDateTime.now(), 1);
//		CreatePaymentRequest req = new CreatePaymentRequest(payment.getMemSeq(), payment.getPayDate(), payment.getPayStatus());
//		service.createPayment(req);
//		
//		PaymentProduct paymentProduct = new PaymentProduct(1, "a", 1, 1);
//		CreatePaymentProductRequest req1 = new CreatePaymentProductRequest(paymentProduct.getPaySeq(), paymentProduct.getProdSeq(), paymentProduct.getPayiPrice(), paymentProduct.getPayiCount());
//		service.createPaymentProduct(req1);
//	}
//	
//	
//	//@Test
//	void create1()
//	{
//		Payment payment = new Payment(2, LocalDateTime.now(), 2);
//		CreatePaymentRequest req = new CreatePaymentRequest(payment.getMemSeq(), payment.getPayDate(), payment.getPayStatus());
//		service.createPayment(req);
//		
//		Payment payment1 = new Payment(3, LocalDateTime.now(), 3);
//		CreatePaymentRequest req1 = new CreatePaymentRequest(payment1.getMemSeq(), payment1.getPayDate(), payment1.getPayStatus());
//		service.createPayment(req1);
//		
//		Payment payment2 = new Payment(4, LocalDateTime.now(), 4);
//		CreatePaymentRequest req2 = new CreatePaymentRequest(payment2.getMemSeq(), payment2.getPayDate(), payment2.getPayStatus());
//		service.createPayment(req2);
//		
//		PaymentProduct paymentProduct = new PaymentProduct(2, "b", 2, 2);
//		CreatePaymentProductRequest req3 = new CreatePaymentProductRequest(paymentProduct.getPaySeq(), paymentProduct.getProdSeq(), paymentProduct.getPayiPrice(), paymentProduct.getPayiCount());
//		service.createPaymentProduct(req3);
//		
//		PaymentProduct paymentProduct1 = new PaymentProduct(3, "c", 3, 3);
//		CreatePaymentProductRequest req4 = new CreatePaymentProductRequest(paymentProduct1.getPaySeq(), paymentProduct1.getProdSeq(), paymentProduct1.getPayiPrice(), paymentProduct1.getPayiCount());
//		service.createPaymentProduct(req4);
//		
//		PaymentProduct paymentProduct2 = new PaymentProduct(4, "d", 4, 4);
//		CreatePaymentProductRequest req5 = new CreatePaymentProductRequest(paymentProduct2.getPaySeq(), paymentProduct2.getProdSeq(), paymentProduct2.getPayiPrice(), paymentProduct2.getPayiCount());
//		service.createPaymentProduct(req5);
//	}
//	
//	//@Test
//	void update()
//	{
//		UpdatePaymentRequest req = new UpdatePaymentRequest(4, 2, LocalDateTime.now(), 2);
//		service.updatePayment(req);
//
//		
//		UpdatePaymentProductRequest req4 = new UpdatePaymentProductRequest(2, "b", 2, 2, 2);
//		service.updatePaymentProduct(req4);
//
//	}
//	
//	
//	//@Test
//	void delete()
//	{
//		service.deletePayment(6);
//		service.deletePaymentProduct(4);
//	}
//	
//	
//	//@Test
//	void getAll() 
//	{
//		service.findAllPayment();
//		service.findAllPaymentProduct();
//	}
//	
//	@Test
//	void getOne()
//	{
//		service.findByIdPayment(3);
//		service.findByIdPaymentProduct(1);
//	}
//}

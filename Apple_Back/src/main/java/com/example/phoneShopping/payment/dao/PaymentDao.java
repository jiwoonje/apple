package com.example.phoneShopping.payment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import com.example.phoneShopping.payment.domain.Payment;
import com.example.phoneShopping.payment.domain.PaymentProduct;
import com.example.phoneShopping.payment.dto.param.CreatePaymentParam;
import com.example.phoneShopping.payment.dto.param.CreatePaymentProductParam;
import com.example.phoneShopping.payment.dto.param.UpdatePaymentParam;
import com.example.phoneShopping.payment.dto.param.UpdatePaymentProductParam;


@Mapper
@Repository
public interface PaymentDao 
{
	// Cart관련 CRUD
	List<Payment> findAllPayment();				// Cart 정보 전체 조회
	Payment findByIdPayment(int paySeq);		// id(seq)로 Cart 정보 찾기(특정 1개)
	Integer createPayment(CreatePaymentParam param);	// Cart 정보 생성
	Integer updatePayment(UpdatePaymentParam param);	// Cart 정보 수정
	Integer deletePayment(int paySeq);			// Cart 정보 삭제
	
	
	// CartProduct관련 CRUD
	PaymentProduct findByIdPaymentProduct(int payiSeq);
	List<PaymentProduct> findAllPaymentProduct();
	Integer createPaymentProduct(CreatePaymentProductParam param);
	Integer updatePaymentProduct(UpdatePaymentProductParam param);	// Cart 정보 수정
	Integer deletePaymentProduct(int payiSeq);
	
	
	// "select o from Payment o " +    "where o.member.mem_id = :mem_id " +  "Payment by o.pay_Date desc
	List<Payment> findPayment(String mem_id);
	
	// "select count(o) from Payment o " + "where o.member.mem_id = :mem_id"
	Integer countOrder(@Param("mem_id") String mem_id);
	
}

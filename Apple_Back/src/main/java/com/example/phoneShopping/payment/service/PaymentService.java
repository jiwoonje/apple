package com.example.phoneShopping.payment.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phoneShopping.payment.dao.PaymentDao;
import com.example.phoneShopping.payment.domain.Payment;
import com.example.phoneShopping.payment.domain.PaymentProduct;
import com.example.phoneShopping.payment.dto.param.CreatePaymentParam;
import com.example.phoneShopping.payment.dto.param.CreatePaymentProductParam;
import com.example.phoneShopping.payment.dto.param.UpdatePaymentParam;
import com.example.phoneShopping.payment.dto.param.UpdatePaymentProductParam;
import com.example.phoneShopping.payment.dto.request.CreatePaymentProductRequest;
import com.example.phoneShopping.payment.dto.request.CreatePaymentRequest;
import com.example.phoneShopping.payment.dto.request.UpdatePaymentProductRequest;
import com.example.phoneShopping.payment.dto.request.UpdatePaymentRequest;
import com.example.phoneShopping.payment.dto.response.CreatePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.CreatePaymentResponse;
import com.example.phoneShopping.payment.dto.response.DeletePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.DeletePaymentResponse;
import com.example.phoneShopping.payment.dto.response.UpdatePaymentProductResponse;
import com.example.phoneShopping.payment.dto.response.UpdatePaymentResponse;
import com.example.phoneShopping.payment.exception.PaymentException;
import com.example.phoneShopping.payment.exception.PaymentProductException;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService 
{
	private final PaymentDao dao;
	
	@Transactional
	public CreatePaymentResponse createPayment(CreatePaymentRequest req)
	{
		createPaymentMethod(req);
		return new CreatePaymentResponse(req.getPaySeq());
	}
		
	private void createPaymentMethod(CreatePaymentRequest req)
	{
		System.out.println("createPayment동작");
		CreatePaymentParam param = new CreatePaymentParam(req.getPaySeq() ,req.getMemSeq(), req.getPayDate(), req.getPayStatus());
		
		Integer result = dao.createPayment(param);
		if(result==0)
		{
			throw new PaymentException("Payment 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Payment> findAllPayment()
	{
		System.out.println("findAllPayment동작");
		List<Payment> list = dao.findAllPayment();
		
		for(int i = 0; i < dao.findAllPayment().size(); i++)
		{
			System.out.println(dao.findAllPayment().get(i).getPaySeq());
			System.out.println(dao.findAllPayment().get(i).getMemSeq());
			System.out.println(dao.findAllPayment().get(i).getPayDate());
			System.out.println(dao.findAllPayment().get(i).getPayStatus());
			System.out.println("\n");
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public Payment findByIdPayment(int paySeq) 
	{
		System.out.println("findByIdPayment동작");
		Payment payment = dao.findByIdPayment(paySeq);
		System.out.println(payment);
		return payment;
	}
	
	@Transactional
	public UpdatePaymentResponse updatePayment(UpdatePaymentRequest req)
	{
		findByIdPayment(req.getPaySeq());		
		return new UpdatePaymentResponse(updatePaymentMethod(req));
	}
	
	private Integer updatePaymentMethod(UpdatePaymentRequest req)
	{
		System.out.println("updatePayment동작");
				
		UpdatePaymentParam param = new UpdatePaymentParam(req.getPaySeq() ,req.getMemSeq(), req.getPayDate(), req.getPayStatus());
		
		Integer result = dao.updatePayment(param);
		
		if(result==0)
		{
			throw new PaymentException("Payment 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@Transactional
	public DeletePaymentResponse deletePayment(int paySeq)
	{
		System.out.println("deletePayment동작");
		int number = dao.deletePayment(paySeq);
		return new DeletePaymentResponse(number);
	}
	
	
	@Transactional
	public CreatePaymentProductResponse createPaymentProduct(CreatePaymentProductRequest req)
	{
		createPaymentProductMethod(req);
		return new CreatePaymentProductResponse(req.getPayiSeq());
	}
		
	private void createPaymentProductMethod(CreatePaymentProductRequest req)
	{
		System.out.println("createPaymentProduct동작");
		CreatePaymentProductParam param = new CreatePaymentProductParam(req.getPayiSeq() ,req.getProdSeq(), req.getPaySeq(), req.getPayiPrice(), req.getPayiCount());
		
		Integer result = dao.createPaymentProduct(param);
		
		if(result==0)
		{
			throw new PaymentProductException("PaymentProduct 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(readOnly=true)
	public List<PaymentProduct> findAllPaymentProduct()
	{
		System.out.println("findAllPaymentProduct동작");
		List<PaymentProduct> list = dao.findAllPaymentProduct();
		
		for(int i = 0; i < dao.findAllPaymentProduct().size(); i++)
		{
			System.out.println(dao.findAllPaymentProduct().get(i).getPayiSeq());
			System.out.println(dao.findAllPaymentProduct().get(i).getProdSeq());
			System.out.println(dao.findAllPaymentProduct().get(i).getPaySeq());
			System.out.println(dao.findAllPaymentProduct().get(i).getPayiPrice());
			System.out.println(dao.findAllPaymentProduct().get(i).getPayiCount());
			System.out.println("\n");
		}
		
		return list;
	}
	
	@Transactional(readOnly=true)
	public PaymentProduct findByIdPaymentProduct(int payiSeq) 
	{
		System.out.println("findByIdPaymentProduct동작");
		
		return dao.findByIdPaymentProduct(payiSeq);
	}
	
	@Transactional
	public UpdatePaymentProductResponse updatePaymentProduct(UpdatePaymentProductRequest req)
	{
		findByIdPaymentProduct(req.getPayiSeq());
		
		return new UpdatePaymentProductResponse(updatePaymentProductMethod(req));
	}
	
	private Integer updatePaymentProductMethod(UpdatePaymentProductRequest req)
	{
		System.out.println("updatePaymentProduct동작");
				
		UpdatePaymentProductParam param = new UpdatePaymentProductParam(req.getPayiSeq() ,req.getProdSeq(), req.getPaySeq(), req.getPayiPrice(), req.getPayiCount());
		
		Integer result = dao.updatePaymentProduct(param);
		
		if(result==0)
		{
			throw new PaymentProductException("PaymentProduct 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@Transactional
	public DeletePaymentProductResponse deletePaymentProduct(int payiSeq)
	{
		System.out.println("deletePaymentProduct동작");
		int number = dao.deletePaymentProduct(payiSeq);
		return new DeletePaymentProductResponse(number);
	}
}

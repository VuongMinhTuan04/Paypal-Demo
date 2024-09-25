package com.example.paypal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaypalService {
	private final APIContext apiContext;
	
	public Payment createPayment(
			Double total,
			String currency,
			String method,
			String intent,
			String description,
			String cancelUrl,
			String successUrl
	) throws PayPalRESTException {
		Amount amount = new Amount();
		amount.setCurrency(currency);
		amount.setTotal(String.format(Locale.forLanguageTag(currency),"%.2f", total)); //US Locate: 9.99$ //forLanguageTag: Tùy thuộc vào loại tiền tệ
		
		Transaction transaction = new Transaction(); //Tạo giao dịch
		transaction.setDescription(description);
		transaction.setAmount(amount);
		
		List<Transaction> transactions = new ArrayList<>();//Tạo danh sách chưa giao dịch
		transactions.add(transaction);
		
		Payer payer = new Payer(); //Người trả tiền
		payer.setPaymentMethod(method);
		
		Payment payment = new Payment(); //Thanh toán
		payment.setIntent(intent); //Mục đích
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl(cancelUrl);
		redirectUrls.setReturnUrl(successUrl);
		
		payment.setRedirectUrls(redirectUrls);
		
		return payment.create(apiContext);
	};
	
	//Thanh toán công khai
	public Payment executePayment(
			String paymentId,
			String payerId
	) throws PayPalRESTException {
		Payment payment = new Payment();
		payment.setId(paymentId);
		
		PaymentExecution paymentExecution = new PaymentExecution(); //Thực hiện thanh toán
		paymentExecution.setPayerId(payerId);
		
		return payment.execute(apiContext, paymentExecution);
	};
}

package com.ts;

import org.json.JSONObject;

import com.entity.TransactionDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

public class OrderDetailService {

	private static final String KEY = "rzp_test_AwJmjsOGm7AicJ";
	private static final String KEY_SECERT = "HzlV2kXWBeyOFtXN6BC3eKmF";
	private static final String CURRENCY = "INR";

	public TransactionDetails createTransaction(Double amount){
		
		try{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("amount", (amount*100));
			jsonObject.put("currency", CURRENCY);
			
			RazorpayClient razorpayClient = new RazorpayClient(KEY,KEY_SECERT);
			
			Order order = razorpayClient.orders.create(jsonObject);
			
			TransactionDetails transactionDetails = prepareTransactionDetails(order);
			return transactionDetails;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
		
		
	}
	
	private TransactionDetails prepareTransactionDetails(Order order){
		String orderId = order.get("id");
		String currency = order.get("currency");
		Integer amount = order.get("amount");
		
		TransactionDetails transactionDetails = new TransactionDetails(orderId,currency,amount);
		return transactionDetails;
	}
}

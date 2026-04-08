package com.example.payment.service.impl;

import com.example.payment.requests.PaymentRequest;
import com.example.payment.service.PaymentService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PaymentServiceImpl implements PaymentService {

//    private final Map<String, PaymentRequest> payments = new ConcurrentHashMap<>();

    @Override
    @CachePut(value = "paymentService",key = "#paymentRequest.getOrderId()",condition = "#paymentRequest.getOrderId() != null")
    public PaymentRequest processPayment(PaymentRequest paymentRequest) {
        String paymentId = UUID.randomUUID().toString();
        //        payments.put(paymentRequest.getOrderId(), payment);
        return new PaymentRequest(paymentId, paymentRequest.getOrderId(), paymentRequest.getAmount(), "SUCCESS");
    }

    @Override
    @Cacheable(value = "paymentService", key = "#orderId")
    public PaymentRequest getPaymentByOrderId(String orderId) {
//        return payments.getOrDefault(orderId, new PaymentRequest("N/A", orderId, 0, "NOT_FOUND"));
        return new PaymentRequest("N/A", orderId, 0, "PAYMENT DETAILS NOT_FOUND");
    }


}

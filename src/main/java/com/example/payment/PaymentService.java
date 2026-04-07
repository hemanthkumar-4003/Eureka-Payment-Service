package com.example.payment;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PaymentService {

    private final Map<String, PaymentRequest> payments = new ConcurrentHashMap<>();

    public PaymentRequest processPayment(PaymentRequest paymentRequest) {
        String paymentId = UUID.randomUUID().toString();
        PaymentRequest payment = new PaymentRequest(paymentId, paymentRequest.getOrderId(), paymentRequest.getAmount(), "SUCCESS");
        payments.put(paymentRequest.getOrderId(), payment);
        return payment;
    }

    public PaymentRequest getPaymentByOrderId(String orderId) {
        return payments.getOrDefault(orderId, new PaymentRequest("N/A", orderId, 0, "NOT_FOUND"));
    }
}

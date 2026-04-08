package com.example.payment.service;

import com.example.payment.requests.PaymentRequest;

public interface PaymentService {
    PaymentRequest processPayment(PaymentRequest paymentRequest);

    PaymentRequest getPaymentByOrderId(String orderId);
}

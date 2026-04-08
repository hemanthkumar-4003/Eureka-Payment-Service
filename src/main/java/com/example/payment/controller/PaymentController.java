package com.example.payment.controller;

import com.example.payment.requests.PaymentRequest;
import com.example.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    // POST /payments
    @PostMapping
    public PaymentRequest processPayment(@RequestBody PaymentRequest payment) {
        return paymentService.processPayment(payment);
    }

    // GET /payments/{orderId}
    @GetMapping(value = "/{orderId}")
    public PaymentRequest getPayment(@PathVariable String orderId) {
        return paymentService.getPaymentByOrderId(orderId);
    }
}

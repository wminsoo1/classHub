package com.example.classHub.payment;

public enum PaymentStatus {
    PENDING,        // 미결제 (결제 진행 중)
    PAID,           // 결제 완료
    PARTIAL_REFUND, // 부분 환불
    FULL_REFUND     // 전액 환불
}
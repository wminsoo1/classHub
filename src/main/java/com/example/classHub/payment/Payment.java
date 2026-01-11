package com.example.classHub.payment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "payments")
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private Long reservationId;

    private String paymentCardNumber;
    private String paymentCardCompany;

    private int amount;       // 결제 금액
    private String orderName; // 클래스 정보 (예: "도자기 물레 체험 외 1건")

    // [결제 상태]
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDateTime paidAt; // 결제 일시

}
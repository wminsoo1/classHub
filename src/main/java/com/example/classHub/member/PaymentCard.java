package com.example.classHub.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentCard {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;   // 실제로는 암호화 필요
    private String cardCompany;  // 현대, 삼성 등
    private String cvc;

    protected PaymentCard(String cardNumber, String cardCompany, String cvc) {
        this.cardNumber = cardNumber;
        this.cardCompany = cardCompany;
        this.cvc = cvc;
    }
}
package com.example.classHub.settlement;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SettlementDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 나중에 클래스 가격이 변동되어도, 정산 당시의 가격과 인원수는 변하면 안 됨
    private String className;      // 클래스 이름
    private int pricePerPerson;    // 1인당 가격
    private int headcount;         // 수강 인원
    private long settlementAmount; // 최종 정산액 (가격 * 인원)

    public SettlementDetail(String className, int pricePerPerson, int headcount) {
        this.className = className;
        this.pricePerPerson = pricePerPerson;
        this.headcount = headcount;
        this.settlementAmount = (long) pricePerPerson * headcount;
    }

}
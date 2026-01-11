package com.example.classHub.settlement;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "settlements")
public class Settlement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long instructorId;

    private LocalDate settlementDate; // 정산 기준일 (예: 2026-01-15)
    private long totalAmount;         // 총 정산 지급액

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "settlement_id")
    private List<SettlementDetail> details = new ArrayList<>();

    public Settlement(Long instructorId, LocalDate settlementDate) {
        this.instructorId = instructorId;
        this.settlementDate = settlementDate;
        this.totalAmount = 0;
    }

}
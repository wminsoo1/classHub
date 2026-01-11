package com.example.classHub.instructor;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SettlementInfo {
    private boolean isBusiness;
    private String settlementAccount;
}
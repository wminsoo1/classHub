package com.example.classHub.instructor;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructor")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Embedded
    private InstructorProfile profile; // 이름, 연락처

    @Embedded
    private SettlementInfo settlementInfo; // 사업자여부, 정산계좌

    public Instructor(String username, String password, InstructorProfile profile, SettlementInfo settlementInfo) {
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.settlementInfo = settlementInfo;
    }
}

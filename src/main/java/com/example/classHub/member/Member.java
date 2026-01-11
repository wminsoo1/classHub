package com.example.classHub.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;

    @Embedded
    private ContactInfo contact; // 연락처 VO

    @Embedded
    private NotificationSetting notificationSetting; // 알림 설정 VO

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private List<PaymentCard> cards = new ArrayList<>();

    public Member(String username, String password, String name, ContactInfo contact, NotificationSetting notificationSetting) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.contact = contact;
        this.notificationSetting = notificationSetting;
    }

}
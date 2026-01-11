package com.example.classHub.oneDayClass;

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
@Table(name = "one_day_class")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OneDayClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long instructorId;

    @Embedded
    private ClassBasicInfo basicInfo; // 제목, 카테고리, 설명

}
package com.example.classHub.oneDayClass;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClassBasicInfo {
    private String title;
    private String category;
    @Column(columnDefinition = "TEXT")
    private String description;
}
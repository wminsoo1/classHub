package com.example.classHub.oneDayClass;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
@Entity
public class ClassSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private int price;

    @Embedded
    private EnrollmentCapacity capacity; //정원 관리 (최소/최대/현재 인원)

    @Enumerated(EnumType.STRING)
    private ClassStatus status;

    protected void addEnrollment() {
        if (this.status != ClassStatus.OPEN) {
            throw new IllegalStateException("현재 모집 중인 상태가 아닙니다.");
        }
        this.capacity = this.capacity.increase();
    }

    protected void close() {
        this.status = ClassStatus.CLOSED;
    }

    public boolean hasVacancy() {
        return this.capacity.isFull();
    }

}
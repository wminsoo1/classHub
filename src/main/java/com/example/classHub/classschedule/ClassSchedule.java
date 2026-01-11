package com.example.classHub.classschedule;

import jakarta.persistence.*;
import lombok.AccessLevel; // 추가
import lombok.Getter;
import lombok.NoArgsConstructor; // 추가
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long oneDayClassId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private int price;

    @Embedded
    private EnrollmentCapacity capacity;

    @Enumerated(EnumType.STRING)
    private ClassStatus status;

    public void addEnrollment() {
        if (this.status != ClassStatus.OPEN) {
            throw new IllegalStateException("현재 모집 중인 상태가 아닙니다.");
        }

        this.capacity = this.capacity.increase();

        if (!hasVacancy()) {
            close();
        }
    }

    public void close() {
        this.status = ClassStatus.CLOSED;
    }

    public boolean hasVacancy() {
        return !this.capacity.isFull();
    }

}
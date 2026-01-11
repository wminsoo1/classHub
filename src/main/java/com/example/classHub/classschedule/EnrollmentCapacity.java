package com.example.classHub.classschedule;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
    public class EnrollmentCapacity {
    private int minCapacity;
    private int maxCapacity;
    private int currentEnrollment;

    protected EnrollmentCapacity increase() {
        if (this.currentEnrollment >= maxCapacity) {
            throw new IllegalStateException("정원이 초과되었습니다.");
        }
        return new EnrollmentCapacity(this.minCapacity, this.maxCapacity, this.currentEnrollment + 1);
    }

    protected boolean isFull() {
        return this.currentEnrollment >= maxCapacity;
    }

}
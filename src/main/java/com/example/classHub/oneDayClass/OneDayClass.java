package com.example.classHub.oneDayClass;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "class_id")
    private List<ClassSchedule> schedules = new ArrayList<>();

    public void enroll(Long scheduleId) {
        for (ClassSchedule schedule : this.schedules) {
            if (schedule.getId().equals(scheduleId)) {
                schedule.addEnrollment();

                if (!schedule.hasVacancy()) {
                    schedule.close();
                }
                return;
            }
        }
    }

}
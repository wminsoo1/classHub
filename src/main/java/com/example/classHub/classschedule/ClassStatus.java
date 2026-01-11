package com.example.classHub.classschedule;

import lombok.Getter;

@Getter
public enum ClassStatus {
    /**
     * 모집 중: 수강 신청이 가능한 상태
     */
    OPEN("모집 중"),

    /**
     * 모집 마감: 정원이 가득 찼거나, 강사가 수동으로 마감한 상태
     */
    CLOSED("모집 마감"),

    /**
     * 진행 예정: 모집이 종료되고 클래스 시작 직전인 상태 (알림톡 발송 기준점)
     */
    UPCOMING("진행 예정"),

    /**
     * 클래스 종료: 수업이 끝난 상태 (이 시점부터 일주일 이내 정산 로직 가동)
     */
    FINISHED("클래스 종료"),

    /**
     * 폐강: 최소 인원 미달 등으로 클래스가 취소된 상태 (전액 환불 대상)
     */
    CANCELED("폐강");

    private final String description;

    ClassStatus(String description) {
        this.description = description;
    }

}
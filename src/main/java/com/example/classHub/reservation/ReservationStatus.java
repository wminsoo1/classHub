package com.example.classHub.reservation;

public enum ReservationStatus {
    CONFIRMED,        // 예약 확정
    CANCEL_REQUESTED, // 취소 요청 중
    CANCEL_COMPLETED, // 취소 완료
    COMPLETED         // 수강 완료
}
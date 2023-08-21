package com.hrdepartment.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttendanceDTO {
    private Long employeeId;
    private LocalDateTime inTime;
    private LocalDateTime outTime;
}

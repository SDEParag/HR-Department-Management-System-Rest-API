package com.hrdepartment.service;

import com.hrdepartment.entity.Attendance;
import com.hrdepartment.payload.AttendanceDTO;

import java.util.List;

public interface AttendanceService {
    List<Attendance> getAllAttendances();
    Attendance getAttendanceById(Long id);
    Attendance createAttendance(AttendanceDTO attendanceDTO);
    Attendance updateAttendance(Long id, AttendanceDTO attendanceDTO);
    void deleteAttendance(Long id);
}

package com.hrdepartment.controller;

import com.hrdepartment.entity.Attendance;
import com.hrdepartment.payload.AttendanceDTO;
import com.hrdepartment.service.AttendanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private ModelMapper modelMapper; // Make sure you have ModelMapper bean configured

    @GetMapping
    public List<AttendanceDTO> getAllAttendances() {
        List<Attendance> attendances = attendanceService.getAllAttendances();
        return attendances.stream()
                .map(attendance -> modelMapper.map(attendance, AttendanceDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AttendanceDTO getAttendanceById(@PathVariable Long id) {
        Attendance attendance = attendanceService.getAttendanceById(id);
        return modelMapper.map(attendance, AttendanceDTO.class);
    }

    @PostMapping
    public AttendanceDTO createAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        Attendance createdAttendance = attendanceService.createAttendance(attendanceDTO);
        return modelMapper.map(createdAttendance, AttendanceDTO.class);
    }

    @PutMapping("/{id}")
    public AttendanceDTO updateAttendance(@PathVariable Long id, @RequestBody AttendanceDTO attendanceDTO) {
        Attendance updatedAttendance = attendanceService.updateAttendance(id, attendanceDTO);
        return modelMapper.map(updatedAttendance, AttendanceDTO.class);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}

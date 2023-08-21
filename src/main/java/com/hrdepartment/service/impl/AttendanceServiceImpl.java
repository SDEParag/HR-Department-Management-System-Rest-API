package com.hrdepartment.service.impl;

import com.hrdepartment.entity.Attendance;
import com.hrdepartment.entity.Employee;
import com.hrdepartment.payload.AttendanceDTO;
import com.hrdepartment.repository.AttendanceRepository;
import com.hrdepartment.repository.EmployeeRepository;
import com.hrdepartment.service.AttendanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Attendance> getAllAttendances() {
        List<Attendance> attendances = attendanceRepository.findAll();
        return attendances.stream()
                .map(attendance -> modelMapper.map(attendance, Attendance.class))
                .collect(Collectors.toList());
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Attendance not found"));
        return modelMapper.map(attendance, Attendance.class);
    }

    @Override
    public Attendance createAttendance(AttendanceDTO attendanceDTO) {
        Employee employee = employeeRepository.findById(attendanceDTO.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        Attendance attendance = modelMapper.map(attendanceDTO, Attendance.class);
        attendance.setEmployee(employee);

        Attendance savedAttendance = attendanceRepository.save(attendance);
        return modelMapper.map(savedAttendance, Attendance.class);
    }

    @Override
    public Attendance updateAttendance(Long id, AttendanceDTO attendanceDTO) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Attendance not found"));

        Employee employee = employeeRepository.findById(attendanceDTO.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        modelMapper.map(attendanceDTO, attendance);
        attendance.setEmployee(employee);

        Attendance updatedAttendance = attendanceRepository.save(attendance);
        return modelMapper.map(updatedAttendance, Attendance.class);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}

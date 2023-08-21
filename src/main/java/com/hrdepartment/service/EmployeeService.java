package com.hrdepartment.service;

import com.hrdepartment.entity.Employee;
import com.hrdepartment.payload.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee createEmployee(EmployeeDTO payload);
    Employee updateEmployee(Long id, EmployeeDTO payload);
    void deleteEmployee(Long id);
}

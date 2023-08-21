package com.hrdepartment.service;

import com.hrdepartment.entity.Department;
import com.hrdepartment.payload.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department createDepartment(DepartmentDTO departmentDTO);
    Department updateDepartment(Long id, DepartmentDTO departmentDTO);

    void deleteDepartment(Long id);
}

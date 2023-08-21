package com.hrdepartment.service;

import com.hrdepartment.entity.Salary;
import com.hrdepartment.payload.SalaryDTO;

import java.util.List;

public interface SalaryService {
    List<Salary> getAllSalaries();
    Salary getSalaryById(Long id);
    Salary createSalary(SalaryDTO payload);
    Salary updateSalary(Long id, SalaryDTO payload);
    void deleteSalary(Long id);
}

package com.hrdepartment.repository;

import com.hrdepartment.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SalaryRepository extends JpaRepository<Salary, Long> {
}

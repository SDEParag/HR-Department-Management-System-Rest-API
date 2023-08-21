package com.hrdepartment.controller;

import com.hrdepartment.entity.Salary;
import com.hrdepartment.payload.SalaryDTO;
import com.hrdepartment.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @GetMapping("/{id}")
    public Salary getSalaryById(@PathVariable Long id) {
        return salaryService.getSalaryById(id);
    }

    @PostMapping
    public Salary createSalary(@RequestBody SalaryDTO salaryDTO) {
        return salaryService.createSalary(salaryDTO);
    }

    @PutMapping("/{id}")
    public Salary updateSalary(@PathVariable Long id, @RequestBody SalaryDTO salaryDTO) {
        salaryDTO.setId(id);  // Set the id in the DTO
        return salaryService.updateSalary(id, salaryDTO);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
        return ResponseEntity.noContent().build();
    }
}

package com.hrdepartment.service.impl;

import com.hrdepartment.entity.Position;
import com.hrdepartment.entity.Salary;
import com.hrdepartment.payload.SalaryDTO;
import com.hrdepartment.repository.EmployeeRepository;
import com.hrdepartment.repository.PositionRepository;
import com.hrdepartment.repository.SalaryRepository;
import com.hrdepartment.service.SalaryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Salary> getAllSalaries() {
        List<Salary> salaries = salaryRepository.findAll();
        return salaries.stream()
                .map(salary -> modelMapper.map(salary, Salary.class))
                .collect(Collectors.toList());
    }

    @Override
    public Salary getSalaryById(Long id) {
        Salary salary = salaryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salary not found"));
        return modelMapper.map(salary, Salary.class);
    }

    @Override
    public Salary createSalary(SalaryDTO salaryDTO) {
        Position position = positionRepository.findById(salaryDTO.getPositionId())
                .orElseThrow(() -> new EntityNotFoundException("Position not found"));

        Salary salary = modelMapper.map(salaryDTO, Salary.class);
        salary.setPosition(position);
        salary.setGrossSalary(calculateGrossSalary(salaryDTO));

        Salary savedSalary = salaryRepository.save(salary);
        return modelMapper.map(savedSalary, Salary.class);
    }

    @Override
    public Salary updateSalary(Long id, SalaryDTO salaryDTO) {

        Salary salary = salaryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salary not found"));

        Position position = positionRepository.findById(salaryDTO.getPositionId())
                .orElseThrow(() -> new EntityNotFoundException("Position not found"));

        // Update the specific fields you want to change
        // Ensure that the id is properly set in the DTO
        salaryDTO.setId(id);
        salary.setBasicSalary(salaryDTO.getBasicSalary());
        salary.setHra(salaryDTO.getHra());
        salary.setDa(salaryDTO.getDa());
        salary.setOtherAllowances(salaryDTO.getOtherAllowances());

        salary.setPosition(position);
        salary.setGrossSalary(calculateGrossSalary(salaryDTO));

        // Save the updated salary entity
        Salary updatedSalary = salaryRepository.save(salary);
        return modelMapper.map(updatedSalary, Salary.class);
    }



    @Override
    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }

    private BigDecimal calculateGrossSalary(SalaryDTO salaryDTO) {
        BigDecimal grossSalary = salaryDTO.getBasicSalary()
                .add(salaryDTO.getHra())
                .add(salaryDTO.getDa())
                .add(salaryDTO.getOtherAllowances());
        return grossSalary;
    }
}

package com.hrdepartment.service.impl;

import com.hrdepartment.entity.Department;
import com.hrdepartment.entity.Employee;
import com.hrdepartment.entity.Position;
import com.hrdepartment.payload.EmployeeDTO;
import com.hrdepartment.repository.DepartmentRepository;
import com.hrdepartment.repository.EmployeeRepository;
import com.hrdepartment.repository.PositionRepository;
import com.hrdepartment.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> modelMapper.map(employee, Employee.class))
                .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        return modelMapper.map(employee, Employee.class);
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        // Map EmployeeDTO to Employee explicitly
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setAddress(employeeDTO.getAddress());

        // Retrieve and set Department and Position using employeeDTO properties
        Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        Position position = positionRepository.findById(employeeDTO.getPositionId())
                .orElseThrow(() -> new EntityNotFoundException("Position not found"));

        employee.setDepartment(department);
        employee.setPosition(position);

        return employeeRepository.save(employee);
    }


    @Override
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        Position position = positionRepository.findById(employeeDTO.getPositionId())
                .orElseThrow(() -> new EntityNotFoundException("Position not found"));

        // Update the employee object with new data from employeeDTO
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setAddress(employeeDTO.getAddress());
        employee.setDepartment(department);
        employee.setPosition(position);

        Employee updatedEmployee = employeeRepository.save(employee);
        return modelMapper.map(updatedEmployee, Employee.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

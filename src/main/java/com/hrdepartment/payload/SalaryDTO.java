package com.hrdepartment.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SalaryDTO {
    private Long id;  // Add this field
    private Long positionId;
    private BigDecimal basicSalary;
    private BigDecimal hra;
    private BigDecimal da;
    private BigDecimal otherAllowances;
    private BigDecimal grossSalary;
}

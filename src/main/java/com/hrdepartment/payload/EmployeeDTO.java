package com.hrdepartment.payload;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long departmentId;
    private Long positionId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
}

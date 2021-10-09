package com.example.vuetilserver.repository;

import com.example.vuetilserver.dto.EmployeeDto;

import java.util.List;

public interface EmpRepositorySupport {

    List<EmployeeDto.empList> empList(EmployeeDto.empListParam empListParam);
}

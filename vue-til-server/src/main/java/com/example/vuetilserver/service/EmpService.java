package com.example.vuetilserver.service;

import com.example.vuetilserver.domain.Employee;
import com.example.vuetilserver.dto.EmployeeDto;

import java.util.List;

public interface EmpService {

    List<EmployeeDto.empList> empList(EmployeeDto.empListParam empListParam);

    EmployeeDto.empRegist empRegist(EmployeeDto.empRegistParam empListParam);
}

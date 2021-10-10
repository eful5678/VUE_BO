package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Employee;
import com.example.vuetilserver.dto.EmployeeDto;

public interface EmpRepositoryManager {

    EmployeeDto.empRegist empRegist(EmployeeDto.empRegistParam empRegistParam);
}

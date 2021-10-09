package com.example.vuetilserver.service;

import com.example.vuetilserver.dto.EmployeeDto;
import com.example.vuetilserver.repository.EmpRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

    private final EmpRepositorySupport empRepositorySupport;

    @Override
    public List<EmployeeDto.empList> empList(EmployeeDto.empListParam empListParam) {

        List<EmployeeDto.empList> employees = empRepositorySupport.empList(empListParam);

        return employees;
    }
}

package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Employee;
import com.example.vuetilserver.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class EmpRepositoryManagerImpl implements EmpRepositoryManager {

    private final EntityManager entityManager;

    @Override
    public EmployeeDto.empRegist empRegist(EmployeeDto.empRegistParam empRegistParam) {

        final Employee employee = Employee.doMaker(empRegistParam).get();
        entityManager.persist(employee);

        return new EmployeeDto.empRegist(employee);
    }
}

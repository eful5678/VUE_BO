package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Employee;
import com.example.vuetilserver.domain.QEmployee;
import com.example.vuetilserver.dto.EmployeeDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmpRepositorySupportImpl extends QuerydslRepositorySupport implements EmpRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public EmpRepositorySupportImpl(EntityManager em){
        super(Employee.class);
        super.setEntityManager(em);
        jpaQueryFactory = new JPAQueryFactory(em);
    }
    @Override
    public List<EmployeeDto.empList> empList(EmployeeDto.empListParam empListParam) {

        QEmployee Employee = QEmployee.employee;

        List<EmployeeDto.empList> employees = jpaQueryFactory.
                select(Projections.constructor(EmployeeDto.empList.class
                        ,Employee.name
                        ,Employee.id))
                .from(Employee)
                .fetch();
        return employees;
    }
}

package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Employee;
import com.example.vuetilserver.domain.QEmployee;
import com.example.vuetilserver.dto.EmployeeDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
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

        // 파라미터
        // 1.

        // 기본조건
        // 1. 사용여부
        final BooleanExpression isUseYn = Employee.useYn.eq('Y');
        final BooleanExpression isDelYn = Employee.delYn.eq('N');

        List<EmployeeDto.empList> employees = jpaQueryFactory.
                select(Projections.constructor(EmployeeDto.empList.class
                        ,Employee.name
                        ,Employee.id
                        ,Employee.empLevel))
                .from(Employee)
                .where(isUseYn
                    .and(isDelYn))
                .fetch();
        return employees;
    }
}

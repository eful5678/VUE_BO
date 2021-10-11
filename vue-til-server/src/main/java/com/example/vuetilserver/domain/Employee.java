package com.example.vuetilserver.domain;

import com.example.vuetilserver.domain.global.BaseEntity;
import com.example.vuetilserver.dto.EmployeeDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.function.Supplier;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee extends BaseEntity {

    // id 값
    @Id
    @GeneratedValue
    @Column(name = "employeeId")
    protected Long id;

    // 직원명
    @Column
    protected String name;

    // 직급
    @Column
    protected String empLevel;

    @Builder
    public Employee(LocalDateTime createDateTime
                    , LocalDateTime updateDateTime
                    , char useYn
                    , char delYn
                    ){
        super(createDateTime, updateDateTime, useYn, delYn);
        this.name = name;
        this.empLevel = empLevel;
    }

    protected Employee(EmployeeDto.empRegistParam empRegistParam){
        this.name = empRegistParam.getName();
        this.empLevel = empRegistParam.getEmpLevel();
    }

    // 직원 등록
    public static Supplier<Employee> doMaker(EmployeeDto.empRegistParam empRegistParam){
        return () -> new Employee(empRegistParam);
    }

    // 직원 삭제
    public Employee destroy(Employee employee){
        employee.useYn = 'N';
        employee.delYn = 'Y';
        return employee;
    }
}

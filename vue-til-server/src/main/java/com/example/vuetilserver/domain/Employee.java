package com.example.vuetilserver.domain;

import com.example.vuetilserver.domain.global.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

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

    @Builder
    public Employee(LocalDateTime createDateTime
                    ,char useYn
                    ,char delYn
                    ){
        super(createDateTime, useYn, delYn);
        this.name = name;
    }

    // 직원 삭제
    public Employee destroy(Employee employee){
        employee.useYn = 'N';
        employee.delYn = 'Y';
        return employee;
    }
}

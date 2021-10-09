package com.example.vuetilserver.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmployeeDto {

    @Getter
    @Setter
    public static class empListParam{

        private Long employeeId;

    }

    @Getter
    @Setter
    public static class empList{
        private String name;

        public empList(String name){
            this.name = name;
        }
    }
}

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
        private Long id;

        public empList(String name
                        ,Long id){
            this.name = name;
            this.id = id;
        }
    }
}

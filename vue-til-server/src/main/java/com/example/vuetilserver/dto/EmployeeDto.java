package com.example.vuetilserver.dto;

import com.example.vuetilserver.domain.Employee;
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
    public static class empRegistParam{
        private String name;
        private String empLevel;
//        private LocalDateTime entryDate;
    }

    @Getter
    @Setter
    public static class empList{
        private String name;
        private Long id;
        private String empLevel;

        public empList(String name
                        ,Long id
                        ,String empLevel){
            this.name = name;
            this.id = id;
            this.empLevel = empLevel;
        }
    }

    @Getter
    @Setter
    public static class empRegist{
        private String name;
        private String empLevel;

        public empRegist(Employee employee){
            this.name = employee.getName();
            this.empLevel = employee.getEmpLevel();
        }

    }
}

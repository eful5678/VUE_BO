package com.example.vuetilserver.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RepairDto {

    @Getter
    @Setter
    public static class repairListParam{
        private String containerCode;
    }

    @Getter
    @Setter
    public static class repairList{
        private String containerCode;

        private BigDecimal repairCost;

        public repairList(String containerCode,
                          BigDecimal repairCost){
            this.containerCode = containerCode;
            this.repairCost = repairCost;
        }
    }
}

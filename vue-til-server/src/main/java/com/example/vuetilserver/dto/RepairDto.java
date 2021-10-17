package com.example.vuetilserver.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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
        // 컨테이너 코드
        private String containerCode;

        // 청구 수리비용
        private BigDecimal repairCost;

        // 선사명
        private String shippingCompany;

        // 지급된 수리비용
        private BigDecimal paymentAmount;

        // 등록일자
        private Long regDate;

        // 수리일자
        private Long repairDate;

        public repairList(String containerCode,
                          String shippingCompany,
                          BigDecimal repairCost,
                          BigDecimal paymentAmount,
                          LocalDateTime regDate,
                          LocalDateTime repairDate){
            this.containerCode = containerCode;
            this.repairCost = repairCost;
            this.shippingCompany = shippingCompany;
            this.regDate = ZonedDateTime.of(regDate, ZoneId.systemDefault()).toInstant().toEpochMilli();
            this.repairDate = ZonedDateTime.of(repairDate, ZoneId.systemDefault()).toInstant().toEpochMilli();
            this.paymentAmount = paymentAmount;
        }
    }

    @Getter
    @Setter
    public static class insertParam{
        private String containerCode;

        private String shippingCompany;

        private BigDecimal repairCost;

        private Long regDate;

    }

    @Getter
    @Setter
    public static class insert{
        private String containerCode;
    }
}
